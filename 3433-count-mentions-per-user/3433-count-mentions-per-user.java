class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
  int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;
            if (a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")) return -1;
            if (a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")) return 1;
            return 0;
        });

        for (List<String> e : events) {
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));

            if (type.equals("OFFLINE")) {
                int user = Integer.parseInt(e.get(2));
                offlineUntil[user] = time + 60;
            } 
            else {
                String text = e.get(2);

                if (text.equals("ALL")) {
                    for (int u = 0; u < numberOfUsers; u++) mentions[u]++;
                } 
                else if (text.equals("HERE")) {
                    for (int u = 0; u < numberOfUsers; u++)
                        if (time >= offlineUntil[u]) mentions[u]++;
                } 
                else {
                    String[] parts = text.split(" ");
                    for (String p : parts) {
                        if (p.startsWith("id")) {
                            int user = Integer.parseInt(p.substring(2));
                            mentions[user]++;
                        }
                    }
                }
            }
        }

        return mentions;
    }
}
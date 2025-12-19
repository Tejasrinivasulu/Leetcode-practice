class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
          Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        int i = 0;
        while (i < meetings.length) {

            int time = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);
                i++;
            }

            Set<Integer> visited = new HashSet<>();

            for (int person : people) {
                if (!visited.contains(person)) {
                    List<Integer> component = new ArrayList<>();
                    boolean hasSecret = dfs(person, graph, visited, component, knows);

                    if (hasSecret) {
                        for (int p : component) {
                            knows[p] = true;
                        }
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (knows[p]) result.add(p);
        }
        return result;
    }

    private boolean dfs(int start, Map<Integer, List<Integer>> graph,
                        Set<Integer> visited, List<Integer> component,
                        boolean[] knows) {

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited.add(start);

        boolean hasSecret = knows[start];

        while (!stack.isEmpty()) {
            int node = stack.pop();
            component.add(node);

            for (int nei : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    stack.push(nei);
                    if (knows[nei]) hasSecret = true;
                }
            }
        }
        return hasSecret;
    }
}
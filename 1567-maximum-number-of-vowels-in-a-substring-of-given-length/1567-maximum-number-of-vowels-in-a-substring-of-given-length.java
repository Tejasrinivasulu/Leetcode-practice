class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) count++;
            if (i >= k && vowels.contains(s.charAt(i - k))) count--;
            max = Math.max(max, count);
        }

        return max;
    }
}
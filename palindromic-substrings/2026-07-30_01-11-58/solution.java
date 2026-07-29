class Solution {

    public int countSubstrings(String s) {

        StringBuilder sb = new StringBuilder();

        sb.append("^");

        for (char c : s.toCharArray()) {
            sb.append("#");
            sb.append(c);
        }

        sb.append("#$");

        String str = sb.toString();

        int[] P = new int[str.length()];

        int center = 0;
        int right = 0;

        for (int i = 1; i < str.length() - 1; i++) {

            int mirror = 2 * center - i;

            if (i < right)
                P[i] = Math.min(right - i, P[mirror]);

            while (str.charAt(i + 1 + P[i]) ==
                   str.charAt(i - 1 - P[i])) {

                P[i]++;
            }

            if (i + P[i] > right) {

                center = i;
                right = i + P[i];
            }
        }

        int answer = 0;

        for (int radius : P)
            answer += (radius + 1) / 2;

        return answer;
    }
}
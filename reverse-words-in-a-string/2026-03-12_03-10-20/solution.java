class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        int i = 0;

        // remove extra spaces
        while (i < s.length()) {

            while (i < s.length() && s.charAt(i) == ' ') i++;

            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }

            while (i < s.length() && s.charAt(i) == ' ') i++;

            if (i < s.length()) sb.append(' ');
        }

        // reverse whole string
        reverse(sb, 0, sb.length() - 1);

        int start = 0;
        int end = 0;

        while (end <= sb.length()) {

            if (end == sb.length() || sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                start = end + 1;
            }

            end++;
        }

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int left, int right){
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
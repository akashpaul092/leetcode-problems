class Solution {
    public String reverseWords(String s) {
        s = rev(s);

        String ss = "";
        String o = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (ss.length() > 0) {
                    if (o.length() > 0) {
                        o += " ";
                    }
                    o += rev(ss);
                    ss = "";
                }

                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                i--;
            } else {
                ss += s.charAt(i);
            }
        }

        // Add the last word
        if (ss.length() > 0) {
            if (o.length() > 0) {
                o += " ";
            }
            o += rev(ss);
        }

        return o;
    }

    private String rev(String s) {
        String re = "";
        for (int i = 0; i < s.length(); i++) {
            re = s.charAt(i) + re;
        }
        return re;
    }
}
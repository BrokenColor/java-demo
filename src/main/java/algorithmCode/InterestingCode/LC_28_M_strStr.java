package algorithmCode.InterestingCode;

/**
 * 28. 找出字符串中第一个匹配项的下标
 */
public class LC_28_M_strStr {
    public static void main(String[] args) {
        LC_28_M_strStr solution = new LC_28_M_strStr();
//        System.out.println(solution.strStr("sadbutsad","sad"));
        System.out.println(solution.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        int p1 = 0, p2 = 0;
        while (p1 < haystack.length()) {
            char c1 = haystack.charAt(p1);
            char c2 = needle.charAt(p2);
            if (c1 == c2) {
                p2++;
                if (p2 == needle.length()) {
                    return p1 - needle.length() + 1;
                }
                p1++;
            } else {
                //p1退到相同的地方
                p1 = p1 - p2 + 1;
                p2 = 0;
            }

        }
        return -1;
    }
}

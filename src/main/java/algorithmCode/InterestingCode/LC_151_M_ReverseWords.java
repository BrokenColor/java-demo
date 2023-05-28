package algorithmCode.InterestingCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 *
 * @Author bc
 * @Date 2023/5/28 18:35
 * @Description:
 */
public class LC_151_M_ReverseWords {
    public static void main(String[] args) {
        LC_151_M_ReverseWords solution = new LC_151_M_ReverseWords();
        System.out.println(solution.reverseWords(" hello world "));
    }

    public String reverseWords(String s) {
        String trim = s.trim();
        List<String> stringList = Arrays.asList(trim.split("\\s+"));
        Collections.reverse(stringList);
        return String.join(" ", stringList);
    }
}

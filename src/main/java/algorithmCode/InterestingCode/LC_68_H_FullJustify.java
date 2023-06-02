package algorithmCode.InterestingCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * @Author bc
 * @Date 2023/6/2 23:00
 * @Description: TODO
 */
public class LC_68_H_FullJustify {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        LC_68_H_FullJustify solution = new LC_68_H_FullJustify();
        System.out.println(solution.fullJustify(words, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        //words中当前指针
        int right = 0;
        int n = words.length;
        while (true) {
            //当前行中第一个单词在words中的指针
            int left = right;
            //当前行单词长度
            int sumLength = 0;
            //判断当前行能放多少单词，每个单词有一个空格（right - left）
            while (right < n && sumLength + words[right].length() + right - left <= maxWidth) {
                sumLength += words[right++].length();
            }
            //当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == n) {
                StringBuilder builder = new StringBuilder();
                builder.append(join(words, left, right, " "));
                builder.append(blank(maxWidth - builder.length()));
                ans.add(builder.toString());
                return ans;
            }
            int sumWord = right - left;
            //当只有一个单词时
            if (sumWord == 1) {
                StringBuilder builder = new StringBuilder(words[left]);
                builder.append(blank(maxWidth - builder.length()));
                ans.add(builder.toString());
                continue;
            }
            //当有多个单词时
            int numSpace = maxWidth - sumLength;
            int avgSpace = numSpace / (sumWord - 1);
            int extraSpaces = numSpace % (sumWord - 1);
            StringBuilder builder = new StringBuilder();
            // 拼接额外加一个空格的单词
            builder.append(join(words, left, left + extraSpaces + 1, blank(avgSpace + 1)));
            builder.append(blank(avgSpace));
            // 拼接其余单词
            builder.append(join(words, left + extraSpaces + 1, right, blank(avgSpace)));
            ans.add(builder.toString());
        }
    }

    //添加空格
    private String blank(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }

    //拼接left，right之间的字符串
    private String join(String[] words, int left, int right, String sep) {
        StringBuilder builder = new StringBuilder(words[left]);
        for (int i = left + 1; i < right; i++) {
            builder.append(sep);
            builder.append(words[i]);
        }
        return builder.toString();
    }
}

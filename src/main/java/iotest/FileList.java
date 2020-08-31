package iotest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author: bc
 * @DateTime: 2020/4/2 下午5:18
 * @Description: 文件列表查询
 */
public class FileList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] files;
        if (args.length == 0)
            files = path.list();
        else
            //回调accept()决定哪些文件包含在列表里
            files = path.list(new DirFilter(args[0]));
        //排序
        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
        for (String fileName : files)
            System.out.println(fileName);
    }
}
//文件列表过滤
class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
//        return dir.isFile();
    }
}
package iotest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author: bc
 * @DateTime: 2020/4/2 下午6:22
 * @Description: TODO
 */
public class FileList2 {
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
    //匿名类 过滤文件
    public static FilenameFilter fileter(final String regex){
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
}

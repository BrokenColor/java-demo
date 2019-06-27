package util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 19:39 2019/6/27
 */
public class FileUtil {

    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    String match ="(symbols|assets|components|displays|previews|scenes).*\\\\.(png|jpg|gif|jpeg|bmp|json|js)";

    String exportPath = "d:/down";

    public String export(String inputPath) {
        return export(inputPath, exportPath);
    }

    public String export(String inputPath, String outputPath) {
        //文件路径集合
        Set set = parsingFiles(inputPath);

        //导出文件
        exportFile(set, outputPath);

        //压缩
        CompressedFiles_Gzip(set, outputPath);

        return null;
    }

    //解析文件内容
    public Set parsingFiles(String path) {
        File file = FileUtils.getFile(path);
        String fileContext = "";
        try {
            //读取文件内容
            fileContext = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //解析文件中资源路径
        Set set = new HashSet();
        Pattern p = Pattern.compile(match);
        Matcher m = p.matcher(fileContext);
        while (m.find()) {
            set.add( m.group());
        }
        //
        if (!set.isEmpty()) {
            set.addAll(recursion(set));
        }
        return set;
    }

    //递归解析资源文件
    public Set recursion(Set pathSet) {
        Set set = new HashSet();
        Iterator<String> it = pathSet.iterator();
        while (it.hasNext()) {
            String filePath = it.next();
            set.addAll(parsingFiles(filePath));
        }
        return set;
    }

    //导出文件
    public void exportFile(Set set, String outputPath) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String fullPath = it.next();

            File file = FileUtils.getFile(outputPath + fullPath);
            //创建文件夹
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //copy文件
            try {
                FileUtils.copyFileToDirectory(FileUtils.getFile(fullPath), file.getParentFile(), true);

                log.debug(file.getName() + "  文件导出到：" + file.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件成Gzip格式，Linux上可使用
     * 压缩文件夹生成后缀名为".gz"的文件并下载
     *
     * @param folderPath,要压缩的文件夹的路径
     * @param targzipFilePath,压缩后文件的路径
     * @throws
     */
    public void CompressedFiles_Gzip(Set folderPath, String targzipFilePath) {
        byte[] buf = new byte[1024]; //设定读入缓冲区尺寸
        FileOutputStream fout = null;
        TarArchiveOutputStream tout = null;
        FileInputStream fin = null;
        File tarFile = FileUtils.getFile(targzipFilePath + "storage.tar");
        try {
            //建立压缩文件输出流
            fout = new FileOutputStream(tarFile);
            //建立tar压缩输出流
            tout = new TarArchiveOutputStream(fout);
            Iterator<String> it = folderPath.iterator();
            while (it.hasNext()) {
                String fileName = it.next();
                //打开需压缩文件作为文件输入流
                fin = new FileInputStream(fileName);   //filename是文件全路径
                TarArchiveEntry tarEn = new TarArchiveEntry(new File(fileName));
                tarEn.setName(fileName);  //此处需重置名称，默认是带全路径的，否则打包后会带全路径
                tout.putArchiveEntry(tarEn);
                int num;
                while ((num = fin.read(buf, 0, 1024)) != -1) {
                    tout.write(buf, 0, num);
                }
                tout.closeArchiveEntry();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) fin.close();
                if (tout != null) tout.close();
                if (fout != null) fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件成Gzip格式，Linux上可使用
     * 压缩文件夹生成后缀名为".gz"的文件并下载
     *
     *
     * @param folderPath,要压缩的文件夹的路径
     * @param targzipFilePath,压缩后文件的路径
     * @param targzipFileName,压缩后文件的名称
     * @throws
     */
    public void CompressedFiles_Gzip(String folderPath, String targzipFilePath, String targzipFileName) {
        File srcPath = new File(folderPath);
        int length = srcPath.listFiles().length;
        byte[] buf = new byte[1024]; //设定读入缓冲区尺寸
        File[] files = srcPath.listFiles();
        try {
            //建立压缩文件输出流
            FileOutputStream fout = new FileOutputStream(targzipFilePath);
            //建立tar压缩输出流
            TarArchiveOutputStream tout = new TarArchiveOutputStream(fout);
            for (int i = 0; i < length; i++) {

                String filename = srcPath.getPath() + File.separator + files[i].getName();
                //打开需压缩文件作为文件输入流
                FileInputStream fin = new FileInputStream(filename);   //filename是文件全路径
                TarArchiveEntry tarEn = new TarArchiveEntry(files[i]); //此处必须使用new TarEntry(File file);
                tarEn.setName(files[i].getName());  //此处需重置名称，默认是带全路径的，否则打包后会带全路径
                tout.putArchiveEntry(tarEn);
                int num;
                while ((num = fin.read(buf, 0, 1024)) != -1) {
                    tout.write(buf, 0, num);
                }
                tout.closeArchiveEntry();
                fin.close();
            }
            tout.close();
            fout.close();

            //建立压缩文件输出流
            FileOutputStream gzFile = new FileOutputStream(targzipFilePath + ".gz");
            //建立gzip压缩输出流
            GZIPOutputStream gzout = new GZIPOutputStream(gzFile);
            //打开需压缩文件作为文件输入流
            FileInputStream tarin = new FileInputStream(targzipFilePath);   //targzipFilePath是文件全路径
            int len;
            while ((len = tarin.read(buf, 0, 1024)) != -1) {
                gzout.write(buf, 0, len);
            }
            gzout.close();
            gzFile.close();
            tarin.close();

            File f = new File(targzipFilePath);
            f.deleteOnExit();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}

package demo;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 10:55 2019/7/1
 */
public class FileUtiltar {

    public static final String EXT = ".tar";
    private static final String BASE_DIR = "";

    // 符号"/"用来作为目录标识判断符
    private static final String PATH = File.separator;
    private static final int BUFFER = 1024;

    /**
     * 压缩
     *
     * @param srcPath 需要压缩的文件（目录） 的路径
     * @throws Exception
     */
    public static void compress(String srcPath) throws Exception {
        File srcFile = new File(srcPath);

        compress(srcFile);
    }

    /**
     * 压缩
     *
     * @param srcFile 需要压缩的文件（目录） 的路径流
     * @throws Exception
     */
    public static void compress(File srcFile) throws Exception {
        String name = srcFile.getName();
        String basePath = srcFile.getParent();
        String destPath = basePath + "/" + name + EXT;
        compress(srcFile, destPath);
    }

    /**
     * 压缩
     *
     * @param srcFile    源路径
     * @param //destPath 目标路径
     * @throws Exception
     */
    public static void compress(File srcFile, File destFile) throws Exception {

        // 对输出文件做CRC32校验
        CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                destFile), new CRC32());

        TarArchiveOutputStream tout = new TarArchiveOutputStream(cos);

        compress(srcFile, tout, BASE_DIR);

        tout.flush();
        tout.close();
    }

    /**
     * 压缩文件
     *
     * @param srcFile
     * @param destPath
     * @throws Exception
     */
    public static void compress(File srcFile, String destPath) throws Exception {
        File destfile = new File(destPath);
        if (destfile.exists()) {
            boolean isDeleted = false;
            isDeleted = destfile.delete();
            if (!isDeleted) {
                try {
                    FileUtils.forceDelete(destfile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        System.out.println("delete:" + destfile.getName());
        compress(srcFile, new File(destPath));
    }

    /**
     * 压缩
     *
     * @param srcFile  源路径
     * @param tout     ZipOutputStream
     * @param basePath 压缩包内相对路径
     * @throws Exception
     */
    private static void compress(File srcFile, TarArchiveOutputStream tout,
                                 String basePath) throws Exception {
        if (srcFile.isDirectory()) {
            compressDir(srcFile, tout, basePath);
        } else {
            compressFile(srcFile, tout, basePath);
        }
    }


    /**
     * 文件压缩
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     */
    public static void compress(String srcPath, String destPath)
            throws Exception {
        File srcFile = new File(srcPath);

        compress(srcFile, destPath);
    }

    /**
     * 压缩目录
     *
     * @param dir
     * @param tout
     * @param basePath
     * @throws Exception
     */
    private static void compressDir(File dir, TarArchiveOutputStream tout,
                                    String basePath) throws Exception {

        File[] files = dir.listFiles();

        // 构建空目录
        if (files.length < 1) {
            TarArchiveEntry entry = new TarArchiveEntry(basePath + dir.getName() + PATH);

            tout.putArchiveEntry(entry);
            tout.closeArchiveEntry();
        }

        for (File file : files) {

            // 递归压缩
            compress(file, tout, basePath + dir.getName() + PATH);

        }
    }

    /**
     * 文件压缩
     *
     * @param file 待压缩文件
     * @param tout ZipOutputStream
     * @param dir  压缩文件中的当前路径
     * @throws Exception
     */
    private static void compressFile(File file, TarArchiveOutputStream tout, String dir)
            throws Exception {

        /**
         * 压缩包内文件名定义
         *
         * <pre>
         * 如果有多级目录，那么这里就需要给出包含目录的文件名
         * </pre>
         */
        TarArchiveEntry entry = new TarArchiveEntry(dir + file.getName());
        //设置文件大小
        entry.setSize(file.length());
        tout.putArchiveEntry(entry);

//        IOUtils.copy(new FileInputStream(file), tout);

//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        int count;
        FileInputStream fin = new FileInputStream(file);   //filename是文件全路径

        byte data[] = new byte[BUFFER];
        while ((count = fin.read(data, 0, BUFFER)) != -1) {
            tout.write(data, 0, count);
        }
        fin.close();

        tout.closeArchiveEntry();
    }

    /**
     * 解压缩功能.
     * 将ZIP_FILENAME文件解压到ZIP_DIR目录下.
     *
     * @throws Exception
     */
    public static void upZipFile() throws Exception {
        String ZIP_DIR = "d:\\";
        String ZIP_FILENAME = "D:\\xxx.zip";
        ZipFile zfile = new ZipFile(ZIP_FILENAME);
        Enumeration zList = zfile.entries();
        ZipEntry ze = null;
        byte[] buf = new byte[1024];
        while (zList.hasMoreElements()) {
            ze = (ZipEntry) zList.nextElement();
            if (ze.isDirectory()) {
                File f = new File(ZIP_DIR + ze.getName());
                f.mkdir();
                continue;
            }
            OutputStream os = new BufferedOutputStream(new FileOutputStream(getRealFileName(ZIP_DIR, ze.getName())));
            InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
            int readLen = 0;
            while ((readLen = is.read(buf, 0, 1024)) != -1) {
                os.write(buf, 0, readLen);
            }
            is.close();
            os.close();
        }
        zfile.close();
    }

    /**
     * 给定根目录，返回一个相对路径所对应的实际文件名.
     *
     * @param baseDir     指定根目录
     * @param absFileName 相对路径名，来自于ZipEntry中的name
     * @return java.io.File 实际的文件
     */
    public static File getRealFileName(String baseDir, String absFileName) {
        String[] dirs = absFileName.split("/");
        File ret = new File(baseDir);
        if (dirs.length > 1) {
            for (int i = 0; i < dirs.length - 1; i++) {
                ret = new File(ret, dirs[i]);
            }
            if (!ret.exists())
                ret.mkdirs();
            ret = new File(ret, dirs[dirs.length - 1]);
            return ret;
        }
        return ret;
    }

}

package demo;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 10:55 2019/7/1
 */
public class FileUtilzip {
    public static final String EXT = ".zip";
    private static final String BASE_DIR = "";

    // 符号"/"用来作为目录标识判断符
    private static final String PATH = "/";
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
        String destPath = basePath +"/"+ name + EXT;
        compress(srcFile, destPath);
    }

    /**
     * 压缩
     *
     * @param srcFile
     * 源路径
     * @param //destPath
     * 目标路径
     * @throws Exception
     */
    public static void compress(File srcFile, File destFile) throws Exception {

// 对输出文件做CRC32校验
        CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                destFile), new CRC32());

        ZipOutputStream zos = new ZipOutputStream(cos);

        compress(srcFile, zos, BASE_DIR);

        zos.flush();
        zos.close();
    }

    /**
     * 压缩文件
     *
     * @param srcFile
     * @param destPath
     * @throws Exception
     */
    public static void compress(File srcFile, String destPath) throws Exception {
        compress(srcFile, new File(destPath));
    }

    /**
     * 压缩
     *
     * @param srcFile
     * 源路径
     * @param zos
     * ZipOutputStream
     * @param basePath
     * 压缩包内相对路径
     * @throws Exception
     */
    private static void compress(File srcFile, ZipOutputStream zos,
                                 String basePath) throws Exception {
        if (srcFile.isDirectory()) {
            compressDir(srcFile, zos, basePath);
        } else {
            compressFile(srcFile, zos, basePath);
        }
    }



    /**
     * 文件压缩
     *
     * @param srcPath
     * 源文件路径
     * @param destPath
     * 目标文件路径
     *
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
     * @param zos
     * @param basePath
     * @throws Exception
     */
    private static void compressDir(File dir, ZipOutputStream zos,
                                    String basePath) throws Exception {

        File[] files = dir.listFiles();

// 构建空目录
        if (files.length < 1) {
            ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);

            zos.putNextEntry(entry);
            zos.closeEntry();
        }

        for (File file : files) {

// 递归压缩
            compress(file, zos, basePath + dir.getName() + PATH);

        }
    }

    /**
     * 文件压缩
     *
     * @param file
     * 待压缩文件
     * @param zos
     * ZipOutputStream
     * @param dir
     * 压缩文件中的当前路径
     * @throws Exception
     */
    private static void compressFile(File file, ZipOutputStream zos, String dir)
            throws Exception {

/**
 * 压缩包内文件名定义
 *
 * <pre>
 * 如果有多级目录，那么这里就需要给出包含目录的文件名
 * 如果用WinRAR打开压缩包，中文名将显示为乱码
 * </pre>
 */
        ZipEntry entry = new ZipEntry(dir + file.getName());

        zos.putNextEntry(entry);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                file));

        int count;
        byte data[] = new byte[BUFFER];
        while ((count = bis.read(data, 0, BUFFER)) != -1) {
            zos.write(data, 0, count);
        }
        bis.close();

        zos.closeEntry();
    }

    /**
     * 解压缩功能.
     * 将ZIP_FILENAME文件解压到ZIP_DIR目录下.
     * @throws Exception
     */
    public static void upZipFile() throws Exception{
        String ZIP_DIR="d:\\";
        String ZIP_FILENAME="D:\\xxx.zip";
        ZipFile zfile=new ZipFile(ZIP_FILENAME);
        Enumeration zList=zfile.entries();
        ZipEntry ze=null;
        byte[] buf=new byte[1024];
        while(zList.hasMoreElements()){
            ze=(ZipEntry)zList.nextElement();
            if(ze.isDirectory()){
                File f=new File(ZIP_DIR+ze.getName());
                f.mkdir();
                continue;
            }
            OutputStream os=new BufferedOutputStream(new FileOutputStream(getRealFileName(ZIP_DIR, ze.getName())));
            InputStream is=new BufferedInputStream(zfile.getInputStream(ze));
            int readLen=0;
            while ((readLen=is.read(buf, 0, 1024))!=-1) {
                os.write(buf, 0, readLen);
            }
            is.close();
            os.close();
        }
        zfile.close();
    }
    /**
     * 给定根目录，返回一个相对路径所对应的实际文件名.
     * @param baseDir 指定根目录
     * @param absFileName 相对路径名，来自于ZipEntry中的name
     * @return java.io.File 实际的文件
     */
    public static File getRealFileName(String baseDir, String absFileName){
        String[] dirs=absFileName.split("/");
        File ret=new File(baseDir);
        if(dirs.length>1){
            for (int i = 0; i < dirs.length-1;i++) {
                ret=new File(ret, dirs[i]);
            }
            if(!ret.exists())
                ret.mkdirs();
            ret=new File(ret, dirs[dirs.length-1]);
            return ret;
        }
        return ret;
    }
}

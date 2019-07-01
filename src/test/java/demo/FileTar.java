package demo;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Description:
 * <p>
 * Author: GWL
 * Date: Create in 15:17 2019/7/1
 */
public class FileTar {
    /**
     * Recursive traversal to add files
     *
     * @param root
     * @param file
     * @param taos
     * @param absolute
     * @throws IOException
     */
    private static void recurseFiles(File root, File file, TarArchiveOutputStream taos,
                                     boolean absolute) throws IOException {
        if (file.isDirectory()) {
            // recursive call
            File[] files = file.listFiles();
            for (File file2 : files) {
                recurseFiles(root, file2, taos, absolute);
            }
        } else if ((!file.getName().endsWith(".tar")) && (!file.getName().endsWith(".TAR"))) {
            String filename = null;
            if (absolute) {
                filename = file.getAbsolutePath().substring(root.getAbsolutePath().length());
            } else {
                filename = file.getName();
            }
            TarArchiveEntry tae = new TarArchiveEntry(filename);
            tae.setSize(file.length());
            taos.putArchiveEntry(tae);
            FileInputStream fis = new FileInputStream(file);
            IOUtils.copy(fis, taos);
            taos.closeArchiveEntry();
        }
    }
}

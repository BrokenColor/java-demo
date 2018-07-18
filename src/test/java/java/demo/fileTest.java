package Demo.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author BONC-g
 * @date 2018年7月18日上午10:41:32
 * @tags 
 */
public class fileTest {
	public static void main(String[] args) throws IOException {
		// 创建文件
		File file = new File("d:\\hello\\test_file.txt");
		fileTest.judgeFileExists(file);

		// 创建文件夹
		File dir = new File("d:\\hello\\test_dir");
		fileTest.judgeDieExists(dir);

		// 删除文件和文件夹
		fileTest.deleteFile(file);
		fileTest.deleteFile(dir);
	}

	// 判断文件是否存在
	public static void judgeFileExists(File file) {
		if (file.exists()) {
			System.out.println("The file exists");
		} else {
			System.out.println("File not exists, create it...");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// 判断文件夹是否存在
	public static void judgeDieExists(File dir) {
		if (dir.exists()) {
			if (dir.isDirectory()) {
				System.out.println("The dir exits.");
			} else {
				System.out.println("The same name file exists, can't create the file.");
			}
		} else {
			System.out.println("The dir doesn't exists, create it.");
			dir.mkdirs();
		}

	}

	// 删除文件或者文件夹
	public static void deleteFile(File file) {
		if (file.exists()) {
			// 文件存在
			System.out.println(file.getAbsolutePath() + " exists.");
			file.delete();
			System.out.println("File is deleted.");
		} else {
			// 文件压根不存在
			System.out.println("File doesn't exists, are you kidding me ?");
		}
	}
}

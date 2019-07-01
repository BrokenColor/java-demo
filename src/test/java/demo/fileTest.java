package demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bc
 * @date 2018年7月18日上午10:41:32
 * @tags
 */
public class fileTest {
//	@Value("${export.Pattern}")
	private String exportPattern="(symbols|assets|components|displays|previews|scenes).*\\\\.(png|jpg|gif|jpeg|bmp|json|js)";

//	@Value("${export.path}")
	private String exportPath="d:/down/";

//	@Value("${storage}")
	private String storagePath = "instance-enjoy/storage";

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

	/**
	 * 文件依赖解析
	 * @param path
	 * @return
	 */

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
		Pattern p = Pattern.compile(exportPattern);
		Matcher m = p.matcher(fileContext);
		while (m.find()) {
			set.add(storagePath + "/" + m.group());
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

//				log.debug(file.getName() + "  文件导出到：" + file.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

package java.util;

import java.io.File;

public class GetTemplatesDir {
	public static String getTemplatesDir(String baseUrl,String suffix) {
		String dirPath =null;
		File root=new File(baseUrl);
		
		if(root.exists()&&root.isDirectory()) {
			 for(File file:root.listFiles()){
				 if(file.isDirectory()) {
					 String name=file.getName();
					 if(name.startsWith(suffix)) {
						 dirPath=baseUrl+"/"+name;
					 }
				 }
			 }
			
		}
		return dirPath;
	}
	public static void main(String[] args) {
//		String dirPath=getTemplatesDir("F:/新项目/eclipse/features");
//		System.out.println(dirPath);
	}
}

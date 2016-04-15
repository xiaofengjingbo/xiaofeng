package cn.com.shxt.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class Common {
	
	/**
	 * 把list转为逗号间隔的字符串,如："1","2","3"
	 * @author 韩老师
	 * @title: listToString
	 * @date 2015-7-25 下午07:24:49
	 * @param list
	 * @return String
	 */
	public static String listToString (List<Integer> list) {
		// "1","2","3"
		//   \"1\"  ,\"2\"    ,\"3\"
		if(list == null || list.isEmpty()) {
			return "";
		}
		StringBuilder s = new StringBuilder()
			.append("\"").append(list.get(0)).append("\"");
		
		for (int i = 1; i < list.size(); i++) {
			s.append(",\"").append(list.get(i)).append("\"");
		}
		
		return s.toString();
	}
	
	
	
	/**获取上传文件的名称
	 * @author 韩老师
	 * @title: getFileName
	 * @date 2013-1-13 上午09:59:28
	 * @param fileName
	 * @return String
	 */
	private static String getFileName(String fileName){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = df.format(new Date());
		int random = new Random().nextInt(10000);//0-9999
		String type = fileName.substring(fileName.lastIndexOf("."));
		return dateStr + random + type;
	}
	
	/**
	 * 上传文件
	 * @author 韩老师
	 * @title: upload
	 * @date 2013-2-26 下午03:44:35
	 * @param file
	 * @param fileName
	 * @return
	 * @throws IOException String
	 */
	public static String upload(File file,String fileName) throws IOException {
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		String newName = getFileName(fileName);
		File newFile = new File(path, newName);
		FileUtils.copyFile(file, newFile);
		return newName;
	}
}

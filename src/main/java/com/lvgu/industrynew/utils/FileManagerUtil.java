package com.lvgu.industrynew.utils;

import com.lvgu.industrynew.exception.RenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/** 
* 文件管理公共接口
*/
@Component
public class FileManagerUtil {

	@Value("${uploadpath}")
	private String savePath;
	@Value("${urlPath}")
	private String urlPath;


	/** 
	* 文件上传接口
	* @author: fuyunhao
	 *
	*/
	public List<Map<String,Object>> uploadFile(HttpServletRequest request) throws IOException {
		List<Map<String,Object>> list = new ArrayList<>();
		Random cruId=new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
//		String cruSavePath=savePath+ymd + File.separator;
//		String cruUrlPath=urlPath+ymd +File.separator;
		String cruSavePath=savePath;
		String cruUrlPath=urlPath;
		String myFileName="";
		File dirFile = new File(cruSavePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		String fileId="";
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				 String pre = (int) System.currentTimeMillis()+"";//开始时时间
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					 myFileName = file.getOriginalFilename();
					if (myFileName.trim() != "") {
						String fileName = myFileName;/*request.getParameter("fileName");*/
						String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
						fileId=cruId+"";
//						fileId = ymd + "-" + pre.substring(pre.length()-4) + "-" +myFileName;
						fileId = myFileName;
						String cruSavePath1 = cruSavePath + fileId;//上传路径
						 String cruUrlPath1= cruUrlPath+fileId;
						File localFile = new File(cruSavePath1);
						try {
							//保存文件数据
							file.transferTo(localFile);
							Map<String,Object> map = new HashMap<>();
							map.put("cruUrlPath",cruUrlPath1);
							map.put("cruSavePath1",cruSavePath1);
							map.put("fileName",fileName);
							list.add(map);
						} catch (IllegalStateException e) {
							System.out.println(fileName+"1失败");
							e.printStackTrace();
						} catch (IOException e) {
							System.out.println(fileName+"2失败");
							e.printStackTrace();
						}
					}
				}
			}
		}else{
		    new RenException("文件不存在");
		}
        return list;
	}

public static String getContentType(String fileName) {
	String fileNameTmp = fileName.toLowerCase();
	String ret = "";
	if (fileNameTmp.endsWith("txt")) {
	ret = "text/plain";
	}
	if (fileNameTmp.endsWith("gif")) {
	ret = "image/gif";
	}
	if (fileNameTmp.endsWith("jpg")) {
	ret = "image/jpeg";
	}
	if (fileNameTmp.endsWith("jpeg")) {
	ret = "image/jpeg";
	}
	if (fileNameTmp.endsWith("jpe")) {
	ret = "image/jpeg";
	}
	if (fileNameTmp.endsWith("zip")) {
	ret = "application/zip";
	}
	if (fileNameTmp.endsWith("rar")) {
	ret = "application/rar";
	}
	if (fileNameTmp.endsWith("doc")) {
	ret = "application/msword";
	}
	if (fileNameTmp.endsWith("ppt")) {
	ret = "application/vnd.ms-powerpoint";
	}
	if (fileNameTmp.endsWith("xls")) {
	ret = "application/vnd.ms-excel";
	}
	if (fileNameTmp.endsWith("html")) {
	ret = "text/html";
	}
	if (fileNameTmp.endsWith("htm")) {
	ret = "text/html";
	}
	if (fileNameTmp.endsWith("tif")) {
	ret = "image/tiff";
	}
	if (fileNameTmp.endsWith("tiff")) {
	ret = "image/tiff";
	}
	if (fileNameTmp.endsWith("pdf")) {
	ret = "application/pdf";
	}
	if (fileNameTmp.endsWith("apk")) {
		ret = "application/apk";
	}
	return ret;
}

	/**
	 * 下载文件
	 * @param response
	 * @param filePath
	 * @param fileName
	 * @throws ServletException
	 */
	public static void fileDownLoad(HttpServletResponse response, String filePath, String fileName){
	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	OutputStream fos = null;
	InputStream fis = null;
	File file = new File(filePath);
//	String fileName = filePath.substring(filePath.lastIndexOf("\\")+ 1, filePath.length());
	try {
		fis = new FileInputStream(file);
		response.reset();
		response.setContentType(getContentType(fileName));// 根据个人需要,这个是下载文件的类型
//		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);// 在浏览器提示用户是保存还是下载
		response.setHeader("Content-disposition", "attachment;filename="+ new String(fileName.getBytes("gb2312"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(file.length()));// 告诉浏览器下载文件的大小
		bis = new BufferedInputStream(fis);
		fos = response.getOutputStream();
		bos = new BufferedOutputStream(fos);
		int bytesRead = 0;
		byte[] buffer = new byte[1024 * 1024];
		while ((bytesRead = bis.read(buffer)) != -1) {
			fos.write(buffer, 0, bytesRead);// 将文件发送到客户端
//			bos.close();
//			bis.close();
//			fos.close();
//			fis.close();
		}
		fos.flush();
	} catch (IOException e) {
		response.reset();
		e.printStackTrace();
	} finally {
		try {
			if (fos != null) {
				fos.close();
			}
			if (bos != null) {
				bos.close();
			}
			if (fis != null) {
				fis.close();
			}
			if (bis != null) {
				bis.close();
			}
		} catch (IOException e) {
			System.err.print(e);
		}
	}
}

	/**
	 * 删除文件
	 * @param path
	 * @return
	 */
	public static  boolean deleteFile(String path) {
		boolean flag = false;
		try {
			//path数据库保存路径
			File  file = new File(path);
			// 路径为文件且不为空则进行删除
			if (file.isFile()) {
				file.delete();
				flag = true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
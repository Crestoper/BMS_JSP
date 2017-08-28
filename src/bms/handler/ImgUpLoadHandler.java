package bms.handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ImgUpLoadHandler implements CommandHandler{

	@Override
	public String Pro(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// MultipartRequest 타입의 변수 선언
		MultipartRequest mr = null;
		// 업로드할 파일의 최대 사이즈(10 * 1024 * 1024 = 10MB)
		int maxSize = 10 * 1024 * 1024;
		// 임시 파일이 저장되는 논리적인 경로
		String saveDir = req.getRealPath("/BMS/Images/imagebyin/");
		// 업로드할 파일이 위치하게될 물리적인 경로
		String realDir = "C:\\DEV\\Project\\BMS_JSP_V4\\WebContent\\BMS\\Images\\imagebyin\\";
		// 인코딩 타입 : 한글 파일명이 열화되는 것을 방지함
		String encType = "UTF-8";
		try {
		/*
		* DefaultFileRenamePolicy() 객체는 중복된 파일명이 있을 경우, 자동으로 파일명을 변경함
		* (예 : filename.png 가 이미 존재할 경우, filename1.png 과 같이)
		*/
		mr = new MultipartRequest(req, saveDir, maxSize, encType, new DefaultFileRenamePolicy());
		FileInputStream fis = new FileInputStream(saveDir + mr.getFilesystemName("img"));
		FileOutputStream fos = new FileOutputStream(realDir + mr.getFilesystemName("img"));
		int data = 0;
		// 논리적인 경로에 저장된 임시 파일을 물리적인 경로로 복사함
		while((data = fis.read()) != -1) {
		fos.write(data);
		}
		fis.close();
		fos.close();
		/*
		* 위에서 MultipartRequest() 객체를 선언해서 받는 모든 request 객체들은
		* MultipartRequest 타입으로 참조돼야함
		* (예 : request.getParameter 에서 mr.getParameter)
		*/

		} catch (Exception e) {
		e.printStackTrace();
		}

		
		return "/BMS/host/host_stock.jsp";
	}

}

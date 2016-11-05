package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//업로드한 파일 저장 & 저장된 파일 삭제
public class FileService {
	/**
	 * File객체, 저장할 경로, 파일명을 전달받아 서버에 파일 저장
	 * @param file	서버에 임시로 업로드된 파일 객체
	 * @param basePath	저장할 경로
	 * @param filename	서버에 임시로 업로드된 파일의 이름
	 * @return	변경 저장된 파일의 이름
	 * @throws IOException
	 */
	public String saveFile(File file, String basePath, String filename) throws IOException {
		System.out.println("saveFile");
		//파일이 없거나 크기가 0이면 저장하지 않고 null을 리턴
		if (file == null || file.length() <= 0) {
			return null; 
		}
		
		//저장 디렉토리가 없는 경우 생성
		File dir = new File(basePath);
		if (!dir.isDirectory()) dir.mkdirs();
		
		//UUID로 난수 발생시킴 (난수를 발생 시킬 것)
		// spring.jpg => springXXXXXXX.jpg
		//저장할 파일명을 년월일로 생성
		String savedFilename;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		savedFilename = sdf.format(new Date());
		
		//원본 파일의 확장자
		String ext;
		//마지막 (.)의 인덱스 위치를 얻어옴
		int lastIndex = filename.lastIndexOf('.');
		if (lastIndex == -1)
			 //확장명이 없는 애로 간주
			ext = "";
		else 
			 //.dat .jpg .psd (확장명 보존)
			ext = "." + filename.substring(lastIndex + 1);

		//저장할 전체 경로
		String serverFullPath = null;
		File serverFile = null;
		
		//같은 이름의 파일이 있는 경우의 처리 (뒤에 시간정보 붙임)
		while (true) {
			//serverFilename = strDate + ext;
			// serverFullPath = "c:  /  uploadpath/springXXXXXXXX  .jpg"
			serverFullPath = basePath + "/" + savedFilename + ext;
			serverFile = new File(serverFullPath);
			if ( !serverFile.isFile()) break;	//같은 이름의 파일이 없으면 나감.
			// c:/uploadpath/springXXXXXXXX2016070801234.jpg
			savedFilename = savedFilename + new Date().getTime();
		}
		
		//파일 저장
		FileInputStream in = new FileInputStream(file);
		FileOutputStream out = new FileOutputStream(serverFile);
		
		int bytesRead = 0;
		
		//한번에 데이터를 얻을 수 없기 때문에 buffer로 1024byte씩 받음
		byte[] buffer = new byte[1024];
		
		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 약 3000Byte의 파일
		//버퍼에 있는 0~1023번지의 메모리를 InputStream에 꽂음
		while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
			//InputStream 메모리(int bytesRead)에 적재된 만큼 buffer를 0에서부터 OutputStream(서버)로 보냄
			//■■■■■■■■■■ ■■■■■■■■■■ ■■■■■■■■■□□
			//1024/1024	1024/1024	800/1024
			out.write(buffer, 0, bytesRead);
		}
		
		out.close();
		in.close();
		
		//실제 저장된 파일의 이름을 리턴 
		return savedFilename + ext;
	}
	
	
	/**
	 * 서버에 저장된 파일을 삭제
	 * @param fullpath 저장된 파일의 전체 경로
	 * @return 삭제 성공 여부
	 */
	public boolean fileDelete(String fullpath) {
		boolean check = false;
		
		try {
			File file = new File(fullpath);
			if (file.isFile()) {
				file.delete();
				check = true;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return check;
	}
}

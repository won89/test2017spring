package kitri.edu.mvc2;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping(value= "upload.file", method=RequestMethod.GET)
	public String uploadform(){
		return "upload/uploadform";
	}
	@RequestMapping(value="upload.file", method=RequestMethod.POST)
	public String uploadresult(@ModelAttribute("uploadvo") UploadVO vo) throws IllegalStateException, IOException{
		//vo 사용, jsp 전달.
		//name, description 
		//file1, file2 : 이름 , 내용 : c:/uplaod/...
		MultipartFile multipartfile1 = vo.getFile1();
		MultipartFile multipartfile2 = vo.getFile2();
		
		//전송파일명 추출
		String filename1 = multipartfile1.getOriginalFilename();
		String filename2 = multipartfile2.getOriginalFilename();
		
		String savePath = "c:/upload/";
		
		File f = new File(savePath);
		String[] filelist = f.list();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].equals(filename1)) {
				filename1 = "1"+filename1;
				System.out.println(filename1);
			}
			if (filelist[i].equals(filename2)) {
				filename2 = "1"+filename2;
				System.out.println(filename2);
			}
		}
		
		
	
		//File 클래스 내부 list()메소드 : String c:uplaod 폴더 목록 조회하여 
				//filename1, filename2 존재하면
				//filename1+"1", filename2+"1"
		
		File file1 = new File(savePath + filename1);
		File file2 = new File(savePath + filename2);
		
		
		multipartfile1.transferTo(file1);
		multipartfile2.transferTo(file2);
		
		return "upload/uploadresult";
	}
	
}

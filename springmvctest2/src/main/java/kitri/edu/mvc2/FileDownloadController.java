package kitri.edu.mvc2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {
	@RequestMapping(value="download.file", method=RequestMethod.GET)
	public ModelAndView downloadform(){
		 ModelAndView m = new ModelAndView();
		 //파일리스트 : model 저장 
		 //downloadlist.jsp : view 지정
		 
		 String savePath = "c:/upload/";
		 File f = new File(savePath);
		 String[] filelist = f.list();
		 
		 m.addObject("filelist", filelist);
		 m.setViewName("download/downloadform");
		 
		 return m;
	}
	
	//http:.../downloadprocess.file?filename=파일명
	@RequestMapping("downloadprocess.file")
	public void downloadprocess(String filename, HttpServletResponse response) throws IOException{
		//1. 매개변수 필요한 것 추가 
		//2. filename 에 해당하는 파일 찾기 
		File f = new File("c:/upload/", filename);
		//3. response 설정하기 
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("content-Disposition", "attachment;filename=\""+filename+"\"");
		//4. 2의 파일을 response 로 출력하기 
		OutputStream out = response.getOutputStream();
		FileInputStream fis = new FileInputStream(f);
		FileCopyUtils.copy(fis, out);
		fis.close();
		out.close();
	}
	
	
	
}

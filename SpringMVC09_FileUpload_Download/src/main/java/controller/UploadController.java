package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.UploadDataVO;

@Controller
public class UploadController {

	@RequestMapping("fileUpload.do")
	public ModelAndView fileUpload(HttpServletRequest request, HttpServletResponse response, UploadDataVO vo) throws Exception {
		
		//1. upload된 파일을 하나 받아온다.
		MultipartFile mFile = vo.getUploadFile(); //내가 선택한 파일
		System.out.println("MultipartFile :: "+mFile);
		
		//2. upload한 파일이 있다면 그 파일의 원래 이름을 받아온다.
		//   그 파일의 사이즈, 기타정보를 다 받아올 수 있다.(MultipartFile API에서 지원)
		if(!mFile.isEmpty()) {//upload 했다
			System.out.println("getSize :: "+mFile.getSize());
			System.out.println("getName :: "+mFile.getName());
			System.out.println("getOriginalFilename :: "+mFile.getOriginalFilename());
		}
		
		//3. 업로드한 파일을 별도의 풀더로 transfer 시킨다.
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile);//원래 업로드한 파일이 해당 path로 이동..
		
		System.out.println("path :: "+path);
		return new ModelAndView("upload_result","uploadFile", mFile.getOriginalFilename());
	}
	
	@RequestMapping("download.do")
	public ModelAndView download(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String fileName = request.getParameter("fileName");
		System.out.println("fileName :: "+fileName);
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		Map map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView",map);
	}
}

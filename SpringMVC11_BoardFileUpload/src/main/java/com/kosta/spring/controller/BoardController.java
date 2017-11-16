package com.kosta.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.spring.model.BoardVO;
import com.kosta.spring.model.MemberVO;
import com.kosta.spring.service.BoardService;
import com.kosta.spring.service.ListVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("write.do")
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response,
							HttpSession session,BoardVO bvo) throws Exception{
		long currTime = System.currentTimeMillis();
		String newfilename;
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo==null){ //로그인 상태가 아니다...글쓰기로 못간다..
			return new ModelAndView("redirect:/index.jsp");			
		}
		//로그인 한 상태라면
		bvo.setMemberVO(mvo); //bvo와 mvo의 Hasing 관계가 성립된다..
		//1. upload된 파일을 하나 받아온다.
		MultipartFile mFile = bvo.getUploadFile(); //내가 선택한 파일
		System.out.println("MultipartFile :: "+mFile);

		//2. upload한 파일이 있다면 그 파일의 원래 이름을 받아온다.
		//   그 파일의 사이즈, 기타정보를 다 받아올 수 있다.(MultipartFile API에서 지원)
		if(!mFile.isEmpty()) {//upload 했다
			System.out.println("getSize :: "+mFile.getSize());
			System.out.println("getName :: "+mFile.getName());
			System.out.println("getOriginalFilename :: "+mFile.getOriginalFilename());
		}
		bvo.setOrgfilename(mFile.getOriginalFilename());
		newfilename = currTime+"_"+mFile.getOriginalFilename();
		bvo.setNewfilename(newfilename);
		System.out.println("newfilename : "+newfilename);

		//3. 업로드한 파일을 별도의 풀더로 transfer 시킨다.
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";

		File copyFile = new File(path+newfilename);
		mFile.transferTo(copyFile);//원래 업로드한 파일이 해당 path로 이동..

		System.out.println("path :: "+path);
		
		boardService.write(bvo); //w_date
		return new ModelAndView("board/show_content", "bvo",bvo);
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(HttpServletRequest request, String no, String newfilename) throws Exception{
		System.out.println("init delete controller...");	
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		//파일삭제
		boardService.deleteFile(path+newfilename);
		//디비삭제
		boardService.delete(no);
		System.out.println("complete delete...");
		//boardService.delete(no); //w_date
		return new ModelAndView("redirect:/list.do");
	}
	
	@RequestMapping("removeFile.do")
	public ModelAndView removeFile(HttpServletRequest request, String newfilename) {
		System.out.println("Ajax Call...");
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		//파일삭제
		boardService.deleteFile(path+newfilename);//upload풀더에서 파일은 삭제
		return new ModelAndView("JsonView");
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView fileDown(HttpServletRequest	request, String orgfilename, String newfilename) throws Exception{
		HashMap map = new HashMap();
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		map.put("path", path);
		return new ModelAndView("downloadView", map);//downloadView는 빈설정문서의 빈 이름	
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(String no) throws Exception{
		System.out.println("init update controller...");
		BoardVO bvo = boardService.showContent(no);
		System.out.println("complete update...");
		return new ModelAndView("board/update","bvo",bvo);
	}
	
	@RequestMapping("updateBoard.do")
	public ModelAndView update(HttpServletRequest request, BoardVO bvo) throws Exception{
		long currTime = System.currentTimeMillis();
		String newfilename;
		//1. upload된 파일을 하나 받아온다.
				MultipartFile mFile = bvo.getUploadFile(); //내가 선택한 파일
				System.out.println("MultipartFile :: "+mFile);

				//2. upload한 파일이 있다면 그 파일의 원래 이름을 받아온다.
				//   그 파일의 사이즈, 기타정보를 다 받아올 수 있다.(MultipartFile API에서 지원)
				if(!mFile.isEmpty()) {//upload 했다
					System.out.println("getSize :: "+mFile.getSize());
					System.out.println("getName :: "+mFile.getName());
					System.out.println("getOriginalFilename :: "+mFile.getOriginalFilename());
				}
				bvo.setOrgfilename(mFile.getOriginalFilename());
				newfilename = currTime+"_"+mFile.getOriginalFilename();
				bvo.setNewfilename(newfilename);
				System.out.println("newfilename : "+newfilename);

				//3. 업로드한 파일을 별도의 풀더로 transfer 시킨다.
				String root = request.getSession().getServletContext().getRealPath("/");
				String path = root+"\\upload\\";

				File copyFile = new File(path+newfilename);
				mFile.transferTo(copyFile);//원래 업로드한 파일이 해당 path로 이동..
		boardService.updateBoard(bvo);//디비에 데이터를 직접 수정
		return new ModelAndView("board/show_content","bvo",boardService.showContent(bvo.getNo()+""));
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String pageNo) throws Exception{
			ListVO lvo = boardService.getBoardList(pageNo);
			
			return new ModelAndView("board/list", "lvo",lvo);			
		}
	
	@RequestMapping("showContent.do")
	public ModelAndView showContent(HttpServletRequest request, HttpServletResponse response, String no) throws Exception{
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("mvo");
		if(mvo == null) {//로그인하지 않았다
			return new ModelAndView("redirect:/index.jsp");//리다이렉트는 viewResolver에 영향을 받지 않음
		}
		//조회수 증가 로직을 추가
		boardService.updateCount(no);
		BoardVO bvo = boardService.showContent(no);		
		return new ModelAndView("board/show_content", "bvo",bvo);			
		
	}
}









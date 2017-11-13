package com.kosta.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.spring.model.BoardDao;
import com.kosta.spring.model.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public void write(BoardVO bvo)throws SQLException{
		System.out.println("Before BVO :: "+bvo.getNo()); //0
		boardDao.write(bvo); //selectKey가 돌아가서 시퀀스를 vo에주입
		System.out.println("After BVO :: "+bvo.getNo()); //3
		
		String date=boardDao.selectByNoForDate(bvo.getNo());//3
		//받아온 날짜를 bvo에 다시 세팅해준다...
		bvo.setWriteDate(date);
	}
	
	public void delete(String no)throws SQLException{
		System.out.println("init delete...");
		boardDao.delete(no);
		System.out.println("delete complete...");
	}
	
	public void updateCount(String no)throws SQLException{
		boardDao.updateCount(no);
	}
	
	public void updateBoard(BoardVO vo)throws SQLException{
		boardDao.updateBoard(vo);
	}
	//getBoardList + 페이징 처리
	public ListVO getBoardList(String pageNo) throws SQLException{
		//no에 값이 없는 경우 (특정페이지를 클릭하지 않고 바로 최신페이지로 가는 경우)
		if(pageNo == null || pageNo=="") pageNo="1";
		
		//페이징 처리시 수정되어야 되는 부분//
		List<BoardVO> list = boardDao.getBoardList(pageNo); // 현재 페이지에 대한 리스트 리턴
		int totalCount = boardDao.totalCount();
		PagingBean paging = new PagingBean(totalCount, Integer.parseInt(pageNo));
		ListVO lvo = new ListVO(list, paging);
		return lvo;
	}
	
	public BoardVO showContent(String no) throws SQLException{
		return boardDao.showContent(no);
	}

				
}















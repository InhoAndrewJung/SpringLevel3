package com.kosta.spring.service;

import java.sql.SQLException;

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
			boardDao.write(bvo);//selectKey가 돌아가서 시퀀스를 vo에 주입
			System.out.println("After BVO :: "+bvo.getNo()); //3
		}
}

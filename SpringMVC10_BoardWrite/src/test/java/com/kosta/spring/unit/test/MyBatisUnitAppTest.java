package com.kosta.spring.unit.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kosta.spring.model.BoardVO;
import com.kosta.spring.model.MemberVO;

public class MyBatisUnitAppTest {

	@Test
	public void unitTest() throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		BoardVO vo = new BoardVO(0, "1", "메롱", 0, "0", new MemberVO("11", "11", "11", "11"));
		session.insert("boardMapper.write", vo);
		session.commit();
		
	}
}

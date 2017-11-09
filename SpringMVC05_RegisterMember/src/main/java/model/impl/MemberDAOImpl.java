package model.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MemberDao;
import model.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		sqlSession.insert("memberMapper.registerMember",vo);	
	}

	@Override
	public Object idcheck(String id) throws SQLException {		
		return sqlSession.selectOne("memberMapper.idcheck",id);
	}
	@Override
	public MemberVO login(MemberVO vo) throws SQLException {		
		return sqlSession.selectOne("memberMapper.login",vo);	}
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		sqlSession.update("memberMapper.updateMember",vo);		
	}
	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		return sqlSession.selectList("memberMapper.findByAddress", address);
	}
	@Override
	public List<String> getAddressKind() throws SQLException {
		return sqlSession.selectList("memberMapper.getAddressKind");	
	}
	@Override
	public List<MemberVO> getAllMember() throws SQLException {		
		return sqlSession.selectList("memberMapper.getAllMember");
	}	
}

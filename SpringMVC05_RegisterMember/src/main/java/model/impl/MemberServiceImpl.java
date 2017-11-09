package model.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.MemberDao;
import model.MemberService;
import model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		memberDao.registerMember(vo);
		
	}

	@Override
	public boolean idcheck(String id) throws SQLException {
		boolean result = false;
		
		if(memberDao.idcheck(id)!=null) result = true;
		return result;
	}

	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		return memberDao.login(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		memberDao.updateMember(vo);
		
	}

	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		return memberDao.findByAddress(address);
	}

	@Override
	public List<String> getAddressKind() throws SQLException {
		return memberDao.getAddressKind();
	}

	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		return memberDao.getAllMember();
	}
}

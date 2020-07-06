package com.koreait.board99.dao;

import java.sql.*;

import com.koreait.board99.vo.UserVO;

public class UserDAO {
	// i_user, cid, cpw, nm, r_dt : t_user3
	// 성공 : 1, 아이디없음 : 2, 비밀번호 틀림 : 3, 데이터오류 : 0
	public static int login(UserVO param) {
		int result = 0; // 데이터 오류
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT I_USER, CPW, NM FROM T_USER3 "
				+ "WHERE CID = ? ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, param.getCid());
			rs = ps.executeQuery();
			if(rs.next()) {
				String dbcpw = rs.getNString("cpw");
				if(dbcpw.equals(param.getCpw())) {
					int i_user = rs.getInt("i_user");
					String nm = rs.getNString("nm");
					
					param.setI_user(i_user);
					param.setNm(nm);
					
					result = 1; // 로그인 성공
				} else {
					result = 3; // 비밀번호 틀림
				}
				
			} else {
				result = 2; // 아이디 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}
		return result;
	}
	
	// 회원가입 성공 : 1, 실패 : 0
	public static int join(UserVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO T_USER3 "
				+ " (I_USER, CID, CPW, NM) "
				+ " VALUE "
				+ " (SEQ_USER.NEXTVAL, ?, ?, ?) ";
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, param.getCid());
			ps.setNString(2, param.getCpw());
			ps.setNString(3, param.getNm());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps);
		}
		return result;
	}
}

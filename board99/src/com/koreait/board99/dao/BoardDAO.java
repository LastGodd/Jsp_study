package com.koreait.board99.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board99.vo.ComBoardVO;

public class BoardDAO {
	public static List<ComBoardVO> selectList(ComBoardVO param){
		List<ComBoardVO> list = new ArrayList<ComBoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.I_BOARD, A.TITLE, B.NM, A.R_DT " + 
				" FROM T_BOARD3 A, T_USER3 B " + 
				" WHERE B.I_USER = ? ";
		
		try {
			con = DbCon.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_user());
			rs = ps.executeQuery();
			while(rs.next()) {
				ComBoardVO cb = new ComBoardVO();
				cb.setI_board(rs.getInt("i_board"));
				cb.setTitle(rs.getNString("title"));
				cb.setUserNm(rs.getNString("nm"));
				cb.setR_dt(rs.getNString("r_dt"));
				cb.setI_user(param.getI_user());
				
				list.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.close(con, ps, rs);
		}
		return list;
	}
}

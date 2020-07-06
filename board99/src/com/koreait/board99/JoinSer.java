package com.koreait.board99;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board99.dao.UserDAO;
import com.koreait.board99.vo.UserVO;

@WebServlet("/join")
public class JoinSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/join.jsp";
		request.getRequestDispatcher(jsp)
		.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		String nm = request.getParameter("nm");
		
		UserVO param = new UserVO();
		param.setCid(cid);
		param.setCpw(cpw);
		param.setNm(nm);
		
		// 1이 반환되면 가입 성공으로 로그인 페이지로 넘김
		int result = UserDAO.join(param);
		if(result == 1) {
			response.sendRedirect("/login");
		} else { // 그 이외에는 회원가입했을 때의 기록을 남기고 다시 회원가입 페이지를 연다
			request.setAttribute("data", param);
			doGet(request, response);
		}
		
	}

}

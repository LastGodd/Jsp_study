package com.koreait.board99;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board99.dao.UserDAO;
import com.koreait.board99.vo.UserVO;

@WebServlet("/login")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/login.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");

		System.out.println("cid : " + cid);
		System.out.println("cpw : " + cpw);

		UserVO param = new UserVO();
		param.setCid(cid);
		param.setCpw(cpw);

		int result = UserDAO.login(param);
		System.out.println("result : " + result);
		System.out.println("로그인성공 : 1, 아이디 없음 : 2, 비밀번호 틀림 : 3, 데이터베이스 오류 : 0");
//		request.setAttribute("result", result);
		if (result == 1) {
			HttpSession hs = request.getSession();
			param.setCpw(null);
			hs.setAttribute("loginUser", param);
			response.sendRedirect("/boardList");
			return; // 함수를 마치게 하는 역할
		}
		
//		request.setAttribute("reCid", cid);
		doGet(request, response);
	}
}

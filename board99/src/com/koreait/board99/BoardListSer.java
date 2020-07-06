package com.koreait.board99;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board99.dao.BoardDAO;
import com.koreait.board99.vo.ComBoardVO;
import com.koreait.board99.vo.UserVO;

@WebServlet("/boardList")
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUsesr");
		if(loginUser == null) {
			response.sendRedirect("/boardList");
			return;
		}
		ComBoardVO param = new ComBoardVO();
		param.setI_user(loginUser.getI_user());
		
		request.setAttribute("data", BoardDAO.selectList(param));
		
		String jsp = "/WEB-INF/jsp/boardList.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

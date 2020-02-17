package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class SearchUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			List<User> userList = UserDao.searchUsersByNicknameVaguely(request.getParameter("SearchContent"));
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/WEB-INF/JSP/SearchUserResultPage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

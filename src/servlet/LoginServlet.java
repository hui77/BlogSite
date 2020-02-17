package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User u = new User(request.getParameter("Id"), request.getParameter("Password"));
		try {
			if(UserDao.verifyPassword(u)) {
				request.getRequestDispatcher("PersonalHome").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/WrongPage/LoginWrongPage.html").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class UpdatePasswordServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String oldPassword = request.getParameter("oldPassword");
		User u = new User(id, oldPassword);
		try {
			if(UserDao.verifyPassword(u)) {
				u = new User(id, request.getParameter("newPassword"));
				UserDao.updatePassword(u);
				request.setAttribute("user", UserDao.getInfos(id));
				request.getRequestDispatcher("/WEB-INF/JSP/PersonalMessagePage.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/WrongPage/UpdatePasswordWrongPage.html").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
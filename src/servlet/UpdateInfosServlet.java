package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class UpdateInfosServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		User u = new User(id, request.getParameter("Nickname"), request.getParameter("Gender"), request.getParameter("Profession"), request.getParameter("Email"), request.getParameter("Introduction"));
		try {
			UserDao.updateInfos(u);
			request.setAttribute("user", UserDao.getInfos(id));
			request.getRequestDispatcher("/WEB-INF/JSP/PersonalMessagePage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

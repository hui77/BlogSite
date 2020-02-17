package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class PersonalMessageServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null) {
			try {
				request.setAttribute("user", UserDao.getInfos(id));
				request.getRequestDispatcher("/WEB-INF/JSP/PersonalMessagePage.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

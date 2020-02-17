package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDao;
import dao.RelationDao;
import dao.UserDao;

public class PersonalHomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("Id");
		if(id != null) {
			try {
				request.setAttribute("user", UserDao.getInfos(id));
				request.setAttribute("blogs", BlogDao.searchBlogs(id));
				request.setAttribute("noticeNum", RelationDao.getAttentionNum(id));
				request.getRequestDispatcher("/WEB-INF/JSP/PersonalHomePage.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

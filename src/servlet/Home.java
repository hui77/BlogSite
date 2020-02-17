package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDao;

public class Home extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("blogs", BlogDao.searchHotBlogs());
			request.getRequestDispatcher("/WEB-INF/JSP/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

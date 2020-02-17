package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RelationDao;
import dao.UserDao;
import entity.User;

public class AttentionListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			List<String> idList = RelationDao.getAttentionIdList(request.getParameter("id"));
			List<User> userList = new LinkedList<User>();
			for(String id : idList) {
				userList.add(UserDao.getInfos(id));
			}
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/WEB-INF/JSP/AttentionList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

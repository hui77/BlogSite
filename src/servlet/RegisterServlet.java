package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String newId = null;
		while(true){
			Random r = new Random();
			char[] temp = new char[10];
			temp[0] = (char) (r.nextInt(9) + 49);
			for(int i = 1; i <= 9; i++){
				temp[i] = (char) (r.nextInt(10) + 48);
			}
			newId = new String(temp);
			try {
				if(!UserDao.findId(newId)){
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String password = request.getParameter("Password");
		String nickname = request.getParameter("Nickname");
		
		try {
			UserDao.registerUser(new User(newId, password, nickname));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 响应Id给用户
		request.setAttribute("id", newId);
		request.getRequestDispatcher("/WEB-INF/JSP/ReturnID.jsp").forward(request, response);
	}
}

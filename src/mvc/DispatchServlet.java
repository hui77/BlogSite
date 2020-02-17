package mvc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DispatchServlet extends HttpServlet {
	private HandlerMapping handlerMapping;

	@Override
	public void init() throws ServletException {
		try {
			handlerMapping = new HandlerMapping();
			
			SAXReader reader = new SAXReader();
			String config = getInitParameter("config");
			InputStream in = getClass().getClassLoader().getResourceAsStream(config);
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
			List<Element> list = root.elements("bean");
			for(Element element : list) {
				String className = element.attributeValue("class");
				handlerMapping.parseController(className);
			}
			in.close();
			System.out.println(handlerMapping);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("控制器解析错误", e);
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			String uri = request.getRequestURI();
			System.out.println(uri);
			String contextPath = request.getContextPath();
			System.out.println(contextPath);
			uri = uri.substring(contextPath.length());
			System.out.println(uri);
			
			Handler handler = handlerMapping.getHandler(uri);
			String path = handler.execute(request);
			
			if(path.startsWith("redirect:")) {
				path = path.substring("redirect:".length());
				if(path.startsWith("http")) {
					response.sendRedirect(path);
				} else {
					path = contextPath + "/" + path;
					response.sendRedirect(path);
				}
			} else {
				path = "/WEB-INF/jsp/" + path + ".jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Handler> mapping = new HashMap<String, Handler>();

	public HandlerMapping() {

	}

	public void parseController(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class cls = Class.forName(className);
		Object controller = cls.newInstance();
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			RequestMapping ann = method.getAnnotation(RequestMapping.class);
			if (ann != null) {
				String url = ann.value();
				mapping.put(url, new Handler(controller, method));
			}
		}
	}

	public Handler getHandler(String url) {
		return mapping.get(url);
	}
	
	@Override
	public String toString() {
		return "HandlerMapping [mapping=" + mapping + "]";
	}

}

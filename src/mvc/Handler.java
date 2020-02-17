package mvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class Handler {
	private Object controller;
	private Method method;
	public Handler() {
		
	}
	public Handler(Object controller, Method method) {
		this.controller = controller;
		this.method = method;
	}
	public String execute(HttpServletRequest request) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return (String) method.invoke(controller, request);
	}
	@Override
	public String toString() {
		return "Handler [controller=" + controller + ", method=" + method + "]";
	}
}

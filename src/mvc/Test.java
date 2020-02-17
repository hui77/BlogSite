package mvc;

import javax.servlet.http.HttpServletRequest;

/** 处理业务逻辑的类 */
public class Test {
	@RequestMapping("/test1.do")
	public String test1(HttpServletRequest request) {
		System.out.println("test1 is running...");
		return "";
	}
	@RequestMapping("/test2.do")
	public String test2(HttpServletRequest request) {
		System.out.println("tset2 is running...");
		return "";
	}
}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="hui" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Blog Site</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/Home.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<!-- CuFon ends -->
</head>
<body>
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">
					<h1>
						<a href="#">BlogSite<span> on Line</span></a><small>You
							are one step away from the world</small>
					</h1>
				</div>
				<div class="clr"></div>
				<div class="menu_nav">
					<ul>
						<li><a href="L_R/login.html">登录</a></li>
						<li><p>|</p></li>
						<li><a href="L_R/register.html">注册</a></li>
					</ul>
					<div class="search">
						<form id="form" name="form" method="post" action="searchBlog" target="_blank">
							<span> <input name="SearchContent" type="text"
								class="keywords" id="textfield" maxlength="50"
								placeholder="search..." /> <input name="icon" type="image"
								src="images/search.gif" class="button" />
							</span>
						</form>
					</div>
					<!--/search -->
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<div class="clr"></div>
		<div class="content">
			<div class="content_resize">
				<div class="mainbar">
					<hui:forEach var="blog" items="${blogs}">
						<div class="article">
							<p style="font-size: 30px;">${blog.title}</p>
							<div class="clr"></div>
							<p>${blog.content}</p>
							<p>
								<a href="#">Read more</a>
							</p>
						</div>
					</hui:forEach>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<div class="fbg">
			<div class="footer">
				<p class="lr">组长：庄龙晖&nbsp;&nbsp;&nbsp;&nbsp;组员：鄞栋泉,李苏宁,陈榕,何英财</p>
				<br><br>
				<p class="lf" style="font-size: 30px;">
					<a href="#" title="" target="_blank">tedu-JSD1810-福州金山中心-hui</a>
				</p>
				<div class="clr"></div>
			</div>
		</div>
	</div>
</body>
</html>

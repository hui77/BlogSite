<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="hui" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>${user.nickname}的主页</title>
<meta charset="UTF-8">
<script src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	background-color: #080808;
	background-image: url("img/bg_snow.jpg");
}

#imgb {
	display: block;
	margin: 0 auto;
	z-index: 0;
}

header {
	position: absolute;
	left: 43%;
	top: 2%;
	z-index: 1;
}

.head-pic {
	margin: 30px auto;
	display: block;
	width: 150px;
	height: 150px;
	border-radius: 50%;
}

.head-pic img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}

.relation {
	display: block;
	text-decoration: none;
	text-align: center;
	margin: 0 auto;
	font-size: 25px;
	color: #3f82bf;
}

.write {
	display: inline-block;
	text-decoration: none;
	font-size: 30px;
	color: #607d8b;
	margin-top: 66px;
	margin-left: 266px;
	position: absolute;
	top: 240px;
	z-index: 1;
}

.wrapper1 {
	width: 878px;
	margin: 20px auto;
	margin-bottom: 50px;
	border: 1px solid #333333;
	background-image: url("img/bg_article.jpg");
	background-size: 100%;
}

.wrapper2 {
	width: 777px;
	height: 300px;
	margin: 50px;
	border: 1px solid gray;
	overflow: hidden;
}

.article {
	height: 240px;
	text-decoration: none;
	display: block;
	margin: 30px;
	overflow: hidden;
}

.title {
	font-size: 35px;
	font-weight: bold;
	color: #8bc34a;
	margin-left: 50px;
}

.content {
	font-size: 22px;
	color: #4caf50;
}
</style>
</head>

<body>
	<img id="imgb" src="img/bg_top.jpg">
	<header>
		<a class="head-pic" href="PersonalMessage?id=${user.id}"><img alt="" src="img/headPic.png"></a>
		<a class="relation" href="AttentionList?id=${user.id}">关注${noticeNum}</a>
	</header>
	<article>
		<a class="write" href="#">write something...</a>
		<div class="wrapper1">
			<% int i = 0; %>
			<hui:forEach var="blog" items="${blogs}">
				<div class="wrapper2"><a id="<hui:if test="<%= i == 0 %>">first-</hui:if>article" class="article" href="#"><span
				class="title">${blog.title}</span><br><br><span
				class="content">${blog.content}</span></a></div>
				<% i++; %>
			</hui:forEach>
		</div>
	</article>
</body>
</html>
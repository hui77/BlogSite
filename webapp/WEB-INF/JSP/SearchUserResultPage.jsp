<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="hui" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Attention List</title>
<meta charset="UTF-8">
<script type="text/javascript">
	
</script>
<style type="text/css">
body {
	background-image: url("img/snowy.gif");
}

article {
	width: 60%;
	margin: 5% auto;
	padding: 5%;
	background-image: url("img/border_whole2.png");
	background-size: 100% 100%;
}

.user {
	position: relative;
	width: 80%;
	height: 100px;
	margin: 30px auto;
	padding: 20px;
	border: 1px solid gray;
}

.user:first-child {
	margin-top: 50px;
}

.user:last-child {
	margin-bottom: 50px;
}

.head-pic {
	position: absolute;
	left: 20px;;
	display: block;
	width: 100px;
	height: 100px;
	border-radius: 50%;
}

.head-pic img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}

.infos {
	position: absolute;
	left: 150px;
	top: 35px;
}

.infos span {
	margin-right: 15px;
	background: -webkit-linear-gradient(top, #eeeeee, #007382 50%, #eeeeee 51%, #00675d);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
	font-family: "仿宋";
}

.nickname {
	font-size: 25px;
	font-weight: bold;
}

.gender {
	font-size: 20px;
}

.profession {
	font-size: 20px;
}

.introduction {
	font-size: 18px;
}
</style>
</head>

<body>
	<article>
		<hui:forEach var="user" items="${userList}">
			<div class="user">
				<a class="head-pic" href="#"><img alt="" src="img/headPic.png"></a>
				<div class="infos">
					<span class="nickname">${user.nickname}</span><span class="gender"><hui:choose><hui:when test="${user.gender == 'male'}">男</hui:when><hui:when test="${user.gender == 'female'}">女</hui:when><hui:otherwise>秘密</hui:otherwise></hui:choose></span><span
						class="profession">${user.profession}</span><br> <br>
					<span class="introduction">${user.introduction}</span>
				</div>
				<form action="#?noticerId=...&noticedId=..." method="post" target="_self"><div class="attention-button"></div></form>
			</div>
		</hui:forEach>
	</article>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="hui" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user.nickname}</title>
<style type="text/css">
body {
	background-color: #090909;
	background-image: url("img/bg_snow.jpg");
	background-size: 100% 100%;
	padding: 0 5% 5%;
}

#bg_text {
	width: 100%;
}
#border {
	width: 66%;
}
#cartoonPic {
	width: 33%;
}

#modifyInfos {
	position: absolute;
	top: 128%;
	left: 66%;
	color: white;
	font-size: 200%;
	cursor: pointer;
}
#modifyPassword {
	position: absolute;
	top: 120%;
	left: 88%;
	color: white;
	font-size: 200%;
	cursor: pointer;
}
#submitForm {
	position: absolute;
	top: 100%;
	left: 70%;
	color: white;
	font-size: 200%;
	cursor: pointer;
}
#wrongMessage {
	position: absolute;
	top: 80%;
	left: 50%;
	color: #e2bda7;
	font-size: 300%;
}

#content {
	height: 66%;
	width: 44%;
	position: absolute;
	top: 80%;
	left: 10%;
	padding: 1%;
}
.line1{
	height: 10%;
	width: 90%;
	margin: 3%;
	color: white;
}
.line2 {
	height: 20%;
	width: 90%;
	margin: 7%;
	color: white;
}
#line1_introduction {
	height: 40%;
}
.line1>div,.line2>div,input,textarea{
	display: inline-block;
	height: 90%;
	vertical-align: middle;
	font-size: 150%;
	line-height: 150%;
}
.line2>div,.line2>input {
	height: 92%;
	font-size: 200%;
	line-height: 250%;
}
#line1_introduction .tab {
	height: 30%;
}
.line1 .tab {
	width: 25%;
	text-align: center;
}
.line1 input[type='text'], #line1_introduction .content, textarea {
	width: 60%;
}
textarea {
	resize: none;
}
.line1 .tab, .label, input[type='radio'] {
	margin-right: 5%;
}
.line2 .tab {
	width: 25%;
	text-align: center;
	margin-right: 8%;
}
.line2>input {
	height: 30%;
	width: 55%;
}
.tab {
	
}
.content {
	
}
.label {
	
}
input, textarea {
	background-color: rgba(0, 0, 0, 0);
	border: 2px solid #6b412e;
}
.content, .label, .form {
	color: gray;
}
</style>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
var state = "none";
var nicknameReg = /^[\u0020-\u007e\u4e00-\u9af5]{1,20}$/;
var professionReg = /^[\u0020-\u007e\u4e00-\u9af5]{0,20}$/;
var emailReg = /^\w+@\w+\.\w+$/;
var introductionReg = /^[\u0020-\u007e\u4e00-\u9af5]{0,80}$/;
var passwordReg = /^[a-zA-Z0-9]{6,20}$/;
$(function(){
	$("#submitForm").hide();
	$("#wrongMessage").hide();
	$(".line2").hide();
	$(".line1 .form, .line1 .label").hide();
	$("#modifyInfos").click(function(){
		state = "modifyInfos";
		$("#submitForm").show();
		$("#wrongMessage").hide();
		$(".line2").hide();
		$(".line1").show();
		$(".line1 .content").hide();
		$(".line1 .form, .line1 .label").show();
	})
	$("#modifyPassword").click(function(){
		state = "modifyPassword";
		$("#submitForm").show();
		$("#wrongMessage").hide();
		$(".line1").hide();
		$(".line2").show();
	})
	$("#submitForm").click(function(){
		if(state == "modifyInfos"){
			if(nicknameReg.test($("input[name='Nickname']")[0].value)
					&& professionReg.test($("input[name='Profession']")[0].value)
					&& emailReg.test($("input[name='Email']")[0].value)
					&& introductionReg.test($("textarea")[0].innerText)){
				form.action = "UpdateInfos?id=" + ${user.id};
				form.submit();
			}else{
				$("#wrongMessage").show();
			}
		}
		if(state == "modifyPassword"){
			if($("input[name='newPassword']")[0].value == $("input[name='confirmPassword']")[0].value
					&& passwordReg.test($("input[name='oldPassword']")[0].value)
					&& passwordReg.test($("input[name='newPassword']")[0].value)
					&& passwordReg.test($("input[name='confirmPassword']")[0].value)){
				form.action = "UpdatePassword?id=" + ${user.id};
				form.submit();
			}else{
				$("#wrongMessage").show();
			}
		}
	})
})
</script>
</head>
<body>
	<img id="bg_text" src="img/bg_text.jpg">
	<img id="border" src="img/border_infos.jpg">
	<img id="cartoonPic" src="img/cartoonPic.jpg">
	<div id="modifyInfos">修改信息</div>
	<div id="modifyPassword">修改密码</div>
	<div id="submitForm">点我提交表单</div>
	<div id="wrongMessage">格式错了啦！</div>
	<form id="form" action="#" method="post" target="_self">
		<div id="content">
			<div class="line1"><div class="tab">昵称</div><div class="content">${user.nickname}</div><input class="form" name="Nickname" type="text" maxlength="20" value="${user.nickname}"></div>
			<div class="line1"><div class="tab">性别</div><div class="content"><hui:choose><hui:when test="${user.gender == 'male'}">男</hui:when><hui:when test="${user.gender == 'female'}">女</hui:when><hui:otherwise>秘密</hui:otherwise></hui:choose></div><input class="form" name="Gender" type="radio" value="male" <hui:if test="${user.gender == 'male'}">checked</hui:if>><div class="label">男</div><input class="form" name="Gender" type="radio" value="female" <hui:if test="${user.gender == 'female'}">checked</hui:if>><div class="label">女</div><input class="form" name="Gender" type="radio" value="secret" <hui:if test="${user.gender == 'secret'}">checked</hui:if>><div class="label">秘密</div></div>
			<div class="line1"><div class="tab">职业</div><div class="content">${user.profession}</div><input class="form" name="Profession" type="text" maxlength="20" value="${user.profession}"></div>
			<div class="line1"><div class="tab">邮箱</div><div class="content">${user.email}</div><input class="form" name="Email" type="text" maxlength="30" value="${user.email}"></div>
			<div id="line1_introduction" class="line1"><div class="tab">个人说明</div><div class="content">${user.introduction}</div><textarea class="form" name="Introduction" maxlength="80">${user.introduction}</textarea></div>
			
			<div class="line2"><div class="tab">原密码</div><input class="form" name="oldPassword" type="password" maxlength="20"></div>
			<div class="line2"><div class="tab">新密码</div><input class="form" name="newPassword" type="password" maxlength="20"></div>
			<div class="line2"><div class="tab">确认密码</div><input class="form" name="confirmPassword" type="password" maxlength="20"></div>
		</div>
	</form>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="blog login page">
  </head>
  
  <body>
    登录页面. <br>
    <%-- <c:forEach items="${requestDataBean.resultData.list}" var="user">
    	<p>姓名：${user.userName }</p>
    	<p>年龄：${user.age }</p>
    	<p>性别：${user.sex }</p>
    </c:forEach> --%>
    
    <form action="${ctxPath}/base/login/login" method="post">
    	<input name="userName" type="text" placeholder="enter your name here"/>
    	<input name="password" type="password" placeholder="enter your password here"/>
    	<button id="subBtn" type="submit">登录</button>
    </form>
    
    <%@include file="comm/comm.jsp" %>
  </body>
</html>

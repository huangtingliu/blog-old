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
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="blog login page">
	<!-- 浏览器标签页图标32*32 -->
	<%-- <link rel="shortcut icon" href="${resRoot}/yunba.ico"> --%>
  </head>
  
  <body>
    首页. <br>
  
    你好啊！${requestDataBean.resultData.userName }.
    <table>
    	<thead>
    		<tr>
    			<th>用户名</th>
    			<th>性别</th>
    			<th>邮箱</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${requestDataBean.resultData.list }" var="user">
	    		<tr>
	    			<td>${user.user_name }</td>
	    			<td>${user.sex eq'0'?'男':'女'}</td>
	    			<td>${user.email }</td>
	    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
    <%@include file="comm/comm.jsp" %>
  </body>
</html>

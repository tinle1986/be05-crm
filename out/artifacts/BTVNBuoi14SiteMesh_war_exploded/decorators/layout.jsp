<%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
	<title>
		<dec:title/>
	</title>
	<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
</head>

<body>
<!-- Preloader -->
<jsp:include page="/WEB-INF/views/layouts/preloader.jsp"/>
<div id="wrapper">
	<!-- Navigation -->
	<jsp:include page="/WEB-INF/views/layouts/nav_bar.jsp"/>
	<!-- Left navbar-header -->
	<jsp:include page="/WEB-INF/views/layouts/side_bar.jsp"/>
	<!-- Left navbar-header end -->
	<!-- Page Content -->
	<div id="page-wrapper">
			<dec:body/>
	</div>
</div>
<!-- /#wrapper -->
<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>
</body>

</html>
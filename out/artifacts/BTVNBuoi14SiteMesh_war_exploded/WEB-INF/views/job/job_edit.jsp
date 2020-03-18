<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.ttlecom.model.Job" %><%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String contextPath = request.getContextPath();
%>

<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Cập nhật công việc</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material" method="post" action="<%=contextPath%>/job/edit?id=${job.id}">
					<div class="form-group">
						<label class="col-md-12">Tên công việc</label>
						<div class="col-md-12">
							<input type="text" placeholder="Tên công việc"
										 class="form-control form-control-line" name="name" value="${job.name}"></div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày bắt đầu</label>
						<div class="col-md-12">
							<input type="text" placeholder="dd/MM/yyyy"
										 class="form-control form-control-line" name="startTime" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${job.startTime}" />"></div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày kết thúc</label>
						<div class="col-md-12">
							<input type="text" placeholder="dd/MM/yyyy"
										 class="form-control form-control-line" name="endTime" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${job.endTime}" />"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Lưu lại</button>
							<a href="<%=contextPath%>/job" class="btn btn-primary">Quay lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
	<!-- /.row -->
</div>
<!-- /.container-fluid -->
<footer class="footer text-center"> 2018 &copy; myclass.com</footer>



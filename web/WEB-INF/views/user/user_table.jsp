<%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% String contextPath = request.getContextPath(); %>


<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách thành viên</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<%=contextPath%>/user/add" class="btn btn-sm btn-success">Thêm mới</a>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /row -->
	<div class="row">
		<div class="col-sm-12">
			<div class="white-box">
				<div class="table-responsive">
					<table class="table" id="example">
						<thead>
						<tr>
							<th>Id</th>
							<th>Fullname</th>
							<th>Email</th>
							<th>Role</th>
							<th>#</th>
						</tr>
						</thead>
						<tbody>

						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.id}</td>
								<td>${user.fullname }</td>
								<td>${user.email }</td>
								<td>${user.roleId }</td>
								<td>
									<% String editPath = request.getContextPath() + "/user/edit?id=";%>
									<a href="<%= editPath%>${user.id}" class="btn btn-sm btn-primary">Sửa</a>
									<% String deletePath = request.getContextPath() + "/user/delete?id="; %>
									<a href="<%= deletePath %>${user.id}" class="btn btn-sm btn-danger">Xóa</a>
									<a href="<%=contextPath%>/user/view?id=${user.id}" class="btn btn-sm btn-info">Xem</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.container-fluid -->
<footer class="footer text-center"> 2018 &copy; myclass.com</footer>
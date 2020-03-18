<%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String contextPath = request.getContextPath();
%>

<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách quyền</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<%=contextPath%>/role/add" class="btn btn-sm btn-success">Thêm mới</a>
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
							<th>Tên Quyền</th>
							<th>Mô Tả</th>
							<th>Hành Động</th>
						</tr>
						</thead>
						<tbody>

						<%-- Role lists --%>
						<c:forEach var="role" items="${roles}">
							<tr>
								<td>${role.id}</td>
								<td>${role.name}</td>
								<td>${role.description }</td>
								<td>
									<% String editPath = request.getContextPath() + "/role/edit?id=";%>
									<a href="<%= editPath%>${role.id}" class="btn btn-sm btn-primary">Sửa</a>
									<% String deletePath = request.getContextPath() + "/role/delete?id="; %>
									<a href="<%= deletePath %>${role.id}" class="btn btn-sm btn-danger">Xóa</a>
								</td>
							</tr>
						</c:forEach>

						<%-- end Role lists --%>
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
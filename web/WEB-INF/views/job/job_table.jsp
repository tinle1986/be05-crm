<%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	String contextPath = request.getContextPath();
%>


<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách công việc</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<%=contextPath%>/job/add" class="btn btn-sm btn-success">Thêm mới</a>
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
							<th>Tên Công Việc</th>
							<th>Ngày Bắt Đầu</th>
							<th>Ngày Kết Thúc</th>
							<th>Hành Động</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="job" items="${jobs}">
							<tr>
								<td>${job.id}</td>
								<td>${job.name}</td>
								<td><fmt:formatDate pattern="dd-MM-yyyy"
																		value="${job.startTime}"/></td>
								<td><fmt:formatDate pattern="dd-MM-yyyy"
																		value="${job.endTime}"/></td>
								<td>
									<a href="<%=contextPath%>/job/edit?id=${job.id}" class="btn btn-sm btn-primary">Sửa</a>
									<a href="<%=contextPath%>/job/delete?id=${job.id}" class="btn btn-sm btn-danger">Xóa</a>
									<a href="<%=contextPath%>/job/view?id=${job.id}" class="btn btn-sm btn-info">Xem</a>
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
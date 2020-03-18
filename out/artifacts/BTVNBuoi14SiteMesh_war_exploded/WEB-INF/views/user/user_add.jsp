<%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>


<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Thêm mới thành viên</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form method="post" action="<%=contextPath%>/user/add" class="form-horizontal form-material">
					<div class="form-group">
						<label class="col-md-12">Full Name</label>
						<div class="col-md-12">
							<input type="text" placeholder="Your Fullname"
										 class="form-control form-control-line" name="fullname"></div>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-12">Email</label>
						<div class="col-md-12"><input type="email" placeholder="Your Email Address"
																					class="form-control form-control-line" name="email"
																					id="email"></div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Password</label>
						<div class="col-md-12"><input type="password" class="form-control form-control-line"
																					name="password">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Admin Group</label>
						<div class="col-md-12">
							<input type="number" placeholder="Role ID"
										 class="form-control form-control-line" name="roleId"></div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Add User</button>
							<a href="<%=contextPath%>/user" class="btn btn-primary">Quay lại</a>
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
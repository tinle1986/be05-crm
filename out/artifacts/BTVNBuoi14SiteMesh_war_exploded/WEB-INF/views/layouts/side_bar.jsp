<%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %>

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse slimscrollsidebar">
		<ul class="nav" id="side-menu">
			<li style="padding: 10px 0 0;">
				<a href="<%=contextPath%>/dashboard" class="waves-effect"><i class="fa fa-clock-o fa-fw"
																																		 aria-hidden="true"></i><span
								class="hide-menu">Dashboard</span></a>
			</li>
			<li>
				<a href="<%=contextPath%>/user" class="waves-effect"><i class="fa fa-user fa-fw"
																																aria-hidden="true"></i><span
								class="hide-menu">Thành viên</span></a>
			</li>
			<li>
				<a href="<%=contextPath%>/role" class="waves-effect"><i class="fa fa-modx fa-fw"
																																aria-hidden="true"></i><span
								class="hide-menu">Quyền</span></a>
			</li>
			<li>
				<a href="<%=contextPath%>/job" class="waves-effect"><i class="fa fa-table fa-fw"
																																aria-hidden="true"></i><span
								class="hide-menu">Công việc</span></a>
			</li>
			<li>
				<a href="<%=contextPath%>/blank" class="waves-effect"><i class="fa fa-columns fa-fw"
																																 aria-hidden="true"></i><span
								class="hide-menu">Blank Page</span></a>
			</li>
			<li>
				<a href="<%=contextPath%>/error" class="waves-effect"><i class="fa fa-info-circle fa-fw"
																																 aria-hidden="true"></i><span class="hide-menu">Error 404</span></a>
			</li>
		</ul>
	</div>
</div>

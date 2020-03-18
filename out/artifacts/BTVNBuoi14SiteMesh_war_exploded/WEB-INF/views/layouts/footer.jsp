<%--
  Created by IntelliJ IDEA.
  User: tinle
  Date: 3/8/20
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- jQuery -->
<script src='<c:url value="/assets/plugins/bower_components/jquery/dist/jquery.min.js" /> '></script>

<!-- Bootstrap Core JavaScript -->
<script src='<c:url value="/assets/bootstrap/dist/js/bootstrap.min.js" /> '></script>

<!-- Menu Plugin JavaScript -->
<script src='<c:url value="/assets/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js" /> '></script>

<!--slimscroll JavaScript -->
<script src='<c:url value="/assets/js/jquery.slimscroll.js" /> '></script>
<script src='<c:url value="/assets/js/jquery.dataTables.js" /> '></script>

<!--Wave Effects -->
<script src='<c:url value="/assets/js/waves.js" /> '></script>

<!-- Custom Theme JavaScript -->
<script src='<c:url value="/assets/js/custom.min.js" /> '></script>

<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>

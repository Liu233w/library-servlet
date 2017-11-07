<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="MyFirstTag" %>
<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="styles" fragment="true" %>
<%@attribute name="scripts" fragment="true" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <meta name="description" content="">
  <meta name="author" content="">

  <link rel="shortcut icon" href="/favicon.ico">

  <title>Library</title>

  <link href="/fonts/roboto/roboto.css" rel="stylesheet"/>
  <link href="/fonts/material-icons/materialicons.css" rel="stylesheet"/>
  <link href="/lib/bootstrap/dist/css/bootstrap.css" rel="stylesheet"/>
  <link href="/lib/bootstrap-select/dist/css/bootstrap-select.css" rel="stylesheet"/>
  <link href="/lib/toastr/toastr.css" rel="stylesheet"/>
  <link href="/lib/sweetalert/dist/sweetalert.css" rel="stylesheet"/>
  <link href="/lib/famfamfam-flags/dist/sprite/famfamfam-flags.css" rel="stylesheet"/>
  <link href="/lib/font-awesome/css/font-awesome.css" rel="stylesheet"/>
  <link href="/lib/Waves/dist/waves.css" rel="stylesheet"/>
  <link href="/lib/animate.css/animate.css" rel="stylesheet"/>
  <link href="/css/materialize.css" rel="stylesheet"/>
  <link href="/css/style.css" rel="stylesheet">
  <link href="/css/themes/all-themes.css" rel="stylesheet"/>
  <link href="/view-resources/Views/Shared/_Layout.css" rel="stylesheet"/>

  <link href="https://cdn.bootcss.com/datatables/1.10.16/css/dataTables.bootstrap.min.css" rel="stylesheet">

  <!-- View specific styles -->
  <jsp:invoke fragment="styles"/>

</head>
<body class="theme-red">

<!-- Page Loader -->
<div class="page-loader-wrapper">
  <div class="loader">
    <div class="preloader">
      <div class="spinner-layer pl-red">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div>
        <div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>
    </div>
    <p>Please wait...</p>
  </div>
</div>
<!-- #END# Page Loader -->
<!-- Overlay For Sidebars -->
<div class="overlay"></div>
<!-- #END# Overlay For Sidebars -->
<!-- Top Bar -->
<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse"
         data-target="#navbar-collapse" aria-expanded="false"></a>
      <a href="javascript:void(0);" class="bars"></a>
      <a class="navbar-brand" href="/"><i class="fa fa-cubes"></i> Library</a>
    </div>

    <div class="collapse navbar-collapse" id="navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <c:choose>
          <c:when test="${sessionScope.user != null}">
            <li>
              <a href="/Account/Logout">Logout</a>
            </li>
          </c:when>
          <c:otherwise>
            <li>
              <a href="/Account/Login">Login</a>
            </li>
            <li>
              <a href="/Account/Register">Register</a>
            </li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>
<!-- #Top Bar -->
<section>
  <aside id="leftsidebar" class="sidebar">

    <jsp:include page="/jsp/components/sidebarUser.jsp"/>
    <myTag:menu />

    <!-- Footer -->
    <div class="legal">
      <div class="copyright">
        &copy; 2017 <a href="javascript:void(0);">Library</a>.
      </div>
      <div class="version">
        <b>Version </b> 0.0.1
      </div>
    </div>
    <!-- #Footer -->
  </aside>

</section>

<section class="content">
  <div class="container-fluid">
    <jsp:doBody/>
  </div>
</section>

<script src="/lib/json2/json2.js"></script>
<script src="/lib/jquery/dist/jquery.js"></script>
<script src="/lib/bootstrap/dist/js/bootstrap.js"></script>
<script src="/lib/moment/min/moment-with-locales.js"></script>
<script src="/lib/jquery-validation/dist/jquery.validate.js"></script>
<script src="/lib/blockUI/jquery.blockUI.js"></script>
<script src="/lib/toastr/toastr.js"></script>
<script src="/lib/sweetalert/dist/sweetalert-dev.js"></script>
<script src="/lib/spin.js/spin.js"></script>
<script src="/lib/spin.js/jquery.spin.js"></script>
<script src="/lib/bootstrap-select/dist/js/bootstrap-select.js"></script>
<script src="/lib/jquery-slimscroll/jquery.slimscroll.js"></script>
<script src="/lib/Waves/dist/waves.js"></script>
<script src="/lib/push.js/push.js"></script>
<script src="/lib/abp-web-resources/Abp/Framework/scripts/abp.js"></script>
<script src="/lib/abp-web-resources/Abp/Framework/scripts/libs/abp.jquery.js"></script>
<script src="/lib/abp-web-resources/Abp/Framework/scripts/libs/abp.toastr.js"></script>
<script src="/lib/abp-web-resources/Abp/Framework/scripts/libs/abp.blockUI.js"></script>
<script src="/lib/abp-web-resources/Abp/Framework/scripts/libs/abp.spin.js"></script>
<script src="/lib/abp-web-resources/Abp/Framework/scripts/libs/abp.sweet-alert.js"></script>
<script src="/js/admin.js"></script>
<script src="/js/main.js"></script>
<script src="/view-resources/Views/Shared/_Layout.js"></script>

<script src="https://cdn.bootcss.com/datatables/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.bootcss.com/datatables/1.10.16/js/dataTables.bootstrap.min.js"></script>

<script>
    //Localizing momentjs
    moment.locale('en-US');
</script>

<!-- View specific scripts -->
<jsp:invoke fragment="scripts"/>
</body>
</html>

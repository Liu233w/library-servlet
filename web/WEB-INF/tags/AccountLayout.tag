<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <link href="/view-resources/Views/Account/_Layout.css" rel="stylesheet"/>

  <!-- View specific styles -->
  <jsp:invoke fragment="styles"/>

</head>

<body class="login-page">

<div class="login-box">
  <div class="logo">
    <a href="javascript:void(0);">Library</a>
  </div>

  <jsp:doBody/>

  <div class="row">
    <div class="col-xs-12 text-center" style="color: #e9e9e9">
      <small>&copy; 2017 Library. <b>Version </b> 0.0.1</small>
    </div>
  </div>

</div>


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


<script>
    //Localizing momentjs
    moment.locale('en-US');
</script>

<!-- View specific scripts -->
<jsp:invoke fragment="scripts"/>
</body>
</html>

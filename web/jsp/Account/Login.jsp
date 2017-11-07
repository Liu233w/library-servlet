<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:AccountLayout>
  <jsp:attribute name="styles">
    <link rel="stylesheet" href="/view-resources/Views/Account/Login.min.css"/>
  </jsp:attribute>
  <jsp:attribute name="scripts">
    <script src="/view-resources/Views/Account/Login.js?"></script>
  </jsp:attribute>
  <jsp:body>
    <div class="card">
      <div class="body">
        <form id="LoginForm" method="post">
          <h4 class="text-center">Login</h4>
          <c:if test="${param.failed == '1'}">
            <div class="alert alert-danger">
              Invalid Email or Password
            </div>
          </c:if>
          <div class="input-group">
                <span class="input-group-addon">
                    <i class="material-icons">person</i>
                </span>
            <div class="form-line">
              <input type="text" class="form-control" name="Email" placeholder="Email" required autofocus maxlength="50">
            </div>
          </div>
          <div class="input-group">
                <span class="input-group-addon">
                    <i class="material-icons">lock</i>
                </span>
            <div class="form-line">
              <input type="password" class="form-control" name="Password" placeholder="Password" required maxlength="50">
            </div>
          </div>
          <div class="row">
            <div class="col-xs-8 p-t-5">
              <input type="checkbox" name="RememberMe" id="rememberme" class="filled-in chk-col-pink" value="true">
              <label for="rememberme">Remember Me</label>
            </div>
            <div class="col-xs-4">
              <button id="LoginButton" class="btn btn-block bg-pink waves-effect" type="submit">Login</button>
            </div>
          </div>
          <div class="row m-t-15 m-b--20">
            <div class="col-xs-12">
              <a href="/Account/Register">Register</a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </jsp:body>
</t:AccountLayout>
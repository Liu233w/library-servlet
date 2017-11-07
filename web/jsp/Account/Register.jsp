<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:AccountLayout>
  <jsp:attribute name="styles">
    <link rel="stylesheet" href="/view-resources/Views/Account/Login.css"/>
  </jsp:attribute>
  <jsp:body>
    <div class="card">
      <div class="body">
        <form method="post">
          <h4 class="text-center">Register</h4>

          <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger">
              <i class="fa fa-warning"></i> ${requestScope.error.title}
            </div>
          </c:if>

          <div class="form-group form-float">
            <div class="form-line">
              <input type="text" class="form-control" name="Name" required maxlength="50">
              <label class="form-label">Name</label>
            </div>
          </div>

          <div class="form-group form-float">
            <div class="form-line">
              <input type="email" class="form-control" name="Email" required maxlength="50">
              <label class="form-label">Email Address</label>
            </div>
          </div>

          <div class="form-group form-float">
            <div class="form-line">
              <input type="password" class="form-control" name="Password" required maxlength="50">
              <label class="form-label">Password</label>
            </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <a href="/Account/Login" class="btn btn-default waves-effect" >Back</a>
              <button class="btn bg-pink waves-effect" type="submit">Register</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </jsp:body>
</t:AccountLayout>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>
  <jsp:body>
    <div class="row">
      <section class="col-lg-12">
        <div class="panel panel-warning">
          <div class="panel-heading">
            <h3 class="panel-title">${requestScope.error.title}</h3>
          </div>
          <div class="panel-body">
            <p>
                ${requestScope.error.detail}
            </p>
          </div>
        </div>
      </section>
    </div>
  </jsp:body>
</t:layout>
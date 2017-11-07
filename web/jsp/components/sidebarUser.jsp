<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="user-info">
  <div class="image">
    <img src="/images/user.png" width="48" height="48" alt="User" />
  </div>
  <div class="info-container">
    <c:choose>
      <c:when test="${sessionScope.user != null}">
        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <span id="HeaderCurrentUserName"> ${sessionScope.user.name} </span>
        </div>
        <div class="email">${sessionScope.user.email}</div>
      </c:when>
      <c:otherwise>
        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Guest</div>
      </c:otherwise>
    </c:choose>
  </div>
</div>


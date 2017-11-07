<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="MyFirstTag" %>

<t:layout>
  <jsp:attribute name="scripts">
    <script>
        $(function () {
            $("#table").DataTable({
                responsive: true,
                columns: [
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    // 第七列禁止排序和搜索
                    { orderable: false, searchable: false }
                ]
            });
        });
    </script>
  </jsp:attribute>
  <jsp:body>

    <div class="row clearfix">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="card">
          <div class="header">
            <h2>
              Book List
            </h2>
            <ul class="header-dropdown m-r--5">
              <li class="dropdown">
                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button"
                   aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">more_vert</i>
                </a>
                <ul class="dropdown-menu pull-right">
                  <li><a id="RefreshButton" href="javascript:void(0);" class="waves-effect waves-block"><i
                          class="material-icons">refresh</i>Refresh</a></li>
                </ul>
              </li>
            </ul>
          </div>
          <div class="body table-responsive">
            <table class="table" id="table">
              <thead>
              <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Publish</th>
                <th>ISBN</th>
                <th>Detail</th>
                <th>Location</th>
                <th>Action</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${requestScope.books}" var="item">
                <myTag:bookItem book="${item}" />
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </jsp:body>
</t:layout>
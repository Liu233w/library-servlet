<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="MyFirstTag" %>

<t:layout>
  <jsp:attribute name="scripts">
    <script>
        $(function () {
            $('#deleteBtn').click(function (e) {
                abp.message.confirm("Are you sure to delete this book?", function (sure) {
                    if (sure) {
                        $('#form').attr("action", "/BookManage/Delete");
                        $('#form').submit();
                    }
                })
            })
        })
    </script>
  </jsp:attribute>
  <jsp:body>
    <div class="row clearfix">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="card">
          <div class="header">
            <h2>
                ${requestScope.title}
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
          <div class="body">
            <form method="post" id="form">
              <input type="hidden" value="${requestScope.book.id}" name="id"/>
              <div class="row clearfix" style="margin-top:10px;">
                <div class="col-sm-12">
                  <div class="form-group form-float">
                    <div class="form-line">
                      <input class="form-control" type="text" name="title" value="${requestScope.book.title}">
                      <label class="form-label">Title</label>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row clearfix">
                <div class="col-sm-6">
                  <div class="form-group form-float">
                    <div class="form-line">
                      <input type="text" name="author" class="form-control" value="${requestScope.book.author}">
                      <label class="form-label">Author</label>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row clearfix">
                <div class="col-sm-12">
                  <div class="form-group form-float">
                    <div class="form-line">
                      <input type="text" name="publish" class="form-control" value="${requestScope.book.publisher}">
                      <label class="form-label">Publish</label>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row clearfix">
                <div class="col-sm-12">
                  <div class="form-group form-float">
                    <div class="form-line">
                      <input type="text" name="isbn" class="form-control" maxlength="13"
                             value="${requestScope.book.isbn}">
                      <label class="form-label">ISBN</label>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row clearfix">
                <div class="col-sm-12">
                  <div class="form-group form-float">
                    <div class="form-line">
                      <input type="text" name="location" class="form-control" value="${requestScope.book.location}"/>
                      <label class="form-label">Location</label>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row clearfix">
                <div class="col-sm-12">
                  <div class="form-group form-float">
                    <div class="form-line">
                      <textarea name="description" class="form-control no-resize"
                                ><c:out value="${requestScope.book.description}" /></textarea>
                      <label class="form-label">Description</label>
                    </div>
                  </div>
                </div>
              </div>
              <button type="submit" class="btn btn-primary waves-effect">Save</button>
              <c:if test="${param.id != null}">
                <button type="button" class="btn btn-danger waves-effect" href="/BookManage/Delete" id="deleteBtn">Delete</button>
              </c:if>
              <a class="btn btn-default waves-effect" href="/BookList">Cancel</a>
            </form>
          </div>
        </div>
      </div>
    </div>
  </jsp:body>
</t:layout>
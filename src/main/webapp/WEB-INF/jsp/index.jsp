<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title>Oscar | Home</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div role="navigation">
        <div class="navbar navbar-inverse">
            <a href="/" class="navbar-brand">Oscar</a>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="new-journey">New Journey</a></li>
                    <li><a href="all-journeys">All Journey</a></li>
                </ul>
            </div>
        </div>
    </div>

    <c:choose>
        <c:when test="${mode == 'MODE_HOME'}">
            <div class="container" id="homeDiv">
                <div class="jumbotron text-center">
                    <h1>Welcome to Oscar</h1>
                </div>
            </div>
        </c:when>

        <c:when test="${mode == 'MODE_JOURNEYS'}">
            <div class="container text-center" id="journeyDiv">
                <h3>Journeys</h3>
                <hr>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Dirver name</th>
                            <th>Descritpion</th>
                            <th>Date</th>
                            <th>From</th>
                            <th>To</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="task" items="${tasks}">
                            <tr>
                                <td>${task.name}</td>
                                <td>${task.description}</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${task.date}"></fmt:formatDate></td>
                                <td>${task.from}</td>
                                <td>${task.to}</td>
                                <td><a href="update-journey?id=${task.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                <td><a href="delete-journey?id=${task.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:when>

        <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
            <div class="container text-center">
                <h3>Manage Journey</h3>
                <hr>
                <form class="form-horizontal" method="POST" action="save-journey">
                    <input type="hidden" name="id" value="${task.id}"/>
                    <div class="form-group">
                        <label class="control-label col-md-3">Name</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="name" value="${task.name}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3">Description</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="description" value="${task.description}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3">Date</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="date" placeholder="yyyy-MM-dd HH:mm:ss" value="${task.date}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3">From</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="from" value="${task.from}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-md-3">To</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="to" value="${task.to}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Save">
                    </div>
                </form>
            </div>
        </c:when>
    </c:choose>


    <script src="static/js/jquery-1.11.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>

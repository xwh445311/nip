<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style type="text/css">
.top-nav{color: #0c0c0c}

</style>
<script type="text/javascript">
    function logout(){
        showConfirm("您确认退出系统吗？",function(){
            window.location.href="<%=basePath%>/login/logout.do";
        });
    }



    function resize(){
        setTimeout(function(){
            var w = $("#gridPanel").width();
            $("#dataList").datagrid('resize',{width:w});
        },80);


    }
</script>
<div class="header-section">
    <!--toggle button start-->
    <a class="toggle-btn" onclick="resize()"><i class="fa fa-bars"></i></a>
    <!--toggle button end-->

    <!--探索框（暂时不用） start-->
    <%--<form class="searchform" action="index.html" method="post">
        <input type="text" class="form-control" name="keyword" placeholder="Search here..." />
    </form>--%>
    <!--探索框 end-->

    <%--<div class="collapse navbar-collapse menu-left" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li ><a href="index.html">Dashboard</a></li>
            <li class="active"><a href="#">Components</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">UI Kits <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">General</a></li>
                    <li><a href="#">Buttons</a></li>
                    <li><a href="#">Widget</a></li>
                    <li><a href="#">Slider</a></li>
                    <li><a href="#">Many More</a></li>
                </ul>
            </li>
            <li><a href="#">Fontawesome</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Form Components <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Form Elements</a></li>
                    <li><a href="#">Advanced Components</a></li>
                    <li><a href="#">Form Wizard</a></li>
                    <li><a href="#">Form Validation</a></li>
                    <li><a href="#">Dropzone</a></li>
                </ul>
            </li>
        </ul>
    </div>--%><!-- /.navbar-collapse -->
    <div class="top-nav">
    <ul class="nav navbar-nav">
        <li ><a href="index.html">Dashboard</a></li>
        <li class="active"><a href="#">Components</a></li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">UI Kits <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#">General</a></li>
                <li><a href="#">Buttons</a></li>
                <li><a href="#">Widget</a></li>
                <li><a href="#">Slider</a></li>
                <li><a href="#">Many More</a></li>
            </ul>
        </li>
        <li><a href="#">Fontawesome</a></li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Form Components <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href="#">Form Elements</a></li>
                <li><a href="#">Advanced Components</a></li>
                <li><a href="#">Form Wizard</a></li>
                <li><a href="#">Form Validation</a></li>
                <li><a href="#">Dropzone</a></li>
            </ul>
        </li>
    </ul>
    </div>

    <!--消息提示菜单 menu start -->
    <div class="menu-right">
        <ul class="notification-menu">

            <li>
                <a href="javascript:void(0)" class="btn btn-default dropdown-toggle info-number" onclick="logout()">
                    <i class="fa fa-power-off"></i>
                </a>
            </li>

            <%--<li>
                <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge">5</span>
                </a>
                <div class="dropdown-menu dropdown-menu-head pull-right">
                    <h5 class="title">您有5封信件</h5>
                    <ul class="dropdown-list normal-list">
                        <li class="new">
                            <a href="">
                                <span class="thumb"><img src="images/photos/user1.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">John Doe <span class="badge badge-success">new</span></span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="images/photos/user2.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">Jonathan Smith</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="images/photos/user3.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">Jane Doe</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="images/photos/user4.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">Mark Henry</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="images/photos/user5.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">Jim Doe</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                            </a>
                        </li>
                        <li class="new"><a href="">Read All Mails</a></li>
                    </ul>
                </div>
            </li>--%>
            <li>
                <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                    <i class="fa fa-bell-o"></i>
                    <c:if test="${sessionScope.USER_NOTE_COUNT > 0}">
                        <span class="badge">${sessionScope.USER_NOTE_COUNT}</span>
                    </c:if>
                </a>
                <div class="dropdown-menu dropdown-menu-head pull-right">
                    <h5 class="title">您有${sessionScope.USER_NOTE_COUNT}條系統消息未讀</h5>
                    <ul class="dropdown-list normal-list">
                        <c:forEach items="${sessionScope.USER_NOTE_LIST}" var="item">
                            <li class="new">
                                <a href="<%=basePath %>/sysadmin/noteInfo/gotoViewNotePage.do?ntId=${item.ntId}">
                                    <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                    <span class="name">${item.ntHead}  </span>
                                    <em class="small">&nbsp;&nbsp;${item.showDiff} 前</em>
                                </a>
                            </li>
                        </c:forEach>
                        <li class="new"><a href="<%=basePath %>/sysadmin/noteInfo/gotoTsNoteInfoPage.do?isMenu=Y">查看所有消息</a></li>
                    </ul>
                </div>
            </li>
            <li>
                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <img src="images/photos/user-avatar.png" alt="" />
                    ${sessionScope.SESSION_KEY_SYSUSER.uiName}
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                    <li><a href="javascript:void(0)" onclick="chagnePass()"><i class="fa fa-cog"></i>修改密碼</a></li>
                    <li><a href="javascript:void(0)" onclick="logout()"><i class="fa fa-sign-out"></i>登出</a></li>
                </ul>
            </li>

        </ul>
    </div>
    <!--消息提示菜单 end -->

</div>

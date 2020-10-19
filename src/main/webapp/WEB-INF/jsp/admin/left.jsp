<%@ page import="com.efs.common.Util.SysConstant" %>
<script type="text/javascript">

    function gotoPage(url){
        window.location.href=url;
    }

</script>
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="#"><img src="<%=basePath%>/resource/frame/images/syslogo.png" alt="" style="height:42px; "></a>
    </div>

    <div class="logo-icon text-center">
        <a href="index.html"><img src="<%=basePath%>/resource/frame/images/syslogo_2.png" alt="" style="height:42px; "></a>
    </div>
    <!--logo and iconic logo end-->

    <div class="left-side-inner">

        <!-- visible to small devices only -->
        <div class="visible-xs hidden-sm hidden-md hidden-lg">
            <div class="media logged-user">
                <img alt="" src="images/photos/user-avatar.png" class="media-object">
                <div class="media-body">
                    <h4><a href="#">John Doe</a></h4>
                    <span>"Hello There..."</span>
                </div>
            </div>

            <h5 class="left-nav-title">Account Information</h5>
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
                <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
                <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
            </ul>
        </div>

        <!--sidebar nav start-->
        <%=session.getAttribute(SysConstant.SESSION_KEY_FUNC_HTML)%>
        <!--sidebar nav end-->

    </div>
</div>
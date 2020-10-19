<%@ page import="com.efs.common.Util.SysConstant" %><%--
  Created by Auton Code.
  User: xwh
  Date: 2018-05-24 13:41:27
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/common.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=SysConstant.PAGE_TITLE%></title>
    <%@ include file="/common/css.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/resource/jqueryui_1_5_2/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/resource/jqueryui_1_5_2/themes/icon.css">
</head>
<body class="sticky-header">

<section>

	<!-- main content start-->
    <div class="main-content" >

        <!--body wrapper start-->
        <div class="wrapper">
        
        	<!-- 查询条件 -->
            <div class="row">
                <div class="col-md-12">
                    <!--查询条件-->
                    <div class="panel panel-primary">
                        <header class="panel-heading">
                            	首次登录，请先修改密码
                        </header>
                        <div class="panel-body" style="padding: 5px;">
							<form action="<%=basePath%>/sysadmin/userAdmin/updateUserPassFirst.do" id="tsPasswordForm" name="tsPasswordForm" method="post" role="form">
								<div class="alert alert-block alert-danger fade in errorContent" id="errContent" style="display: none"></div><br/>

								<div class="form-group">
									<label for="oldPassword"><span class="text-danger ">*</span>原密码</label>
									<input type="password" class="form-control" name="oldPassword" id="oldPassword">
								</div>
								<div class="form-group">
									<label for="newPassword"><span class="text-danger ">*</span>新密码</label>
									<input type="password" class="form-control" name="newPassword" id="newPassword">
								</div>
								<div class="form-group">
									<label for="newPasswordConfirm"><span class="text-danger ">*</span>新密码确认</label>
									<input type="password" class="form-control" name="newPasswordConfirm" id="newPasswordConfirm">
								</div>

								<div class="form-group">
									<br/><button type="submit" class="btn btn-primary">提交</button>
								</div>

							</form>
                        </div>
                    </div>

					<br/>
					<c:if test="${not empty msg}">
						<div class="alert alert-block alert-danger fade in">
							<strong>错误!</strong>&nbsp;
							${msg}
						</div>
					</c:if>

                </div>
            </div>
            <br/>

		</div>
	</div>
</section>
</body>

<%@ include file="/common/script.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	
    //初始化校验框架
    InitValidate("tsPasswordForm","errContent",{
        oldPassword:{
            required:true,
            remote:{
                url:"<%=basePath%>/sysadmin/userAdmin/checkUserPassword.do",
                type:"post",
                data:{
                    oldPassword:function(){
                        return $('#oldPassword').val();
                    }
                }
            }
        },
        newPassword:{
            required:true,
            minlength:6
        },
        newPasswordConfirm:{
            required:true,
            minlength:6,
            equalTo:newPassword
        }
    },{
        oldPassword:{
            required:"原密码：必须输入",
            remote:"原密码：原密码输入错误"
        },
        newPassword:{
            required:"新密码：必须输入",
            minlength:"新密码：至少需要6位"
        },
        newPasswordConfirm:{
            required:"新密码确认：必须输入",
            minlength:"新密码确认：至少需要6位",
            equalTo:"新密码两次输入不一致"
        }
    });
});


</script>
</html>
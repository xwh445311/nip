<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: xwh
  Date: 2017/6/23
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/common.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=SysConstant.PAGE_TITLE%></title>
    <%@ include file="/common/css.jsp" %>

    <style type="text/css" >
        .titleA{
            color: #EEEEEE;
            text-decoration: none;

        }
        .titleA:hover{
            text-decoration: none;
        }

        .notea{
            font-size: 13px;
            color: #535351;
            text-decoration:none;
        }
    </style>

</head>
<body class="sticky-header">

<section>
    <!-- left side start-->
    <%@ include file="/WEB-INF/jsp/admin/left.jsp" %>
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <%@ include file="/WEB-INF/jsp/admin/top.jsp" %>
        <!-- header section end-->



        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row states-info">

                    <c:forEach items="${chartData.USER_QUICK_LINK }" var="item" varStatus="stat">
                        <div class="col-md-2">
                            <a class="titleA" href='<%=basePath%>${item.muUrl}'>
                            <div class="panel ${item.quickColor}-bg">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <i class="fa ${item.quickIcon}"></i>
                                        </div>
                                        <div class="col-xs-7">
                                            <h4>
                                            <span class="state-title">${item.muName}</span>
                                            </h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </a>
                        </div>
                    </c:forEach>

            </div>

            <div class="row">
                <div class="col-md-8">
                    <div class="panel">
                        <header class="panel-heading">
                            通知信息
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <%--<a href="javascript:;" class="fa fa-times"></a>--%>
                             </span>
                        </header>
                        <div class="panel-body">
                            <ul class="list-group">
                                <c:if test="${not empty chartData.tsMessageInfoList}">
                                    <c:forEach items="${chartData.tsMessageInfoList}" var="item">
                                        <li class="list-group-item">
                                            <a class="thumb pull-left notea" href="#"> <img src="<%=basePath%>/resource/images/user3.png" style="height: 22px;"> </a>
                                            <a class="notea" href="<%=basePath%>/office/message/gotoDetailPage.do?miCode=${item.miCode}&flag=00">
                                                <small class="pull-right text-muted">${item.miIssueDate} ${item.miIssueTime}</small>
                                                <strong>【${item.miIssueDeptNm}】</strong>
                                                <span>${item.miTitle}</span>
                                            </a>

                                            <c:choose>
                                                <c:when test="${item.miLvl == '1'}">
                                                <span class="label label-sm btn-danger">
                                                        ${item.miLvlNm}
                                                </span>
                                                </c:when>
                                                <c:when test="${item.miLvl == '2'}">
                                                    <span class="label label-sm btn-warning">
                                                            ${item.miLvlNm}
                                                    </span>
                                                </c:when>
                                                <c:when test="${item.miLvl == '3'}">
                                                    <span class="label label-sm btn-info">
                                                            ${item.miLvlNm}
                                                    </span>
                                                </c:when>
                                                <c:when test="${item.miLvl == '4'}">
                                                    <span class="label label-sm btn-success">
                                                            ${item.miLvlNm}
                                                    </span>
                                                </c:when>
                                            </c:choose>
                                        </li>
                                    </c:forEach>
                                </c:if>

                                <c:if test="${empty chartData.tsMessageInfoList}">
                                    <li class="list-group-item">
                                        <a class="thumb pull-left" href="#"></a>
                                        <strong>暂无任何通知</strong>
                                    </li>
                                </c:if>
                            </ul>
                            <a class="thumb pull-right" href="<%=basePath%>/office/message/gotoTsMessageInfoPage.do">更多通知</a>
                        </div>
                    </div>

                    <!--工作台-->
                    <div class="col-md-12" style="padding: 0px 0px 0px 0px;">
                        <div class="panel">
                            <header class="panel-heading">
                                我的工作台
                                <span class="tools pull-right">
                                    <a href="javascript:;" class="fa fa-chevron-down"></a>
                                    <%--<a href="javascript:;" class="fa fa-times"></a>--%>
                                 </span>
                            </header>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <c:if test="${not empty chartData.locProcessDefinitionList}">
                                        <c:forEach items="${chartData.locProcessDefinitionList}" var="item">
                                            <li class="list-group-item">
                                                <a class="thumb pull-left notea" href="#"> <img src="<%=basePath%>/resource/images/flow.png" style="height: 22px;"> </a>
                                                <a class="notea" href="javascript:;" onclick="showProcImg('${item.wokProsId}')">
                                                    <span>【${item.wokProsName}】 &nbsp;${item.wokProsDesc}</span>
                                                </a>
                                                <small class="pull-right text-muted">
                                                    <a>申请</a>&nbsp;&nbsp;
                                                </small>
                                            </li>
                                        </c:forEach>
                                    </c:if>

                                    <c:if test="${empty chartData.locProcessDefinitionList}">
                                        <li class="list-group-item">
                                            <a class="thumb pull-left" href="#"></a>
                                            <strong>暂无可用流程</strong>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12" style="padding: 0px 0px 0px 0px;">
                        <section class="panel">
                            <header class="panel-heading">
                                我的访问量
                                <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <%--<a href="javascript:;" class="fa fa-times"></a>--%>
                         </span>
                            </header>
                            <div class="panel-body">
                                <div id="myvisitChart" style="width: 100%;height:358px; text-align: center; margin:0 auto;">
                                </div>
                            </div>
                        </section>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="panel">
                        <header class="panel-heading">
                            待办工作
                            <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <%--<a href="javascript:;" class="fa fa-times"></a>--%>
                             </span>
                        </header>
                        <div class="panel-body">
                            <ul class="list-group">
                                <c:if test="${not empty chartData.todoTaskInfoList}">
                                    <c:forEach items="${chartData.todoTaskInfoList}" var="item">
                                        <li class="list-group-item">
                                            <a class="thumb pull-left notea" href="#"> <img src="<%=basePath%>/resource/images/user3.png" style="height: 22px;"> </a>
                                            <a class="notea" href="<%=basePath%>${item.ttUrl}"> <strong>${item.mainTitle}</strong>
                                                <span>${item.ttTitle}</span>
                                            </a>
                                            <span class="label label-sm btn-${item.ttLvl}">
                                                <c:choose>
                                                    <c:when test="${item.ttLvl == 'danger'}">
                                                        高
                                                    </c:when>
                                                    <c:when test="${item.ttLvl == 'warning'}">
                                                        中
                                                    </c:when>
                                                    <c:when test="${item.ttLvl == 'success'}">
                                                        低
                                                    </c:when>
                                                </c:choose>
                                            </span>
                                        </li>
                                    </c:forEach>
                                </c:if>

                                <c:if test="${empty chartData.todoTaskInfoList}">
                                    <li class="list-group-item">
                                        <a class="thumb pull-left" href="#"></a>
                                        <strong>暂无待办任务</strong>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>

                    <auth:ax srcId="role_queryAddressBook">
                    <!--快捷通讯录-->
                    <div class="col-md-12" style="padding: 0px 0px 0px 0px;">
                        <div class="panel">
                            <header class="panel-heading">
                                通讯录
                                <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <%--<a href="javascript:;" class="fa fa-times"></a>--%>
                             </span>
                            </header>
                            <div class="panel-body">
                                <input type="text" placeholder="输入用户名、学号、班级搜索" class="form-control blog-search" name="addrBook" id="addrBook" onchange="searAddrBook()">
                                <br/><br/>
                                <ul class="list-group" id="addBookPane">

                                </ul>
                            </div>
                        </div>
                    </div>
                    </auth:ax>

                    <div class="col-md-12" style="padding: 0px 0px 0px 0px;">
                        <div class="panel">
                            <header class="panel-heading">
                                系统提示
                                <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <%--<a href="javascript:;" class="fa fa-times"></a>--%>
                             </span>
                            </header>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span>为了更好的兼容性，更快的访问系统，建议使用<a href="https://download-ssl.firefox.com.cn/releases-sha2/stub/official/zh-CN/Firefox-latest.exe">火狐浏览器</a></span>
                                    </li>
                                    <li class="list-group-item">
                                        <span>如果需要使用条码打印的功能，请分别下载并安装<a href="<%=basePath%>/model/install_lodop32.exe">驱动程序1</a>和<a href="<%=basePath%>/model/CLodop_Setup_for_Win32NT.exe">驱动程序2</a></span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-8">
                    <section class="panel">
                        <header class="panel-heading">
                            总的访问量
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <%--<a href="javascript:;" class="fa fa-times"></a>--%>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="visitChart" style="width: 100%;height:358px; text-align: center; margin:0 auto;">
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer>
            2018 &copy; 徐武海版权所有
        </footer>
        <!--footer section end-->

        <!-- 密码修改 -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title">修改密码</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form" id="userForm">

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
                                <br/><button type="button" class="btn btn-primary" onclick="doChanePass()">提交</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- 二维码 -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="imgModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title">通讯录二维码，请用微信扫一扫</h4>
                    </div>
                    <div class="modal-body" style="text-align: center">
                        <img src="" width="" id="barCodeImg">
                    </div>
                </div>
            </div>
        </div>

        <!-- 流程图 -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="procImgModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title">流程步骤图</h4>
                    </div>
                    <div class="modal-body" style="text-align: center">
                        <img src="" width="" id="procImg">
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- main content end-->
</section>
</body>
<%@ include file="/common/script.jsp" %>
<script type="application/javascript">

    $(document).ready(function(){

        //初始化校验框架
        InitValidate("userForm","errContent",{
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


    var visitChart = echarts.init(document.getElementById('visitChart'));
    var option = {
        title: {
            text: '近十日系统总访问量'
        },
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data:['用户访问']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ${chartData.USER_LOGIN_LAB}
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'访问次数',
                type:'line',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'top'
                    }
                },
                itemStyle: {normal: {color:'#AED4C3'}},
                areaStyle: {normal: {color:'#AED4C3'}},
                data:${chartData.USER_LOGIN_DATA}
            }
        ]
    };

    visitChart.setOption(option);

    //我的访问量
    var myvisitChart = echarts.init(document.getElementById('myvisitChart'));
    var myoption = {
        title: {
            text: '我的访问量'
        },
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data:['我的访问']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ${chartData.CURUSER_LOGIN_LAB}
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'访问次数',
                type:'line',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'top'
                    }
                },
                areaStyle: {normal: {}},
                data:${chartData.CURUSER_LOGIN_DATA}
            }
        ]
    };

    myvisitChart.setOption(myoption);

    function chagnePass(){

        ClearForm("userForm");
        $('#myModal').modal('show');
    }

    function doChanePass(){

        //數據校驗
        if(!Vlaidate()){
            return;
        }

        //修改用戶信息
        var url = "<%=basePath %>/sysadmin/userAdmin/updateUserPass.do";
        SubmitForm("userForm",url,function(data){
            ShowSuccessDialog("修改成功");
            $('#myModal').modal('hide');
        },function () {
            ShowErrorDialog("修改失败");
        });
    }

    function searAddrBook(){
        var keyWord = $('#addrBook').val();
        if(keyWord==''){
            ShowErrorDialog("请输入查询关键字");
            return;
        }

        $.ajax({
            async: false,
            ifModified:true,
            type: "POST",
            url: "<%=basePath%>/sysadmin/userAdmin/queryAddressBook.do",
            data: {"keyWord":keyWord},
            dataType: "json",
            success: function(data)
            {
                if(data.success){
                    $('#addBookPane').empty();
                    $('#addBookPane').append(data.data)
                }else{
                    ShowErrorDialog("查找通讯录信息失败！");
                }
            },
            error: function(request, status, err)
            {
                ShowErrorDialog(request.status + "," + request.responseText);
                ShowErrorDialog("查找通讯录信息失败");
            }
        });
    }

    function showBarCodeImg(userId){
        $('#barCodeImg').attr("src",'<%=basePath%>/sysadmin/userAdmin/getVcardBarCode.do?userId=' + userId + "&stamp=" + Date.parse(new Date()));
        $('#imgModal').modal('show');
    }

    function showProcImg(defId){
        $('#procImg').attr("src",'<%=basePath%>/bpmn/procDef/showProcessDefImag.do?wokProsId=' + defId );
        $('#procImgModal').modal('show');
    }


</script>
</html>

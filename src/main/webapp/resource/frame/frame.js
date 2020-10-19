/**
 * Created by xwh on 2017/6/28.
 */

var rootContext='/SGOP';
var codeTextX=45;
var codeTextY=5;

/**
 * 提示确认对话框
 * @param title
 * @param message
 */
function showConfirm(message,okfunc){
    BootstrapDialog.confirm({
        title: '確認對話框',
        message: message,
        type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: '取消', // <-- Default value is 'Cancel',
        btnOKLabel: '確認', // <-- Default value is 'OK',
        btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            // result will be true if button was click, while it will be false if users close the dialog directly.
            if(result) {
                okfunc.call();
            }
        }
    });

}

function ShowErrorDialog(message){
    BootstrapDialog.alert({
        title: '錯誤',
        message: message,
        type: BootstrapDialog.TYPE_DANGER, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true // <-- Default value is false
    });
}

function ShowSuccessDialog(message){
    BootstrapDialog.alert({
        title: '成功',
        message: message,
        type: BootstrapDialog.TYPE_SUCCESS, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true // <-- Default value is false
    });
}

function ShowWarningDialog(message){
    BootstrapDialog.alert({
        title: '警告',
        message: message,
        type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true // <-- Default value is false
    });
}

function ShowMessageDialog(message){
    BootstrapDialog.alert({
        title: '消息對話框',
        message: message,
        type: BootstrapDialog.TYPE_INFO, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true // <-- Default value is false
    });
}

/**
 * 通用AJAX请求
 * @param url
 * @param data
 * @param succFunc
 * @param errFunc
 * @constructor
 */
function PostAjax(url,data,succFunc,errFunc){
    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: url,
        data: data,
        dataType: "json",
        success: function(data)
        {

            if(data.success == true){

                if(data.message != null && data.message.length > 0){
                    ShowSuccessDialog(data.message);
                }

                if(succFunc){
                    succFunc(data.data);
                }

            }else{
                if(data.message != null && data.message.length > 0){
                    ShowErrorDialog(data.message);
                }

                if(errFunc){
                    errFunc.call();
                }
            }

        },
        error: function(request, status, err)
        {
            ShowErrorDialog("操作失敗,[" + request.status + "," + request.readyState + "]," + request.responseText);

            if(errFunc){
                errFunc.call();
            }
        }
    });
}

function ClearForm(formid) {
    $('#' + formid).form('clear');

}

/**
 * 加载FORM表单数据
 * @param formid
 * @param url
 * @param params
 * @constructor
 */
function LoadForm(formid,url,params,succFunc,errFunc){

    //清空表单内容
    ClearForm(formid);

    //发送JSON请求
    PostAjax(url,params,function (data) {

        //装载数据
        var obj = data;
        var key,value,tagName,type,arr,x;
        for(x in obj){
            key = x;
            value = obj[x];

            $("[name='"+key+"'],[name='"+key+"[]']").each(function(){
                tagName = $(this)[0].tagName;
                type = $(this).attr('type');
                if(tagName=='INPUT'){
                    if(type=='radio'){
                        if($(this).val()==value){
                            $(this).iCheck('check');
                        }

                    }else if(type=='checkbox'){
                        arr = value.split(',');
                        for(var i =0;i<arr.length;i++){
                            if($(this).val()==arr[i]){
                                $(this).iCheck('check')
                                break;
                            }
                        }
                    }else{
                        $(this).val(value);
                    }
                }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
                    $(this).val(value);
                }

            });
        }

        //数据装后调回调方法
        if(succFunc){
            succFunc.call();
        }

    },errFunc);


}

/**
 * 提交表單信息
 * @param formId
 * @param url
 * @param succFunc
 * @param errFunc
 * @constructor
 */
function SubmitForm(formId,url,succFunc,errFunc){
    PostAjax(url,$('#' + formId).serialize(),function (data) {
        if(succFunc){
            succFunc(data);
        }else{
            ShowSuccessDialog("數據保存成功！");
        }
    },function(data){
        if(errFunc){
            errFunc(data);
        }else{
            ShowErrorDialog("數據保存失敗");
        }
    })
}

//校验部分
var validForm ;
var specFunc;
var validator;
function InitValidate(formId,contentId,rule,message,specValid){
    validForm = $('#' + formId);
    specFunc = specValid;
    validator = validForm.validate({
        errorLabelContainer:$("#" + contentId),
        rules:rule,
        messages:message
    });
}

/**
 * 校验框架
 * @param validForm：校验表单
 * @param rules：VALID校验规则
 * @param messages：VALID校验信息
 * @param specValidFunc：特殊校验框架
 * @constructor
 */
function Vlaidate(){
    var errMsg = "";

    if(validForm){
        if(!validForm.valid()){

            return false;
        }
    }

    if(specFunc){
        errMsg = specFunc();

        if(errMsg.length > 0){
            ShowErrorDialog(errMsg);
            return false;
        }
    }

    return true;
}

/**
 * 重置验证器
 * @constructor
 */
function ResetValidate(){
    if(validator){
        validator.resetForm();
    }
}

//調整DATA GRID 分頁控件
function initDataGridPage(gridID)
{
    var p = $('#' + gridID).datagrid({
        onLoadError:function(){
            ShowErrorDialog("加载数据错误");
            return;
        },
        emptyMsg:"暂无信息显示"
    }).datagrid('getPager').pagination({
        pageSize: 20,
        pageList: [10,20,30,50,100],
        beforePageText: '第',
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    });
}

/*
禁用表单控件
 */
function disabledField(fileId){
    $('#' + fileId).attr('disabled','disabled');
}

/**
 * 取消禁用
 * @param fileId
 */
function cancleDisabledField(fileId){
    $('#' + fileId).removeAttr('disabled');
}

/**
 * 设置只读
 * @param fileId
 */
function readonlyField(fileId){
    $('#' + fileId).attr('readonly','readonly');
}

/**
 * 取消只读
 * @param fileId
 */
function cancleReadonlyField(fileId){
    $('#' + fileId).removeAttr('readonly');
}

/**
 * 从远程方法获取下拉列表数据，数据格式遵从JSON RESULT对象格式
 * @param selId
 * @param url
 * @param paraObj
 * @param hasTitle
 */
function genSelectListFromRemote(selId,url,paraObj,hasTitle){
    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: url,
        data: paraObj,
        dataType: "json",
        success: function(data)
        {
            $("#" + selId).empty();
            if(hasTitle == true){
                $("#" + selId).append("<option value=''>请选择</option>");
            }

            $.each(data.data,function(index,value){
                $("#" + selId).append("<option value='" + value.key + "'>" + value.value + "</option>");
            });
        },
        error: function(request, status, err)
        {
            ShowErrorDialog("获取数据失败" + request + "," + status + "," + err);
        }
    });
}

/*
根据学期更换班级
 */
function changeClassFromTerm(termId,classId){
    var term = $('#' + termId).val();

    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: rootContext + '/edu/classes/listClassSelectListFromTerm.do',
        data: {'term':term},
        dataType: "json",
        success: function(data)
        {
            $("#" + classId).empty();
            $("#" + classId).append("<option value=''>请选择</option>");

            $.each(data.data,function(index,value){
                $("#" + classId).append("<option value='" + value.key + "'>" + value.value + "</option>");
            });
        },
        error: function(request, status, err)
        {
            ShowErrorDialog("获取数据失败" + request + "," + status + "," + err);
        }
    });
}

/**
 * 初始化打印程序,ws变量由调用都自己定义
 */
var wsUrl = 'ws://127.0.0.1:2012';//打印后台地址与

function argonxConnect() {
    if ('WebSocket' in window) {
        ws = new WebSocket(wsUrl);
    }
    else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(wsUrl);
    } else {
        alert('当前浏览器不支持条码打印');

    }

    //注册各类回调
    ws.onopen = function () {
        //alert('连接打印后台成功');
    }

    ws.onclose = function () {
        //alert('与打印后台断开连接');
    }
    ws.onerror = function () {
        alert('数据传输发生错误');
    }
    ws.onmessage = function (receiveMsg) {
        if(receiveMsg.data.split("|")[0] == "A_GetPrinterStatus"){

            var ret=receiveMsg.data.split("|")[1] ;
            if (ret == 0) {
                document.getElementById("status").value = "无返回值";
                return;
            }
            else if (ret== 1)
            {
                document.getElementById("status").value = "打印机命令解析器忙碌中！";
                return;
            }
            else if (ret== 2)
            {
                document.getElementById("status").value ="2 纸张用完或安装错误！";          //纸张用完或安装错误！
                return;
            }
            else if (ret== 4)
            {
                document.getElementById("status").value ="4 碳带用完或安装错误！";                       //碳带用完或安装错误！";
                return;
            }
            else if (ret== 8)
            {
                document.getElementById("status").value ="8 打印批次文档中！";           //打印批次文档中！";
                return;
            }
            else if (ret== 16)
            {
                document.getElementById("status").value ="16 正在打印文件！";                 //正在打印文件！
                return;
            }
            else if (ret== 32)
            {
                document.getElementById("status").value = "32 打印机暂停！";                 //打印机暂停！
                return;
            }
            else if (ret== 64)
            {
                document.getElementById("status").value = "64 正在送出标签纸！";                 //正在送出标签纸！
                return;
            }
            else if (ret== 9)
            {
                document.getElementById("status").value = "9 打印机待机中！";                 //打印机待机中！
                return;
            }

        }
    }
}

/**
 * 打印条码信息
 */
function printArgonxBarCode(barCode) {
    //尝试向打印后台发送消息
    ws.send('A_EnumUSB');
    ws.send('A_CreateUSBPort|1');
    ws.send('A_Set_Backfeed|320');
    ws.send('A_Prn_Barcode|12|2|1|E|2|4|40|B|1|' + barCode);
    ws.send('A_Print_Out|1|1|1|1');
    ws.send('A_ClosePrn');
}

/**
 * 打印条码并带文字信息
 * @param barCode
 * @param text
 */
function printArgonxBarCodeAndText(barCode,text){
    //尝试向打印后台发送消息
    ws.send('A_EnumUSB');
    ws.send('A_CreateUSBPort|1');
    ws.send('A_Set_Backfeed|320');
    ws.send('A_Prn_Barcode|20|35|1|E|3|7|45|B|1|' + barCode);
    ws.send('A_Prn_Text_TrueType|65|5|35|宋体|1|600|0|0|0|CC|'+ text +'|1');
    ws.send('A_Print_Out|1|1|1|1');
    ws.send('A_ClosePrn');
}

/**
 * 打印条码并带文字信息
 * @param barCode
 * @param text
 */
function printArgonxBarCodeAndTextDef(barCode,text,x,y){
    //尝试向打印后台发送消息
    ws.send('A_EnumUSB');
    ws.send('A_CreateUSBPort|1');
    ws.send('A_Set_Backfeed|320');
    ws.send('A_Prn_Barcode|30|35|1|E|3|7|45|B|1|' + barCode);
    ws.send('A_Prn_Text_TrueType|'+x+'|'+y+'|35|宋体|1|600|0|0|0|CC|'+ text +'|1');
    ws.send('A_Print_Out|1|1|1|1');
    ws.send('A_ClosePrn');
}
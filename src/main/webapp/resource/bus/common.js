/**
 * 添加宠物信息
 */
function addPetInfo(){
    var lastIndex = 0;
    var oldName = "";
    var oldId = "";
    var newName = "";
    var newId = "";

    lastIndex = $("#petDiv section").length;

    //添加新项
    var $lastObj = $("#petModel").children().clone(true);

    oldName = $lastObj.find(".petTitle").html();
    newName = newChangeName(oldName,lastIndex+1);
    $lastObj.find(".petTitle").html(newName);

    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            oldId = $(this).attr("id");

            newName = newChangeName(oldName,lastIndex);
            newId = newChangeName(oldId,lastIndex);

            $(this).attr("name",newName);
            $(this).attr("id",newId);
        });

    $("#petDiv").append($lastObj);
}

/**
 * 添加宠物信息
 */
function addInHospitalReason(){
    var lastIndex = 0;
    var oldName = "";
    var oldId = "";
    var newName = "";
    var newId = "";

    lastIndex = $("#resonDiv div").length;

    //添加新项
    var $lastObj = $("#reasonModel").children().clone(true);

    oldName = $lastObj.find(".titleSpan").html();
    newName = newChangeName(oldName,lastIndex+1);
    $lastObj.find(".titleSpan").html(newName);

    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            //oldId = $(this).attr("id");

            newName = newChangeName(oldName,lastIndex);
            //newId = newChangeName(oldId,lastIndex);

            $(this).attr("name",newName);
            //$(this).attr("id",newId);
        });

    $("#resonDiv").append($lastObj);
}

function delInHospitalReason(item) {
    $(item).parent().remove();
}

function newChangeName(oldName,newIndex)
{
    var newName = "";
    var oldVal = "";

    if(typeof(oldName) != "undefined" && oldName !=''){
        oldVal = oldName.match(/\{0\}/);
        newName = oldName.replace(oldVal,newIndex);
    }
    return newName;
}

function newChangeChildName(oldName,parentIndex,newIndex)
{
    var newName = "";
    var oldVal = "";

    if(typeof(oldName) != "undefined" && oldName !=''){

        oldVal = oldName.match(/\{0\}/);
        newName = oldName.replace(oldVal,parentIndex);

        oldVal = newName.match(/\{1\}/);
        newName = newName.replace(oldVal,newIndex);
    }
    return newName;
}

/**
 * 添加項目計劃表
 * @param index
 */
function addAdviceItemPlan(parentIndex){
    var lastIndex = 0;
    var oldName = "";
    var newName = "";
    var modType = "";


    modType = $('#mtHosType_' + parentIndex).val();
    lastIndex = $("#itemPlanTable_" + parentIndex).children().length;

    //添加新项
    var $lastObj = $("#itemPlanTableModel_"+ modType +" tbody").children().clone(true);


    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            //oldId = $(this).attr("id");

            newName = newChangeChildName(oldName,parentIndex,lastIndex);
            //newId = newChangeChildName(oldId,parentIndex,lastIndex);

            $(this).attr("name",newName);
            //$(this).attr("id",newId);
        });

    //更新方法的參數
    $lastObj
        .find("button")
        .each(function(){
            oldName = $(this).attr("onclick");
            newName = newChangeChildName(oldName,parentIndex,lastIndex);
            $(this).attr("onclick",newName);
        });

    $("#itemPlanTable_" + parentIndex).append($lastObj);
}

/**
 * 检查是否能够增加新的计划项目（如果已经勾选24小，则不能增加）
 */
function checkCanAdd(){

}

/**
 * 复制項目計劃表
 * @param index
 */
function copyAdviceItemPlan(parentIndex,obj){
    var lastIndex = 0;
    var oldName = "";
    var oldId = "";
    var newName = "";
    var newId = "";

    lastIndex = $("#itemPlanTable_" + parentIndex).children().length;

    //添加新项
    //var $lastObj = $(this).parentsUntil('tbody').clone(true);

    var $lastObj = $(obj).parent().parent().clone(true);
    var delNum = $lastObj.children().children('[delete]').length;
    if(delNum == 0){
        $lastObj.children().append("<button delete='Y' class=\"btn btn-danger btn-xs\" type=\"button\" onclick=\"deleteAdviceItemPlan(this)\">刪除</button>");
    }


    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            newName = ChangeCopyItemPlanName(oldName,lastIndex);
            $(this).attr("name",newName);
        });

    $("#itemPlanTable_" + parentIndex).append($lastObj);
}

/**
 * 删除项目计划表
 * @param obj
 */
function deleteAdviceItemPlan(obj){
    $(obj).parent().parent().remove();
}

function ChangeCopyItemPlanName(oldName,newIndex)
{
    var newName = "";
    var oldVal = "";

    if(typeof(oldName) != "undefined" && oldName !=''){

        oldVal = oldName.match(/daItemPlanList\[\d\]/);
        newName = oldName.replace(oldVal,"daItemPlanList["+newIndex+"]");
    }
    return newName;
}

/**
 * 选择药品大类方法
 * @param obj
 */
function chagneMedType(obj,contextPath){
    var mtId = $(obj).val();
    var medType ;
    var oldName = "";
    var newName = "";

    if(mtId == ''){
        return;
    }

    var lastIndex =$(obj).attr("id").split('_')[1];


    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: contextPath + "/base/medType/getPcMedTypeInfo.do",
        data: {"mtId":mtId},
        dataType: "json",
        success: function(data)
        {
            $(obj).prev().val(data.mtHosType);
            medType = data.mtHosType;

        },
        error: function(request, status, err)
        {
            ShowErrorDialog(request.status + "," + request.responseText);
        }
    });

    //更新药品 信息下拉选项框
    var $medObj = $('#aiMedId_' + lastIndex);
    $medObj.empty();
    $medObj.append("<option value=\"\">請選擇</option>");

    $.ajax({
        async: false,
        ifModified:true,
        type: "POST",
        url: contextPath + "/base/medInfo/lsitMedInfoFromType.do",
        data: {"medType":$(obj).val()},
        dataType: "json",
        success: function(data)
        {
            $.each(data,function(i,value){
                $medObj.append("<option value='"+value.key+"'>"+value.value+"</option>");
            });

        },
        error: function(request, status, err)
        {
            ShowErrorDialog(request.status + "," + request.responseText);
        }
    });


    //更新项目计划表内容
    var $parObj = $(obj).parent().parent().find('tbody');

    //删除子元素
    $parObj.empty();

    //根据模板添加元素
    var $lastObj = $("#changeMedTypeItemPlanTableModel_"+ medType +" tbody").children().clone(true);

    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            newName = newChangeName(oldName,lastIndex);
            $(this).attr("name",newName);
        });

    //更新方法的參數
    $lastObj
        .find("button")
        .each(function(){
            oldName = $(this).attr("onclick");
            newName = newChangeName(oldName,lastIndex);
            $(this).attr("onclick",newName);
        });

    $parObj.append($lastObj);

}

/**
 * 添加诊疗项目
 */
function addAdviceMedItem(){
    var lastIndex = 0;
    var oldName = "";
    var oldId = "";
    var newName = "";
    var newId = "";

    lastIndex = $("#medItemTable").children().length;

    //添加新项
    var $lastObj = $("#medItemTableModel").children().clone(true);


    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            oldId = $(this).attr("id");

            newName = newChangeName(oldName,lastIndex);
            newId = newChangeName(oldId,lastIndex);

            $(this).attr("name",newName);
            $(this).attr("id",newId);
        });

    //更新方法中的参数
   $lastObj
        .find("[onclick]")
        .each(function(){
            oldName = $(this).attr("onclick");

            newName = newChangeName(oldName,lastIndex);

            $(this).attr("onclick",newName);
        });

    $lastObj
        .find("[id^=itemPlanTable_]")
        .each(function(){
            oldName = $(this).attr("id");

            newName = newChangeName(oldName,lastIndex);

            $(this).attr("id",newName);
        });


    $("#medItemTable").append($lastObj);
}

/**
 * 删除诊疗项目
 * @param obj
 */
function delAdviceMedItem(obj) {

    $(obj).parent().parent().remove();
}

/**
 * 添加住院记录问题
 */
function addRecProblem(){
    var lastIndex = 0;
    var oldName = "";
    var oldId = "";
    var newName = "";
    var newId = "";

    lastIndex = $("#recProblemDiv div").length;

    //添加新项
    var $lastObj = $("#recProblemModel").children().clone(true);

    oldName = $lastObj.find(".titleSpan").html();
    newName = newChangeName(oldName,lastIndex+1);
    $lastObj.find(".titleSpan").html(newName);

    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            //oldId = $(this).attr("id");

            newName = newChangeName(oldName,lastIndex);
            //newId = newChangeName(oldId,lastIndex);

            $(this).attr("name",newName);
            //$(this).attr("id",newId);
        });

    $("#recProblemDiv").append($lastObj);
}

/**
 * 删除住院记录问题
 */
function delRecProblem(obj) {
    $(obj).parent().remove();
}

/**
 * 添加住院记录说明
 */
function addRecSpec(){
    var lastIndex = 0;
    var oldName = "";
    var oldId = "";
    var newName = "";
    var newId = "";

    lastIndex = $("#recSpecDiv div").length;

    //添加新项
    var $lastObj = $("#recSpecModel").children().clone(true);

    oldName = $lastObj.find(".titleSpan").html();
    newName = newChangeName(oldName,lastIndex+1);
    $lastObj.find(".titleSpan").html(newName);

    //更新元素名称
    $lastObj
        .find("[name]")
        .each(function(){
            oldName = $(this).attr("name");
            //oldId = $(this).attr("id");

            newName = newChangeName(oldName,lastIndex);
            //newId = newChangeName(oldId,lastIndex);

            $(this).attr("name",newName);
            //$(this).attr("id",newId);
        });

    $("#recSpecDiv").append($lastObj);
}

/**
 * 删除住院记录说明
 */
function delRecSpec(obj) {
    $(obj).parent().remove();
}


/**
 * 每日记录-添加特殊诊疗项目
 */
function addRecMedItem(){
    var lastIndex = 0;
    var oldName = "";
    var oldId = "";
    var newName = "";
    var newId = "";

    lastIndex = $("#specItemBody").children().length;

    var $lastObj = $("#specItemBodyModel").children().clone(true);

    //更新事件参数
    $lastObj
        .find("[onchange]")
        .each(function(){
            oldName = $(this).attr("onchange");
            newName = newChangeName(oldName,lastIndex);
            $(this).attr("onchange",newName);
        });

    //更新CLASS参数
    $lastObj
        .find("[class^='siItemValue_']")
        .each(function(){
            oldName = $(this).attr("class");
            newName = newChangeName(oldName,lastIndex);
            $(this).attr("class",newName);
        });

    //更新名称信息
    var initIndex = lastIndex * 24;
    $lastObj
        .find("[name]")
        .each(function(){

            var idStr = $(this).attr("id");
            var idArr = idStr.split('_');

            var colIndex = Number(idArr[1]);
            var row = Number(idArr[2]);

            if(row == 1){
                lastIndex = initIndex + colIndex -1;
            }else{
                lastIndex = initIndex + 24 + colIndex -1;
            }

            oldName = $(this).attr("name");
            newName = newChangeName(oldName,lastIndex);
            $(this).attr("name",newName);
        });

    $("#specItemBody").append($lastObj);

}

function delRecMedItem() {
    var lastIndex = $("#specItemBody").children().length;

    if(lastIndex == 2){
        ShowWarningDialog("不能再繼續刪除了");
        return;
    }

    $("#specItemBody").children().eq(lastIndex-1).remove();
    $("#specItemBody").children().eq(lastIndex-2).remove();
}
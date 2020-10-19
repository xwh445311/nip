function checkEmpty(title,value)
{
    var errMsg = "";
    if(!$.trim(value).length > 0)
    {
        errMsg = title + ":" + "必須輸入\n";
    }

    return errMsg;
}

function checkMaxLength(title,value,maxLen)
{
    var errMsg = "";
    if(value){
        if(value.length > maxLen)
        {
            errMsg = title + ":" + "長度不能超過" + maxLen+ "位\n";
        }
    }
    return errMsg;

}

function checkMinLength(title,value,minLen)
{
    var errMsg = "";
    if(value.length < minLen)
    {
        errMsg = title + ":" + "長度不能少於" + minLen+ "位\n";
    }

    return errMsg;

}

function checkLengthRange(title,value,minLen,maxLen)
{
    var errMsg = "";
    if(value.length < minLen || value.length > maxLen)
    {
        errMsg = title + ":" + "長度必須介於" + minLen+ " 與 " + maxLen + "之間\n";
    }

    return errMsg;
}

function checkDigit(title,value)
{
    var errMsg = "";

    if($.trim(value).length == 0)
    {
        return "";
    }

    if(!/^\d+$/.test(value))
    {
        errMsg = title + ":" + "只能輸入數字\n";
    }

    return errMsg;
}

function checkDateFormat(title,value)
{
    var errMsg = "";
    if($.trim(value).length == 0)
    {
        return "";
    }
    if(!/^\d{4}[\/]\d{2}[\/]\d{2}$/.test(value))
    {
        errMsg = title + ":" + "日期格式輸入錯誤，應輸入：2001/01/01.\n";
    }

    return errMsg;
}

function checkTimeFormat(title,value)
{
    var errMsg = "";

    if($.trim(value).length == 0)
    {
        return "";
    }

    if(!/^\d{2}[:]\d{2}$/.test(value))
    {
        errMsg = title + ":" + "時間格式輸入錯誤，應輸入：15:03.\n";
    }

    return errMsg;
}

function checkNumber(title,value){
    var errMsg = "";

    if($.trim(value).length == 0)
    {
        return "";
    }

    if(!/^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test( value ))
    {
        errMsg = title + ":" + "只能輸入有效整数或小数\n";
    }

    return errMsg;
}
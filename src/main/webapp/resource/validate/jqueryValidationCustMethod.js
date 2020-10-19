/**
 * 通用电话格式数字、括号、短横线
 */
$.validator.addMethod( "comPhone", function( value, element ) {
    return this.optional( element ) || /^[\d\(\)-]+$/.test(value);
}, "格式不正確" );
/**
 * Created by Charlotte514 on 2017/6/23.
 */
/**
 * this file is to check inputs on HR_newInfo.jsp
 */

function notNullSubmit(){
    var inputs=new Array();
    var newInfoform=document.getElementById("newJobInfoForm");
    inputs[0]=document.getElementById("company");
    inputs[1]=document.getElementById("position");
    inputs[2]=document.getElementById("work-skill");
    inputs[3]=document.getElementById("wage");
    inputs[4]=document.getElementById("phone");
    inputs[5]=document.getElementById("details");
    for(var i=0;i<6;i++){
        if(inputs[i].value==""){
            alert("表单项未填写完整或格式不正确");
            return false;
        }
    }
    if(inputs[4].value.length!=11){
        alert("请填写正确的手机号码")
        return false;
    }
    else  if(inputs[5].value=="详细信息...") {
        alert("请填写详细信息");
        return false;
    }else{
        //页面填写完毕
        var type=window.confirm("确认提交吗？");
        if(type==true)
            newInfoform.submit();
    }





}

/**
 * Created by Charlotte514 on 2017/6/21.
 */
function isEmail(Email){

    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(myreg.test(Email.value)){
        return true;
    }else{
        //警告并清空输入内容
        alert("请输入正确的邮箱地址");
        Email.value="";
        return false;
    }
}

function isPwdChecked(){
    var registerpwd=document.getElementById("register_password");
    var checkpwd=document.getElementById("check_password");
    if(registerpwd.value!=checkpwd.value){
        //警告并清空输入项
        alert("确认密码不匹配，请检查后重新输入");
        registerpwd.value="";
        checkpwd.value="";
        return false;
    }else {
        return true;
    }
}
function notNull(type){
    if(type==1){
        //登录的非空检测
        var loginmail=document.getElementById("login_mailbox");
        var loginpwd=document.getElementById("login_password");
        if((loginmail.value!="企业邮箱"&&loginmail.value!=="")
        &&loginpwd.value!="密码"&&loginpwd.value!=""){
            //通过验证
            return true;
        }else
            alert("请输入邮箱或密码");
    }else if(type==2){
        //注册的非空检测
        var registerEmail=document.getElementById("register_mailbox");
        var registerpwd=document.getElementById("register_password");
        var checkpwd=document.getElementById("check_password");
        if(registerEmail.value==""||registerEmail.value=="输入您的企业邮箱..."){
            alert("请输入企业邮箱");
        }
        else if(registerpwd.value==""||registerpwd.value=="输入您的密码...")
        {
            alert("请输入密码");
        }
        else if(checkpwd.value==""||checkpwd.value=="确认密码...")
        {
            alert("请输入确认密码");
        }
        else
            return true;
    }
    return false;

}
function HRLogin(type){
    var formSignIn=document.getElementById("HR_SIGN_IN");
    var formSignUp=document.getElementById("HR_SIGN_UP");
    var Email;
    if(type == 1) {
        Email=document.getElementById("login_mailbox");
        if(notNull(type)&&isEmail(Email)){
            //通过检测后提交
            formSignIn.submit();
            return true;
        }
    }
    else if (type == 2) {
        Email = document.getElementById("register_mailbox");
        if (notNull(type) && isEmail(Email)) {
            if (isPwdChecked()) {
                formSignUp.submit();
                return true;
            }
        }
        var registerpwd=document.getElementById("register_password");
        var checkpwd=document.getElementById("check_password");
        Email.value="";
        registerpwd.value="";
        checkpwd.value="";
    }
}
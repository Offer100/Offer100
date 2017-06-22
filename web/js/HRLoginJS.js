/**
 * Created by Charlotte514 on 2017/6/21.
 */
function HRLogin(type){
    var formSignIn=document.getElementById("HR_SIGN_IN");
    var formSignUp=document.getElementById("HR_SIGN_UP");

    if(type == 1)
        formSignIn.submit();
    else if (type==2)
        formSignUp.submit();
}
/**
 * Created by Charlotte514 on 2017/6/26.
 */
/*
*查询界面上获取被点击行和信息的id
 */
function getOfferId(num){
    var box=document.getElementById("GetOfferId");
    var form=document.getElementById("offer");
    box.value=num.toString();
    form.submit();
}

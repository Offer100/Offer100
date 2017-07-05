/**
 * Created by Charlotte514 on 2017/6/26.
 */
/*
*查询界面上获取被点击行和信息的id
 */
function getOfferId2(num){
    var box=document.getElementById("GetOfferId");
    var form=document.getElementById("offer2");
    box.value=num.toString();
    alert(num.toString());
    form.submit();
}

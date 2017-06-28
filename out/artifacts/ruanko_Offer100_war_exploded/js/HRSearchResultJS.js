/**
 * Created by Charlotte514 on 2017/6/28.
 */
function getOfferId(num) {
    var box = document.getElementById("GetOfferId");
    var form = document.getElementById("search_offer");
    box.value = num.toString();
    form.submit();
}

function jump(){
    var type=window.confirm("确认跳转回查询界面吗？");
    if(type==true){
        window.location.href="../Offer100/HR_search.jsp";
    }
}


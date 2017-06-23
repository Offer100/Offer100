package control;

import model.HR;
import model.Offer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Charlotte514 on 2017/6/23.
 */
public class DeleteInfoServlet extends HttpServlet {
    //从删除管理界面获取删除信息的id
    //调用Offer的删除方法删除后，返回删除管理界面。

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String ids=req.getParameter("id_box");
        List<String> deleteIds=null;
        List<Offer> Offers=null;
        Offer temp=new Offer();
        HR aHR=(HR)session.getAttribute("HR");
        if(aHR==null){
            //若session失效，跳转到登录界面
            session.setAttribute("wrongMsg","登录过期，请重新登录");
            resp.sendRedirect("../login.jsp");
        }
        //HR信息未失效。
        if(ids!=null&&ids.length()>0){
            //为非空字符串时：
            deleteIds= Arrays.asList(ids.split(","));
            for(int i=0;i<deleteIds.size();i++){
                int Offerid=Integer.parseInt(deleteIds.get(i));
                temp.delete(Offerid,aHR.getMail());
            }
            session.setAttribute("wrongMsg","已成功删除信息");
            //获取新的OfferList
            Offers=temp.find(aHR.getMail());
        }
        session.setAttribute("wrongMsg","请选择删除内容");
        session.setAttribute("delete_list",Offers);

        //跳转到删除管理界面
        resp.sendRedirect("../HR_management.jsp");
    }
}

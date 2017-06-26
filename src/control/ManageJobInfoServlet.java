package control;

import model.HR;
import model.Offer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlotte514 on 2017/6/23.
 */
public class ManageJobInfoServlet extends HttpServlet {
    //用于从删除管理界面获取删除关键词，搜寻该HR名下符合关键词的Offer
    //返回到删除管理界面显示


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        List<Offer> Offers=null;
        Offer mOffer=new Offer();
        String position=null;
        String date=null;
        //获取HR的信息
        HR aHR=(HR)session.getAttribute("HR");
        if(aHR==null||aHR.getMail()==null||aHR.getMail().equals("")){
            //HR信息丢失
            //跳转至Login界面
            session.setAttribute("wrongMsg","登陆过期，请重新登录");
            resp.sendRedirect("../login.jsp");
        }else{
            //HR信息在，查找对应的Offers信息
            //TODO
            //数据库部署前注释掉
            //Offers=mOffer.find(aHR.getMail());
            //假数据：
            mOffer=new Offer("sss","ssss","ssss","ssss","ssss",
                    "sssss", "sss","ssss","ssss","ssss","ssss");
            Offers=new ArrayList<Offer>();
            Offers.add(mOffer);

            //首先置错误信息为空
            session.setAttribute("wrongMsg","");
            if(Offers==null||Offers.size()<=0){
                //列表不存在或为空
                session.setAttribute("wrongMsg","无可删除的招聘信息");
            }
            session.setAttribute("delete_list",Offers);
            resp.sendRedirect("../HR_management.jsp");
        }

    }
}

package control;

import model.HR;
import model.Offer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Charlotte514 on 2017/6/28.
 * 负责从HR查询界面获取关键词，并转发到详情显示界面
 */
public class HRSearchInfoServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String workplace = (String)req.getParameter("workplace");
        String time = (String)req.getParameter("time");
        Offer mOffer=new Offer();
        List<Offer> Offers=null;
        HR aHR=(HR)session.getAttribute("HR");

        //首先置错误信息为空
        session.setAttribute("wrongMsg","");

        if(aHR==null){
            //无法获取HR信息
            //转入登录界面
            session.setAttribute("wrongMsg","登录过期，请重新登录");
            resp.sendRedirect("../login.jsp");
        }else{
            //可以获取HR信息
            Offers=mOffer.find(aHR.getMail());
            if(Offers==null||Offers.size()<=0){
                //查询列表为空
                session.setAttribute("wrongMsg","无发布招聘信息");
                session.setAttribute("search_offer",null);
            }else {
                session.setAttribute("wrongMsg", "查询成功");
                session.setAttribute("search_offer",Offers);
            }
            //转入详情显示页面
            resp.sendRedirect("../HR_search_detail.jsp");
        }
    }
}

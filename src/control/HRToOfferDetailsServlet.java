package control;

import model.Offer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/6/28.
 * 从HR查询结果界面转向查询详情界面(details.jsp)
 */
public class HRToOfferDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String offerId=(String)req.getParameter("GetOfferId");
        Offer mOffer=new Offer();

        //查找对应的 Offer
        mOffer=mOffer.findByID(Integer.parseInt(offerId));

        //置空假数据
        session.setAttribute("wrongMsg","");
        if(mOffer==null){
            //获取详情失败
            session.setAttribute("wrongMsg","获取详情信息失败，将返回查询界面。");
            //置空搜索结果列表
            session.setAttribute("search_offer",null);
            //重定向到HR查询界面
            resp.sendRedirect("../HR_search.jsp");
        }else{
            //查找到对应的Offer
            session.setAttribute("DetailedOffer",mOffer);
            //跳转到详情显示页面detailed
            resp.sendRedirect("../details.jsp");
        }
    }
}

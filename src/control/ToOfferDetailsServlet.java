package control;

import model.Offer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Charlotte514 on 2017/6/26.
 * 负责从用户查询界面到详情界面的转发
 */
public class ToOfferDetailsServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String OfferId=(String)req.getParameter("GetOfferId");
        Offer mOffer=null;

        //根据Id查找
        //完成数据库前先注释掉
        mOffer=mOffer.findByID(Integer.parseInt(OfferId));
        //保存进session
        //重定向
        //TODO
        //假数据
        session.setAttribute("wrongMsg","");
        if(mOffer==null||mOffer.getAdress()==""){
            session.setAttribute("wrongMsg","获取详情信息失败，回到查询界面。");
            //置空搜索结果列表
            session.setAttribute("search_list",null);
            //重定向到查询界面
            resp.sendRedirect("../JobSearch.jsp");
        }
        session.setAttribute("DetailedOffer", mOffer);
        resp.sendRedirect("../details.jsp");
    }
}

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
 * 负责从查询界面到详情界面的转发
 */
public class ToOfferDetailsServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String OfferId=(String)req.getParameter("getOfferId");
        Offer mOffer=null;

        //根据Id查找
        //完成数据库前先注释掉
        //mOffer=mOffer.findByID(Integer.parseInt(OfferId));

        //保存进session

        //重定向

        //TODO
        //假数据
        mOffer=new Offer("sss","ssss","ssss","ssss","ssss",
                "sssss", "sss","ssss","ssss","ssss","ssss");
        session.setAttribute("wrongMsg","");
        if(mOffer==null){
            session.setAttribute("wrongMsg","获取详情信息失败，马上回到查询界面。");
        }
        session.setAttribute("DetailedOffer",mOffer);
        resp.sendRedirect("../details.jsp");
    }
}

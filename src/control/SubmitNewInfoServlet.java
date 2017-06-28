package control;

import model.HR;
import model.Offer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Charlotte514 on 2017/6/23.
 */
public class SubmitNewInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();

        //获取此时的系统时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime=new Date();
        String timeStr=sdf.format(currentTime);
        String company=(String)req.getParameter("company");
        String workplace=(String)req.getParameter("workplace");
        String position=(String)req.getParameter("position");
        String industry=(String)req.getParameter("industry-category");
        String workskill=(String)req.getParameter("work-skill");
        String wage=(String)req.getParameter("wage");
        String phone=(String)req.getParameter("phone");
        String jobcategory=(String)req.getParameter("job_category");
        String details=(String)req.getParameter("details");
        String allstr=workplace+"#"+position+"#"+industry+"#"+jobcategory;
        HR aHR=(HR)session.getAttribute("HR");
        //生成订单
        Offer mOffer=new Offer(company,position,workskill,wage,phone,details,timeStr,allstr,industry,jobcategory,workplace);
        try {
            mOffer.add(mOffer,aHR.getMail());
        } catch(Exception e){
            session.setAttribute("wrongMsg","招聘信息生成失败，请稍后再试。是否返回主界面？");
        }
        session.setAttribute("wrongMsg","成功提交招聘信息！是否返回主界面？");
        resp.sendRedirect("../HR_newInfo.jsp");
    }
}

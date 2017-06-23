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
 * Created by Charlotte514 on 2017/6/21.
 * used in HR account sign up for system
 */
public class HRLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();

        String email=req.getParameter("login_mailbox");
        String pwd=req.getParameter("login_password");
        HR aHR=new HR(email,pwd);
        List<Offer> offers;
        List<Offer> offersToShow=new ArrayList<Offer>();
        Offer temp=new Offer();

        try {
            //if( aHR.check(aHR)){
            //TEST
            if( true){
                //匹配成功
                //重定向到HR招聘信息管理界面
                session.setAttribute("HR",aHR);
                //获取
                resp.sendRedirect("../HR_home.jsp");

                //TODO
                /*
                offers=temp.find(aHR.getMail());
                if(offers.size()<=5){
                    //小于五条直接显示
                    //页面上判断一下大小是否为0;
                    offersToShow=offers;
                }else {
                    //多于五条取前五条
                    for(int i=0;i<6;i++){
                        temp=offers.get(i);
                        offersToShow.add(temp);
                    }
                }
                session.setAttribute("OfferList",offersToShow);
                resp.sendRedirect("../HR_home.jsp");
                 */
            }else{
                //匹配失败
                //重定向至登录界面
                session.setAttribute("wrongMsg","用户密码不匹配，请核对!");
                resp.sendRedirect("../login.jsp");
                //TEST
                //

            }
        } catch (Exception e) {
            //SQL错误
            //重定向至登录界面
            session.setAttribute("wrongMsg","请正确填写用户邮箱和密码");
           resp.sendRedirect("../login.jsp");
        }
    }
}

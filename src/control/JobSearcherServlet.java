package control;

import model.Frequency;
import model.JobSearcher;
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
 * 普通用户招聘信息查询，获取页面上的关键词信息后，
 * 调用查询函数进行查找，并显示出来。
 */
public class JobSearcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        String keyword=req.getParameter("keyword");
        Offer mOffer=new Offer();
        List<Offer> Offers=new ArrayList<Offer>();
        int[] result=null;
        Frequency frequency=new Frequency();
        JobSearcher jobSearcher=new JobSearcher();
        //更新Keyword的点击数据
        if(keyword!=null&&!keyword.equals("")){
            //搜索关键词不为空
            System.out.println(keyword);
            frequency.update(keyword,null);
            //查询函数，获取Offerid
            result=jobSearcher.search(keyword);
            for(int i=0;i<result.length;i++){
                if(result[i]==0)
                    break;
                mOffer = mOffer.findByID(result[i]);
                if (mOffer != null && mOffer.getAllString() != null)
                    Offers.add(mOffer);
            }
        }
        //TODO
        //查询函数

        //保存进session

        //重定向到结果显示界面。

        //TODO
        //假数据

        //首先将错误消息置空
        session.setAttribute("wrongMsg","");
        if(Offers==null||Offers.size()<=0){
            //Offers为空的错误处理
            session.setAttribute("wrongMsg","没有对应的招聘信息");
        }else {
            session.setAttribute("wrongMsg", "查询成功");
        }
        session.setAttribute("search_list",Offers);
        resp.sendRedirect("../JobSearchResult.jsp");
    }
}

package controller;

import dal.CakeDAO;
import dal.ShopInfoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cake;
import model.ShopInfo;

public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //init cake and shop info dao using to get data fromd database
            CakeDAO cakeUtils = new CakeDAO();
            ShopInfoDAO shopInfoUtils = new ShopInfoDAO();
            //get info for intro cake
            Cake introductionCake = cakeUtils.getOne(0);
            //get 2 most update cake 
            ArrayList<Cake> top2Cake = cakeUtils.getMost2Update();
            //get info about shop
            ShopInfo shopInfo = shopInfoUtils.getInformation(0);
            //set attribute before fetch to jsp
            request.setAttribute("intro", introductionCake);
            request.setAttribute("listCake", top2Cake);
            request.setAttribute("info", shopInfo);
            //fetch data to homepage.jsp to display
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

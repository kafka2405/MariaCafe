package controller;

import dal.CakeDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cake;
import utils.HTMLHelper;


public class AboutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            CakeDAO cakeUtils = new CakeDAO();
            
            String strItemOnPage = getServletContext().getInitParameter("ItemOnPage");
            int itemOnPage = Integer.parseInt(strItemOnPage);

            int currentPage;
            
            try {
                 currentPage = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
                currentPage = 1;
            }
            

            int totalRecord = cakeUtils.totalSushi();

            int totalPage = (totalRecord / itemOnPage) + (totalRecord % itemOnPage != 0 ? 1 : 0);

            if(currentPage > totalPage){
                currentPage = totalPage;
            }
            if(currentPage <= 0){
                currentPage = 1;
            }
            
            int start = itemOnPage * (currentPage - 1) + 1;
            int end = start + itemOnPage - 1;


            ArrayList<Cake> listCake = cakeUtils.getListByIndex(start, end);
            
            String pagination = HTMLHelper.pagger(currentPage, totalPage, "aboutController");
            
            request.setAttribute("listCake", listCake);
            request.setAttribute("pagination", pagination);
            
            request.getRequestDispatcher("listCake.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

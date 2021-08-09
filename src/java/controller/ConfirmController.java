/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.PromotionDAO;
import daos.UserDAO;
import dto.Promotion;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class ConfirmController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConfirmController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserDAO().getUserById(id);
            Promotion promotion = new Promotion(user.getId(), 5.0, user.getPhoto(), 1);
            boolean flag = true;

            ArrayList<Promotion> listPromotion = (ArrayList<Promotion>) session.getAttribute("listPromotion");
            ArrayList<Promotion> listAllPromotion = new PromotionDAO().getAllPromotion();

            for (Promotion promo : listAllPromotion) {          // check xem user da dc them vao promote list tu trc chua
                if (promo.getUserId() == promotion.getUserId()) {
                    flag = false;
                }
            }
            if (listPromotion != null) {   // check xem user da trong danh sach confirm chua
                for (Promotion pro : listPromotion) {
                    if (pro.getUserId() == promotion.getUserId()) {
                        flag = false;
                    }
                }
            }

            if (listPromotion == null && flag) {
                listPromotion = new ArrayList<>();
                listPromotion.add(promotion);
            } else if (listPromotion != null && flag) {
                listPromotion.add(promotion);
            }
            session.setAttribute("listPromotion", listPromotion);
            response.sendRedirect("AdminHomeController");
            
        }catch(Exception e){
            log("ERROR at ConfirmController: " + e.getMessage());
        }
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

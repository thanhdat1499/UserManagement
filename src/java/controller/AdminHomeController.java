/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.PromotionDAO;
import daos.RoleDAO;
import daos.UserDAO;
import dto.Promotion;
import dto.Role;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AdminHomeController extends HttpServlet {

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
        try {
            ArrayList<Role> listRole = new ArrayList<>();
            ArrayList<User> listUser = new ArrayList<>();
            String tmp = request.getParameter("role_id");
            if (tmp == null) {
                listUser = new UserDAO().getAllUser();
                listRole = new RoleDAO().getAllRole();
            } else {
                int role_id = Integer.parseInt(tmp);
                if (role_id == 0) {
                    listUser = new UserDAO().getAllUser();
                } else {
                    listUser = new UserDAO().getUserByRole(role_id);
                }
                listRole = new RoleDAO().getAllRole();
            }
            ArrayList<Promotion> listPromotion = new PromotionDAO().getAllPromotion();
            
            request.setAttribute("listPromotion", listPromotion);
            request.setAttribute("listUser", listUser);
            request.setAttribute("listRole", listRole);
            request.getRequestDispatcher("adminHome.jsp").forward(request, response);
        } catch(Exception e){
            log("ERROR at AdminHomeController: " + e.getMessage());
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
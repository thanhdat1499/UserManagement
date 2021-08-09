/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.UserDAO;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AddNewController extends HttpServlet {

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
            out.println("<title>Servlet AddNewController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("addNew.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            String password = toHexString(getSHA(pass));
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String photo = request.getParameter("photo");

            User userAddNew = new User();
            userAddNew.setDisplayName(name);
            userAddNew.setUsername(username);
            userAddNew.setPassword(password);
            userAddNew.setEmail(email);
            userAddNew.setPhone(phone);
            userAddNew.setAddress(address);
            userAddNew.setPhoto(photo);

            ArrayList<User> listUser = new UserDAO().getAllUser();
            int flag = 0;
            String err = "";
            for (User user : listUser) {
                if (user.getUsername().equals(userAddNew.getUsername())) {
                    flag = 1;
                    err = "Username is duplicated !!";
                }
            }
            if (flag == 0) {
                int checkAddNew = new UserDAO().addNewUserByAdmin(userAddNew);
                if (checkAddNew != 0) {
                    response.sendRedirect("AdminHomeController");
                } else {
                    err = "Create User Failed!!";
                    request.setAttribute("err", err);
                    request.setAttribute("userAddNew", userAddNew);
                    request.getRequestDispatcher("addNew.jsp").forward(request, response);
                }
            } else{
                request.setAttribute("err", err);
                request.setAttribute("userAddNew", userAddNew);
                request.getRequestDispatcher("addNew.jsp").forward(request, response);
            } 
        }catch(Exception e){
            log("ERROR at AddNewController: " + e.getMessage());
        }
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
    
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA 
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

}

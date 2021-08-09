/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoNew;
import dao.DaoSearch;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Digital;

/**
 *
 * @author mynameis
 */
public class ServletSearch extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet ServletSearch</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSearch at " + request.getContextPath() + "</h1>");
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
        String searchTitle = request.getParameter("search");
        DaoSearch dao = new DaoSearch();
        DaoNew dn = new DaoNew();
        Digital d = dn.getTopNew();
        List<Digital> listTop5 = dn.getTop5();
        List<Digital> list = null;

        list = dao.listSearch(searchTitle);

        int totalNew = list.size();
        int pageNumber = 2;
        int paging = 0;
        if (totalNew > 0) {
            if (totalNew % pageNumber != 0) {
                paging = totalNew / pageNumber;
            } else {
                paging = totalNew / pageNumber - 1;
            }
        }

        request.setAttribute("paging", paging);
        request.setAttribute("search", searchTitle);

        request.setAttribute("num", pageNumber);
        request.setAttribute("searchname", searchTitle);
        request.setAttribute("total", totalNew);
        request.setAttribute("digital", d);

        String numString = request.getParameter("num");
        int num = 0;
        try {
            num = Integer.parseInt(numString);
        } catch (Exception e) {
        }
        List<Digital> list2 = dao.listPaging(searchTitle, num);
        request.setAttribute("list", list2);
        request.setAttribute("top5", listTop5);
        request.getRequestDispatcher("./view/Search.jsp").forward(request, response);

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

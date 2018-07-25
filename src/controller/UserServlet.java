package controller;

import dbutils.DBConnection;
import domain.Idea;
import domain.User;
import service.IdeaService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");

//    fetching data into database
//
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String category = request.getParameter("category");


        PrintWriter out = response.getWriter();

        if(page.equalsIgnoreCase("signup")){
            String query = "insert into users (name,phone,address,email,password,category) values (?,?,?,?,?,?)";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
            try {
                pstm.setString(1, name);
                pstm.setString(2, phone);
                pstm.setString(3, address);
                pstm.setString(4, email);
                pstm.setString(5, password);
                pstm.setString(6, category);
//

                pstm.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
            request.setAttribute("msg1","Congrats you have signed up!!!");
            rd.forward(request,response);

        }

//    ------------------------------------------------------------------------------
        if (page.equalsIgnoreCase("login")) {
            User user = new UserService().getUser(email, password);


            if (user != null) {
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);
                String username = user.getUsername();
                System.out.println(username);
                session.setAttribute("username",username);
                session.setAttribute( "id",user.getId());
                redirectToList(request,response);

            } else {
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);
                request.setAttribute("msg","email or password not found!!!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }

        if (!page.equalsIgnoreCase("login") && !page.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            if (user == null) {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
        if (page.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

        if(page.equalsIgnoreCase("details")){

            HttpSession session = request.getSession(false);
            User currentUser = (User) session.getAttribute("user");

            Integer userId = parseInt(request.getParameter("id"));

            User user = new UserService().getUser(userId);
            List<Idea> ideaList = new IdeaService().getUserIdeaList(userId);


            request.setAttribute("currentUser", currentUser);
            request.setAttribute("user",user);
            request.setAttribute("userIdeas", ideaList);

            RequestDispatcher rd =request.getRequestDispatcher("display_user.jsp");
            rd.forward(request,response);

        }
        if(page.equalsIgnoreCase("home")){

            HttpSession session = request.getSession(false);
            List<Idea> ideaList = new IdeaService().getIdeaList();
            request.setAttribute("ideaList", ideaList);
            RequestDispatcher rd = request.getRequestDispatcher("post_idea.jsp");
            rd.forward(request, response);


        }


    }
    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Idea> ideaList = new IdeaService().getIdeaList();
        request.setAttribute("ideaList", ideaList);
        RequestDispatcher rd = request.getRequestDispatcher("post_idea.jsp");
        rd.forward(request, response);
    }



    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doProcess(request, response);
    }
}
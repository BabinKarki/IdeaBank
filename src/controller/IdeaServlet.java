package controller;

import dbutils.DBConnection;
import domain.Idea;
import domain.User;
import service.IdeaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "IdeaServlet")
public class IdeaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);



    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String page = request.getParameter("page");



//    fetching data into database
        String table_name = "idea";
//
        String idea = request.getParameter("idea");
        int id= Integer.parseInt(request.getParameter("id")) ;
//        session.setAttribute('id',id);
//        `System.out.println("id="+id);
        HttpSession session = request.getSession(false);
//        session.setAttribute('id',id);
        PrintWriter out = response.getWriter();

        PreparedStatement pst = null;
        Idea newIdea = new Idea();
        User user_id = newIdea.getUser();
        System.out.println("user_id = " + user_id);

        if (page.equalsIgnoreCase("post_idea")) {
            String query = "INSERT INTO " + table_name + " (idea,user_id) VALUES (?,?)";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
            try {

                pstm.setString(1, idea);
                pstm.setInt(2,id);
                pstm.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            redirectToList(request,response);

        }


//------------------------------------------------------------------------------------------------------------------

        if (page.equalsIgnoreCase("deleteIdea")) {
            int id1 = Integer.parseInt(request.getParameter("id"));
            new IdeaService().delete(id);
            redirectToList(request, response);
        }

        if (page.equalsIgnoreCase("update")) {
            Idea idea1 = new Idea();
            idea1.setId(Integer.parseInt(request.getParameter("id")));
            idea1.setIdea(request.getParameter("idea"));
            new IdeaService().update(idea1);

            redirectToList(request, response);
        }

        if (page.equalsIgnoreCase("editIdea")) {
            int id2 = Integer.parseInt(request.getParameter("id"));
            Idea idea1 = new IdeaService().getIdea(id);

            request.setAttribute("idea", idea1);
            RequestDispatcher rd =  request.getRequestDispatcher("edit_idea.jsp");
            rd.forward(request, response);
        }

//------------------------------------------------------------------------------------------------------------------
    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Idea> ideaList = new IdeaService().getIdeaList();
        request.setAttribute("ideaList", ideaList);
        RequestDispatcher rd = request.getRequestDispatcher("post_idea.jsp");
        rd.forward(request, response);
    }





//    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Idea> ideaList = new IdeaService().getIdeaList();
//        request.setAttribute("ideaList", ideaList);
//
//        RequestDispatcher rd = request.getRequestDispatcher("post_idea.jsp");
//        rd.forward(request, response);
//    }

//        if (page.equalsIgnoreCase("ideaList")) {
//            redirectToList(redirectToList(""););
//        }





    //        if (page.equalsIgnoreCase("questionForm")) {
//            RequestDispatcher rd = request.getRequestDispatcher("question/questionForm.jsp");
//            rd.forward(request, response);
//        }
//        if (page.equalsIgnoreCase("addQuestion")) {
//            Question question = new Question();
//            question.setQuestion(request.getParameter("idea"));
//            new QuestionService().add(question);
//            redirectToList(request, response);
//
//        }
//        if (page.equalsIgnoreCase("deleteQuestion")) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            new QuestionService().delete(id);
//            redirectToList(request, response);
//        }
//
//        if (page.equalsIgnoreCase("update")) {
//            Question question = new Question();
//            question.setQuestion(request.getParameter("question"));
//            question.setCategory(request.getParameter("category"));
//            question.setOption_1(request.getParameter("option_1"));
//            question.setOption_2(request.getParameter("option_2"));
//            question.setOption_3(request.getParameter("option_3"));
//            question.setOption_4(request.getParameter("option_4"));
//            question.setCorrect_ans(request.getParameter("correct_ans"));
//            question.setId(Integer.parseInt(request.getParameter("id")));
//            new QuestionService().update(question);
//            redirectToList(request, response);
//        }
//
//        if (page.equalsIgnoreCase("editQuestion")) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            Question question = new QuestionService().getQuestion(id);
//            request.setAttribute("question", question);
//            RequestDispatcher rd =  request.getRequestDispatcher("question/editQuestion.jsp");
//            rd.forward(request, response);
//        }
//
//    }


        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doProcess(request, response);
        }

    }
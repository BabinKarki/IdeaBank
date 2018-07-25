package service;

import dbutils.DBConnection;
import domain.Idea;
import domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class IdeaService {


    public List<Idea> getIdeaList() {
        List<Idea> ideaList = new ArrayList<Idea>();

        String query = "select * from idea ";

        PreparedStatement pstm = new DBConnection().getPreparedStatement(query);

        //run the preparedstatement query
        try {
            ResultSet rs = pstm.executeQuery(query);
            while (rs.next()) {
                User user = new UserService().getUser(rs.getInt("user_id"));
                Idea idea = new Idea(); //create new idea object in each loop and add that object to list
                idea.setId(rs.getInt("id"));
                idea.setIdea(rs.getString("idea"));
                idea.setUser(user);
               ideaList.add(idea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ideaList;
    }

    public List<Idea> getUserIdeaList(Integer id) {

        String query = "select * from idea where user_id=?";

        List <Idea> ideaList = new ArrayList<Idea>();

        PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,  id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new UserService().getUser(id);
                Idea idea = new Idea();
                idea.setId(rs.getInt("id"));
                idea.setIdea(rs.getString("idea"));
                idea.setUser(user);
                ideaList.add(idea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ideaList;
    }




    public void delete(int id) {
        String query = "delete from idea where id=?";
        PreparedStatement pstm = new DBConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Idea idea) {
        /*String query = "UPDATE `idea` SET `idea`=? WHERE `id`=?";*/
        String query = "UPDATE idea SET idea = ? WHERE id = ? ";
        PreparedStatement pstm = new DBConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, idea.getIdea());
            pstm.setInt(2, idea.getId());
            pstm.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public Idea getIdea(int id) {
        Idea question = null;
        String query = "select * from idea where id=?";
        PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Idea();
                question.setId(rs.getInt("id"));
                question.setIdea(rs.getString("idea"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }


}

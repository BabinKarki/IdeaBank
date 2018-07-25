package service;

import dbutils.DBConnection;
import domain.Idea;
import domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public User getUser(String email, String password) {
        User user = null;
        String query = "select * from users where email=? and password=?";
        PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
        try {
            pstm.setString(1, email);
            pstm.setString(2, password);
//            System.out.println("name"+name);
//            System.out.println("passwprd="+password);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;

  }

    public User getUser(Integer id) {
        User user = null;
        String query = "select * from users where id=?";
        PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,  id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setCategory(rs.getString("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }


    }





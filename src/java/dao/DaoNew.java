/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Digital;

/**
 *
 * @author mynameis
 */
public class DaoNew {

    Connection con = null;

    public Digital getTopNew() {

        String sql = "SELECT Top(1)*\n"
                + "FROM DigitalNew\n"
                + "ORDER BY timePost DESC";
        try {
            con = new DBcontext().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                DateFormat df = new SimpleDateFormat("MMM dd yyyy - hh:mm a");
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        df.format(rs.getTimestamp("timePost")).replace("AM", "am").replace("PM", "pm"),
                        rs.getString("shortDescription")
                );
                return d;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public List<Digital> getTop5() {
        List<Digital> listNew = new ArrayList<>();
        String sql = "SELECT TOP(5) *\n"
                + "FROM DigitalNew d \n"
                + "WHERE timePost!=(SELECT MAX(timePost) FROM DigitalNew)\n"
                + "ORDER BY timePost DESC";
        try {
            con = new DBcontext().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("MMM dd yyyy - hh:mm aa");
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        df.format(rs.getTimestamp("timePost")),
                        rs.getString("shortDescription")
                );
                listNew.add(d);
            }

        } catch (Exception e) {
        }
        return listNew;

    }

    public Digital getDetail(int id) {
        String sql = "SELECT * FROM DigitalNew WHERE id=?";
        try {
            con = new DBcontext().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("MMM dd yyyy - hh:mm aa");
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        df.format(rs.getTimestamp("timePost")).replace("AM", "am").replace("PM", "pm"),
                        rs.getString("shortDescription")
                );
                return d;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        DaoNew d = new DaoNew();
        System.out.println(d.getDetail(1).getTimePost());
    }

}

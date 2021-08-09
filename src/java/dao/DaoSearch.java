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
public class DaoSearch {

    Connection con;

    public List<Digital> listSearch(String title) {
        List<Digital> listNew = new ArrayList<>();
        String sql = "SELECT * FROM DigitalNew d WHERE d.title LIKE ?";//select all news have the name of title get from search input

        try {
            con = new DBcontext().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + title + "%");

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
                listNew.add(d);
            }

        } catch (Exception e) {
        }
        return listNew;
    }
// phân trang và lấy new theo row
    public List<Digital> listPaging(String title, int numberPage) {
        List<Digital> listNew = new ArrayList<>();
        String sql = "WITH title as\n"//use with clause 
                + "(SELECT * FROM DigitalNew d WHERE d.title LIKE ?),\n"//select all new have name of title match with search name
                + "Ranking as(select id,title,description,image,author,timePost,shortDescription ,ROW_NUMBER() OVER(ORDER BY timePost desc) as row  from title)\n"
                + "SELECT id,title,description,image,author,timePost,shortDescription  from Ranking \n"
                + "WHERE row BETWEEN ?*2+1 AND ?*2+2";
        //b1 select a list news with the title name likes search name input
        //b2 select the ranking of the list 
        //b3 with the condition row in range begin in the end of one paging and 2 new in one page

        try {
            con = new DBcontext().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + title + "%");
            st.setInt(2, numberPage);
            st.setInt(3, numberPage);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("MMM dd yyyy - hh:mm aa");//use DateFormat 
                Digital d = new Digital(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        df.format(rs.getTimestamp("timePost")).replace("AM", "am").replace("PM", "pm"),//change upperCase->lowerCase
                        rs.getString("shortDescription")
                );
                listNew.add(d);//add new object 
            }

        } catch (Exception e) {
        }
        return listNew;
    }
    public static void main(String[] args) {
        DaoSearch dao =new DaoSearch();
        List<Digital> list =dao.listSearch("");
        System.out.println(list);
    }

}

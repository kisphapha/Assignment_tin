/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author VNHCMLAP-0074
 */
public class CategoriesDao {
    //ham nay de thuc hien ket noi sqlserver
    //lay tat ca cac dong trong bang Categories tra ve Arraylist<Categories>

    public static ArrayList<Categories> getAllCategories() throws Exception {
        //tao cau noi giua yout app va sql server
        Connection cn = DBUtils.makeConnection();
        ArrayList<Categories> list = new ArrayList<>();//noi chua cac dong trong hang typeser
        if (cn != null) {
            //viet sql va execute no
            String sql = "select [CateId],[CateName],[Status] from [dbo].[Categories]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("CateId");
                    String name = rs.getString("CateName");
                    Boolean status = rs.getBoolean("Status");
                    Categories types = new Categories(id, name, status);
                    list.add(types);
                }
            }
            cn.close();
        }
        return list;
    }

    public static String getCategoriesName(String CateId) throws Exception {
        //tao cau noi giua yout app va sql server
        Connection cn = DBUtils.makeConnection();
        String r = null;
        if (cn != null) {
            //viet sql va execute no
            String sql = "select [CateName] from [dbo].[Categories] where [CateId]=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, CateId);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                r = rs.getString("CateName");
            }
            cn.close();
        }
        return r;
    }

//    //Ham nay de xoa Categories khi biet typeser id tra ve 1 hoac 0
//    public static int removeCategories(String CateId) throws Exception {
//        Connection cn = DBUtils.makeConnection();
//        int r = 0;
//        if (cn != null) {
//            String sql = "delete from [dbo].[tblCategories] where [CateId]='" + CateId + "'";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            r = pst.executeUpdate();
//            cn.close();
//        }
//        return r;
//    }
//    //Ham nay de reset password
//    public static int resetPassword(String CateId) throws Exception {
//        int r = 0;
//        Connection cn = DBUtils.makeConnection();
//        if (cn != null) {
//            String sql = "update [dbo].[tblCategories] set password=? where CateId=?";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            //random 1 day so ngau nhien
//            int newPassword = (int) (Math.random() * 1000000);
//            pst.setString(1, "" + newPassword);
//            pst.setString(2, CateId);
//            r = pst.executeUpdate();
//            cn.close();
//        }
//        return r;
//    }
//    //Ham nay de  insert 1 dong vao bang Categories tra ve 1 hoac 0
//    public static int insertCategories(String CateId, String CateName) throws Exception {
//        int r = 0;
//        Connection cn = DBUtils.makeConnection();
//        if (cn != null) {
//            String sql = "INSERT dbo.tblCategories([typeserID],[fullName],[roleID],[password]) VALUES (?,?,?,?)";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setString(1, CateId);
//            pst.setString(2, CateName);
//            pst.setString(3, "US");
//            pst.setString(4, "" + (int) (Math.random() * 1000000));
//            r = pst.executeUpdate();
//            cn.close();
//        }
//        return r;
//    }
//    //Ham nay de lay Categories trong bang tblCategories khi biet CateId tra ve Categories tim thay hoac NULL
//    public static Categories getCategories(String CateId) throws Exception {
//        Categories r = null;
//        Connection cn = DBUtils.makeConnection();
//        if (cn != null) {
//            //viet sql va execute no
//            String sql = "select [typeserID],[roleID],[fullName],[password]\n"
//                    + "from [dbo].[tblCategories] where typeserID=?";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setString(1, CateId);
//            ResultSet tmp = pst.executeQuery();
//            if (tmp != null && tmp.next()) {
//                String id = tmp.getString("typeserID");
//                String fullName = tmp.getString("fullName");
//                String role = tmp.getString("roleID");
//                String password = tmp.getString("password");
//                r = new Categories(id, fullName, role, password);
//            }
//            cn.close();
//        }
//        return r;
//    }
}

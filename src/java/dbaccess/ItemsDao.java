/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;
import basicobject.Items;

/**
 *
 * @author VNHCMLAP-0074
 */
public class ItemsDao {

    public static ArrayList<Items> getAllItems() throws Exception {
        //tao cau noi giua yout app va sql server
        Connection cn = DBUtils.makeConnection();
        ArrayList<Items> list = new ArrayList<>();//noi chua cac dong trong hang user
        if (cn != null) {
            //viet sql va execute no
            String sql = "select[ItemId],[ItemName],[Price],[CateId] from [dbo].[Items]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("ItemId");
                    String name = rs.getString("ItemName");
                    Double price = rs.getDouble("Price");
                    String cateid = rs.getString("CateId");

                    Items item = new Items(id, name, price, cateid);
                    list.add(item);
                }
            }
            cn.close();
        }
        return list;
    }

    public static int updateItem(String ItemId, Items item) throws Exception {
        //tao cau noi giua yout app va sql server
        Connection cn = DBUtils.makeConnection();
        int rs = 0;
        double price = item.getPrice();
        if (cn != null) {
            //viet sql va execute no     
            String sql = "UPDATE [dbo].[Items] set ItemName=?,Price=?,CateId=? "
                    + "where [ItemId]=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, "" + item.getName());
            st.setInt(2, (int) price);
            st.setString(3, item.getCateid());
            st.setString(4, "" + ItemId);
            rs = st.executeUpdate();
            cn.close();
        }
        return rs;
    }

    public static void UpdateItems2(Items updatedItem) throws Exception {
        Connection cn = DBUtils.makeConnection();

        if (cn != null) {
            String sql = "UPDATE [dbo].[Items] set [ItemName] = ?, [Price] = ?, [CateId] = ? WHERE [ItemId] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, updatedItem.getName());
            pst.setDouble(2, updatedItem.getPrice());
            pst.setString(3, updatedItem.getCateid());
            pst.setString(4, updatedItem.getId());
            pst.executeUpdate();

            cn.close();
        }
    }
//    public static int updateStatus(String id, String status) throws Exception {
//        int r = 0;
//        Connection cn = DBUtils.makeConnection();
//        if (cn != null) {
//            String sql = "update [dbo].[tblItems] set status=? where id=?";
//            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.setString(1, "" + status.equals("enable"));
//            pst.setString(2, id);
//            r = pst.executeUpdate();
//            cn.close();
//        }
//        return r;
//    }

    public static int insertItems(Items item) throws Exception {
        int r = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "insert into [dbo].[Items] values (?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, item.getId());
            pst.setString(2, item.getName());
            pst.setDouble(3, item.getPrice());
            pst.setString(4, "" + item.getCateid());
            r = pst.executeUpdate();
            cn.close();
        }
        return r;
    }

    public static ArrayList<Items> getItemsByName(String name) throws Exception {
        ArrayList<Items> list = new ArrayList<>();
        ArrayList<Items> allList = getAllItems();
        for (Items c : allList) {
            if (c.getName().contains(name)) {
                list.add(c);
            }
        }
        return list;
    }

    public static ArrayList<Items> getItemsByCateId(String cateid) throws Exception {
        ArrayList<Items> list = new ArrayList<>();
        ArrayList<Items> allList = getAllItems();
        for (Items c : allList) {
            if (c.getCateid().equals(cateid)) {
                list.add(c);
            }
        }
        return list;
    }

    public static Items getItemById(String itemId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        Items item = null;

        if (cn != null) {
            String sql = "select[ItemId],[ItemName],[Price],[CateId] from [dbo].[Items] WHERE [ItemId] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, itemId);
            ResultSet rs = pst.executeQuery();

            if (rs != null && rs.next()) {
                String id = rs.getString("ItemId");
                String name = rs.getString("ItemName");
                double price = rs.getDouble("Price");
                String cateId = rs.getString("CateId");
                item = new Items(id, name, price, cateId);
            }

            cn.close();
        }

        return item;
    }
}

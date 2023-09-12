/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.FAQs;
import basicobject.FAQs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author VNHCMLAP-0074
 */
public class FAQsDao {

    public static ArrayList<FAQs> getAllFAQ() throws Exception {
        //tao cau noi giua yout app va sql server
        Connection cn = DBUtils.makeConnection();
        ArrayList<FAQs> list = new ArrayList<>();//noi chua cac dong trong hang user
        if (cn != null) {
            //viet sql va execute no
            String sql = "select[Id],[CustName],[CustContent],[ItemId] from [dbo].[FAQ]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("Id");
                    String custName = rs.getString("CustName");
                    String custContent = rs.getString("CustContent");
                    String itemId = rs.getString("ItemId");

                    FAQs faq = new FAQs(id, custName, custContent, itemId);
                    list.add(faq);
                }
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<FAQs> getFQAsByItemId(String ItemId) throws Exception {
        ArrayList<FAQs> list = new ArrayList<>();
        ArrayList<FAQs> allList = getAllFAQ();
        for (FAQs c : allList) {
            if (c.getItemId().equals(ItemId)) {
                list.add(c);
            }
        }
        return list;
    }
}

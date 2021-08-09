/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import datlt.conn.MyConnection;
import dto.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RoleDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public RoleDAO() {
    }
    
    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Role> getAllRole() throws Exception {
        try {
            String sql = "SELECT [Id]\n"
                    + "      ,[RoleName]\n"
                    + "      ,[RoleStatus]\n"
                    + "  FROM [dbo].[RoleUser]";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<Role> listRole = new ArrayList<>();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listRole.add(role);
            }
            return listRole;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            closeConnection();
        }
        return null;
    }

    public String getRoleById(int id) throws Exception {
        try {
            String sql = "SELECT [Id]\n"
                    + "      ,[RoleName]\n"
                    + "      ,[RoleStatus]\n"
                    + "  FROM [dbo].[RoleUser]\n"
                    + "  WHERE Id = ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getString(2);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            closeConnection();
        }
        return null;
    }
}

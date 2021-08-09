/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import datlt.conn.MyConnection;
import dto.Promotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PromotionDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public PromotionDAO() {
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
    
    public ArrayList<Promotion> getAllPromotion() throws Exception {
        try {
            String sql = "SELECT [PromotionId]\n"
                    + "      ,[UserId]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[RankPromotion]\n"
                    + "      ,[Photo]\n"
                    + "  FROM [dbo].[tblPromotion]\n"
                    + "  WHERE [PromotionStatus] = 1";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<Promotion> listPromotion = new ArrayList<>();
            while (rs.next()) {
                Promotion promotion = new Promotion(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDouble(4), rs.getString(5));
                listPromotion.add(promotion);
            }
            return listPromotion;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
    
    public int addToPromotionList(ArrayList<Promotion> listPromotion) throws Exception {
        try {
            String sql = "INSERT INTO [dbo].[tblPromotion]\n"
                    + "           ([UserId]\n"
                    + "           ,[RankPromotion]\n"
                    + "           ,[Photo]\n"
                    + "           ,[PromotionStatus])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            int[] arr = {};

            for (Promotion promotion : listPromotion) {
                ps.setInt(1, promotion.getUserId());
                ps.setDouble(2, promotion.getRankPromo());
                ps.setString(3, promotion.getPhoto());
                ps.setInt(4, promotion.getStatus());
                ps.addBatch();
            }

            arr = ps.executeBatch();
            return arr.length;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            closeConnection();
        }
        return 0;
    }

    public int deletePromotion(int id) throws Exception {
        try {
            String sql = "UPDATE [dbo].[tblPromotion]\n"
                    + "   SET \n"
                    + "       [PromotionStatus] = 0\n"
                    + " WHERE [UserId] = ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            closeConnection();
        }
        return 0;
    }

    public int updateRankPromotion(ArrayList<Promotion> listPromotion) throws Exception {
        try {
            String sql = "UPDATE [dbo].[tblPromotion]\n"
                    + "   SET \n"
                    + "       [RankPromotion] = ?\n"
                    + " WHERE [PromotionId] = ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            int[] arr = {};

            for (Promotion promotion : listPromotion) {
                ps.setDouble(1, promotion.getRankPromo());
                ps.setInt(2, promotion.getId());
                ps.addBatch();
            }

            arr = ps.executeBatch();
            return arr.length;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            closeConnection();
        }
        return 0;
    }

    public Promotion getPromotionById(int id) throws Exception {
        try {
            String sql = "SELECT [PromotionId]\n"
                    + "      ,[UserId]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[RankPromotion]\n"
                    + "      ,[Photo]\n"
                    + "      ,[PromotionStatus]\n"
                    + "  FROM [dbo].[tblPromotion]\n"
                    + "  WHERE [PromotionId] = ? ";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Promotion promotion = new Promotion(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                return promotion;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            closeConnection();
        }
        return null;
    }

    
}

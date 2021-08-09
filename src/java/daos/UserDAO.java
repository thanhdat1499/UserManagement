package daos;

import datlt.conn.MyConnection;
import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public UserDAO() {
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

    public User login(String username, String password) throws Exception {
        try {
            String sql = "SELECT [UserId]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Password]\n"
                    + "      ,[DisplayName]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Address]\n"
                    + "      ,[Photo]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[UserStatus]\n"
                    + "      ,[RoleId]\n"
                    + "  FROM [dbo].[tblUser]"
                    + "  WHERE [Username] = ? and [Password] = ? and [UserStatus] = 1";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getDate(9));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public ArrayList<User> getAllUser() throws Exception {
        try {
            String sql = "SELECT [UserId]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Password]\n"
                    + "      ,[DisplayName]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Address]\n"
                    + "      ,[Photo]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[UserStatus]\n"
                    + "      ,[RoleId]\n"
                    + "  FROM [dbo].[tblUser]\n";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            ArrayList<User> listUser = new ArrayList<>();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getDate(9));
                listUser.add(user);
            }
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public ArrayList<User> getUserByRole(int role_id) throws Exception {
        try {
            String sql = "SELECT [UserId]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Password]\n"
                    + "      ,[DisplayName]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Address]\n"
                    + "      ,[Photo]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[UserStatus]\n"
                    + "      ,[RoleId]\n"
                    + "  FROM [dbo].[tblUser]\n"
                    + "  WHERE [RoleId] = ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, role_id);
            rs = ps.executeQuery();

            ArrayList<User> listUser = new ArrayList<>();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getDate(9));
                listUser.add(user);
            }
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public ArrayList<User> searchUser(String name) throws Exception {
        try {
            String sql = "SELECT [UserId]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Password]\n"
                    + "      ,[DisplayName]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Address]\n"
                    + "      ,[Photo]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[UserStatus]\n"
                    + "      ,[RoleId]\n"
                    + "  FROM [dbo].[tblUser]\n"
                    + "  WHERE [DisplayName] like ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();

            ArrayList<User> listUser = new ArrayList<>();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getDate(9));
                listUser.add(user);
            }
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public int deleteUser(int id) throws Exception {
        try {
            String sql = "UPDATE [dbo].[tblUser]\n"
                    + "   SET \n"
                    + "      [UserStatus] = 0\n"
                    + " WHERE [UserId] = ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return 0;
    }

    public User getUserById(int id) throws Exception {
        try {
            String sql = "SELECT [UserId]\n"
                    + "      ,[UserName]\n"
                    + "      ,[Password]\n"
                    + "      ,[DisplayName]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Address]\n"
                    + "      ,[Photo]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[UserStatus]\n"
                    + "      ,[RoleId]\n"
                    + "  FROM [dbo].[tblUser]\n"
                    + "  WHERE [UserId] = ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(11), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10), rs.getDate(9));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public int updateUserByAdmin(User user) throws Exception {
        try {
            String sql = "UPDATE [dbo].[tblUser]\n"
                    + "   SET [RoleId] = ?\n"
                    + "      ,[DisplayName] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[Phone] = ?\n"
                    + "      ,[Address] = ?\n"
                    + "      ,[Photo] = ?\n"
                    + "      ,[UserStatus] = ?\n"
                    + " WHERE [UserId] = ?";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getRole_Id());
            ps.setString(2, user.getDisplayName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPhoto());
            ps.setInt(7, user.getStatus());
            ps.setInt(8, user.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return 0;
    }

    public int addNewUserByAdmin(User user) throws Exception {
        try {
            String sql = "INSERT INTO [dbo].[tblUser]\n"
                    + "           ([UserName]\n"
                    + "           ,[Password]\n"
                    + "           ,[DisplayName]\n"
                    + "           ,[Email]\n"
                    + "           ,[Phone]\n"
                    + "           ,[Address]\n"
                    + "           ,[Photo]\n"
                    + "           ,[UserStatus]\n"
                    + "           ,[RoleId])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,1,1)";
            conn = MyConnection.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getDisplayName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getPhoto());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return 0;
    }

}

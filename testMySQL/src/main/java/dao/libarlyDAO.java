package dao;

import java.sql.*;
import java.util.ArrayList;
import database.libralyData;
import model.testmysql.libraly;

public class libarlyDAO implements DAOInterface<libraly> {

    public static libarlyDAO getInstance(){
        return new libarlyDAO();
    }
    @Override
    public int insert(libraly libraly) {
        int ketqua = 0;
        try {
            Connection connection = libralyData.getConnection();
            String mysql = "INSERT INTO vocabulary (id, english, vietnam) "+
                           " VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(mysql);
            pst.setInt(1, libraly.getId());
            pst.setString(2, libraly.getEnglish());
            pst.setString(3, libraly.getVietnam());
            ketqua = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int update(libraly libraly) {
        int ketqua = 0;
        try {
            Connection connection = libralyData.getConnection();
            String mysql = "UPDATE vocabulary "+
                           " SET " +
                           " english=?"+
                           ", vietnam=?"+
                           " WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(mysql);
            pst.setString(1, libraly.getEnglish());
            pst.setString(2, libraly.getVietnam());
            pst.setInt(3, libraly.getId());
            ketqua = pst.executeUpdate();
            System.out.println("Ban da thuc thi "+mysql);
            System.out.println("Co "+ketqua+" dong thay doi");
            libralyData.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int delete(libraly libraly) {
        int ketqua = 0;
        try {
            Connection connection = libralyData.getConnection();
            String mysql = "DELETE from vocabulary "+
                           " WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(mysql);
            pst.setInt(1, libraly.getId());
            ketqua = pst.executeUpdate();
            System.out.println("Ban da thuc thi "+mysql);
            System.out.println("Co "+ketqua+" dong thay doi");
            libralyData.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public ArrayList<libraly> selectAll() {
        ArrayList<libraly> ketqua = new ArrayList<libraly>();
        try {
            Connection connection = libralyData.getConnection();
            String mysql = "SELECT * FROM vocabulary ";
            PreparedStatement pst = connection.prepareStatement(mysql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String english = rs.getString("english");
                String vietnam = rs.getString("vietnam");
                libraly libralys = new libraly(id, english, vietnam);
                ketqua.add(libralys);
            }
            libralyData.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;    }

    @Override
    public libraly seclectById(libraly libraly) {
        libraly ketqua = null;
        try {
            Connection connection= libralyData.getConnection();
            String mysql = "SELECT * FROM vocabulary where id=?";
            PreparedStatement pst = connection.prepareStatement(mysql);
            pst.setInt(1, libraly.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String english = rs.getString("english");
                String vietnam = rs.getString("vietnam");
                ketqua = new libraly(id, english, vietnam);
            }
            libralyData.closeConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public ArrayList<libraly> seclectByCondition(String condition) {
        return null;
    }
}

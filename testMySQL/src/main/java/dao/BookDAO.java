package dao;

import database.JDBCUtil;
import model.testmysql.book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO implements DAOInterface<book>{

    public static BookDAO getInstance() {
        return new BookDAO();
    }
    @Override
    public int insert(book book) {
        int ketqua = 0;
        try {
            //connect
            Connection con = JDBCUtil.getConnection();
            //statement
            Statement st = con.createStatement();
            String sql = "INSERT INTO book (id, tenSach, giaBan, namXuatBan) "+
                    " VALUES ('"+book.getId()+"' , '"+book.getTenSach()+"' , "+book.getGiaBan()+" , '"+book.getNamXuatBan()+"')";

            ketqua = st.executeUpdate(sql);
            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketqua+" dong thay doi");
            //
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int update(book book) {
        int ketqua = 0;
        try {
            //connect
            Connection con = JDBCUtil.getConnection();
            //statement
            Statement st = con.createStatement();
            String sql = "UPDATE book "+
                         " SET " +
                         " tenSach='"+book.getTenSach()+"'"+
                         ", giaBan="+book.getGiaBan()+
                         ", namXuatBan="+book.getNamXuatBan()+
                         " WHERE id='"+book.getId()+"'";
            System.out.println(sql);
            ketqua = st.executeUpdate(sql);
            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketqua+" dong thay doi");
            //
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public int delete(book book) {
        int ketqua = 0;
        try {
            //connect
            Connection con = JDBCUtil.getConnection();
            //statement
            Statement st = con.createStatement();
            String sql = "DELETE from book "+
                         " WHERE id='"+book.getId()+"'";
            ketqua = st.executeUpdate(sql);
            System.out.println("Ban da thuc thi "+sql);
            System.out.println("Co "+ketqua+" dong thay doi");
            //
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public ArrayList<book> selectAll() {
        ArrayList<book> ketqua = new ArrayList<book>();
        try {
            //connect
            Connection con = JDBCUtil.getConnection();
            //statement
            Statement st = con.createStatement();
            //
            String sql = "SELECT * FROM book ";
            ResultSet rs = st.executeQuery(sql);
            //
            while(rs.next()) {
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");

                book book0 = new book(id, tenSach, giaBan,namXuatBan);
                ketqua.add(book0);
            }
            //
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public book seclectById(book book) {
        book ketqua = null;
        try {
            //connect
            Connection con = JDBCUtil.getConnection();
            //statement
            Statement st = con.createStatement();
            //
            String sql = "SELECT * FROM book where id='"+book.getId()+"'";
            ResultSet rs = st.executeQuery(sql);
            //
            while(rs.next()) {
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");

                ketqua = new book(id, tenSach, giaBan,namXuatBan);
            }
            //
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketqua;
    }

    @Override
    public ArrayList<book> seclectByCondition(String condition) {
        return null;
    }
}

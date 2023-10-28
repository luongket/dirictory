package dao;

import model.testmysql.khachhang;

import java.util.ArrayList;

public class KhachHangDAO implements DAOInterface<khachhang>{

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }
    @Override
    public int insert(khachhang khachhang) {
        return 0;
    }

    @Override
    public int update(khachhang khachhang) {
        return 0;
    }

    @Override
    public int delete(khachhang khachhang) {
        return 0;
    }

    @Override
    public ArrayList<khachhang> selectAll() {
        return null;
    }

    @Override
    public khachhang seclectById(khachhang khachhang) {
        return null;
    }

    @Override
    public ArrayList<khachhang> seclectByCondition(String condition) {
        return null;
    }
}

package model.testmysql;

public class book {
    private String id;
    private String tenSach;
    private float giaBan;
    private int namXuatBan;

    public book() {

    }

    public book(String id, String tenSach, float giaBan, int namXuatBan) {
        this.id = id;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.namXuatBan = namXuatBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    @Override
    public String toString() {
        return "book{" +
                "id='" + id + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", giaBan=" + giaBan +
                ", namXuatBan=" + namXuatBan +
                '}';
    }
}

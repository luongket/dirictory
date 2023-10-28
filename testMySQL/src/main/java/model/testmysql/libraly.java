package model.testmysql;

public class libraly {
    private int id;
    private String english;
    private String vietnam;

    public libraly() {
    }

    public libraly(int id, String english, String vietnam) {
        this.id = id;
        this.english = english;
        this.vietnam = vietnam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietnam() {
        return vietnam;
    }

    public void setVietnam(String vietnam) {
        this.vietnam = vietnam;
    }

    @Override
    public String toString() {
        return "libraly{" +
                "id=" + id +
                ", english='" + english + '\'' +
                ", vietnam='" + vietnam + '\'' +
                '}';
    }
}

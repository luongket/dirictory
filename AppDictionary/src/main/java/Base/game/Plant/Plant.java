package Base.game.Plant;

import Base.game.GameElement;
import Base.game.Zombie.Basic_Zombie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.List;

public class Plant extends GameElement {
    protected Point center;
    protected double price;
    protected double hp;
    protected String name;
    ImageView img;
    public int Lane;
    public int row,col;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }



    public Plant(int width, int height, Point center, double price, double hp,
                 String name,int Lane) {
        super(width, height);
        this.center = center;
        this.price = price;
        this.hp = hp;
        this.name = name;
        this.Lane = Lane;
        String tmp = "/asset/Game/" + name+"/"+name + ".gif";
        this.setPath(tmp);
    }

    public void makeImage(GridPane pane, int col, int row) {
        img = new ImageView();
        Image im = new Image(path, (double) width, (double) height, false, false);
        img.setImage(im);
        pane.add(img, col, row, 1, 1);
        Lane=row+1;
        this.row=row;
        this.col=col;
    }
    public void ActionPlant(Basic_Zombie zombie){

    }
    public void Reset(){

    }
}

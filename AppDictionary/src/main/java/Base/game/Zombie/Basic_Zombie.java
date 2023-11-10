package Base.game.Zombie;

import Base.game.Plant.Plant;
import Base.game.Plant.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


enum state {
    poisoned,
    freeze,
    Normal,
    burn;
}

public class Basic_Zombie {
    private float movementSpeed;
    private String Name;
    private Point Position;
    private state stateZombie;
    private float MaxHp;
    private float hp;
    private float damage;
    private float Width;
    private float Height;
    private ImageView image;
    private int Lane;
    public Boolean collisionPlant=false;


    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public float getWidth() {
        return Width;
    }

    public void setWidth(float width) {
        Width = width;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        Height = height;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Point getPosition() {
        return Position;
    }

    public void setPosition(Point position) {
        Position = position;
    }

    public state getStateZombie() {
        return stateZombie;
    }

    public void setStateZombie(state stateZombie) {
        this.stateZombie = stateZombie;
    }

    public Basic_Zombie(float movementSpeed, String name, Point position, int Lane,
                        float maxHp, float damage,
                        float width, float height, Pane pane) {
        this.movementSpeed = movementSpeed;
        Name = name;
        Position = position;
        this.stateZombie = state.Normal;
        this.MaxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
        this.Lane=Lane;
        Width = width;
        Height = height;
        String path="/asset/Game/"+name+".gif";
        image=new ImageView(new Image(path));
        this.image.setLayoutX(position.getPointX());
        this.image.setLayoutY(position.getPointY());
        this.image.setFitHeight(height);this.image.setFitWidth(width);
        pane.getChildren().add(this.image);
    }

    public Boolean IsDie() {
        return hp == 0;
    }

    public int getLane() {
        return Lane;
    }

    public void setLane(int lane) {
        Lane = lane;
    }


    public void Move(){
        if(hp>0&&this.getImage().getLayoutX()>100&&!collisionPlant){
            this.getImage().setLayoutX(this.getImage().getLayoutX()-this.getMovementSpeed());
        }
    }
    public Boolean eatPlant(Plant plant){
        if(plant.Lane==this.getLane()){
            if(Math.abs(plant.getCenter().getPointX()-this.getImage().getLayoutX())<5){
                plant.setHp(plant.getHp()-this.getDamage());
                System.out.println("eatPlant");
                return true;

            }
            return false;

        }
        return false;

    }


}

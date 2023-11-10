package Base.game.Plant;

import Base.game.Zombie.Basic_Zombie;

public class pea extends Plant {
    public Bullet bullet;

    public pea(int width, int height, Point center,
               double hp, String name, int lane, Bullet bulletNew) {
        super(width, height, center, 50, hp, name,lane);
        bullet=bulletNew;


    }

    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void ActionPlant(Basic_Zombie zombie){
        bullet.getImage().setLayoutX(bullet.getImage().getLayoutX() +bullet.getSpeed());
        if(bullet.getImage().getLayoutX()>900){
            bullet.getImage().setLayoutX(0);
        }
        if(bullet.getPosition().getPointX()>bullet.getImage().getLayoutX()){
            bullet.falg=false;
        }else {
            bullet.falg=true;

        }
        bullet.getImage().setVisible(bullet.falg);
        bullet.Collision(zombie);
    }
    @Override
    public void Reset(){
        if((this.getCenter().getPointX()-bullet.getImage().getLayoutX())<=5
                &&(this.getCenter().getPointX()-bullet.getImage().getLayoutX())>=1){
            bullet.reset();
        }
        bullet.getImage().setLayoutX(bullet.getImage().getLayoutX() +bullet.getSpeed());
        if(bullet.getImage().getLayoutX()>900){
            bullet.getImage().setLayoutX(0);
        }
        if(bullet.getPosition().getPointX()>bullet.getImage().getLayoutX()){
            bullet.falg=false;
        }else {
            bullet.falg=true;

        }
        bullet.getImage().setVisible(bullet.falg);
    }
}

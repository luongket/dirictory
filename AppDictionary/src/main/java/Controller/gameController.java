package Controller;

import Base.game.Plant.Bullet;
import Base.game.Plant.Plant;
import Base.game.Plant.Point;
import Base.game.Plant.pea;
import Base.game.Card;
import Base.game.Zombie.Basic_Zombie;
import Base.game.lawn_mower;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import javafx.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    private DataHero hero = new DataHero();
    @FXML
    private AnchorPane GameRoot;
    @FXML
    private GridPane lawn_grid;
    private int level = 0;
    private int Sun = 0;
    public static final int LANE1 = 50;
    public static final int LANE2 = 110;
    public static final int LANE3 = 177;
    public static final int LANE4 = 233;
    public static final int LANE5 = 300;
    public boolean level_complete = false;
    @FXML
    private HBox BoxPlant;
    @FXML
    private GridPane table;
    @FXML
    private AnchorPane PausePane;
    public static int val;
    public static List<Plant> listPlant = new ArrayList<Plant>();
    public static List<Bullet> listBullet = new ArrayList<Bullet>();
    public static List<Basic_Zombie> ZombieList = new ArrayList<Basic_Zombie>();
    public static List<lawn_mower> lawnMovers = new ArrayList<lawn_mower>();
    public static List<Card> plantIterm = new ArrayList<Card>();

    public void ShowData() {
        PausePane.setVisible(true);
        PausePane.setViewOrder(-2);

        for (int i = 0; i < hero.getHeroes().size(); i++) {
            hero.getHeroes().get(i).getImg().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node node = (ImageView) event.getSource();
                    int row = table.getRowIndex(node);
                    int column = table.getColumnIndex(node);
                    int plant = column * 4 + row;
                    if (plantIterm.size() < 4) {
                        if (!BoxPlant.getChildren().contains(node)) {
                            hero.getHeroes().get(plant).getImgBox().setOnMouseClicked(mouseEvent -> {
                                val = BoxPlant.getChildren().indexOf((ImageView) mouseEvent.getSource());
                                System.out.print(val);
                            });
                            BoxPlant.getChildren().add(hero.getHeroes().get(plant).getImgBox());
                            plantIterm.add(hero.getHeroes().get(plant));
                        }
                    }
                }
            });
            table.add(hero.getHeroes().get(i).getImg(), i / 4, i % 4, 1, 1);
        }
    }

    public void CloseTable() {
        table.getChildren().removeAll();
        PausePane.setVisible(false);

    }

    public void AddPlant(Card iterm, int row, int col, Point center) {
        Plant plant;
        switch (iterm.getPlantform()) {
            case shooter:
                Bullet bullet = new Bullet(iterm.getDamge(), iterm.getSpeed(), row + 1, GameRoot, center, iterm.getBulletname());
                plant = new pea(40, 40, center, iterm.getHp(), iterm.getNamePlant(), row + 1, bullet);
                plant.makeImage(lawn_grid, col, row);
                listBullet.add(bullet);
                listPlant.add(plant);
                break;
        }

    }

    public void removePlant(Plant plant) {
        plant.getImg().setVisible(false);
        if (plant instanceof pea) {
            pea shoot = (pea) plant;
            shoot.bullet.getImage().setVisible(false);
            listBullet.remove(shoot.bullet);
        }
        listPlant.remove(plant);
    }

    public Card choosePlant(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        int Index = BoxPlant.getChildren().indexOf(node);
        return plantIterm.get(Index);
    }

    public void SpawnZombie() {
        if (ZombieList.size() == 0) {
            Random random = new Random();
            level += 1;
            int countZombie = random.nextInt(5 + 3 * level) + 3 * level;
            Point center = new Point(700, 700);
            Timeline SpawnTime = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
                int Lane = random.nextInt(4);
                switch (Lane) {
                    case 0:
                        center.setPointY(LANE1);
                        Basic_Zombie newZom1 = new Basic_Zombie(1, "Zombie"
                                , center, Lane + 1,
                                20, 10, 50, 50,
                                GameRoot);
                        ZombieList.add(newZom1);
                        break;
                    case 1:
                        center.setPointY(LANE2);
                        Basic_Zombie newZom2 = new Basic_Zombie(1, "Zombie"
                                , center, Lane + 1,
                                20, 2, 50, 50,
                                GameRoot);
                        ZombieList.add(newZom2);
                        break;
                    case 2:
                        center.setPointY(LANE3);
                        Basic_Zombie newZom3 = new Basic_Zombie(1, "Zombie"
                                , center, Lane + 1,
                                20, 2, 50, 50,
                                GameRoot);
                        ZombieList.add(newZom3);
                        break;
                    case 3:
                        center.setPointY(LANE4);
                        Basic_Zombie newZom4 = new Basic_Zombie(1, "Zombie"
                                , center, Lane + 1,
                                20, 2, 50, 50,
                                GameRoot);
                        ZombieList.add(newZom4);
                        break;
                    case 4:
                        center.setPointY(LANE5);
                        Basic_Zombie newZom5 = new Basic_Zombie(0.25f, "Zombie"
                                , center, Lane + 1,
                                20, 2, 50, 50,
                                GameRoot);
                        ZombieList.add(newZom5);
                        break;
                }

            }));
            SpawnTime.setCycleCount(countZombie);
            SpawnTime.play();
        }
    }

    public void RemoveZombie1(Basic_Zombie zombie) {
        zombie.getImage().setVisible(false);
        ZombieList.remove(zombie);
    }


    @FXML
    public void choose(MouseEvent event) throws IOException {
        if (PausePane.isVisible()) {
            return;
        }
        Node node = (Node) event.getSource();
        int row = lawn_grid.getRowIndex(node);
        int column = lawn_grid.getColumnIndex(node);
        for (int i = 0; i < listPlant.size(); i++) {
            if (listPlant.get(i).row == row && listPlant.get(i).col == column) {
                return;
            }
        }
        Point center = new Point(node.getLayoutX() + 170, node.getLayoutY() + 65);
        System.out.println(row + " " + column);
        AddPlant(plantIterm.get(val), row, column, center);

    }

    Timeline updatePlant = new Timeline(new KeyFrame(Duration.seconds(0.04), event -> {
        for (int i = 0; i < listPlant.size(); i++) {
            for (Basic_Zombie zombie : ZombieList) {
                listPlant.get(i).ActionPlant(zombie);
            }
            if (listPlant.get(i).getHp() <= 0) {
                removePlant(listPlant.get(i));
            }
        }
    }));
    Timeline updateZombie = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
        for (int i = 0; i < ZombieList.size(); i++) {
            for (int j = 0; j < listPlant.size(); j++) {
                ZombieList.get(i).collisionPlant = false;
                if (ZombieList.get(i).eatPlant(listPlant.get(j))) {
                    ZombieList.get(i).collisionPlant = true;
                    break;
                }
            }
            ZombieList.get(i).Move();

            if (ZombieList.get(i).IsDie()) {

                RemoveZombie1(ZombieList.get(i));
            }
        }
    }));
    Timeline UpdateLevel = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
        SpawnZombie();
    }));
    Timeline UpdateLawnMover = new Timeline(new KeyFrame(Duration.seconds(0.02), event -> {
        for (int i = 0; i < lawnMovers.size(); i++) {
            lawnMovers.get(i).checkAction(ZombieList);
        }

    }));

    public void SpawnLawnMover() {
        lawn_mower newLawnMower1 = new lawn_mower(50, 50, 1, 100, LANE1);
        lawn_mower newLawnMower2 = new lawn_mower(50, 50, 2, 100, LANE2);
        lawn_mower newLawnMower3 = new lawn_mower(50, 50, 3, 100, LANE3);
        lawn_mower newLawnMower4 = new lawn_mower(50, 50, 4, 100, LANE4);
        lawn_mower newLawnMower5 = new lawn_mower(50, 50, 5, 100, LANE5);
        lawnMovers.add(newLawnMower1);
        lawnMovers.add(newLawnMower2);
        lawnMovers.add(newLawnMower3);
        lawnMovers.add(newLawnMower4);
        lawnMovers.add(newLawnMower5);
        GameRoot.getChildren().add(newLawnMower1.getImage());
        GameRoot.getChildren().add(newLawnMower2.getImage());
        GameRoot.getChildren().add(newLawnMower3.getImage());
        GameRoot.getChildren().add(newLawnMower4.getImage());
        GameRoot.getChildren().add(newLawnMower5.getImage());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BoxPlant.setViewOrder(-1);
        SpawnLawnMover();

        UpdateLevel.setCycleCount(Animation.INDEFINITE);
        UpdateLevel.play();
        updatePlant.setCycleCount(Animation.INDEFINITE);
        updatePlant.play();
        updateZombie.setCycleCount(Animation.INDEFINITE);
        updateZombie.play();
        UpdateLawnMover.setCycleCount(Animation.INDEFINITE);
        UpdateLawnMover.play();

    }
}

package Base.game.Plant;

import Base.game.Card;
import Base.game.PlantSeed;

import java.util.ArrayList;
import java.util.List;


public class DataPlant {
    private List<Card> heroes = new ArrayList<Card>();
    Card plant1 = new Card("pea", 15, 4, 4, "SeedPea", 100,"bullet", PlantSeed.pea);
    Card plant2 = new Card("cactus", 20, 5, 4, "SeedPea", 125,"bullet", PlantSeed.cactus);
    Card plant3 = new Card("Cherry", 50, 30, 3, "SeedPea", 150,"bullet", PlantSeed.cherry);
    Card plant4 = new Card("DoomShroom", 50, 20, 4, "SeedPea", 125,"bullet", PlantSeed.DroomShroom);
    Card plant6 = new Card("IcePea", 15, 4, 4, "SeedPea", 175,"bullet", PlantSeed.IcePea);
    Card plant7 = new Card("IceShroom", 50, 20, 4, "SeedPea", 75,"bullet", PlantSeed.IceShroom);
    Card plant8 = new Card("PotatoMine", 50, 20, 4, "SeedPea", 25,"bullet", PlantSeed.PotatoMine);
    Card plant9 = new Card("SpikeRock", 50, 0.1f, 4, "SeedPea", 100,"bullet", PlantSeed.SpikeRock);
    Card plant11 = new Card("Squash", 50, 25, 4, "SeedPea", 50,"bullet", PlantSeed.Squash);
    Card plant12 = new Card("SunFlower", 50, 20, 4, "SeedPea", 150,"bullet", PlantSeed.SunFlower);
    Card plant13 = new Card("ThreePeater", 50, 5, 5, "SeedPea", 325,"bullet", PlantSeed.ThreePeater);
    Card plant15 = new Card("Walnut", 100, 20, 4, "SeedPea", 50,"bullet", PlantSeed.Walnut);
    Card plant16 = new Card("chilli", 50, 20, 4, "SeedPea", 125,"bullet", PlantSeed.chilli);

    public List<Card> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Card> heroes) {
        this.heroes = heroes;
    }

    public DataPlant() {
        this.heroes.add(plant1);
        this.heroes.add(plant2);
        this.heroes.add(plant3);
        this.heroes.add(plant4);
        this.heroes.add(plant6);
        this.heroes.add(plant7);
        this.heroes.add(plant8);
        this.heroes.add(plant9);
        this.heroes.add(plant11);
        this.heroes.add(plant12);
        this.heroes.add(plant13);
        this.heroes.add(plant15);
        this.heroes.add(plant16);
    }
}

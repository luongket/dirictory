<<<<<<<< HEAD:AppDictionary/src/main/java/Base/game/Plant/DataPlant.java
package Base.game.Plant;
========
package Controller;
>>>>>>>> 5512e3afda1f66cf1871836575459925154e89f1:AppDictionary/src/main/java/Controller/DataHero.java

import Base.game.Card;
import Base.game.PlantSeed;

import java.util.ArrayList;
import java.util.List;


public class DataPlant {
    private List<Card> heroes = new ArrayList<Card>();
<<<<<<<< HEAD:AppDictionary/src/main/java/Base/game/Plant/DataPlant.java
    Card plant1 = new Card("pea", 15, 1, 4, "SeedPea", 100,"bullet", PlantSeed.pea);
    Card plant2 = new Card("cactus", 20, 2, 4, "SeedPea", 100,"bullet", PlantSeed.cactus);
    Card plant3 = new Card("Cherry", 50, 20, 3, "SeedPea", 100,"bullet", PlantSeed.cherry);
    Card plant4 = new Card("DoomShroom", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.DroomShroom);
    Card plant5 = new Card("GatlingPea", 50, 2, 4, "SeedPea", 100,"bullet", PlantSeed.GatlingPea);
    Card plant6 = new Card("IcePea", 15, 2, 3, "SeedPea", 100,"bullet", PlantSeed.IcePea);
    Card plant7 = new Card("IceShroom", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.IceShroom);
    Card plant8 = new Card("PotatoMine", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.PotatoMine);
    Card plant9 = new Card("SpikeRock", 50, 0.1f, 4, "SeedPea", 100,"bullet", PlantSeed.SpikeRock);
    Card plant10 = new Card("SplitPea", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.SlitPea);
    Card plant11 = new Card("Squash", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.Squash);
    Card plant12 = new Card("SunFlower", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.SunFlower);
    Card plant13 = new Card("ThreePeater", 50, 2, 2, "SeedPea", 100,"bullet", PlantSeed.ThreePeater);
    Card plant14 = new Card("Tonchwood", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.TonchWood);
    Card plant15 = new Card("Walnut", 100, 20, 4, "SeedPea", 100,"bullet", PlantSeed.Walnut);
    Card plant16 = new Card("chilli", 50, 20, 4, "SeedPea", 100,"bullet", PlantSeed.chilli);
========
    Card plant1 = new Card("pea", 50, 1, 1, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant2 = new Card("cactus", 50, 20, 2, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant3 = new Card("Cherry", 50, 20, 3, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant4 = new Card("DoomShroom", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant5 = new Card("GatlingPea", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant6 = new Card("IcePea", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant7 = new Card("IceShroom", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant8 = new Card("PotatoMine", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant9 = new Card("SpikeRock", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant10 = new Card("SplitPea", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant11 = new Card("Squash", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant12 = new Card("SunFlower", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant13 = new Card("ThreePeater", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant14 = new Card("Tonchwood", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant15 = new Card("Walnut", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
    Card plant16 = new Card("pea", 50, 20, 4, "SeedPea", 100, "bullet", Plantform.shooter);
>>>>>>>> 5512e3afda1f66cf1871836575459925154e89f1:AppDictionary/src/main/java/Controller/DataHero.java

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
        this.heroes.add(plant5);
        this.heroes.add(plant6);
        this.heroes.add(plant7);
        this.heroes.add(plant8);
        this.heroes.add(plant9);
        this.heroes.add(plant10);
        this.heroes.add(plant11);
        this.heroes.add(plant12);
        this.heroes.add(plant13);
        this.heroes.add(plant14);
        this.heroes.add(plant15);
        this.heroes.add(plant16);
    }
}

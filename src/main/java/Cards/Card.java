package Cards;

import java.awt.Color;
import java.util.List;

public class Card {

    List<Color> uniqueColorSequence;
    String name;
    int cost;
    int damage;

    public Card() {
    }

    public Card(List<Color> uniqueColorSequence, String name, int cost, int damage) {
        this.uniqueColorSequence = uniqueColorSequence;
        this.name = name;
        this.cost = cost;
        this.damage = damage;
    }

    public List<Color> getUniqueColorSequence() {
        return uniqueColorSequence;
    }

    public void setUniqueColorSequence(List<Color> uniqueColorSequence) {
        this.uniqueColorSequence = uniqueColorSequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

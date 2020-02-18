package Cards;

import java.awt.Color;
import java.util.List;

public class Creature extends Card {

    int defense;
    boolean isTough;
    boolean isElusive;
    boolean hasFastAttack;
    boolean hasActionWhenPlayed;
    boolean hasActionWhenDies;
    boolean hasActionWhenAttacks;
    boolean isHero;
    boolean isFearless;
    boolean hasOverwhelm;
    boolean isSpell = false;
    boolean isCreature = true;

//    public Creature() {
//    }

    public Creature(List<Color> uniqueColorSequence, String name, int cost, int damage) {
        super(uniqueColorSequence, name, cost, damage);
    }

    public Creature(List<Color> uniqueColorSequence, String name, int cost, int damage, int defense) {
        super(uniqueColorSequence, name, cost, damage);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean isTough() {
        return isTough;
    }

    public void setTough(boolean tough) {
        isTough = tough;
    }

    public boolean isElusive() {
        return isElusive;
    }

    public void setElusive(boolean elusive) {
        isElusive = elusive;
    }

    public boolean isHasFastAttack() {
        return hasFastAttack;
    }

    public void setHasFastAttack(boolean hasFastAttack) {
        this.hasFastAttack = hasFastAttack;
    }

    public boolean isHasActionWhenPlayed() {
        return hasActionWhenPlayed;
    }

    public void setHasActionWhenPlayed(boolean hasActionWhenPlayed) {
        this.hasActionWhenPlayed = hasActionWhenPlayed;
    }

    public boolean isSpell() {
        return isSpell;
    }

    public void setSpell(boolean spell) {
        isSpell = spell;
    }

    public boolean isCreature() {
        return isCreature;
    }

    public void setCreature(boolean creature) {
        isCreature = creature;
    }

    public boolean isHasActionWhenDies() {
        return hasActionWhenDies;
    }

    public void setHasActionWhenDies(boolean hasActionWhenDies) {
        this.hasActionWhenDies = hasActionWhenDies;
    }

    public boolean isHasActionWhenAttacks() {
        return hasActionWhenAttacks;
    }

    public void setHasActionWhenAttacks(boolean hasActionWhenAttacks) {
        this.hasActionWhenAttacks = hasActionWhenAttacks;
    }

    public boolean isHero() {
        return isHero;
    }

    public void setHero(boolean hero) {
        isHero = hero;
    }

    public boolean isFearless() {
        return isFearless;
    }

    public void setFearless(boolean fearless) {
        isFearless = fearless;
    }

    public boolean isHasOverwhelm() {
        return hasOverwhelm;
    }

    public void setHasOverwhelm(boolean hasOverwhelm) {
        this.hasOverwhelm = hasOverwhelm;
    }
}

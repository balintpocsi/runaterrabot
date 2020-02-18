package Cards;

import java.awt.Color;
import java.util.List;

public class Spell extends Card {

    boolean isBurstSpell;
    boolean isFastSpell;
    boolean isSlowSpel;
    boolean IsBuff;
    boolean isCrowdControl;
    boolean isSpell = true;
    boolean isCreature = false;

    public Spell(List<Color> uniqueColorSequence, String name, int cost, int damage) {
        super(uniqueColorSequence, name, cost, damage);
    }

    public boolean isBurstSpell() {
        return isBurstSpell;
    }

    public void setBurstSpell(boolean burstSpell) {
        isBurstSpell = burstSpell;
    }

    public boolean isFastSpell() {
        return isFastSpell;
    }

    public void setFastSpell(boolean fastSpell) {
        isFastSpell = fastSpell;
    }

    public boolean isSlowSpel() {
        return isSlowSpel;
    }

    public void setSlowSpel(boolean slowSpel) {
        isSlowSpel = slowSpel;
    }

    public boolean isBuff() {
        return IsBuff;
    }

    public void setBuff(boolean buff) {
        IsBuff = buff;
    }

    public boolean isCrowdControl() {
        return isCrowdControl;
    }

    public void setCrowdControl(boolean crowdControl) {
        isCrowdControl = crowdControl;
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
}

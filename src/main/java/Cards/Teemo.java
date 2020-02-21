package Cards;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class Teemo extends Creature{

    public Teemo(List<Color> uniqueColorSequence, String name, int cost, int damage) {
        super(uniqueColorSequence, name, cost, damage);
    }

    public Teemo createTeemo(){
        List<Color> list = Arrays.asList(new Color(-123124), new Color(-124151));
        Teemo teemo = new Teemo(list, "Teemo", 1, 1);
        defense=1;
        return teemo;
    }

}

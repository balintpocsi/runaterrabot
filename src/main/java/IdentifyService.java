import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import Cards.Card;

public class IdentifyService {

    public void tellMeWhoAmI(List<Color> colorListOfTargetPixelSequence) throws IOException {

        File file = new File("teemo.png");
        BufferedImage image = ImageIO.read(file);
        int heightValueConst = 100;

        Color color = new Color(image.getRGB(3,3));
        System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());

        for (int widthStartValue = 0; widthStartValue < image.getWidth(); widthStartValue++){

            image.setRGB(widthStartValue,heightValueConst, new Color(255, 255, 255).getRGB());
        }
        //return new Card();
    }
}

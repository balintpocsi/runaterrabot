import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;


public class TestList {

    @Test
    public void listTestMethod() throws InterruptedException {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
        Queue<String> queue = new LinkedList<>();
        List<String> listOrdered2 = new ArrayList<String>();



        for (int i =0; i < 10;i++){

            Calendar now = Calendar.getInstance();
            Thread.sleep(1000);
            String actualTime = formatter.format(now.getTime());

            System.out.println(actualTime);


            list.add(actualTime);
            queue.add(actualTime);


            if(queue.size()==5){

                List<String> listOrdered = new ArrayList<String>();

                for(int z = 0; z <5;z++){
                    listOrdered.add(queue.remove());
                }
                listOrdered2 = listOrdered;

            }



        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("for ciklus at the end");
        for (String s : listOrdered2){
            System.out.println(s);
        }
    }

    //identify pic by a line of rgb color value
    @Test
    public void getColorFromImage() throws IOException {
        File file = new File("teemo.png");
        BufferedImage image = ImageIO.read(file);
        int heightValueConst = 100;

        Color color = new Color(image.getRGB(3,3));
        System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());

        for (int widthStartValue = 0; widthStartValue < image.getWidth(); widthStartValue++){

            image.setRGB(widthStartValue,heightValueConst, new Color(255, 255, 255).getRGB());
        }

        File outputfile = new File("saved.png");
        ImageIO.write(image, "png", outputfile);
    }
}
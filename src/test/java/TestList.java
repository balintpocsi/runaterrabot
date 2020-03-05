import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import netscape.javascript.JSObject;

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

        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.RED);

        int heightValueConst = 100;

        Color color = new Color(image.getRGB(3,3));
        System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());

        for (int widthStartValue = 50; widthStartValue < 200; widthStartValue++){

            image.setRGB(widthStartValue,heightValueConst, new Color(255, 255, 255).getRGB());
        }

        //drawing the ed rectangle
        graphics.drawRect(0, 0, 249, 375);
        graphics.dispose();

        File outputfile = new File("saved.png");
        ImageIO.write(image, "png", outputfile);
    }

//    @Test
//    public void readFromJsonMethod() throws IOException {
//        Gson gson = new Gson();
//        JsonElement json = gson.fromJson(new FileReader("C:\\comrunaterra\\set1-en_us.json"), JsonElement.class);
//        String result = gson.toJson(json);
//        System.out.println(result);
//
//    }

    private String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public String readFile(){
        String filePath = "C:\\comrunaterra\\set1-en_us.json";

        return readLineByLineJava8( filePath );
    }

    @Test
    public void readFromJsonMethod2() {
        JSONArray cardArray = new JSONArray(readFile());
//        System.out.println(cardArray.getJSONObject(0).toString());
//        System.out.println(cardArray.getJSONObject(0).get("name").toString());
//        System.out.println(cardArray.getJSONObject(1).toString());
//        System.out.println(cardArray.getJSONObject(1).get("name").toString());

        System.out.println("Size: "+cardArray.length()+"\n");
        for (int i =0;i<cardArray.length();i++){
            System.out.println(cardArray.getJSONObject(i).get("name").toString());
        }


    }
}

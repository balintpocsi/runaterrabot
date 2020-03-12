import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
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

import org.jnativehook.NativeHookException;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import KeyboardService.ReadFromFileService;
import Service.CropImageService;
import Service.MouseListenerService;
import PageObjects.BattlingPage;
import PageObjects.MainMenuPage;
import PageObjects.SelectYourDeckPage;
import PageObjects.StartingHandPage;
import Service.ScreenshotService;
import net.sourceforge.tess4j.TesseractException;

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

        File outputfile = new File("teemo_saved.png");
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
        String filePath = "set1-en_us.json";

        return readLineByLineJava8( filePath );
    }

    private void pressEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Test
    public void readFromJsonMethod2() throws InterruptedException {
        JSONArray cardArray = new JSONArray(readFile());
//        System.out.println(cardArray.getJSONObject(0).toString());
//        System.out.println(cardArray.getJSONObject(0).get("name").toString());
        System.out.println("Size: "+cardArray.length()+"\n");
        Thread.sleep(3000);
        for (int i =0;i<cardArray.length();i++){
            System.out.println(cardArray.getJSONObject(i).get("name").toString());
        }
    }

    @Test
    public void testMouseServiceNavigateToPlayMatch() throws AWTException, InterruptedException {

        MainMenuPage mainMenuPage = new MainMenuPage();
        SelectYourDeckPage selectYourDeckPage = new SelectYourDeckPage();
        StartingHandPage startingHandPage = new StartingHandPage();
        BattlingPage battlingPage = new BattlingPage();

        Thread.sleep(5000);

        mainMenuPage.clickOnPlay();
        Thread.sleep(1000);
        selectYourDeckPage.selectFirstDeck();
        Thread.sleep(1000);
        selectYourDeckPage.confirmPlay();
        Thread.sleep(1000);
        startingHandPage.confirmOkayToHand();
        Thread.sleep(3000);
    }

    public void navigateToPlayFromMainPage() throws AWTException, InterruptedException {
        MainMenuPage mainMenuPage = new MainMenuPage();
        SelectYourDeckPage selectYourDeckPage = new SelectYourDeckPage();
        StartingHandPage startingHandPage = new StartingHandPage();
        BattlingPage battlingPage = new BattlingPage();

        Thread.sleep(5000);

        mainMenuPage.clickOnPlay();
        Thread.sleep(1000);
        selectYourDeckPage.selectFirstDeck();
        Thread.sleep(1000);
        selectYourDeckPage.confirmPlay();
        Thread.sleep(1000);
        startingHandPage.confirmOkayToHand();
        Thread.sleep(3000);
    }

    @Test
    public void checkManaTest() throws AWTException, InterruptedException {
        System.out.println("started");
        Thread.sleep(5000);
        BattlingPage battlingPage = new BattlingPage();
        System.out.println("actual mana: "+battlingPage.checkMyMana());
    }


    @Test
    public void screenShotServiceTest() throws Exception {
        ScreenshotService screenshotService = new ScreenshotService();
        Thread.sleep(4000);
        screenshotService.makeScreenshotVoid(1659, 708, 40, 40);
        System.out.println("done");
    }

     @Test
    public void returnBufferedImageReadItsValueTest() throws Exception {
         //navigateToPlayFromMainPage();
         //--------------------------------------------------------------------------------------------
         ReadValuesFromImageService readValuesFromImageService = new ReadValuesFromImageService();
         ScreenshotService screenshotService = new ScreenshotService();
         Thread.sleep(4000);
         while(true){
             BufferedImage bufferedImage = screenshotService.makeScreenshotReturnBufferedImage(1659, 708, 40, 40);
             String valueFromBufferedImage = readValuesFromImageService.readFromBufferedImage(bufferedImage);
             System.out.println("Number of round: "+valueFromBufferedImage);
             Thread.sleep(800);
         }
     }

    /**
     * Send keyboard strokes based on card names test.
     */
    @Test
    public void writeFromJsonFile() throws AWTException, InterruptedException {
        ReadFromFileService readFromFileService = new ReadFromFileService();
        JSONArray cardArray = new JSONArray(readFile());
        System.out.println("Size: "+cardArray.length()+"\n");
        Thread.sleep(3000);
        String cardname;
        for (int i =0;i<cardArray.length();i++){
            cardname = cardArray.getJSONObject(i).get("name").toString();
            readFromFileService.readFromString(cardname);
            pressEnter();
        }

        //        for(Object obj : cardArray){
        //           JSONObject jsonObject = (JSONObject) obj;
        //            System.out.println(jsonObject.get("name").toString());
        //            readFromFileService.readFromString(jsonObject.get("name").toString());
        //            Thread.sleep(20);
        //            pressEnter();
        //        }
    }

    /**
     * Scan for mouse positions and its rgb values as initialization informations.
     */
     @Test
    public void scanMousePositionAndColor() throws AWTException, InterruptedException {
        RobotService robotService = new RobotService();
         robotService.scanForColorValues();
     }

    /**
     * You can crop an image by giving the rectangle's top left corner as x, y parameter,
     * and the bottom right corner as x2, y2 parameters.
     */
     @Test
    public void cropImageByRectangleTest() throws AWTException, IOException, InterruptedException, NativeHookException {
        ScreenshotService screenshotService = new ScreenshotService();
         System.out.println("Get ready!");
        Thread.sleep(4000);
        screenshotService.cropImageByGivenRectangle(1554, 1105, 1575, 1130);
         System.out.println("Operation ended.");
     }

    /**
     * Run this test for testing the service if it can read out the proper information from the cropped image.
     */
     @Test
    public void readValueAsStringFromImage() throws TesseractException {
         ReadValuesFromImageService readValuesFromImageService = new ReadValuesFromImageService();
         String valueFromImage = readValuesFromImageService.readFromImage("enemy name.png");
         System.out.println(valueFromImage);
    }

    /**
     * Tracking the given number of mouse clicks and its rgb values by the parameter.
     */
    @Test
    public void globalMouseListenerTest() throws NativeHookException, InterruptedException, AWTException {
        MouseListenerService mouseListenerService = new MouseListenerService();
        mouseListenerService.trackingMouseClicksThenPrintPositions(2);
    }

    /**
     * Cropping image by 2 mouseclicks.
     */
    @Test
    public void cropImageServiceTest() throws AWTException, InterruptedException, NativeHookException, IOException {
        CropImageService cropImageService = new CropImageService();
        cropImageService.cropImageByGiven2MouseClicks();
        //nem lehet ismetelni akkor sem ha kulon peldanyokon hivom meg ugyan ezt a (cropImageByGiven2MouseClicks()) metodust
    }

    @Test
    public void readImagesAndStoreUniqueColorId() throws IOException {

        List<Integer> rgbValueUniqueIdList = new ArrayList<>();

        File file = new File("01DE001.png");
        BufferedImage image = ImageIO.read(file);

        int heightValueConst = 400;

        Color color = new Color(image.getRGB(3,3));
        System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());

        for (int widthStartValue = 226; widthStartValue < 453; widthStartValue++){
            rgbValueUniqueIdList.add(image.getRGB(widthStartValue, heightValueConst));
            image.setRGB(widthStartValue,heightValueConst, new Color(255, 255, 255).getRGB());
        }

        System.out.println("Size:");
        System.out.println(rgbValueUniqueIdList.size());

        File outputfile = new File("01DE001_saved2.png");
        ImageIO.write(image, "png", outputfile);

    }

    private List<Color> getUniqueColorListIdFromImage() throws IOException {
        List<Integer> rgbValueUniqueIdList = new ArrayList<>();
        List<Color> colorList = new ArrayList<>();

        File file = new File("teemo.png");
        BufferedImage image = ImageIO.read(file);

        int heightValueConst = 100;
        for (int widthStartValue = 100; widthStartValue < 150; widthStartValue++){
            rgbValueUniqueIdList.add(image.getRGB(widthStartValue, heightValueConst));
            Color color1 = new Color(image.getRGB(widthStartValue, heightValueConst));
            colorList.add(color1);
            image.setRGB(widthStartValue,heightValueConst, new Color(255, 255, 255).getRGB());
        }

        File outputfile = new File("teemo_exp.png");
        ImageIO.write(image, "png", outputfile);
        return colorList;
    }

    @Test
    public void identifyTargetImage1() throws IOException {
        boolean answer = false;
        File targetFileToIdentify = new File("teemo.png");
        List<Color> uniqueColorList = getUniqueColorListIdFromImage();
        BufferedImage targetImageToIdentify = ImageIO.read(targetFileToIdentify);
        System.out.println("list size: "+uniqueColorList.size());
        System.out.println("szelesseg: "+targetImageToIdentify.getWidth());
        System.out.println("magassag: "+targetImageToIdentify.getHeight());
        List<Color> resultColorList = new ArrayList<>();

//        for (int i =0;i<bufferedImage.getHeight();i++){
//            for(int z = 0; z<bufferedImage.getWidth();z++){
//                Color color = new Color(bufferedImage.getRGB(z, i));
//
//
//            }
//
//        }


        for (int z = 0;z<targetImageToIdentify.getWidth()-uniqueColorList.size();z++){
            int magicScore50 = 0;
            boolean isUniqueSequenceFound = false;
            Color color = new Color(targetImageToIdentify.getRGB(z, 100));

            System.out.println(z);
            for (int c = 0; c<uniqueColorList.size();c++){
                System.out.print(c+" ");


                boolean hasPreviousElement = false;

//                if(z != 0 && c != 0){
//                    hasPreviousElement = true;
//                    //System.out.println("boolean: "+uniqueColorList.get(c-1).equals(new Color(bufferedImage.getRGB(z-1,100))));
//                }

                //if (color.equals(uniqueColorList.get(c)) && hasPreviousElement && uniqueColorList.get(c-1).equals(new Color(targetImageToIdentify.getRGB(z-1,100)))){
                    if (color.equals(uniqueColorList.get(c))){
                        System.out.print("X ");
                    resultColorList.add(color);
                } else {
                    //isAstreak = false;
                }
            }
            System.out.println();
            System.out.println();


            if (magicScore50 == 50){
                isUniqueSequenceFound = true;
                System.out.println("found it");
                System.out.println("magic row: "+z);
            }
            answer = isUniqueSequenceFound;

        }

        System.out.println("final boolean: "+answer);
        //ImageIdentifyService imageIdentifyService = new ImageIdentifyService(file, );
    }

    private boolean identifyCardByRow(int whichNumberOfRow) throws IOException {
        List<Color> colorRowFromImage = getColorRowFromImage(whichNumberOfRow); //100. row from image
        List<Color> uniqueColorList = getUniqueColorListIdFromImage(); //   size: 50 Teemo's unique color list ID
        List<Color> resultList = new ArrayList<>();
        List<Integer> startCoordsList = new ArrayList<>();

        for (int i = 0; i < colorRowFromImage.size()-uniqueColorList.size();i++){
            if(colorRowFromImage.get(i).equals(uniqueColorList.get(0))){
                startCoordsList.add(i);
            }
        }

        for(int i = 0;i<startCoordsList.size();i++){
            int startIndex = startCoordsList.get(i); //100
            System.out.println("current index:"+i);
            System.out.println("start index: "+startIndex);
            for (int z = 0;z<50;z++){
                if(uniqueColorList.get(z).equals(colorRowFromImage.get(startIndex+z))){
                    resultList.add(colorRowFromImage.get(startIndex+z));
                }else{
                    resultList.clear();
                    break;
                }
            }
        }

        System.out.println("coords:");
        for (Integer integer : startCoordsList){
            System.out.println(integer);
        }

        System.out.println("Result:");
        System.out.println(uniqueColorList.toString());
        System.out.println(resultList.toString());

        return uniqueColorList.equals(resultList);
    }


    /**
     * Working identify image.
     */
    @Test
    public void identifyTargetImage2() throws IOException {

        List<Color> colorRowFromImage = getColorRowFromImage(100); //100. row from image
        List<Color> uniqueColorList = getUniqueColorListIdFromImage(); //   size: 50
        List<Color> resultList = new ArrayList<>();
        List<Integer> startCoordsList = new ArrayList<>();

       for (int i = 0; i < colorRowFromImage.size()-uniqueColorList.size();i++){
            if(colorRowFromImage.get(i).equals(uniqueColorList.get(0))){
                startCoordsList.add(i);
            }
       }

       for(int i = 0;i<startCoordsList.size();i++){
           int startIndex = startCoordsList.get(i); //100
           System.out.println("current index:"+i);
           System.out.println("start index: "+startIndex);
           for (int z = 0;z<50;z++){
               if(uniqueColorList.get(z).equals(colorRowFromImage.get(startIndex+z))){
                   resultList.add(colorRowFromImage.get(startIndex+z));
               }else{
                   resultList.clear();
                   break;
               }
           }
       }

        System.out.println("coords:");
       for (Integer integer : startCoordsList){
           System.out.println(integer);
        }

        System.out.println("Result:");
        System.out.println(uniqueColorList.toString());
        System.out.println(resultList.toString());
        Assert.assertEquals(uniqueColorList, resultList);

    }

    private List<Color> getColorRowFromImage(int rowIndex) throws IOException {
        List<Color> rowColorFromImage = new ArrayList<>();
        File image = new File("teemo.png");
        BufferedImage targetImageToIdentify = ImageIO.read(image);

        for (int i = 0; i < targetImageToIdentify.getWidth();i++){
            Color color = new Color(targetImageToIdentify.getRGB(i, rowIndex));
            rowColorFromImage.add(color);
        }
        return rowColorFromImage;
    }


    @Test
    public void identifyByRowTest() throws IOException {
        //250 width
        //376 height
        for(int i = 0;i<376;i++){
            if(identifyCardByRow(i)){
                System.out.println("got it: "+i);
                break;
            }
        }
        System.out.println("Exiting...");
    }
}

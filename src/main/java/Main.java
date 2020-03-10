import java.awt.Color;
import java.util.List;

import MouseListener.MainMouseListenerService;

public class Main {

    public static void main(String[] args) throws Exception {

        final Color RED = new Color(237,27,36);
        final Color VIOLET = new Color(163, 73, 164);
        final Color GREEN = new Color(34, 177, 76);
        final Color BLUE = new Color(0, 162, 232);
        List<Color> list;

        RobotService robotService = new RobotService();
        ReadValuesFromImageService readValuesFromImageService = new ReadValuesFromImageService();
        MainMouseListenerService mainMouseListenerService = new MainMouseListenerService();
//
        //WORKING - Read value from image = 2 and 4
       System.out.println(readValuesFromImageService.readFromImage("2020-03-10 12 18 18_screenshot.png"));
        System.out.println(readValuesFromImageService.readFromImage("2020-03-06 05 26 47_screenshot.png"));

       //mainMouseListenerService.trackingMouseClicksThenPrintPositions();

        //System.out.println(readValuesFromImageService.readFromImage("C:\\screenshots\\2020-03-06 05 26 47_screenshot.png"));

//
//        ScreenshotService screenshotService = new ScreenshotService();
//
//        list=screenshotService.getUniqueSequenceFromPicture(screenshotService.getBufferedImageByStaticCoordinates());
//        screenshotService.drawUniqueSequenceOfColorsToWhiteFlatBoard(list);
        //screenshotService.cachedScreenshots();    //nem mukodik
        //screenshotService.makeScreenshotInfinitely();

        //robotService.scanForColorValues();

        //screenshotService.makeScreenshotInfinitely(0, 0, 250,376);

        //robotService.printSomethingIfFoundColorAtGivenPosition(255,255,255);

        //robotService.loopUntilGivenRGBVaueIsFound(35, 177, 77);
        //robotService.loopUntilGivenRGBVaueIsFound(RED);

//        robotService.loopOfGetColorValue(RED);
//        robotService.loopOfGetColorValue(VIOLET);
//        robotService.loopOfGetColorValue(GREEN);
//        robotService.loopOfGetColorValue(BLUE);

        //robotService.loopOfGetColorValue(2086, 238, RED);

    }
}

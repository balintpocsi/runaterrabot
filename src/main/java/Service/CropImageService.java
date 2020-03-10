package Service;

import java.awt.AWTException;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class CropImageService implements NativeMouseInputListener {

    //why static is needed here?
    private static List<String> mouseClickedDatas;
    private static List<Integer> cropImageCoords;
    private ScreenshotService screenshotService;
    private RobotService robotService;

    public CropImageService() throws AWTException {
        turnOffMouseEventLogging();
        screenshotService = new ScreenshotService();
        mouseClickedDatas = new ArrayList<>();
        cropImageCoords = new ArrayList<>();
        robotService = new RobotService();
    }

    public List<String> getMouseClickedDatas() {
        return mouseClickedDatas;
    }

    private void turnOffMouseEventLogging(){
        LogManager.getLogManager().reset();
        // Get the logger for "org.jnativehook" and set the level to off.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }

    public void nativeMouseClicked(NativeMouseEvent e) {
        int[] array = new int[2];
        String[] coordinatesStringArray =  (e.getX()+" "+e.getY()).split(" ");
        array[0] = Integer.parseInt(coordinatesStringArray[0]);
        array[1] = Integer.parseInt(coordinatesStringArray[1]);
        cropImageCoords.add(Integer.parseInt(coordinatesStringArray[0]));
        cropImageCoords.add(Integer.parseInt(coordinatesStringArray[1]));
        System.out.println("Mouse clicked at position: "+e.getX() + ", " + e.getY());
        Color color = robotService.getColorValuesOfGivenPosition(array);
        System.out.println("RGB value: "+color.getRGB());
        System.out.println("("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+")");
        mouseClickedDatas.add(e.getX()+" "+e.getY());
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        //System.out.println("Mouse Pressed: " + e.getButton());
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        //System.out.println("Mouse Released: " + e.getButton());
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }

    private boolean checkNumberOfClicks(int numberOfMouseClicksToTrack){
        return mouseClickedDatas.size() < numberOfMouseClicksToTrack;
    }

    public void cropImageByGiven2MouseClicks() throws InterruptedException, NativeHookException, AWTException, IOException {
        int numberOfMouseClicksToTrack = 2;
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // Construct the example object.
        CropImageService cropImageService = new CropImageService();

        // Add the appropriate listeners
        GlobalScreen.addNativeMouseListener(cropImageService);
        while(checkNumberOfClicks(numberOfMouseClicksToTrack)){
            System.out.println("list actual size: "+getMouseClickedDatas().size());
            Thread.sleep(700);
        }

        GlobalScreen.unregisterNativeHook();

        System.out.println("Initialization ended.");
        System.out.println("List size: "+getMouseClickedDatas().size());
        System.out.println("Coordinates:");
        for (String s : getMouseClickedDatas()){
            System.out.println(s);
        }

        if((cropImageCoords.get(2) - cropImageCoords.get(0)) <= 0 || (cropImageCoords.get(3) - cropImageCoords.get(1)) <= 0){
            System.out.println("Invalid rectangle!");
        }else {
            System.out.println("Cropping image...");
            screenshotService.cropImageByGivenRectangle(cropImageCoords.get(0), cropImageCoords.get(1), cropImageCoords.get(2), cropImageCoords.get(3));
            Thread.sleep(3000);
            System.out.println("Operation ended.");
        }
    }
}

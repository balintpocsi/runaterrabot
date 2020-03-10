package Service;

import java.awt.AWTException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class MouseListenerService implements NativeMouseInputListener {

    //why static is needed here?
    private static List<String> mouseClickedDatas;
    private RobotService robotService;

    public MouseListenerService() throws AWTException {
        turnOffMouseEventLogging();
        mouseClickedDatas = new ArrayList<>();
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

    public void trackingMouseClicksThenPrintPositions(int numberOfMouseClicksToTrack) throws InterruptedException, NativeHookException, AWTException {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // Construct the example object.
        MouseListenerService mouseListenerService = new MouseListenerService();

        // Add the appropriate listeners
        GlobalScreen.addNativeMouseListener(mouseListenerService);
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
    }
}
package MouseListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class MainMouseListenerService2 implements NativeMouseInputListener {

    private static List<String> mouseClickedDatas;

    public MainMouseListenerService2() {
        mouseClickedDatas = new ArrayList<>();
        LogManager.getLogManager().reset();

        // Get the logger for "org.jnativehook" and set the level to off.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }

    public static List<String> getMouseClickedDatas() {
        return mouseClickedDatas;
    }

    public void nativeMouseClicked(NativeMouseEvent e) {
        //System.out.println("Mouse Clicked: " + e.getClickCount());
        System.out.println("Mouse clicked at position: "+e.getX() + ", " + e.getY());
        mouseClickedDatas.add(e.getX()+" "+e.getY());
        //return checkListSize();
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

    private static boolean checkListSize(){
        return mouseClickedDatas.size() < 3;
    }

    public void trackingMouseClicksThenPrintPositions() throws InterruptedException, NativeHookException {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // Construct the example object.
        MainMouseListenerService mainMouseListenerService = new MainMouseListenerService();

        // Add the appropriate listeners.
        //GlobalScreen.addNativeMouseListener(mouseListenerService);

        GlobalScreen.addNativeMouseListener(mainMouseListenerService);
        while(checkListSize()){
            System.out.println("list actual size: "+getMouseClickedDatas().size());
            Thread.sleep(1000);
        }

        GlobalScreen.unregisterNativeHook();

        System.out.println("Initialization ended.");
        System.out.println("List size: "+getMouseClickedDatas().size());
        System.out.println("Coordinates:");
        for (String s : getMouseClickedDatas()){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws NativeHookException, InterruptedException {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        // Construct the example object.
        MainMouseListenerService2 mainMouseListenerService = new MainMouseListenerService2();

        // Add the appropriate listeners.
        //GlobalScreen.addNativeMouseListener(mouseListenerService);

        GlobalScreen.addNativeMouseListener(mainMouseListenerService);
        while(checkListSize()){
            System.out.println("list actual size: "+getMouseClickedDatas().size());
            Thread.sleep(2000);
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

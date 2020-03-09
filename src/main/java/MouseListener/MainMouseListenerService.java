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

public class MainMouseListenerService implements NativeMouseInputListener {

private static List<String> mouseClickedDatas;

    public MainMouseListenerService() {
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
        System.out.println("Mouse Clicked: " + e.getClickCount());
        System.out.println("At position: "+e.getX() + ", " + e.getY());
        mouseClickedDatas.add(e.getX()+" "+e.getY());
        //return checkListSize();
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        System.out.println("Mouse Pressed: " + e.getButton());
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        System.out.println("Mouse Released: " + e.getButton());
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
    }

    public void nativeMouseDragged(NativeMouseEvent e) {
        System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
    }

    private static boolean checkListSize(){
        if(mouseClickedDatas.size()<3){
            return true;
        } else {
            return false;
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
        MainMouseListenerService mainMouseListenerService = new MainMouseListenerService();

        // Add the appropriate listeners.
        //GlobalScreen.addNativeMouseListener(mouseListenerService);

        System.out.println(checkListSize());
        System.out.println(getMouseClickedDatas().size());
        while(checkListSize()){
            System.out.println("list actual size: "+getMouseClickedDatas().size());
            GlobalScreen.addNativeMouseListener(mainMouseListenerService);
            Thread.sleep(3000);
        }
        System.out.println("vege");
        System.out.println("Size: "+getMouseClickedDatas().size());
        for (String s : getMouseClickedDatas()){
            System.out.println(s);
        }
        GlobalScreen.unregisterNativeHook();
    }
}

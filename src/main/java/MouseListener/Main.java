package MouseListener;

import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;

public class Main {
    public static void main(String[] args) throws NativeHookException, InterruptedException, AWTException {
//        LogManager.getLogManager().reset();
//
//        // Get the logger for "org.jnativehook" and set the level to off.
//        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
//        logger.setLevel(Level.OFF);
//        ManageService service = new ManageService();
//        NativeMouseEvent mouseEvent = new NativeMouseEvent(20, 30L,10,9,8,7);
//        GlobalScreen.registerNativeHook();
//        GlobalScreen.addNativeKeyListener(service.getKeyboard());
//        //service.getKeyboard().nativeMouseClicked(mouseEvent);

        MainMouseListenerService mainMouseListenerService = new MainMouseListenerService();
        mainMouseListenerService.trackingMouseClicksThenPrintPositions();

    }
}

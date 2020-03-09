package MouseListener;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class NativeKeyboard implements NativeKeyListener, NativeMouseListener {

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {

        System.out.println("hello clicked nativemouseclicked");
        System.out.println(nativeMouseEvent.getPoint());
        System.out.println(nativeMouseEvent.getX());
        System.out.println(nativeMouseEvent.getY());
        System.out.println(nativeMouseEvent.getPoint().x+" "+nativeMouseEvent.getPoint().y);

    }

    @Override public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {

    }

    @Override public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {

    }
}

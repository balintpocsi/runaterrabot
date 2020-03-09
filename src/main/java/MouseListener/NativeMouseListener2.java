package MouseListener;

import java.util.EventListener;

import org.jnativehook.mouse.NativeMouseEvent;

public interface NativeMouseListener2 extends EventListener {
    boolean nativeMouseClicked(NativeMouseEvent var1);

    void nativeMousePressed(NativeMouseEvent var1);

    void nativeMouseReleased(NativeMouseEvent var1);
}

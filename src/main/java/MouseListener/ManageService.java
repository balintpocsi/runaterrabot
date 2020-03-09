package MouseListener;

public class ManageService {
    private NativeKeyboard keyboard;

    public ManageService() {
        keyboard = new NativeKeyboard();
    }

    public NativeKeyboard getKeyboard() {
        return keyboard;
    }
}

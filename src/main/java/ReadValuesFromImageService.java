import java.awt.image.BufferedImage;
import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadValuesFromImageService {

    private Tesseract tesseract;

    public ReadValuesFromImageService() {
        this.tesseract = new Tesseract();
        tesseract.setDatapath("tessdata");
    }

    public String readFromImage(String path) throws TesseractException {
        return tesseract.doOCR(new File(path));
    }

    public String readFromBufferedImage(BufferedImage bufferedImage) throws TesseractException {
        return tesseract.doOCR(bufferedImage);
    }
}

package Service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageIdentifyService {

    private BufferedImage bufferedImage;
    private List<Color> colorList;
    private File file;

    public ImageIdentifyService(BufferedImage bufferedImage, List<Color> colorList) {
        this.bufferedImage = bufferedImage;
        this.colorList = colorList;
    }

    public ImageIdentifyService(File image, List<Color> colorList) {
        this.file = image;
        this.colorList = colorList;
    }

    public void findTargetColorSequenceInPicture(){
        bufferedImage.getHeight();
    }
}

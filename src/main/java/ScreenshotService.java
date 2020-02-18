import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.imageio.ImageIO;

public class ScreenshotService {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
    private Robot robot;
    private List<BufferedImage> imageList;

    public ScreenshotService() throws AWTException {
        this.robot = new Robot();
        this.imageList = new ArrayList<BufferedImage>();
    }

    public BufferedImage makeScreenshotReturnImage() throws Exception {
        //Rectangle rect = new Rectangle(0, 0, 800, 800);
        Calendar now = Calendar.getInstance();
        //BufferedImage screenShot = robot.createScreenCapture(rect);
//        ImageIO.write(screenShot, "png", new File("C:\\screenshots\\"+formatter.format(now.getTime())+"_screenshot.png"));
//        System.out.println(formatter.format(now.getTime())+"_screenshot.png"+" created.");
        return robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }

    public void makeScreenshotVoid(int x, int y, int width, int height) throws Exception {
        Rectangle rect = new Rectangle(x, y, width, height);
        Calendar now = Calendar.getInstance();
        //BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        BufferedImage screenShot = robot.createScreenCapture(rect);
        ImageIO.write(screenShot, "png", new File("C:\\screenshots\\"+formatter.format(now.getTime())+"_screenshot.png"));
        System.out.println(formatter.format(now.getTime())+"_screenshot.png"+" created.");
    }

    public void makeScreenshotInfinitely(int x, int y, int width, int height) throws Exception {
        while(true){
            Thread.sleep(3000);

            makeScreenshotVoid(x,y,width,height);
        }
    }

    //nem mukodik
    public void cachedScreenshots() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
        Queue<BufferedImage> queue = new LinkedList<>();
        List<BufferedImage> listOrdered2 = new ArrayList<BufferedImage>();

        for (int i =0; i < 10;i++){
            Thread.sleep(3000);
            queue.add(makeScreenshotReturnImage());

            if(queue.size()==5){
                List<BufferedImage> listOrdered = new ArrayList<BufferedImage>();
                for(int z = 0; z <5;z++){
                    listOrdered.add(queue.remove());
                }
                listOrdered2.clear();
                listOrdered2 = listOrdered;
            }
        }

        System.out.println("size: "+listOrdered2.size());
        for (BufferedImage screenShot : listOrdered2){
            Calendar now = Calendar.getInstance();
            ImageIO.write(screenShot, "png", new File("C:\\screenshots\\"+formatter.format(now.getTime())+"_screenshot.png"));
            System.out.println(formatter.format(now.getTime())+"_screenshot.png"+" created.");
        }
    }


}

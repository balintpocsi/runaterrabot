package Service;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    public void fullScreenshot() throws Exception {
        Calendar now = Calendar.getInstance();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "png", new File("C:\\screenshots\\"+formatter.format(now.getTime())+"_screenshot.png"));
        System.out.println(formatter.format(now.getTime())+"_screenshot.png"+" created.");
    }

    public void makeScreenshotVoid(int x, int y, int width, int height) throws Exception {
        Rectangle rect = new Rectangle(x, y, width, height);
        Calendar now = Calendar.getInstance();
        //BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        BufferedImage screenShot = robot.createScreenCapture(rect);
        ImageIO.write(screenShot, "png", new File("C:\\screenshot\\"+formatter.format(now.getTime())+"_screenshot.png"));
        System.out.println(formatter.format(now.getTime())+"_screenshot.png"+" created.");
    }

    public void makeIdentifyScreenshots() throws Exception {
        Rectangle rect = new Rectangle(559, 127, 290, 267);
        Calendar now = Calendar.getInstance();
        //BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        BufferedImage screenShot = robot.createScreenCapture(rect);
        ImageIO.write(screenShot, "png", new File("C:\\screenshot\\"+formatter.format(now.getTime())+"_screenshot.png"));
        System.out.println(formatter.format(now.getTime())+"_screenshot.png"+" created.");
    }

    public BufferedImage makeIdentifyScreenshotsReturnBufferedImage() throws Exception {
        Rectangle rect = new Rectangle(559, 127, 290, 267);
        Calendar now = Calendar.getInstance();
        //BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        BufferedImage screenShot = robot.createScreenCapture(rect);
        return screenShot;
    }

    public BufferedImage makeScreenshotReturnBufferedImage(int x, int y, int width, int height) throws Exception {
        Rectangle rect = new Rectangle(x, y, width, height);
        Calendar now = Calendar.getInstance();
        //BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        return robot.createScreenCapture(rect);
    }

    //mocked
    public BufferedImage getBufferedImageByStaticCoordinates() throws IOException {
        int x = 0;
        int y =0;
        int width = 249;
        int height =375;
        Rectangle rect = new Rectangle(x, y, width, height);
        //return robot.createScreenCapture(rect);

        //mocked
        File file = new File("teemo.png");
        BufferedImage image = ImageIO.read(file);
        //mocked

        return image;
    }

    public List<Color> getUniqueSequenceFromPicture(BufferedImage image){
        List<Color> colorList = new ArrayList<>();
        int heightValueConst = 100;

        Color color = new Color(image.getRGB(3,3));
        System.out.println(color.getRed()+" "+color.getGreen()+" "+color.getBlue());

        for (int widthStartValue = 50; widthStartValue < 200; widthStartValue++){
            colorList.add(new Color(image.getRGB(widthStartValue, heightValueConst)));
        }

        System.out.println("must be 150 element");
        System.out.println(colorList.size());
        for(Color c : colorList){
            System.out.println(c.getRGB());
        }
        return colorList;
    }

    public void drawUniqueSequenceOfColorsToWhiteFlatBoard(List<Color> list) throws IOException {
        int heightValueConst = 100;
        File outputfile = new File("white.png");
        BufferedImage image = ImageIO.read(outputfile);
        for (int i = 0; i < 150; i++){
            image.setRGB(i+50,heightValueConst, list.get(i).getRGB());
        }


        ImageIO.write(image, "png", outputfile);
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

    public void cropImageByGivenRectangle(int x, int y, int x2, int y2) throws IOException {
            Rectangle rect = new Rectangle(x, y, (x2 - x), (y2 - y));
            Calendar now = Calendar.getInstance();
            //BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            BufferedImage screenShot = robot.createScreenCapture(rect);
            ImageIO.write(screenShot, "png", new File("C:\\screenshots\\" + formatter.format(now.getTime()) + "_screenshot.png"));
            System.out.println(formatter.format(now.getTime()) + "_screenshot.png" + " created.");
    }
}

package Service;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageIdentifyService {

    private BufferedImage bufferedImage;
    private List<Color> colorList;
    private File file;

    public ImageIdentifyService() {
    }

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

    public Map<String, BufferedImage> readRefCardsFromFolder(final File folder) throws IOException {
        Map<String, BufferedImage> cardNameWithBufferedImageMap = new HashMap<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                readRefCardsFromFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                File file = new File("cardReferences/"+fileEntry.getName());
                BufferedImage referenceImage = ImageIO.read(file);
                System.out.println(referenceImage.getWidth()+" "+referenceImage.getHeight());
                cardNameWithBufferedImageMap.put(fileEntry.getName(), referenceImage);
            }
        }
        return cardNameWithBufferedImageMap;
    }

    private List<Color> getUniqueColorListIdFromImage(File file) throws IOException {
        List<Color> colorList = new ArrayList<>();
        BufferedImage image = ImageIO.read(file);

        int heightValueConst = image.getHeight()/2; //170 width , 75 height
        int startingPosition = image.getWidth()/4;

        for (int widthStartValue = startingPosition; widthStartValue < startingPosition*3; widthStartValue++){
            Color color1 = new Color(image.getRGB(widthStartValue, heightValueConst));
            colorList.add(color1);
        }
        return colorList;
    }

    private List<Color> getUniqueColorListIdFromImage(BufferedImage image) throws IOException {
        List<Color> colorList = new ArrayList<>();
        int heightValueConst = image.getHeight()/2; //170 width , 75 height
        int startingPosition = (image.getWidth()/4)*2;

        for (int widthStartValue = startingPosition; widthStartValue < startingPosition+20; widthStartValue++){
            Color color1 = new Color(image.getRGB(widthStartValue, heightValueConst));
            colorList.add(color1);
        }
        return colorList;
    }

    /**
     * Get the List<Color> from the given row by the rowIndex param.
     */
    private List<Color> getColorRowFromImage(int rowIndex, BufferedImage targetImageToIdentify) throws IOException {
        List<Color> rowColorFromImage = new ArrayList<>();

        for (int i = 0; i < targetImageToIdentify.getWidth();i++){
            Color color = new Color(targetImageToIdentify.getRGB(i, rowIndex));
            rowColorFromImage.add(color);
        }
        return rowColorFromImage;  //returns for example the List<Color> of the 100. row.
    }

    private boolean identifyCardByRow(int rowIndex, List<Color> uniqueColorList, BufferedImage referenceCardImage) throws IOException {
        List<Color> colorRowFromImage = getColorRowFromImage(rowIndex, referenceCardImage); //100. row from image
        List<Color> resultList = new ArrayList<>();
        List<Integer> startCoordsList = new ArrayList<>();

        for (int i = 0; i < colorRowFromImage.size()-uniqueColorList.size();i++){
            if(colorRowFromImage.get(i).equals(uniqueColorList.get(0))){
                startCoordsList.add(i);
            }
        }

        for(int i = 0;i<startCoordsList.size();i++){
            int startIndex = startCoordsList.get(i); //100
            System.out.println("current index:"+i);
            System.out.println("start index: "+startIndex);
            for (int z = 0;z<uniqueColorList.size();z++){     //z < 50 (uniqueColorList.size())
                if(uniqueColorList.get(z).equals(colorRowFromImage.get(startIndex+z))){
                    resultList.add(colorRowFromImage.get(startIndex+z));
                }else{
                    resultList.clear();
                    break;
                }
            }

            if(resultList.size()==uniqueColorList.size()){
                break;
            }
        }

        System.out.println("Result:");
        System.out.println(uniqueColorList.toString());
        System.out.println(resultList.toString());

        return uniqueColorList.equals(resultList);
    }

    public void readRefCardsFromFolder() throws IOException {
        final File folder = new File("cardReferences");
        Map<String, BufferedImage> referenceCardNameWithBufferedImageMap = readRefCardsFromFolder(folder);

        for (String key : referenceCardNameWithBufferedImageMap.keySet()){
            System.out.println(key);
        }
    }


    //MAIN
    /**
     * Compare method<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<.
     */
    public String compareCardColorUniqueListWithCardReferenceDataFolder(BufferedImage imageToIdentify) throws IOException, InterruptedException {
        String name = "undefined";
        final File folder = new File("cardReferences");
        Map<String, BufferedImage> referenceCardNameWithBufferedImageMap = readRefCardsFromFolder(folder); //ref cards
        List<Color> uniqueColorList = getUniqueColorListIdFromImage(imageToIdentify); //ezt hasonlitom ossze (egy egyetlen 1 sorbol valamennyi(X), egymas mellett levő pixel color-ja)

        for (String cardName : referenceCardNameWithBufferedImageMap.keySet()){

            BufferedImage referenceCardImage = referenceCardNameWithBufferedImageMap.get(cardName); //ezzel hasonlitom ossze

            if(compareBufferedImages(uniqueColorList, referenceCardImage, cardName)){
                System.out.println("GOT IT (compareCardColorUniqueListWithCardReferenceDataFolder)"+cardName);
                name = cardName;
                break;
            }
        }
        return name;
    }

    private boolean compareBufferedImages(List<Color> uniqueColorList, BufferedImage referenceCardImage, String cardName) throws IOException {
        boolean weFoundIt = false;
        for(int rowIndex = 0;rowIndex<referenceCardImage.getHeight();rowIndex++){                       //magic number should be removed!!!!
            if(identifyCardByRow(rowIndex, uniqueColorList, referenceCardImage)){              //getColorRowFromImage() method-ban van definialva hogy melyik image-el hasonlitja ossze
                System.out.println("got it: "+rowIndex);
                System.out.println("It is the "+cardName);
                weFoundIt = true;
                break;
            }
        }
        return weFoundIt;
    }
}

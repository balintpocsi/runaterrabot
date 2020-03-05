package KeyboardService;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ReadFromFileService {

    private StringBuffer stringBuffer = new StringBuffer();
    private KeyboardService keyboardService = new KeyboardService();
    public ReadFromFileService() {
    }

    public void readFromFile(String path) throws InterruptedException, AWTException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                path));
            String line = reader.readLine();
            while (line != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileData = stringBuffer.toString();
        System.out.println(fileData);
        fileData = fileData.toLowerCase();
        char[] rawStringArray = fileData.toCharArray();

        Thread.sleep(3000);
        for (char ch : rawStringArray){
            String chToString = Character.toString(ch);
            keyboardService.printChar(chToString);
            Thread.sleep(50);
        }
    }
}

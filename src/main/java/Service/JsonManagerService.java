package Service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonManagerService {


    public JsonManagerService() {
    }


    private String readFile(){
        String filePath = "set1-en_us.json";

        return readLineByLineJava8( filePath );
    }

    private String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public JSONObject returnJsonObjectByCardName(String cardName) throws InterruptedException {
        JSONArray cardArray = new JSONArray(readFile());
        JSONObject cardObject = null;
//        System.out.println(cardArray.getJSONObject(0).toString());
//        System.out.println(cardArray.getJSONObject(0).get("name").toString());
        System.out.println("Size: "+cardArray.length()+"\n");
        Thread.sleep(3000);
        for (int i =0;i<cardArray.length();i++){
            if(cardArray.getJSONObject(i).get("name").toString().equals(cardName)){
                cardObject = cardArray.getJSONObject(i);
                break;
            }
        }
        return cardObject;
    }
}

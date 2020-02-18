import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//nem mukodik
public class CachedMemory {

    public void listTestMethod() throws InterruptedException {
        List<String> list = new ArrayList<String>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
        Queue<String> queue = new LinkedList<>();
        List<String> listOrdered2 = new ArrayList<String>();



        for (int i =0; i < 10;i++){

            Calendar now = Calendar.getInstance();
            Thread.sleep(1000);
            String actualTime = formatter.format(now.getTime());

            System.out.println(actualTime);


            list.add(actualTime);
            queue.add(actualTime);


            if(queue.size()==5){

                List<String> listOrdered = new ArrayList<String>();

                for(int z = 0; z <5;z++){
                    listOrdered.add(queue.remove());
                }
                listOrdered2 = listOrdered;

            }



        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("for ciklus at the end");
        for (String s : listOrdered2){
            System.out.println(s);
        }
    }
}

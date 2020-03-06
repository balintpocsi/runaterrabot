package PageObjects;

import java.awt.AWTException;

import Service.MouseService;

public class BattlingPage {

    MouseService mouseService;
    RobotService robotService;
    boolean isfound;

    public BattlingPage() throws AWTException {
        mouseService = new MouseService();
        robotService = new RobotService();
    }

    public int checkMyMana(){
        int mana = 0;

        mana = robotService.checkManaService(mana,1722, 724, 78, 126, 255);
        mana =  robotService.checkManaService(mana, 1740, 726, 74, 119, 255);
        mana = robotService.checkManaService(mana,1761, 722, 77, 124, 255);
        mana = robotService.checkManaService(mana,1779, 716, 76, 122, 255);
        mana = robotService.checkManaService(mana,1795, 707, 76, 122, 255);


        return mana;
    }

    private int incrementMana(boolean found, int mana){
        if(!found){
            mana = mana +1;
        }
        return mana;
    }

    public int checkMySpellMana(){
        return 0;
    }
}

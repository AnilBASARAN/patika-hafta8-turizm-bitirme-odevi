package Turizm.view;
import Turizm.core.Config;

import javax.swing.*;

public abstract class Layout extends JFrame {
    public void setGUILayout(int width,int height){
        setSize(width,height);
        setLocationRelativeTo(null);
        //setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        //setResizable(false);
        setVisible(true);
    }


}

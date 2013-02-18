/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package umayr.apps.mobilism;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 *
 * @author Administrator
 */
public class SplashScreen extends Canvas{
    Image imgSplash = null;
             public SplashScreen(){
            	 
            	 
            	 
    }

    protected void paint(Graphics g) {
           
            
            int width = getWidth();
            int height = getHeight();
            setFullScreenMode(true);
            showMessage("Width: "+ width);
            showMessage("Width: "+ height);
        
        try {
             imgSplash = Image.createImage("/splash.jpg");
             g.drawImage(imgSplash, 0, 0, Graphics.TOP | Graphics.LEFT);
             waitForTime();
        }   catch (IOException ex) {
            ex.printStackTrace();
        }
            
             
        
    }
    public void showMessage(String message){
        
        System.out.println("Message: " + message);
        
    }

    private void waitForTime() {
          
            new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(4000);
                    
                    // call MainMenu
                    //MainMenu objMainMenu = new MainMenu();
                    FormMainSearch objMainMenu = new FormMainSearch();
                    objMainMenu.show();
                    
                    
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            }
        }).start();
        
    }
}

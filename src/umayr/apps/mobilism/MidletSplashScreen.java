/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package umayr.apps.mobilism;

import com.sun.lwuit.Display;
import javax.microedition.midlet.MIDlet;




/**
 * @author faraz_lbs
 */
public class MidletSplashScreen extends MIDlet {
javax.microedition.lcdui.Display display = null;
    public void startApp() {
        
        Display.init(this);
        display  =  javax.microedition.lcdui.Display.getDisplay(this);
        SplashScreen objSplashScreen = new  SplashScreen();
        Static.Midlet = this;
        display.setCurrent(objSplashScreen);
       
        
        
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
        
        notifyDestroyed();
    }
}

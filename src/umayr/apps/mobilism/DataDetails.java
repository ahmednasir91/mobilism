package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class DataDetails {

	
	String USB=null;
	String WAN=null;
	String Bluetooth=null;
	String Speed=null;
	String EDGE=null;
	String GPRS=null;
	public DataDetails(JSONObject object) {

	try {
		this.Bluetooth = object.getString("Bluetooth");
		this.USB= object.getString("USB");
		this.WAN = object.getString("WAN");
		this.Speed= object.getString("Speed");
		this.EDGE= object.getString("EDGE");
		this.GPRS= object.getString("GPRS");
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	/**
	 * @return the uSB
	 */
	public String getUSB() {
		return USB;
	}
	/**
	 * @param uSB the uSB to set
	 */
	public void setUSB(String uSB) {
		USB = uSB;
	}
	/**
	 * @return the wAN
	 */
	public String getWAN() {
		return WAN;
	}
	/**
	 * @param wAN the wAN to set
	 */
	public void setWAN(String wAN) {
		WAN = wAN;
	}
	/**
	 * @return the bluetooth
	 */
	public String getBluetooth() {
		return Bluetooth;
	}
	/**
	 * @param bluetooth the bluetooth to set
	 */
	public void setBluetooth(String bluetooth) {
		Bluetooth = bluetooth;
	}
	/**
	 * @return the speed
	 */
	public String getSpeed() {
		return Speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(String speed) {
		Speed = speed;
	}
	/**
	 * @return the eDGE
	 */
	public String getEDGE() {
		return EDGE;
	}
	/**
	 * @param eDGE the eDGE to set
	 */
	public void setEDGE(String eDGE) {
		EDGE = eDGE;
	}
	/**
	 * @return the gPRS
	 */
	public String getGPRS() {
		return GPRS;
	}
	/**
	 * @param gPRS the gPRS to set
	 */
	public void setGPRS(String gPRS) {
		GPRS = gPRS;
	}
	
}

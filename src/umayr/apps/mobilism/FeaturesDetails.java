package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class FeaturesDetails {

	String Colors = null;
	String Java = null;
	String Radio = null;
	String GPS = null;
	String Browser = null;
	String Messaging = null;
	String Sensors = null;
	String GPU = null;
	String CPU = null;
	String OS = null;

	public FeaturesDetails(JSONObject Object) {

		try {
			this.Colors = Object.getString("Colors");
			this.Java = Object.getString("Java");
			this.Radio = Object.getString("Radio");
			this.GPS = Object.getString("GPS");
			this.Browser = Object.getString("Browser");
			this.Messaging = Object.getString("Messaging");
			this.Sensors = Object.getString("Sensors");
			this.GPU = Object.getString("GPU");
			this.CPU = Object.getString("CPU");
			this.OS = Object.getString("OS");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the colors
	 */
	public String getColors() {
		return Colors;
	}

	/**
	 * @param colors
	 *            the colors to set
	 */
	public void setColors(String colors) {
		Colors = colors;
	}

	/**
	 * @return the java
	 */
	public String getJava() {
		return Java;
	}

	/**
	 * @param java
	 *            the java to set
	 */
	public void setJava(String java) {
		Java = java;
	}

	/**
	 * @return the radio
	 */
	public String getRadio() {
		return Radio;
	}

	/**
	 * @param radio
	 *            the radio to set
	 */
	public void setRadio(String radio) {
		Radio = radio;
	}

	/**
	 * @return the gPS
	 */
	public String getGPS() {
		return GPS;
	}

	/**
	 * @param gPS
	 *            the gPS to set
	 */
	public void setGPS(String gPS) {
		GPS = gPS;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return Browser;
	}

	/**
	 * @param browser
	 *            the browser to set
	 */
	public void setBrowser(String browser) {
		Browser = browser;
	}

	/**
	 * @return the messaging
	 */
	public String getMessaging() {
		return Messaging;
	}

	/**
	 * @param messaging
	 *            the messaging to set
	 */
	public void setMessaging(String messaging) {
		Messaging = messaging;
	}

	/**
	 * @return the sensors
	 */
	public String getSensors() {
		return Sensors;
	}

	/**
	 * @param sensors
	 *            the sensors to set
	 */
	public void setSensors(String sensors) {
		Sensors = sensors;
	}

	/**
	 * @return the gPU
	 */
	public String getGPU() {
		return GPU;
	}

	/**
	 * @param gPU
	 *            the gPU to set
	 */
	public void setGPU(String gPU) {
		GPU = gPU;
	}

	/**
	 * @return the cPU
	 */
	public String getCPU() {
		return CPU;
	}

	/**
	 * @param cPU
	 *            the cPU to set
	 */
	public void setCPU(String cPU) {
		CPU = cPU;
	}

	/**
	 * @return the oS
	 */
	public String getOS() {
		return OS;
	}

	/**
	 * @param oS
	 *            the oS to set
	 */
	public void setOS(String oS) {
		OS = oS;
	}
}

package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class GeneralDetails {

	String Network2G=null;
	String Network3G=null;
	String Sim=null;
	String Status=null;
	public GeneralDetails(JSONObject Object) {

	try {
		this.Network2G = Object.getString("Network2G");
		this.Network3G = Object.getString("Network3G");
		this.Sim = Object.getString("Sim");
		this.Status = Object.getString("Status");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	/**
	 * @return the network2G
	 */
	public String getNetwork2G() {
		return Network2G;
	}
	/**
	 * @param network2g the network2G to set
	 */
	public void setNetwork2G(String network2g) {
		Network2G = network2g;
	}
	/**
	 * @return the network3G
	 */
	public String getNetwork3G() {
		return Network3G;
	}
	/**
	 * @param network3g the network3G to set
	 */
	public void setNetwork3G(String network3g) {
		Network3G = network3g;
	}
	/**
	 * @return the sim
	 */
	public String getSim() {
		return Sim;
	}
	/**
	 * @param sim the sim to set
	 */
	public void setSim(String sim) {
		Sim = sim;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}
}

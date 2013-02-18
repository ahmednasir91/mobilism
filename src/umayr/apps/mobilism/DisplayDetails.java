package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class DisplayDetails {

	String Protection = null;
	String Multitouch = null;
	String Size = null;
	String Type = null;

	public DisplayDetails(JSONObject Object) {
		// TODO Auto-generated constructor stub

		try {
			this.Protection = Object.getString("Protection");
			this.Multitouch = Object.getString("Multitouch");
			this.Size = Object.getString("Size");
			this.Type = Object.getString("Type");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getProtection() {
		return Protection;
	}

	public void setProtection(String protection) {
		Protection = protection;
	}

	public String getMultitouch() {
		return Multitouch;
	}

	public void setMultitouch(String multitouch) {
		Multitouch = multitouch;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}

package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class SoundDetails {

	String Loudspeaker = null;
	String AlertTypes = null;

	public SoundDetails(JSONObject Object) {

		try {
			this.Loudspeaker = Object.getString("Loudspeaker");
			this.AlertTypes = Object.getString("AlertTypes");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getLoudspeaker() {
		return Loudspeaker;
	}

	public void setLoudspeaker(String loudspeaker) {
		Loudspeaker = loudspeaker;
	}

	public String getAlertTypes() {
		return AlertTypes;
	}

	public void setAlertTypes(String alertTypes) {
		AlertTypes = alertTypes;
	}

}

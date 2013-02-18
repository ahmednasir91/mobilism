package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class CameraDetails {
	String Primary=null;
	String Secondary=null;
	String Features=null;
	String Video=null;
	public CameraDetails(JSONObject Object) {

	try {
		this.Primary = Object.getString("Primary");
		this.Secondary = Object.getString("Secondary");
		this.Features = Object.getString("Features");
		this.Video = Object.getString("Video");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	/**
	 * @return the primary
	 */
	public String getPrimary() {
		return Primary;
	}
	/**
	 * @param primary the primary to set
	 */
	public void setPrimary(String primary) {
		Primary = primary;
	}
	/**
	 * @return the secondary
	 */
	public String getSecondary() {
		return Secondary;
	}
	/**
	 * @param secondary the secondary to set
	 */
	public void setSecondary(String secondary) {
		Secondary = secondary;
	}
	/**
	 * @return the features
	 */
	public String getFeatures() {
		return Features;
	}
	/**
	 * @param features the features to set
	 */
	public void setFeatures(String features) {
		Features = features;
	}
	/**
	 * @return the video
	 */
	public String getVideo() {
		return Video;
	}
	/**
	 * @param video the video to set
	 */
	public void setVideo(String video) {
		Video = video;
	}
}

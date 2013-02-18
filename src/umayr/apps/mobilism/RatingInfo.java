package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class RatingInfo {

	String Performance = null;
	String Design = null;
	String Features = null;

	public RatingInfo(JSONObject Object) {

		try {
			this.Performance = Object.getString("Performance");
			this.Design = Object.getString("Design");
			this.Features = Object.getString("Features");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the performance
	 */
	public String getPerformance() {
		return Performance;
	}

	/**
	 * @param performance
	 *            the performance to set
	 */
	public void setPerformance(String performance) {
		this.Performance = performance;
	}

	/**
	 * @return the design
	 */
	public String getDesign() {
		return Design;
	}

	/**
	 * @param design
	 *            the design to set
	 */
	public void setDesign(String design) {
		this.Design = design;
	}

	/**
	 * @return the features
	 */
	public String getFeatures() {
		return Features;
	}

	/**
	 * @param features
	 *            the features to set
	 */
	public void setFeatures(String features) {
		this.Features = features;
	}
}

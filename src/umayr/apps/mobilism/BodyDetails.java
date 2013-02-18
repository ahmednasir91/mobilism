package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class BodyDetails {

	String Weight=null;
	String Dimension=null;
	public BodyDetails(JSONObject Object) {
		
		try {
			this.Weight = Object.getString("Weight");
			this.Dimension = Object.getString("Dimensions");
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return Weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		Weight = weight;
	}
	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return Dimension;
	}
	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(String dimension) {
		Dimension = dimension;
	}
}

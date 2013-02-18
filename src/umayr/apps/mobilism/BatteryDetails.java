package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class BatteryDetails {

	String MusicPlay=null;
	String Talktime=null;
	String StandBy=null;
	String Type=null;
	public BatteryDetails(JSONObject Object) {
		// TODO Auto-generated constructor stub
		
		try {
			this.MusicPlay = Object.getString("MusicPlay");
			this.Talktime = Object.getString("Talktime");
			this.StandBy= Object.getString("StandBy");
			this.Type= Object.getString("Type");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the musicPlay
	 */
	public String getMusicPlay() {
		return MusicPlay;
	}
	/**
	 * @param musicPlay the musicPlay to set
	 */
	public void setMusicPlay(String musicPlay) {
		MusicPlay = musicPlay;
	}
	/**
	 * @return the talktime
	 */
	public String getTalktime() {
		return Talktime;
	}
	/**
	 * @param talktime the talktime to set
	 */
	public void setTalktime(String talktime) {
		Talktime = talktime;
	}
	/**
	 * @return the standBy
	 */
	public String getStandBy() {
		return StandBy;
	}
	/**
	 * @param standBy the standBy to set
	 */
	public void setStandBy(String standBy) {
		StandBy = standBy;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}
}

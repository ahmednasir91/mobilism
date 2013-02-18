package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class Mobile {

	String Manufacturer = null;
	String Id = null;
	String Name = null;
	String ImageURL = null;
	BodyDetails Body = null;
	BatteryDetails Battery = null;
	CameraDetails Camera = null;
	DataDetails Data = null;
	DisplayDetails Display = null;
	FeaturesDetails Feature = null;
	GeneralDetails General = null;
	MemoryDetails Memory = null;
	SoundDetails Sound = null;
	RatingInfo UserRating = null;

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public BodyDetails getBody() {
		return Body;
	}

	public void setBody(BodyDetails body) {
		Body = body;
	}

	public BatteryDetails getBattery() {
		return Battery;
	}

	public void setBattery(BatteryDetails battery) {
		Battery = battery;
	}

	public CameraDetails getCamera() {
		return Camera;
	}

	public void setCamera(CameraDetails camera) {
		Camera = camera;
	}

	public DataDetails getData() {
		return Data;
	}

	public void setData(DataDetails data) {
		Data = data;
	}

	public DisplayDetails getDisplay() {
		return Display;
	}

	public void setDisplay(DisplayDetails display) {
		Display = display;
	}

	public FeaturesDetails getFeature() {
		return Feature;
	}

	public void setFeature(FeaturesDetails feature) {
		Feature = feature;
	}

	public GeneralDetails getGeneral() {
		return General;
	}

	public void setGeneral(GeneralDetails general) {
		General = general;
	}

	public MemoryDetails getMemory() {
		return Memory;
	}

	public void setMemory(MemoryDetails memory) {
		Memory = memory;
	}

	public SoundDetails getSound() {
		return Sound;
	}

	public void setSound(SoundDetails sound) {
		Sound = sound;
	}

	public RatingInfo getUserRating() {
		return UserRating;
	}

	public void setUserRating(RatingInfo userRating) {
		UserRating = userRating;
	}

	public Mobile(JSONObject obj) {

		if (obj != null) {
			try {

				this.Manufacturer = obj.get("Manufacturer").toString();
				this.ImageURL = obj.get("ImageURL").toString();
				this.Id = obj.get("Id").toString();
				this.Name = obj.get("Name").toString();
				this.Body = new BodyDetails(obj.getJSONObject("Body"));
				this.Battery = new BatteryDetails(obj.getJSONObject("Battery"));
				this.Camera = new CameraDetails(obj.getJSONObject("Camera"));
				this.Display = new DisplayDetails(obj.getJSONObject("Display"));
				this.Data = new DataDetails(obj.getJSONObject("Data"));
				this.General = new GeneralDetails(obj.getJSONObject("General"));
				this.Feature = new FeaturesDetails(obj.getJSONObject("Feature"));
				this.Memory = new MemoryDetails(obj.getJSONObject("Memory"));
				this.Sound = new SoundDetails(obj.getJSONObject("Sound"));
				this.UserRating = new RatingInfo(
						obj.getJSONObject("UserRating"));
			} catch (JSONException e) {

			}
		}

	}

}

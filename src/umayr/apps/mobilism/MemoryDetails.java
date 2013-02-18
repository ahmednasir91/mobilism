package umayr.apps.mobilism;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class MemoryDetails {

	String InternalMemory = null;
	String CardSlot = null;

	public MemoryDetails(JSONObject Object) {

		try {
			this.InternalMemory = Object.getString("InternalMemory");
			this.CardSlot = Object.getString("CardSlot");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the internalMemory
	 */
	public String getInternalMemory() {
		return InternalMemory;
	}

	/**
	 * @param internalMemory
	 *            the internalMemory to set
	 */
	public void setInternalMemory(String internalMemory) {
		InternalMemory = internalMemory;
	}

	/**
	 * @return the cardSlot
	 */
	public String getCardSlot() {
		return CardSlot;
	}

	/**
	 * @param cardSlot
	 *            the cardSlot to set
	 */
	public void setCardSlot(String cardSlot) {
		CardSlot = cardSlot;
	}
}

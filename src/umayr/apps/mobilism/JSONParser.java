package umayr.apps.mobilism;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

public class JSONParser {

	private static StringBuffer getData(String url) {
		StringBuffer stringBuffer = new StringBuffer();
		InputStream is = null;
		HttpConnection hc = null;

		try {
			hc = (HttpConnection) Connector.open(url);
			is = hc.openInputStream();
			int ch;
			while ((ch = is.read()) != -1) {
				stringBuffer.append((char) ch);
			}
		}

		catch (SecurityException se) {
			Util.SomethingWentWrong();
			System.out.println("security exception:" + se);
		} catch (NullPointerException npe) {
			Util.SomethingWentWrong();
			System.out.println("Null pointer excception:" + npe);
		} catch (IOException ioe) {
			Util.SomethingWentWrong();
			System.out.println("io exception:" + ioe);
		}
		try {
			hc.close();
			is.close();
		} catch (Exception e) {
			Util.SomethingWentWrong();
			System.out.println("Error in MostActivePareser Connection close:"
					+ e);
			e.printStackTrace();
		}

		return stringBuffer;

	}

	
	public static JSONObject Parse(String url) {
		try {

			JSONArray jArr = new JSONArray(JSONParser.getData(url).toString());
			
			return jArr.getJSONObject(0);

		} catch (JSONException e1) {

			Util.SomethingWentWrong();
			return null;

		} catch (NullPointerException e) {
			System.out.println("null error:" + e);
		}
		return null;
	}
	
	public static JSONArray ParseArray(String url) {
		try {
			JSONArray js = new JSONArray(JSONParser.getData(url).toString());
			return js;

		} catch (JSONException e) {
			Util.SomethingWentWrong();
			return null;

		} catch (NullPointerException e) {
			System.out.println("null error:" + e);
		}
		return null;
	}

}

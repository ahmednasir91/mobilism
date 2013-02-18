package umayr.apps.mobilism;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.plaf.Style;

public class Util {

	public static String encodeQuery(String Query) {

		String Result;
		try {
			Result = encode(Query, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Result = "";
			e.printStackTrace();
		}

		return Result;
	}

	public static String encode(String s, String enc) throws IOException {

		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		DataOutputStream dOut = new DataOutputStream(bOut);
		StringBuffer ret = new StringBuffer(); // return value
		dOut.writeUTF(s);
		ByteArrayInputStream bIn = new ByteArrayInputStream(bOut.toByteArray());
		bIn.read();
		bIn.read();
		int c = bIn.read();
		while (c >= 0) {
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
					|| (c >= '0' && c <= '9') || c == '.' || c == '-'
					|| c == '*' || c == '_') {
				ret.append((char) c);
			} else if (c == ' ') {
				ret.append('+');
			} else {
				if (c < 128) {
					appendHex(c, ret);
				} else if (c < 224) {
					appendHex(c, ret);
					appendHex(bIn.read(), ret);
				} else if (c < 240) {
					appendHex(c, ret);
					appendHex(bIn.read(), ret);
					appendHex(bIn.read(), ret);
				}
			}
			c = bIn.read();
		}
		return ret.toString();
	}

	private static void appendHex(int arg0, StringBuffer buff) {
		buff.append('%');
		if (arg0 < 16) {
			buff.append('0');
		}
		buff.append(Integer.toHexString(arg0));
	}

	public static TextArea getHeadingComponent(String Text) {

		TextArea T = new TextArea(Text);
		T.setTextEditorEnabled(false);
		T.setEditable(false);
		T.setUIID("Label");
		Style S = T.getStyle();
		S.setFgColor(0x00a8f0);
		S.setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN,
				Font.SIZE_SMALL));
		T.setUnselectedStyle(S);
		T.setSelectedStyle(S);
		T.setPressedStyle(S);
		return T;

	}

	public static TextArea getHeader(String Text) {

		TextArea T = new TextArea(1, 20);
		T.setText(Text);
		T.setTextEditorEnabled(false);
		T.setEditable(false);
		T.setUIID("Label");
		T.setWidth(Display.getInstance().getDisplayWidth());

		Style S = T.getStyle();
		S.setFgColor(0xffffff);
		S.setBgColor(0x00a8f0);
		S.setAlignment(Component.CENTER, true);
		S.setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN,
				Font.SIZE_SMALL));
		T.setUnselectedStyle(S);
		T.setSelectedStyle(S);
		T.setPressedStyle(S);
		return T;

	}

	public static TextArea getTextComponent(String Text) {

		TextArea T = new TextArea(1, 30);
		T.setText(Text);
		T.setTextEditorEnabled(false);
		T.setSingleLineTextArea(false);
		T.setEditable(false);
		T.setUIID("Label");
		T.setGrowByContent(true);
		T.setFocus(false);
		if (Text.length() > 30) {

			double rows = Math.ceil((double) (((float) Text.length()) / 30));
			T.setRows((int) rows);

		}

		Style S = T.getStyle();
		S.setFgColor(0xffffff);
		S.setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN,
				Font.SIZE_SMALL));

		T.setUnselectedStyle(S);
		T.setSelectedStyle(S);
		T.setPressedStyle(S);
		return T;

	}

	public static Label getImage(String URL) {
		StreamConnection streamConnection = null;
		try {
			streamConnection = (StreamConnection) Connector.open(URL);

			Image I = Image.createImage(streamConnection.openInputStream());
			streamConnection.close();
			int padding = (I.getWidth() / 3);

			System.out.println(padding);
			Label L = new Label(I);
			L.setWidth(Display.getInstance().getDisplayWidth());
			Style oStyle = L.getUnselectedStyle();
			oStyle.setAlignment(Component.CENTER);
			oStyle.setPadding(15, 15, padding, padding);
			oStyle.setBgTransparency(255);
			oStyle.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
			oStyle.setBgImage(Image.createImage(1, 1, 0xffffff));
			L.setSelectedStyle(oStyle);
			L.setPressedStyle(oStyle);
			return L;

		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static void setCommand(Form f, boolean showList, boolean showHome) {
		Command Exit = new Command("Exit");
		Command Help = new Command("Help");
		Command Aboutus = new Command("About");
		Command Home = new Command("Home");
		Command List = new Command("List");

		f.addCommand(Help);
		f.addCommand(Aboutus);
		if (showList) {
			f.addCommand(List);
		}
		if (showHome) {
			f.addCommand(Home);
		}

		f.addCommand(Exit);

		f.addCommandListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String cmdName = arg0.getCommand().getCommandName();
				if (cmdName == "Exit") {
					Static.Midlet.destroyApp(true);
				} else if (cmdName == "Help") {

					FormExtra f = new FormExtra("Help", "For help, visit:\n util.codenotch.com/Mobilism/");
					f.show();
				} else if (cmdName == "About Us") {
					FormExtra f = new FormExtra(
							"About",
							"Mobilism is your pocket Mobile Database. Every Cellphone specification at your finger tips. It is sync with our web API so everytime you'll get latest specs. \nVersion 1.0.1 ");
					f.show();
				} else if (cmdName == "Home") {

					FormMainSearch f = new FormMainSearch();
					f.show();
				} else if (cmdName == "List") {
					FormMobileList f = new FormMobileList();
					f.show();

				}

			}
		});

	}

	public static void MobileNotFound(){
		
		Dialog validDialog = new Dialog("Error");
		validDialog.setScrollable(false);
		validDialog.setTimeout(3000);
		TextArea textArea = new TextArea(1, 25);
		textArea.setText("No Mobile Found. :( ");
		textArea.setFocusable(false);
		textArea.setEditable(false);
		textArea.setUIID("Label");

		Style tStyle = textArea.getStyle();
		tStyle.setAlignment(Component.CENTER, true);
		tStyle.setBgColor(0x383838);

		validDialog.addComponent(textArea);
		validDialog.show(110, 110, 5, 5, true);
	}
	public static void SomethingWentWrong(){
		
		Dialog validDialog = new Dialog("Error");
		validDialog.setScrollable(false);
		validDialog.setTimeout(3000);
		TextArea textArea = new TextArea(2, 25);
		textArea.setText("Something Went Wrong. :( \n Please try again.");
		textArea.setFocusable(false);
		textArea.setEditable(false);
		textArea.setUIID("Label");

		Style tStyle = textArea.getStyle();
		tStyle.setAlignment(Component.CENTER, true);
		tStyle.setBgColor(0x383838);

		validDialog.addComponent(textArea);
		validDialog.show(110, 110, 5, 5, true);
	}
}

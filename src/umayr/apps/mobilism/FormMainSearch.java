package umayr.apps.mobilism;

import java.util.Vector;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import com.sun.lwuit.Button;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.TextField;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.ListModel;
import com.sun.lwuit.plaf.Style;

public class FormMainSearch extends Form {

	Form formSearch = null;
	Button btnSearch;
	Button btnShowCompleteList;
	TextField txtSearch;
	ListModel listAutocomplete;
	Button btnMoreOptions;

	public FormMainSearch() {

		formSearch = this;
		formSearch.setTitle("Mobilism");
		formSearch.setLayout(new BorderLayout());

		formSearch.setTransitionOutAnimator(CommonTransitions.createSlide(
				CommonTransitions.SLIDE_HORIZONTAL, true, 400));

		txtSearch = new TextField();

		btnSearch = new Button();
		btnSearch.setText("Search");
		Style bStyle = btnSearch.getStyle();
		bStyle.setAlignment(CENTER, true);

		btnMoreOptions = new Button();
		btnMoreOptions.setText("More");
		btnMoreOptions.setWidth(0x50);
		Style mStyle = btnSearch.getStyle();
		mStyle.setAlignment(CENTER, true);
		btnMoreOptions.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				FormMoreOptions fList = new FormMoreOptions();
				fList.show();
			}
		});

		btnSearch.setUnselectedStyle(bStyle);
		btnSearch.setSelectedStyle(bStyle);
		btnSearch.setPressedStyle(bStyle);

		final Vector vMobileList = new Vector();

		final TextArea L = new TextArea(2, 30);
		L.setTextEditorEnabled(false);
		L.setEditable(false);
		L.setUIID("Label");
		L.setSingleLineTextArea(false);
		Style LStyle = L.getStyle();

		LStyle.setFont(Font.createSystemFont(Font.FACE_SYSTEM,
				Font.STYLE_PLAIN, Font.SIZE_SMALL));
		LStyle.setAlignment(CENTER, true);
		L.setUnselectedStyle(LStyle);
		L.setSelectedStyle(LStyle);
		L.setPressedStyle(LStyle);
		formSearch.addComponent(BorderLayout.NORTH, L);

		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (txtSearch.getText().length() > 2) {
					L.setText("Please wait..");

					new Thread(new Runnable() {

						public void run() {

							Static.APIParams.NAME_LIKE = Util
									.encodeQuery(txtSearch.getText());
							String URL = Static.getURL(1);
							try {
								JSONArray jArr = JSONParser.ParseArray(URL);

								if (jArr.length() == 0) {

									Util.MobileNotFound();
								} else {
									for (int i = 0; i < jArr.length(); i++) {

										try {
											JSONObject jObj = jArr
													.getJSONObject(i);
											vMobileList.addElement(jObj
													.getString("Name"));

										} catch (JSONException e) {

											Util.SomethingWentWrong();
										}
									}

									FormSearchResult fsr = new FormSearchResult(
											vMobileList);
									fsr.show();
								}
							} catch (OutOfMemoryError e) {

								L.setText("Your Search looks a bit vague, \nPlease try to refine it!");

							}
						}
					}).start();

				} else {

					Dialog validDialog = new Dialog("Error");
					validDialog.setScrollable(false);
					validDialog.setTimeout(5000);
					TextArea textArea = new TextArea(2, 25);
					textArea.setText("Search Query must consist atleast 3 Chars. ");
					textArea.setFocusable(false);
					textArea.setUIID("Label");

					Style tStyle = textArea.getStyle();
					tStyle.setAlignment(CENTER, true);
					tStyle.setBgColor(0x383838);

					validDialog.addComponent(textArea);
					validDialog.show(100, 100, 5, 5, true);

				}

			}
		});

		Container Form = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Form.addComponent(txtSearch);
		Form.addComponent(btnSearch);
		Style fStyle = Form.getStyle();
		fStyle.setMargin(50, 0, 0, 0);

		Form.setUnselectedStyle(fStyle);
		Form.setSelectedStyle(fStyle);
		Form.setPressedStyle(fStyle);

		Util.setCommand(this, true, false);

		formSearch.addComponent(BorderLayout.CENTER, Form);
		formSearch.addComponent(BorderLayout.SOUTH, btnMoreOptions);
		formSearch.show();

	}

}

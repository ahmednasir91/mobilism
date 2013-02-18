package umayr.apps.mobilism;

import java.util.Vector;

import org.json.me.JSONException;
import org.json.me.JSONObject;

import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.list.DefaultListModel;
import com.sun.lwuit.list.ListModel;

public class FormSearchResult extends Form {

	Form f = null;
	ListModel oModel = null;
	boolean isFirst;

	public FormSearchResult(Vector Result) {

		isFirst = true;
		f = this;
		Util.setCommand(f, true, true);
		f.setTitle("Result");
		f.setLayout(new BorderLayout());
		f.setTransitionOutAnimator(CommonTransitions.createSlide(
				CommonTransitions.SLIDE_HORIZONTAL, false, 400));

		oModel = new DefaultListModel(Result);
		List oList = new List(oModel);
		f.addComponent(BorderLayout.CENTER, oList);

		addCommands();
	}

	private void addCommands() {
		Command cmdBackCommand = new Command("Back") {

			public void actionPerformed(ActionEvent ae) {

				FormMainSearch objMainMenu = new FormMainSearch();
				objMainMenu.show();
			}

		};
		oModel.addSelectionListener(new SelectionListener() {

			public void selectionChanged(int arg0, int arg1) {
				if (!isFirst) {
					int i = oModel.getSelectedIndex();
					String name = oModel.getItemAt(i).toString();

					Static.APIParams.NAME_LIKE = Util.encodeQuery(name);
					String URL = Static.getURL(1);
					System.out.println(URL);
					JSONObject oJSON = JSONParser.Parse(URL);
					try {
						System.out.println(oJSON.getString("Name"));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Mobile m = new Mobile(oJSON);
					System.out.println(m.getManufacturer());
					FormMobileDisplay oFMD = new FormMobileDisplay(m);
					oFMD.show();
				} else {

					isFirst = false;
				}
			}
		});
		f.addCommand(cmdBackCommand);
		f.setBackCommand(cmdBackCommand);

	}
}

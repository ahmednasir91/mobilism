/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package umayr.apps.mobilism;

import org.json.me.JSONObject;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.TextField;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.list.DefaultListModel;
import com.sun.lwuit.list.ListModel;

/**
 * 
 * @author Umayr Shahid
 */
public class FormMobileList extends Form {

	Form frmMainMenu = null;
	Button btnTest1;
	TextField txtSearch;
	ListModel listAutocomplete;
	FilterProxyListModel pModel;
	boolean isFirst;

	FormMobileList() {

		isFirst = true;
		frmMainMenu = this;
		frmMainMenu.setTitle("Mobilism");
		frmMainMenu.setLayout(new BorderLayout());
		txtSearch = new TextField();
		listAutocomplete = new DefaultListModel(Static.getAutocompleteList());
		frmMainMenu.setTransitionOutAnimator(CommonTransitions.createSlide(
				CommonTransitions.SLIDE_HORIZONTAL, false, 400));
		
		pModel = new FilterProxyListModel(listAutocomplete);

		List people = new List(pModel);
		frmMainMenu.addComponent(BorderLayout.NORTH, txtSearch);
		frmMainMenu.addComponent(BorderLayout.CENTER, people);
		txtSearch.addDataChangeListener(new DataChangedListener() {
			public void dataChanged(int type, int index) {

				pModel.filter(txtSearch.getText());

			}
		});

		ShowUi();

	}

	private void ShowUi() {

		addCommands();
	}

	private void addCommands() {
		Command cmdBackCommand = new Command("Back") {

			public void actionPerformed(ActionEvent ae) {

				FormMainSearch objMainMenu = new FormMainSearch();
				objMainMenu.show();
			}

		};
		pModel.addSelectionListener(new SelectionListener() {

			public void selectionChanged(int arg0, int arg1) {

				if (!isFirst) {
					int i = pModel.getSelectedIndex();
					String name = pModel.getItemAt(i).toString();

					Static.APIParams.NAME_LIKE = Util.encodeQuery(name);
					String URL = Static.getURL(1);
					JSONObject oJSON = JSONParser.Parse(URL);
					Mobile m = new Mobile(oJSON);
					FormMobileDisplay oFMD = new FormMobileDisplay(m);
					oFMD.show();
				}
				else{
					
					isFirst = false;
				}
			}
		});
		Util.setCommand(this,  false, true);
		frmMainMenu.addCommand(cmdBackCommand);
		frmMainMenu.setBackCommand(cmdBackCommand);

	}
}

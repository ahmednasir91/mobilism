package umayr.apps.mobilism;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Style;

public class FormMoreOptions extends Form {

	Form f;
	Button btnList;
	Button btnAdvance;

	public FormMoreOptions() {

		f = this;
		Util.setCommand(this, true, true);
		f.setTitle("More Mobilism");
		f.setLayout(new BorderLayout());

		Container C = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		f.setTransitionOutAnimator(CommonTransitions.createSlide(
				CommonTransitions.SLIDE_HORIZONTAL, false, 400));

		btnList = new Button();
		btnList.setText("Complete List");
		C.addComponent(btnList);

		Style cStyle = C.getStyle();
		cStyle.setMargin(TOP, 100);
		btnList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				FormMobileList fList = new FormMobileList();
				fList.show();

			}
		});
		btnAdvance = new Button("Advance Search");
		C.addComponent(btnAdvance);

		btnAdvance.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Dialog validDialog = new Dialog("Sorry. :(");
				validDialog.setScrollable(false);
				validDialog.setTimeout(5000);
				TextArea textArea = new TextArea(2, 25);
				textArea.setText("This feature is not available in this version. But it'll be. \n We Promise.");
				textArea.setFocusable(false);
				textArea.setUIID("Label");

				Style tStyle = textArea.getStyle();
				tStyle.setAlignment(CENTER, true);
				tStyle.setBgColor(0x383838);

				validDialog.addComponent(textArea);
				validDialog.show(90, 90, 5, 5, true);

			}
		});
		Command cmdBack = new Command("Back") {
			public void actionPerformed(ActionEvent ae) {

				FormMainSearch objMainMenu = new FormMainSearch();
				objMainMenu.show();
			}

		};
		f.addCommand(cmdBack);
		f.setBackCommand(cmdBack);
		f.addComponent(BorderLayout.CENTER, C);

		Style bStyle = btnList.getStyle();
		bStyle.setFgColor(0xFFFFFF);

		btnList.setUnselectedStyle(bStyle);
		btnAdvance.setUnselectedStyle(bStyle);
	}
}

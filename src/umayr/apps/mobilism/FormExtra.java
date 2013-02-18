package umayr.apps.mobilism;


import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.plaf.Style;

public class FormExtra extends Form {

	public FormExtra(String Title, String Text) {

		Form f = this;
		f.setTitle(Title);
		f.setLayout(new BorderLayout());
		f.setTransitionOutAnimator(CommonTransitions.createSlide(
				CommonTransitions.SLIDE_HORIZONTAL, false, 400));
		

		TextArea textArea = new TextArea(5, 30);
		textArea.setText(Text);
		textArea.setFocusable(false);
		textArea.setUIID("Label");
		textArea.setEditable(false);
		Style tStyle = textArea.getStyle();
		tStyle.setAlignment(CENTER, true);
		f.addComponent(BorderLayout.CENTER, textArea);

		Command cmdBackCommand = new Command("Back") {

			public void actionPerformed(ActionEvent ae) {

				FormMainSearch f = new FormMainSearch();
				f.show();
			}

		};

		f.addCommand(cmdBackCommand);
		f.setBackCommand(cmdBackCommand);

	}

}

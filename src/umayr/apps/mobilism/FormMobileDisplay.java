package umayr.apps.mobilism;

import com.nokia.mid.ui.orientation.Orientation;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.FlowLayout;

public class FormMobileDisplay extends Form {

	public FormMobileDisplay(Mobile M) {

		final Form f = this;
		Util.setCommand(this, true, true);

		f.setTitle(M.getName());
		f.setTransitionOutAnimator(CommonTransitions.createSlide(
				CommonTransitions.SLIDE_HORIZONTAL, false, 400));
		
		f.setLayout(new FlowLayout(Orientation.ORIENTATION_PORTRAIT));

		f.setLayout(new FlowLayout());
		Command cmdBack = new Command("Back") {
			public void actionPerformed(ActionEvent ae) {

				FormMainSearch objMainMenu = new FormMainSearch();
				objMainMenu.show();
			}

		};
		f.addCommand(cmdBack);
		f.setBackCommand(cmdBack);
		f.addComponent(Util.getImage(M.getImageURL()));

		f.addComponent(Util.getHeader("Body"));

		Container cBody = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cBody.addComponent(Util.getHeadingComponent("Dimensions"));
		cBody.addComponent(Util.getTextComponent(M.getBody().getDimension()));
		cBody.addComponent(Util.getHeadingComponent("Weight"));
		cBody.addComponent(Util.getTextComponent(M.getBody().getWeight()));

		f.addComponent(cBody);

		f.addComponent(Util.getHeader("Battery"));

		Container cBattery = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cBattery.addComponent(Util.getHeadingComponent("Music Play"));
		cBattery.addComponent(Util.getTextComponent(M.getBattery()
				.getMusicPlay()));
		cBattery.addComponent(Util.getHeadingComponent("Standby"));
		cBattery.addComponent(Util
				.getTextComponent(M.getBattery().getStandBy()));
		cBattery.addComponent(Util.getHeadingComponent("Talktime"));
		cBattery.addComponent(Util.getTextComponent(M.getBattery()
				.getTalktime()));
		cBattery.addComponent(Util.getHeadingComponent("Type"));
		cBattery.addComponent(Util.getTextComponent(M.getBattery().getType()));

		f.addComponent(cBattery);

		f.addComponent(Util.getHeader("Camera"));

		Container cCamera = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cCamera.addComponent(Util.getHeadingComponent("Primary"));
		cCamera.addComponent(Util.getTextComponent(M.getCamera().getPrimary()));
		cCamera.addComponent(Util.getHeadingComponent("Secondary"));
		cCamera.addComponent(Util
				.getTextComponent(M.getCamera().getSecondary()));
		cCamera.addComponent(Util.getHeadingComponent("Features"));
		cCamera.addComponent(Util.getTextComponent(M.getCamera().getFeatures()));
		cCamera.addComponent(Util.getHeadingComponent("Video"));
		cCamera.addComponent(Util.getTextComponent(M.getCamera().getVideo()));
		f.addComponent(cCamera);

		f.addComponent(Util.getHeader("Data"));

		Container cData = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cData.addComponent(Util.getHeadingComponent("Bluetooth"));
		cData.addComponent(Util.getTextComponent(M.getData().getBluetooth()));
		cData.addComponent(Util.getHeadingComponent("EDGE"));
		cData.addComponent(Util.getTextComponent(M.getData().getEDGE()));
		cData.addComponent(Util.getHeadingComponent("GPRS"));
		cData.addComponent(Util.getTextComponent(M.getData().getGPRS()));
		cData.addComponent(Util.getHeadingComponent("Speed"));
		cData.addComponent(Util.getTextComponent(M.getData().getSpeed()));
		cData.addComponent(Util.getHeadingComponent("USB"));
		cData.addComponent(Util.getTextComponent(M.getData().getUSB()));
		cData.addComponent(Util.getHeadingComponent("WAN"));
		cData.addComponent(Util.getTextComponent(M.getData().getWAN()));

		f.addComponent(cData);

		f.addComponent(Util.getHeader("Display"));

		Container cDisplay = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cDisplay.addComponent(Util.getHeadingComponent("Multitouch"));
		cDisplay.addComponent(Util.getTextComponent(M.getDisplay()
				.getMultitouch()));
		cDisplay.addComponent(Util.getHeadingComponent("Protection"));
		cDisplay.addComponent(Util.getTextComponent(M.getDisplay()
				.getProtection()));
		cDisplay.addComponent(Util.getHeadingComponent("Size"));
		cDisplay.addComponent(Util.getTextComponent(M.getDisplay().getSize()));
		cDisplay.addComponent(Util.getHeadingComponent("Type"));
		cDisplay.addComponent(Util.getTextComponent(M.getDisplay().getType()));

		f.addComponent(cDisplay);

		f.addComponent(Util.getHeader("Features"));

		Container cFeatures = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cFeatures.addComponent(Util.getHeadingComponent("OS"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature().getOS()));
		cFeatures.addComponent(Util.getHeadingComponent("Browser"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature()
				.getBrowser()));
		cFeatures.addComponent(Util.getHeadingComponent("Colors"));
		cFeatures.addComponent(Util
				.getTextComponent(M.getFeature().getColors()));
		cFeatures.addComponent(Util.getHeadingComponent("CPU"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature().getCPU()));
		cFeatures.addComponent(Util.getHeadingComponent("GPS"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature().getGPS()));
		cFeatures.addComponent(Util.getHeadingComponent("GPU"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature().getGPU()));
		cFeatures.addComponent(Util.getHeadingComponent("Java"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature().getJava()));
		cFeatures.addComponent(Util.getHeadingComponent("Messaging"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature()
				.getMessaging()));
		cFeatures.addComponent(Util.getHeadingComponent("Radio"));
		cFeatures
				.addComponent(Util.getTextComponent(M.getFeature().getRadio()));
		cFeatures.addComponent(Util.getHeadingComponent("Sensors"));
		cFeatures.addComponent(Util.getTextComponent(M.getFeature()
				.getSensors()));
		f.addComponent(cFeatures);

		f.addComponent(Util.getHeader("General"));

		Container cGeneral = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cGeneral.addComponent(Util.getHeadingComponent("2G Network"));
		cGeneral.addComponent(Util.getTextComponent(M.getGeneral()
				.getNetwork2G()));
		cGeneral.addComponent(Util.getHeadingComponent("3G Network"));
		cGeneral.addComponent(Util.getTextComponent(M.getGeneral()
				.getNetwork3G()));
		cGeneral.addComponent(Util.getHeadingComponent("Sim"));
		cGeneral.addComponent(Util.getTextComponent(M.getGeneral().getSim()));
		cGeneral.addComponent(Util.getHeadingComponent("Status"));
		cGeneral.addComponent(Util.getTextComponent(M.getGeneral().getStatus()));
		f.addComponent(cGeneral);

		f.addComponent(Util.getHeader("Memory"));

		Container cMemory = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cMemory.addComponent(Util.getHeadingComponent("Internal Memory"));
		cMemory.addComponent(Util.getTextComponent(M.getMemory()
				.getInternalMemory()));
		cMemory.addComponent(Util.getHeadingComponent("Card Slot"));
		cMemory.addComponent(Util.getTextComponent(M.getMemory().getCardSlot()));
		f.addComponent(cMemory);

		f.addComponent(Util.getHeader("Sound"));

		Container cSound = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cSound.addComponent(Util.getHeadingComponent("Alert Types"));
		cSound.addComponent(Util.getTextComponent(M.getSound().getAlertTypes()));
		cSound.addComponent(Util.getHeadingComponent("Loudspeaker"));
		cSound.addComponent(Util
				.getTextComponent(M.getSound().getLoudspeaker()));
		f.addComponent(cSound);

		f.addComponent(Util.getHeader("User Rating"));

		Container cUserRating = new Container(new BoxLayout(BoxLayout.Y_AXIS));

		cUserRating.addComponent(Util.getHeadingComponent("Design"));
		cUserRating.addComponent(Util.getTextComponent(M.getUserRating()
				.getDesign()));
		cUserRating.addComponent(Util.getHeadingComponent("Performance"));
		cUserRating.addComponent(Util.getTextComponent(M.getUserRating()
				.getPerformance()));
		cUserRating.addComponent(Util.getHeadingComponent("Features"));
		cUserRating.addComponent(Util.getTextComponent(M.getUserRating()
				.getFeatures()));
		f.addComponent(cUserRating);

	}
}

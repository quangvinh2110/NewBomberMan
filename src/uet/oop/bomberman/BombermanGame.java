package uet.oop.bomberman;

import javafx.application.Application;
import javafx.stage.Stage;
import uet.oop.bomberman.Setup.BaseWindow;

public class BombermanGame extends Application {


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		try {
			BaseWindow baseWindow = new BaseWindow();
			mainStage = baseWindow.getMainStage();
			mainStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

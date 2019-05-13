package main.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.model.Disaster;

public class MapView {
	public MapView() {
		Button button = new Button();
		button.setText("Open a New Window");

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				int width = 600;
				Label disasterType = new Label("Type of Disaster:");
				Label xLoc = new Label("X Coordinate:");
				Label yLoc = new Label("Y Coordinate:");
				TextField yLocField = new TextField("Y Location");
				TextField xLocField = new TextField("X Location");
				Button submit = new Button("Submit");
				Button cancel = new Button("Cancel");
				ComboBox dropdown = new ComboBox<Disaster>();
				dropdown.getItems().addAll("Fire", "Earthquake", "Blizzard");

				GridPane gridLayout = new GridPane();
				gridLayout.setHgap(10);
				gridLayout.setVgap(10);
				gridLayout.setPadding(new Insets(10, 10, 10, 10));
				disasterType.setPrefWidth(width / 4);
				dropdown.setPrefWidth(width - disasterType.getWidth());
				xLoc.setPrefWidth(width - 70 / 4);
				xLocField.setPrefWidth(width - 70 / 4);
				yLoc.setPrefWidth(width - 70 / 4);
				yLocField.setPrefWidth(width - 70 / 4);
				submit.setPrefWidth((width - 70 / 4));
				cancel.setPrefWidth((width - 70 / 4));

				gridLayout.add(disasterType, 0, 0);
				gridLayout.add(dropdown, 1, 0, 3, 1);
				gridLayout.add(xLoc, 0, 1);
				gridLayout.add(xLocField, 1, 1);
				gridLayout.add(yLoc, 2, 1);
				gridLayout.add(yLocField, 3, 1);
				gridLayout.add(submit, 3, 2);
				gridLayout.add(cancel, 2, 2);

				Scene secondScene = new Scene(gridLayout, width, 200);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Submit a disaster");
				newWindow.setScene(secondScene);
				newWindow.setResizable(false);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(button);
	}
}
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author Mpho Makalancheche
 * User interface class.
 * Using JavaFx
 *
 */
public class DesignFx extends Application{

	TextField txt_queryBar;
	TextField txt_queryType;
	Button btn_runQuery;
	TextArea txtReturn;
	
	Label commandType;
	Label command;
	Label result;

	
	httpClient connect ;
	/**
	 * @param args: parameters from user
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        launch(args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.getIcons().add(new Image(getClass().getResourceAsStream("pinglo_logo.png")));
		stage.setTitle("No Sql Client");
		
		commandType = new Label("Command TYPE:");
		txt_queryType = new TextField("");
		txt_queryType.setMinHeight(30);
		
		command = new Label("Command: ");
		txt_queryBar = new TextField();	
		txt_queryBar.setMinHeight(60);
		
	
		btn_runQuery = new Button("Run Query");
		btn_runQuery.setMinWidth(100);
		btn_runQuery.setMinHeight(35);
		
		result = new Label("Result: ");
		txtReturn = new TextArea();
		txtReturn.setWrapText(true);
		connect = new httpClient();
		
		btn_runQuery.setOnAction(new EventHandler<ActionEvent>() {
			
			private String text = null;

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(txt_queryBar.getText() != ""){
					 text = txt_queryType.getText()+"\r\n" + txt_queryBar.getText() +"\r\n";
					 
					 txtReturn.setText(connect.Run(text, "localhost", 1337));
				}
					
				
				
				
			}
		});
		VBox main = new VBox();
		main.getChildren().addAll(commandType,txt_queryType,command,txt_queryBar,btn_runQuery,result,txtReturn);
		
		Scene scene = new Scene(main, 1000, 500); //set the scene
		stage.setScene(scene);
		
		scene.getStylesheets().add("styleSheet.css");
		stage.show();
	}

}

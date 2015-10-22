import javax.swing.JOptionPane;




import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise1 extends Application {
	public enum AccountType{student, staff, admin}
	
	TextField tf;
	PasswordField pwfield;

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		String username, password, usernameinput, pwinput;
		username = "CSC200";
		password = "123123";
		primaryStage.setTitle("Authentication");
		Button btn = new Button("OK");
		Label label1 = new Label("Enter your username(CSC2OO)");

		Label label2 = new Label("Enter your password(123123)");

		tf = new TextField();
		pwfield = new PasswordField();
		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				String usernameinput = tf.getText();
				String pwinput = pwfield.getText();
				
				AccountType [] choices ={AccountType.admin,AccountType.staff,AccountType.student};
				do{
					if(pwinput.equals(password)&&usernameinput.equals(username)){
					AccountType selecta = (AccountType) JOptionPane.showInputDialog(null, "Select your account type", "AccountType", JOptionPane.QUESTION_MESSAGE, null,choices, choices[0]);
					AccountType selectb=(AccountType) JOptionPane.showInputDialog(null, "Select your account type","AccountType", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);//select account
					while(!selecta.equals(selectb)&&selecta!=null){
					selectb=(AccountType) JOptionPane.showInputDialog(null, "Select your account type","AccountType", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);//select account
					System.out.println("Select your account type again");
					}System.out.println("Welcome");
					}else{
						System.out.println("Invalid password or username");return;
					}	
					
				}while(!usernameinput.equals(username)||!pwinput.equals(password));
			}
			});

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(20);
		grid.setHgap(20);
		grid.add(label1, 0, 0);
		grid.add(label2, 0, 1);
		grid.add(tf, 1, 0);
		grid.add(pwfield, 1, 1);
		grid.add(btn, 1, 2);
		Scene scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
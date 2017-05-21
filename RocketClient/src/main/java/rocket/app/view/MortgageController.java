package rocket.app.view;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;


public class MortgageController {

	ObservableList<String> options = FXCollections.observableArrayList("15 Year Fixed Rate", "30 Year Fixed Rate");

	@FXML TextField txtIncome;
	@FXML TextField txtExpenses;
	@FXML TextField txtCreditScore;
	@FXML TextField txtHouseCost;
	@FXML TextField txtDownPayment;
	@FXML Label lblMortgagePayment;
	@FXML ComboBox<String> cmbTerm;
	
	private MainApp mainApp;
	
	@FXML
	private void initialize()
	{
		cmbTerm.setItems(options);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double MonthlyPITI = (lRequest.getdIncome() * (28/100));
		double MonthlyIncome = ((lRequest.getdIncome()) * (36/100));

		
		if (MonthlyIncome < MonthlyPITI) {
			double PMT = Math.round(lRequest.getdPayment());
			System.out.printf("Payment is %.2f", PMT);
		if (MonthlyPITI < MonthlyIncome) {
			PMT = Math.round(lRequest.getdPayment());
			System.out.printf("Payment is %.2f", PMT);
		}
}

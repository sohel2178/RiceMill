package Application;

import Application.Database.DatabaseUtil;
import Application.Model.Account;
import Application.Tab.AccountTab;
import Application.Tab.EmployeeController;
import Application.Utility.MyPreference;
import com.jfoenix.controls.JFXTabPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private Tab tabEmployee;

   /* @FXML
    private EmployeeController employeeController;*/

    /*@FXML
    private AccountTab accountTab;*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                switch ((int) newValue){
                    case 0:
                        //System.out.println(newValue);
                        break;
                    case 1:
                        //System.out.println(newValue);
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
            }
        });

        if(MyPreference.getInstance().getBasicAccount()){
            System.out.println("Basic Account Set");
        }else{
            System.out.println("Basic Account NOT Set");

            setBasicAccount();

        }
    }

    private void setBasicAccount() {

        Account cashAcc = new Account("Cash",0);
        Account purchaseAcc = new Account("Purchase",0);
        Account salesAcc = new Account("Sales",0);
        Account salaryAccount = new Account("Salary",2);

        DatabaseUtil util = DatabaseUtil.getInstance();

        if(util.insertAccount(cashAcc) && util.insertAccount(purchaseAcc) && util.insertAccount(salesAcc) && util.insertAccount(salaryAccount)){
            MyPreference.getInstance().setBasicAccount(true);
            System.out.println("Basic Account Set Now");
        }

    }
}

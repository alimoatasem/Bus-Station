package bus.station;
import bus.station.users.Driver;
import bus.station.users.Employee;
import bus.station.users.Manager;
import bus.station.users.Passenger;
import javax.swing.*;
import java.awt.print.Book;


public class Login extends JFrame{
    private JPanel loginpannel;
    private JTextField textField1;
    private JRadioButton passengerRadioButton;
    private JRadioButton employeeRadioButton;
    private JButton loginButton;
    private JButton signupButton;
    private JPasswordField passwordField1;
    private JLabel username;

    public Login(BookOrView bookOrView) {
        add(loginpannel);
        setSize(loginpannel.getPreferredSize());
        setMinimumSize(loginpannel.getMinimumSize());
        setMaximumSize(loginpannel.getMaximumSize());


        employeeRadioButton.addActionListener(e -> {
            signupButton.setEnabled(false);
            username.setText(" ID                    ");
        });
        passengerRadioButton.addActionListener(e -> {
            signupButton.setEnabled(true);
            username.setText(" Username       ");
        });


        loginButton.addActionListener(e -> {
            String nameOrID = textField1.getText();
            String number = String.valueOf(passwordField1.getPassword());

            if (passengerRadioButton.isSelected()) {
                Passenger passenger = new Passenger();
                boolean valid = passenger.validate(nameOrID, number);
                if (valid) {
                    passenger = Passenger.passengersDictionary.get(nameOrID);
                    bookOrView.setPassenger(passenger);
                    setVisible(false);
                    bookOrView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane,"wrong username or password ");
                }
            } else if (employeeRadioButton.isSelected()) {
                Employee driver = new Driver();
                Employee manager = new Manager();

                if (driver.validate(nameOrID, number)) {
                    // TODO: 4/12/2019 jump to driver screen
                } else if (manager.validate(nameOrID, number)) {
                    // TODO: 4/12/2019 jump to manager screen
                } else {
                    JOptionPane.showMessageDialog(rootPane,"wrong username or password ");
                }
            }
        });


        signupButton.addActionListener(e -> {
            // TODO: 4/12/2019 go to sign up

        });
    }
}

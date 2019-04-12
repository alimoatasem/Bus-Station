package bus.station;

import bus.station.users.Passenger;
import javax.swing.*;

public class ViewTrips extends JPanel{
    private JTable table;
    private JPanel rootPanel;
    private Passenger passenger;

    public ViewTrips() {
        add(rootPanel);
        setSize(rootPanel.getPreferredSize());

    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

}

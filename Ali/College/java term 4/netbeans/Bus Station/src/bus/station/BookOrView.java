package bus.station;

import bus.station.users.Passenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookOrView extends JFrame{
    private JPanel rootpanel;
    private JButton viewTripsButton;
    private JButton bookATripButton;
    private Passenger passenger;

    private ViewTrips viewTrips;

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public BookOrView(ViewTrips viewTrips) throws HeadlessException {
        this.viewTrips = viewTrips;
        add(rootpanel);
        setSize(rootpanel.getPreferredSize());

        viewTripsButton.addActionListener(e -> {
            viewTrips.setPassenger(passenger);
            setVisible(false);
            viewTrips.setVisible(true);
        });
    }

    public JPanel getRootpanel() {
        return rootpanel;
    }
}

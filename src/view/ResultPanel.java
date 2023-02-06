package view;

import domain.Airport;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ResultPanel extends JPanel {
    private List<Airport> airports = new ArrayList<>();
    private int pos = 0;

    public ResultPanel(List<Airport> airports) {
        this.airports = airports;
        setLayout(null);
        for (Airport airport : this.airports) {
            AirportInfo airportInfo = new AirportInfo(airport);
            add(airportInfo);
            airportInfo.setBounds(0, pos, 679, 60);
            pos += 60;
        }
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<Airport> airports) {
        System.out.println("this.airports.size() = " + this.airports.size());
        removeAll();

        this.airports = airports;
        pos = 0;
        for (Airport airport : this.airports) {
            AirportInfo airportInfo = new AirportInfo(airport);
            add(airportInfo);
            airportInfo.setBounds(0, pos, 679, 60);
            pos += 60;
        }
        revalidate();
        repaint();
    }

}

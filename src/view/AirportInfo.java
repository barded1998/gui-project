package view;

import domain.Airport;

import javax.swing.*;
import java.awt.*;

public class AirportInfo extends JPanel {

    private Airport airport;

    public AirportInfo(Airport airport) {
        setLayout(null);
        setSize(679, 60);
        setBackground(new Color(244, 244, 244));

        JLabel airportName = new JLabel(airport.getKoreanAirportName() + " (" + airport.getEnglishAirportName() + ")" );
        airportName.setFont(new Font(this.getFont().getName(), Font.BOLD, 14));
        add(airportName);
        airportName.setBounds(16,0, 400, 30 );

        JLabel countryAndCity = new JLabel(airport.getKoreanCountryName() + "(" + airport.getEnglishCountryName() + ") - " + airport.getEnglishCityName() );
        countryAndCity.setFont(new Font(this.getFont().getName(), Font.PLAIN, 14));
        countryAndCity.setForeground(Colors.GRAY);
        countryAndCity.setHorizontalAlignment(JLabel.RIGHT);
        add(countryAndCity);
        countryAndCity.setBounds(372,0, 296, 30 );

        JLabel iataAndIcao = new JLabel( "IATA : "+airport.getIATA() + ", ICAO : " + airport.getICAO());
        iataAndIcao.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        iataAndIcao.setForeground(Colors.GRAY);
        add(iataAndIcao);
        iataAndIcao.setBounds(16,30, 400, 30 );

        JLabel locale = new JLabel(airport.getLocale());
        locale.setFont(new Font(this.getFont().getName(), Font.PLAIN, 12));
        locale.setForeground(Colors.GRAY);
        locale.setHorizontalAlignment(JLabel.RIGHT);
        add(locale);
        locale.setBounds(372,30, 296, 30 );
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Colors.GRAY);
        g.drawLine(0,0, 679, 0);
    }
}

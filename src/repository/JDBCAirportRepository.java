package repository;

import domain.Airport;
import file.CsvFileController;
import file.FileController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAirportRepository implements AirportRepository {

    private static String dburl = "jdbc:mysql://localhost:3306/GUI?useSSL=false&allowPublicKeyRetrieval=true";
    private static String dbUser = "root";
    private static String dbpasswd = null;
    private static Connection con = null;

    public JDBCAirportRepository() {
        con = makeConnection();
    }

    public static Connection makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("데이터베이스 연결 중...");
            con = DriverManager.getConnection(dburl, dbUser, dbpasswd);
            System.out.println("데이터베이스 연결 성공.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    @Override
    public ArrayList<Airport> findAll() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM airport");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Airport> list = new ArrayList<>();
        while (resultSet.next()) {
            Airport airport = new Airport(
                resultSet.getInt("id"),
                resultSet.getString("english_airport_name"),
                resultSet.getString("korean_airport_name"),
                resultSet.getString("IATA"),
                resultSet.getString("ICAO"),
                resultSet.getString("locale"),
                resultSet.getString("english_country_name"),
                resultSet.getString("korean_country_name"),
                resultSet.getString("english_city_name"));
            list.add(airport);
        }
        return list;
    }

    @Override
    public ArrayList<Airport> findByKeyAndValue(String key, String value) throws SQLException {

        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM airport WHERE " + key + " LIKE ?");
        preparedStatement.setString(1, "%" + value + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Airport> list = new ArrayList<>();
        while (resultSet.next()) {
            Airport airport = new Airport(
                resultSet.getInt("id"),
                resultSet.getString("english_airport_name"),
                resultSet.getString("korean_airport_name"),
                resultSet.getString("IATA"),
                resultSet.getString("ICAO"),
                resultSet.getString("locale"),
                resultSet.getString("english_country_name"),
                resultSet.getString("korean_country_name"),
                resultSet.getString("english_city_name"));
            list.add(airport);
        }
        return list;
    }

    @Override
    public Airport findById(int id) {
        return null;
    }

    @Override
    public void save(List<Airport> airports) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO airport(english_airport_name, korean_airport_name, IATA, ICAO, locale, english_country_name, korean_country_name, english_city_name) VALUES(?, ?, ?,?,?,?,?,?)");
        for (Airport airport : airports) {
            preparedStatement.setString(1, airport.getEnglishAirportName());
            preparedStatement.setString(2, airport.getKoreanAirportName());
            preparedStatement.setString(3, airport.getIATA());
            preparedStatement.setString(4, airport.getICAO());
            preparedStatement.setString(5, airport.getLocale());
            preparedStatement.setString(6, airport.getEnglishCountryName());
            preparedStatement.setString(7, airport.getKoreanCountryName());
            preparedStatement.setString(8, airport.getEnglishCityName());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }
}

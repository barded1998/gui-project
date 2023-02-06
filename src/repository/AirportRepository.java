package repository;

import domain.Airport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AirportRepository {
    public ArrayList<Airport> findAll() throws SQLException;
    public ArrayList<Airport> findByKeyAndValue(String key, String value) throws SQLException;
    public Airport findById(int id);
    public void save(List<Airport> airports) throws SQLException;

    public void delete(int id);
    public void update(int id);
}
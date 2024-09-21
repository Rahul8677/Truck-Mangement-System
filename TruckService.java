package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckService {

    public void addTruck(Truck truck) {
        String sql = "INSERT INTO truck(name,model,capacity,driver_name) VALUES (?,?,?,?)";
        try (Connection connection = ConnectionDetails.getconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapicity());
            preparedStatement.setString(4, truck.getDriverName());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row inserted: " + update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Truck getTruckById(int id) {
        String sql = "SELECT * FROM truck WHERE id = ?";
        Truck truck = null;
        try (Connection connection = ConnectionDetails.getconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapicity(resultSet.getInt("capicity"));
                truck.setDriverName(resultSet.getString("driver_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return truck;
    }

    public void update(Truck truck) {
        String sql = "UPDATE truck SET name = ?, model = ?, capacity = ?, driver_name = ? WHERE id = ?";
        try (Connection connection = ConnectionDetails.getconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapicity());
            preparedStatement.setString(4, truck.getDriverName());
            preparedStatement.setInt(5, truck.getId());

            int update = preparedStatement.executeUpdate();
            System.out.println("Row updated: " + update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Truck> getAllTrucks() {
        String sql = "SELECT * FROM truck";
        List<Truck> trucks = new ArrayList<>();
        try (Connection connection = ConnectionDetails.getconnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapicity(resultSet.getInt("capicity"));
                truck.setDriverName(resultSet.getString("driver_name"));
                trucks.add(truck);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trucks;
    }

    public void deleteTruck(int id) {
        String sql = "DELETE FROM truck WHERE id= ?";
        try (Connection connection = ConnectionDetails.getconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int update = preparedStatement.executeUpdate();
            System.out.println("Row deleted: " + update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

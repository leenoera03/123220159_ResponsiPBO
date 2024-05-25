/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DosenPage;
/**
 *
 * @author DELL
 */

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODosen implements InterfaceDAODosen {

    @Override
    public void insert(dosenpage dosen) {
        try {
            String query = "INSERT INTO dosen (nama, nip) VALUES (?, ?);";
            PreparedStatement statementd = Connector.Connect().prepareStatement(query);
            statementd.setString(1, dosen.getNama());
            statementd.setString(2, dosen.getNo_hp());
            statementd.setString(2, dosen.getEmail());           
            statementd.executeUpdate();
            statementd.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(dosenpage dosen) {
        try {
            String query = "UPDATE dosen SET nama=?, nip=? WHERE id=?;";
            PreparedStatement statementd = Connector.Connect().prepareStatement(query);
            statementd.setString(1, dosen.getNama());
            statementd.setString(2, dosen.getNo_hp());
            statementd.setString(3, dosen.getEmail());            
            statementd.setInt(3, dosen.getId());
            statementd.executeUpdate();
            statementd.close();
        } catch (SQLException e) {
            System.out.println("Update Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM dosen WHERE id=?;";
            PreparedStatement statementd = Connector.Connect().prepareStatement(query);
            statementd.setInt(1, id);
            statementd.executeUpdate();
            statementd.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<dosenpage> getAll() {
        List<dosenpage> listDosen = new ArrayList<>();
        try {
            Statement statementd = Connector.Connect().createStatement();
            String query = "SELECT * FROM dosen;";
            ResultSet resultSet = statementd.executeQuery(query);
            while (resultSet.next()) {
                dosenpage dosen = new dosenpage();
                dosen.setId(resultSet.getInt("id"));
                dosen.setNama(resultSet.getString("nama"));
                dosen.setNo_hp(resultSet.getString("No HP"));
                listDosen.add(dosen);
            }
            statementd.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }
}


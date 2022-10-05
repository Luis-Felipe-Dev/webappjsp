/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.webappjsp.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.isil.webappjsp.user.dao.mysql.MysqlConnection;
import pe.isil.webappjsp.user.model.User;

/**
 *
 * @author S173-559
 */
public class UserDao {

    public int registerUser(User user) throws Exception {
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected = 0;

        String queryInsert = "INSERT INTO USERS(name,lastname,username,pass,tipDoc,nroDoc,enable,email) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(queryInsert);
        ps.setString(1, user.getName());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getUsername());
        ps.setString(4, user.getPass());
        ps.setString(5, user.getTipDoc());
        ps.setString(6, user.getNroDoc());
        ps.setInt(7, user.getEnable());
        ps.setString(8, user.getEmail());

        rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    public int modificarUser(User user) throws Exception {
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected = 0;

        PreparedStatement psSelect = conn.prepareStatement("SELECT nroDoc FROM USERS WHERE nroDoc = ?");
        psSelect.setString(1, user.getNroDoc());
        ResultSet rsSelect = psSelect.executeQuery();

        int contador = 0;
        while (rsSelect.next()) {
            contador++;
        }

        if (contador > 0) {
            String queryUpdate = "UPDATE USERS SET name = ?,lastname = ?,username = ?,pass = ?,enable = ?,email = ? where nroDoc = ?";

            PreparedStatement ps = conn.prepareStatement(queryUpdate);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPass());
            ps.setInt(5, user.getEnable());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getNroDoc());

            System.out.println(ps.toString());
            int rsPreparedStatement = ps.executeUpdate();
            return rsPreparedStatement;
        } else {
            return 0;
        }
    }
}

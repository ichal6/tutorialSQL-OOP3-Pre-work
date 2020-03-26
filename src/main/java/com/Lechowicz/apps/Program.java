package com.Lechowicz.apps;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/test_db";
        String user = "michael";
        String password = "1234";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT VERSION()")) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
                //System.out.println("Sekretnykod");
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Program.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}

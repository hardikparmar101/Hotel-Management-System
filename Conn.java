package hotel.management.system;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    Connection c;
    Statement s;

    Conn() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "ramram1234");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {

    }

}

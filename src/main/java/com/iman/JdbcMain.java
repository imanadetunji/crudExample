package main.java.com.iman;

import main.java.com.iman.jdbc.JdbcHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class JdbcMain {
    Logger logger = LogManager.getLogger(JdbcMain.class);
    public static void main(String[] args) {

        try {
            new JdbcHelper().connectAndPrint();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}




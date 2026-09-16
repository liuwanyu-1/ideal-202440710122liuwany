package org.example.ch5.q1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DB_NAME = "202440710122";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
    private static final String USER = getValue("mysql.user", "MYSQL_USER", "root");
    private static final String PASSWORD = getValue("mysql.password", "MYSQL_PASSWORD", "123456");//这里SQL管理工具不让我设置小于6位的密码

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static String getValue(String propertyName, String envName, String defaultValue) {
        String value = System.getProperty(propertyName);
        if (value != null && value.length() > 0) {
            return value;
        }

        value = System.getenv(envName);
        if (value != null && value.length() > 0) {
            return value;
        }

        return defaultValue;
    }
}

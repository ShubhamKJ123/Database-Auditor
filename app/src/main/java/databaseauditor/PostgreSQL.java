package databaseauditor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;

class PostgreSQL implements Database {
    Dotenv dotenv = Dotenv.load();
    final String jdbcUrl = dotenv.get("POSTGRES_URL");
    final String username = dotenv.get("POSTGRES_USER");
    final String password = dotenv.get("POSTGRES_PASSWORD");
    Connection connectionObj = null;
    Utilities util = new Utilities();

    @Override
    public boolean connect() {
        if (connectionObj != null) {
            return true;
        }

        try {
            connectionObj = DriverManager.getConnection(jdbcUrl, username, password);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void disconnect() {
        if (connectionObj != null) {
            try {
                connectionObj.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public <T> int insertOne(T obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        String columns = "(", values = "(";

        for (Field field : fields) {
            try {
                columns = columns + field.getName().toString() + ", ";
                values = values + "'" + field.get(obj).toString() + "', ";
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return -1;
            } catch (IllegalAccessException e) {
                System.out.println("Error: " + e.getMessage());
                return -1;
            }
        }

        columns = columns.substring(0, columns.length() - 2) + ")";
        values = values.substring(0, values.length() - 2) + ")";
        String sql = "insert into " + util.camelToSnakeCase(
                obj.getClass().getName().split("\\.")[obj.getClass().getName().split("\\.").length - 1]) + " "
                + columns + " values " + values + ";";

        try {
            PreparedStatement stmt = connectionObj.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public <T> int updateMany(T obj, List<List<String>> params) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<String>();
        String updates = "", conditions = "";

        for (Field field : fields) {
            try {
                fieldNames.add(field.getName().toString());
                updates = updates + field.getName().toString() + " = ";
                updates = updates + "'" + field.get(obj).toString() + "', ";
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return -1;
            } catch (IllegalAccessException e) {
                System.out.println("Error: " + e.getMessage());
                return -1;
            }
        }

        for (List<String> param : params) {
            if (fieldNames.contains(param.get(0))) {
                conditions = conditions + " " + param.get(0) + " = ";
                conditions = conditions + "'" + param.get(1) + "' and";
            } else {
                System.out.println("ERROR: Invalid paramater: " + param.get(0));
                return -1;
            }
        }

        updates = updates.substring(0, updates.length() - 2);
        conditions = conditions.substring(0, conditions.length() - 4);
        String sql = "update " + util.camelToSnakeCase(
                obj.getClass().getName().split("\\.")[obj.getClass().getName().split("\\.").length - 1]) + " set "
                + updates + " where" + conditions + ";";

        try {
            PreparedStatement stmt = connectionObj.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public <T> int deleteMany(T obj, List<List<String>> params) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<String>();
        String conditions = "";

        for (Field field : fields) {
            try {
                fieldNames.add(field.getName().toString());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return -1;
            }
        }

        for (List<String> param : params) {
            if (fieldNames.contains(param.get(0))) {
                conditions = conditions + " " + param.get(0) + " = ";
                conditions = conditions + "'" + param.get(1) + "' and";
            } else {
                System.out.println("ERROR: Invalid paramater: " + param.get(0));
                return -1;
            }
        }

        conditions = conditions.substring(0, conditions.length() - 4);
        String sql = "delete from " + util.camelToSnakeCase(
                obj.getClass().getName().split("\\.")[obj.getClass().getName().split("\\.").length - 1]) + " where"
                + conditions + ";";

        try {
            PreparedStatement stmt = connectionObj.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
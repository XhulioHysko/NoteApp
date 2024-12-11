import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestApp {
    public Map<String, List<String>> executeQuery(String query, String queryType) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mobile_app";
        String user = "root";
        String password = "12345678";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<String> notes = new ArrayList<>();
        List<String> sda_notes = new ArrayList<>();
        List<String> laconics_notes = new ArrayList<>();
        List<String> users_data = new ArrayList<>();
        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute SQL query
            if (queryType.equals("insert")) {
                statement.executeUpdate(query);
            }

            if (queryType.equals("select")) {
                resultSet = statement.executeQuery(query);

                // 4. Process the result set
                while (resultSet.next()) {
                    if(query.equals("select * from notes")){
                        notes.add(resultSet.getString("name"));
                    }
                    if(query.equals("select * from sda_notes")){
                        sda_notes.add(resultSet.getString("name"));
                    }
                    if (query.equals("select * from laconics_notes")){
                        laconics_notes.add(resultSet.getString("name"));
                    }
                    if (query.equals("select * from users_data")){
                        users_data.add(resultSet.getString("full_name"));
                        users_data.add(resultSet.getString("password"));
                        users_data.add(resultSet.getString("gender"));
                        users_data.add(resultSet.getString("date_of_birth"));
                        users_data.add(resultSet.getString("address"));
                        users_data.add(resultSet.getString("email"));
                    };
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        Map<String, List<String>> response = new HashMap<>();
        response.put("notes", notes);
        response.put("sda_notes", sda_notes);
        response.put("laconics_notes", laconics_notes);
        response.put("users_data", users_data);

        return response;
    }

    public void SignUp(String fullName, String password, String gender, String dob,
                       String address, String email) {
        String insertUserQuery = "INSERT INTO users_data (full_name, password, gender, date_of_birth, address, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_app",
                "root", "12345678");
             PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {

            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, dob);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, email);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean validateCredentials(String fullName, String password) {
        String url = "jdbc:mysql://localhost:3306/mobile_app";
        String user = "root";
        String dbPassword = "12345678";

        try (Connection connection = DriverManager.getConnection(url, user, dbPassword)) {
            String query = "SELECT * FROM users_data WHERE full_name = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
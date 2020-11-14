package warsztat;

import entity.User;

import java.sql.*;

public class UserDao {
    private static final String CREATE_USER_QUERY =                         //Zapytanie tworzące użytkownika:
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

    //Zapytanie wczytujące wszystkie dane użytkownika dla zadanego identyfikatora:
    private static final String READ_USER_QUERY =
            "SELECT * FROM users where id = ?";

    //Zapytanie służące do edycji danych użytkownika:
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? where id = ?";

    //Zapytanie, dzięki któremu pobierzemy informacje o wszystkich użytkownikach z bazy danych.

    private static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users";

    public UserDao(Object user) {

    }


    public User create(User user) {
        try (Connection connection = DBUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

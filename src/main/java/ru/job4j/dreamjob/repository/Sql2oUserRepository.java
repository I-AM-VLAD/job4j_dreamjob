package ru.job4j.dreamjob.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.dreamjob.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Repository
public class Sql2oUserRepository implements UserRepository {

    private final Sql2o sql2o;
    private static final Logger LOGGER = LoggerFactory.getLogger(Sql2oUserRepository.class);

    public Sql2oUserRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<User> save(User user) {
        try (var connection = sql2o.open()) {
                var sql = "INSERT INTO users(email, name, password) "
                        + "VALUES (:email, :name, :password)";
                var query = connection.createQuery(sql, true)
                        .addParameter("email", user.getEmail())
                        .addParameter("name", user.getName())
                        .addParameter("password", user.getPassword());
                int generatedId = query.executeUpdate().getKey(Integer.class);
                user.setId(generatedId);
            return Optional.of(user);
        } catch (Exception e) {
            LOGGER.error("Ошибка", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM users WHERE email = :email AND password = :password");
            query.addParameter("email", email);
            query.addParameter("password", password);
            var user = query.executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);
        }
    }
}

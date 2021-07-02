package dmk.resolver.query;

import dmk.model.User;
import dmk.repository.UserRepository;
import dmk.stub.UserStub;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Component
public class UserResolver implements GraphQLQueryResolver {
    Logger logger = LoggerFactory.getLogger(UserResolver.class);

    @Autowired
    UserRepository userRepository;

    public User testUserById(UUID id) {
        logger.info(format("query user with id: %s", id));
        var user = UserStub.genUser("testuser1");
        user.setUserId(id);
        return user;
    }

    public List<User> testUsersWithName(String first) {
        logger.info(format("query user with name: %s", first));
        return UserStub.genUsers();
    }

    public User userById(UUID id) {
        logger.info(format("query user with id: %s", id));
        var user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> usersWithName(String first) {
        logger.info(format("query user with name: %s", first));
        return userRepository.findByFirst(first);
    }

    public long countUsersWithName(String first) {
        logger.info(format("count user(s) with name: %s", first));
        return userRepository.countByFirst(first);
    }
}

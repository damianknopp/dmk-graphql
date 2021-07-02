package dmk.stub;

import dmk.model.User;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;

public class UserStub {

    public static List<User> genUsers() {
        return asList(genUser("test1"), genUser("test2"));
    }

    public static User genUser(String first) {
        final var user = new User();
        user.setUserId(randomUUID());
        user.setFirst(first);
        user.setLast("user");
        return user;
    }
}

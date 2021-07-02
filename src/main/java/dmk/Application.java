package dmk;


import dmk.repository.UserRepository;
import dmk.stub.AttributeStub;
import dmk.stub.UserStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

import static java.util.Arrays.sort;

@ComponentScan("dmk")
@SpringBootApplication
public class Application {
    static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(dmk.Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            printBeans(context);
            UserRepository userRepository = (UserRepository) context.getBean("userRepository");
//            createTestData(userRepository);
        };
    }

    public void printBeans(ApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        sort(beanNames);
        if (logger.isTraceEnabled()) {
            Stream.of(beanNames).forEach(logger::trace);
        }

    }

    public void createTestData(UserRepository userRepository) {
        logger.info("cleaning test users");
        userRepository.deleteAll();
        var users = UserStub.genUsers();
        users.forEach(user -> user.setAttributes(AttributeStub.genAttributes()));
        logger.info("saving {} test users to db", users.size());
        userRepository.saveAll(users);
    }

}
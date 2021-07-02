package dmk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationLifecycleListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger
            = LoggerFactory.getLogger(ApplicationLifecycleListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (logger.isInfoEnabled()) {
            logger.info("lifecycle changed {}", event);
        }
    }
}

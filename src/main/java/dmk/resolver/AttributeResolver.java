package dmk.resolver;

import dmk.model.Attribute;
import dmk.model.User;
import dmk.repository.AttributeRepository;
import dmk.stub.AttributeStub;
import graphql.kickstart.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.StreamSupport.stream;

@Component
public class AttributeResolver implements GraphQLResolver<User> {
    Logger logger = LoggerFactory.getLogger(AttributeResolver.class);

    @Autowired
    AttributeRepository attributeRepository;

    public Set<Attribute> testAttributes(User user) {
        logger.info(format("query attribute for user: %s", user.getUserId()));
        return AttributeStub.genAttributes();
    }

    /**
     * NOTE: using spring data jdbc with not lazy load on attributes will supply this
     * method with a fully populated attributes list already, making this resolver unnecessary
     * <p>
     * TODO: look into lazy loading attributes
     *
     * @param user
     * @return
     */
    public Set<Attribute> attributes(User user) {
        logger.info(format("query attribute for user: %s", user.getUserId()));
        if (isNull(user.getAttributes()) || user.getAttributes().isEmpty()) {
            logger.info("user attribute ids are empty, generating test attribute data!");
            return testAttributes(user);
        }

        Set<UUID> ids = user.getAttributes().stream().map(Attribute::getAttributeId).collect(toSet());
        if (logger.isDebugEnabled()) {
            var numIds = ids.size();
            var limit = Math.min(numIds, 4);
            var idList = ids.stream().limit(limit).map(UUID::toString).collect(toSet());
            logger.debug("found {} attribute ids: {}", ids.size(), idList);
            logger.debug("user: {}", user);
        }
        Iterable<Attribute> iterable = attributeRepository.findAllById(ids);
        return stream(iterable.spliterator(), false).collect(toSet());
    }

}

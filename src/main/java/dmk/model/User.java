package dmk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static java.lang.String.format;

@Table("USERS")
public class User {
    @Id()
    UUID userId;
    String first;
    String last;
    @MappedCollection(keyColumn = "USER_ID", idColumn = "USER_ID")
    Set<Attribute> attributes;

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User rhs = (User) o;
        return Objects.equals(userId, rhs.getUserId())
                && Objects.equals(first, rhs.getFirst())
                && Objects.equals(last, rhs.getLast())
                && Objects.equals(attributes, rhs.getAttributes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, first, last, attributes);
    }

    public String toString() {
        return format("uuid: %s, first: %s, last: %s attributes: %s", userId, first, last, attributes);
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID id) {
        this.userId = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }
}

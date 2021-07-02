package dmk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

import static java.lang.String.format;

@Table("ATTRIBUTES")
public class Attribute {
    @Id
    UUID attributeId;
    String role;

    @Override
    public String toString() {
        return format("id: %s, role: %s", attributeId, role);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Attribute)) {
            return false;
        }
        Attribute rhs = (Attribute) o;
        return Objects.equals(attributeId, rhs.getAttributeId())
                && Objects.equals(role, rhs.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributeId, role);
    }

    public UUID getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(UUID attributeId) {
        this.attributeId = attributeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
package dmk.stub;

import dmk.model.Attribute;

import java.util.Set;

import static java.util.UUID.randomUUID;

public class AttributeStub {

    public static Set<Attribute> genAttributes() {
        return Set.of(genAttribute("role1"), genAttribute("role2"));
    }

    public static Attribute genAttribute(String role) {
        var attribute = new Attribute();
        attribute.setAttributeId(randomUUID());
        attribute.setRole(role);
        return attribute;
    }
}

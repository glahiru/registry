package registry.models;

import javax.annotation.processing.Generated;
import java.util.List;

public class Person {
    private final Id id;
    private final Name name;
    int age;
    private final Name spouse;
    private final List<Child> children;

    private Person(Id id, Name name, Name spouse, List<Child> children) {
    this.id = id;
        this.name = name;
        this.spouse = spouse;
        this.children = children;
    }

    public static IdStep newInstance() {
    return new Builder();
    }

    public Name getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Name getSpouse() {
        return spouse;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Id getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", spouse=" + spouse +
                ", children=" + children +
                '}';
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface IdStep {  NameStep id(Id id);
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface NameStep {  SpouseStep name(Name name);
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface SpouseStep {  ChildrenStep spouse(Name spouse);
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface ChildrenStep {  FinalStep children(List<Child> children);
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface FinalStep {  Person build(); FinalStep age(int age);
    }

    @Generated(value = "Step Builder Generator Plugin")
    private static final class Builder implements IdStep, NameStep, SpouseStep, ChildrenStep, FinalStep { private Id id;
        private Name name;
        private Name spouse;
        private List<Child> children;
        private int age;

        public NameStep id(Id id) { this.id = id; return this; }

        public SpouseStep name(Name name) { this.name = name; return this; }

        public ChildrenStep spouse(Name spouse) { this.spouse = spouse; return this; }

        public FinalStep children(List<Child> children) { this.children = children; return this; }

        public FinalStep age(int age) { this.age = age; return this; }

        public Person build() {
    Person theObject = new Person(id, name, spouse, children);
            theObject.age = age;
            return theObject;
        }
    }
}
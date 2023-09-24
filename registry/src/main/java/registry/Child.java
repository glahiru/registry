package registry;

import javax.annotation.processing.Generated;

public class Child {
    Name name;
    int age;

    private Child() {
    }

    public static FinalStep newInstance() {
    return new Builder();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
@Generated(value = "Step Builder Generator Plugin")
public interface FinalStep {  Child build(); FinalStep name(Name name); FinalStep age(int age);
}

    @Generated(value = "Step Builder Generator Plugin")
    private static final class Builder implements FinalStep { private Name name;
        private int age;

        public FinalStep name(Name name) { this.name = name; return this; }

        public FinalStep age(int age) { this.age = age; return this; }

        public Child build() {
    Child theObject = new Child();
            theObject.name = name;
            theObject.age = age;
            return theObject;
        }
    }
}

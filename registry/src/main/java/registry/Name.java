package registry;

import javax.annotation.processing.Generated;

public class Name {
    private final String firstName;
    private final String lastName;

    private Name(String firstName, String lastName) {
    this.firstName = firstName;
        this.lastName = lastName;
    }

    public static FirstNameStep newInstance() {
    return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
@Generated(value = "Step Builder Generator Plugin")
public interface FirstNameStep {  LastNameStep firstName(String firstName);
}

    @Generated(value = "Step Builder Generator Plugin")
    public interface LastNameStep {  FinalStep lastName(String lastName);
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface FinalStep {  Name build();
    }

    @Generated(value = "Step Builder Generator Plugin")
    private static final class Builder implements FirstNameStep, LastNameStep, FinalStep { private String firstName;
        private String lastName;

        public LastNameStep firstName(String firstName) { this.firstName = firstName; return this; }

        public FinalStep lastName(String lastName) { this.lastName = lastName; return this; }

        public Name build() {
    Name theObject = new Name(firstName, lastName);
            return theObject;
        }
    }
}

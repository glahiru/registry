package registry.models;

import javax.annotation.processing.Generated;

public class Id {
    private final String socialSecurityNumber;

    private Id(String socialSecurityNumber) {
    this.socialSecurityNumber = socialSecurityNumber;
    }

    public static SocialSecurityNumberStep newInstance() {
    return new Builder();
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public String toString() {
        return "Id{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                '}';
    }

@Generated(value = "Step Builder Generator Plugin")
public interface SocialSecurityNumberStep {  FinalStep socialSecurityNumber(String socialSecurityNumber);
}

    @Generated(value = "Step Builder Generator Plugin")
    public interface FinalStep {  Id build();
    }

    @Generated(value = "Step Builder Generator Plugin")
    private static final class Builder implements SocialSecurityNumberStep, FinalStep { private String socialSecurityNumber;

        public FinalStep socialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; return this; }

        public Id build() {
    Id theObject = new Id(socialSecurityNumber);
            return theObject;
        }
    }
}

package registry;

import registry.models.Id;
import registry.models.Name;

import javax.annotation.processing.Generated;
import java.util.Optional;

public class OldestChildResponse {
    private final Optional<Name> name;
    private final Id parentId;


private OldestChildResponse(Optional<Name> name, Id parentId) {
    this.name = name;
    this.parentId = parentId;
}

    public static NameStep newInstance() {
    return new Builder();
    }

    public Optional<Name> getName() {
    return name;
    }

    public Id getParentId() {
    return parentId;
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface NameStep {  ParentIdStep name(Optional<Name> name);
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface ParentIdStep {  FinalStep parentId(Id parentId);
    }

    @Generated(value = "Step Builder Generator Plugin")
    public interface FinalStep {  OldestChildResponse build();
    }

    @Generated(value = "Step Builder Generator Plugin")
    private static final class Builder implements NameStep, ParentIdStep, FinalStep { private Optional<Name> name;
        private Id parentId;

        public ParentIdStep name(Optional<Name> name) { this.name = name; return this; }

        public FinalStep parentId(Id parentId) { this.parentId = parentId; return this; }

        public OldestChildResponse build() {
    OldestChildResponse theObject = new OldestChildResponse(name, parentId);
            return theObject;
        }
    }
}

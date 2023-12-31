package util;

import registry.models.Child;

import java.util.List;
import java.util.Optional;

public class ChildUtil {
    public static Optional<Child> getOldestChild(List<Child> children) {
        Child oldest = null;
        for (Child child : children) {
            if (oldest == null) {
                oldest = child;
            } else if (child.getAge() > oldest.getAge()) {
                oldest = child;
            }
        }
        return Optional.ofNullable(oldest);
    }
}

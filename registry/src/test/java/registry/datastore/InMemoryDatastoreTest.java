package registry.datastore;

import datastore.InvalidPersonException;
import datastore.InMemoryDatastore;
import org.junit.Before;
import org.junit.Test;
import registry.models.Child;
import registry.models.Id;
import registry.models.Name;
import registry.models.Person;

import static org.junit.Assert.assertThrows;

public class InMemoryDatastoreTest {
    public static final Name NAME_1 = Name.newInstance().firstName("Lahiru").lastName("G").build();
    public static final Name NAME_SPOUSE = Name.newInstance().firstName("Lahiru").lastName("G").build();
    public static final Name NAME_CHILD_1 = Name.newInstance().firstName("Child").lastName("G").build();
    public static final Child CHILD_1 = Child.newInstance().name(NAME_CHILD_1).age(2).build();

    public static final Id INVALID_ID_START = Id.newInstance().socialSecurityNumber("000-232-3232").build();

    private InMemoryDatastore datastore;

    @Before
    public void setUp() throws Exception {
        datastore = new InMemoryDatastore();
    }

    // Needs to add more test cases to validate.
    @Test
    public void invalidIdTest() {
        // Datastore tests can be used to assert proper exceptions.
        assertThrows(InvalidPersonException.class, () ->
                datastore.addPerson(Person.newInstance().id(INVALID_ID_START)
                .name(NAME_1)
                .spouse(NAME_SPOUSE)
                .children(java.util.List.of(CHILD_1))
                .build()));
    }
    // TODO(glahiru): Add more tests.
}

package test.registry;

import org.junit.Before;
import org.junit.Test;
import registry.*;

import java.util.Optional;

import static org.junit.Assert.*;

public class PeopleServiceTest {
    public static final Name NAME_1 = Name.newInstance().firstName("Lahiru").lastName("G").build();
    public static final Name NAME_SPOUSE = Name.newInstance().firstName("Lahiru").lastName("G").build();
    public static final Name NAME_CHILD_1 = Name.newInstance().firstName("Child").lastName("G").build();
    public static final Name NAME_CHILD_OLDEST = Name.newInstance().firstName("Child2").lastName("G").build();
    public static final Child CHILD_1 = Child.newInstance().name(NAME_CHILD_1).age(2).build();
    public static final Child CHILD_OLDEST = Child.newInstance().name(NAME_CHILD_OLDEST).age(3).build();

    public static final Id ID_1 = Id.newInstance().socialSecurityNumber("745-23-3232").build();

    public static final Id INVALID_ID_START = Id.newInstance().socialSecurityNumber("000-232-3232").build();

    public static final Person BASE_PERSON =
            Person.newInstance().id(ID_1).name(NAME_1).spouse(NAME_SPOUSE).children(java.util.List.of(CHILD_1)).build();
    private PeopleService peopleService = null;

    @Before
    public void setUp() throws Exception {
        peopleService = PeopleService.createInMemoryService();
    }

    // Needs to add more test cases to validate.
    @Test
    public void invalidIdTest() {
        // Datastore tests can be used to assert proper exceptions.
        assertFalse(peopleService.addPerson(Person.newInstance().id(INVALID_ID_START)
                .name(NAME_1)
                .spouse(NAME_SPOUSE)
                .children(java.util.List.of(CHILD_1))
                .build()));
    }

    @Test
    public void addPersonTest() {
        assertTrue(peopleService.addPerson(BASE_PERSON));
    }

    @Test
    public void getPersonTest() throws Exception {
        assertTrue(peopleService.addPerson(BASE_PERSON));

        Optional<Person> person = peopleService.getPerson(ID_1);

        assertTrue(person.isPresent());
        assertEquals(BASE_PERSON, person.get());
    }

    @Test
    public void failToAddWithSameIdTest() throws Exception {
        assertTrue(peopleService.addPerson(BASE_PERSON));

        assertFalse(peopleService.addPerson(Person.newInstance().id(ID_1)
                .name(NAME_1).spouse(NAME_SPOUSE).children(java.util.List.of(CHILD_1, CHILD_OLDEST)).build()));

        Optional<Person> person = peopleService.getPerson(ID_1);

        assertTrue(person.isPresent());
        // asserts that still returns the originally stored person
        assertEquals(BASE_PERSON, person.get());
    }

    @Test
    public void getOldestChildTestValid() throws Exception {
        assertTrue(peopleService.addPerson(Person.newInstance().id(ID_1)
                .name(NAME_1).spouse(NAME_SPOUSE).children(java.util.List.of(CHILD_1, CHILD_OLDEST)).build()));

        OldestChildResponse oldest = peopleService.getOldest(ID_1);

        assertTrue(oldest.getName().isPresent());
        assertEquals(NAME_CHILD_OLDEST, oldest.getName().get());
        assertEquals(ID_1, oldest.getParentId());
    }

    @Test
    public void getOldestChildWhenNoChildrenTest() throws Exception {
        assertTrue(peopleService.addPerson(Person.newInstance().id(ID_1)
                .name(NAME_1).spouse(NAME_SPOUSE).children(java.util.List.of()).build()));

        OldestChildResponse oldest = peopleService.getOldest(ID_1);

        assertTrue(oldest.getName().isEmpty());
        assertEquals(ID_1, oldest.getParentId());
    }
}

package registry;

import datastore.*;
import datastore.InMemoryDatastore;
import registry.models.Id;
import registry.models.Person;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * Implementation of the People Service which uses an in memory storage.
 */
public class PeopleService {
    static final Logger logger = Logger.getLogger(PeopleService.class.getName());
    private final Datastore datastore;

    private PeopleService(Datastore datastore) {
        this.datastore = datastore;
    }

    public static PeopleService createInMemoryService() {
        return new PeopleService(new InMemoryDatastore());
    }

    public boolean addPerson(Person person) throws InvalidPersonException, RecordExistException {
        return this.datastore.addPerson(person);
    }

    // TODO(glahiru): Implement the update operation.
    public boolean updatePerson(Person person) {
        throw new UnsupportedOperationException();
    }

    public Optional<Person> getPerson(Id id) throws InvalidIdException {
        return this.datastore.getPerson(id);
    }

    public OldestChildResponse getOldest(Id id) throws NoChildException, InvalidIdException {
        return OldestChildResponse.newInstance().name(this.datastore.getOldestChild(id)).parentId(id).build();
    }

}

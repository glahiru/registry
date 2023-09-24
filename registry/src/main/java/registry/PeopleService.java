package registry;

import datastore.*;
import datastore.impl.InMemoryDatastore;

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

    // TODO(glahiru): If updates are supported, it can be implemented separate.
    public boolean addPerson(Person person) {
        try {
            return this.datastore.addPerson(person);
        } catch (InvalidPersonException | RecordExistException e) {
            logger.severe(String.format("Failed to add the person given: %s", person.toString()));
        }
        return false;
    }

    public Optional<Person> getPerson(Id id) throws InvalidIdException {
        return this.datastore.getPerson(id);
    }

    public OldestChildResponse getOldest(Id id) throws NoChildException, InvalidIdException {
        return OldestChildResponse.newInstance().name(this.datastore.getOldestChild(id)).parentId(id).build();
    }
}

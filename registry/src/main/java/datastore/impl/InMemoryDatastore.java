package datastore.impl;

import datastore.*;
import registry.Child;
import registry.Id;
import registry.Name;
import registry.Person;
import util.ChildUtil;
import util.Validator;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In memory implementation for Datastore. This will keep all the data in memory and
 * all the data will be destroyed during a restart of the server.
 */
public class InMemoryDatastore implements Datastore {
    private final Map<Id, Person> registry = new ConcurrentHashMap<>();
    // We duplicate data here because the number of Persons are low but this map would allow us to
    // query the oldest child quickly.
    private final Map<Id, Child> oldestChild = new ConcurrentHashMap<>();

    // TODO(glahiru): More validation logics needed to be implemented.
    @Override
    public Optional<Person> getPerson(Id id) throws InvalidIdException {
        if (!Validator.isValid(id)) {
            throw new InvalidIdException();
        }
        return registry.containsKey(id) ? Optional.of(registry.get(id)) : Optional.empty();
    }

    // This
    @Override
    public boolean addPerson(Person person) throws InvalidPersonException, RecordExistException {
        if (!Validator.isValid(person.getId())) {
            throw new InvalidPersonException();
        }

        if (registry.containsKey(person.getId())) {
            throw new RecordExistException();
        }
        registry.put(person.getId(), person);

        if (oldestChild.containsKey(person.getId())) {
            throw new RuntimeException("Data is inconsistent, child exist but no parent.");
        }

        Optional<Child> oldest = ChildUtil.getOldestChild(person.getChildren());
        oldest.ifPresent(child -> oldestChild.put(person.getId(), child));
        return true;
    }

    @Override
    public Optional<Name> getOldestChild(Id id) throws NoChildException, InvalidIdException {
        return oldestChild.containsKey(id) ? Optional.of(oldestChild.get(id).getName()) : Optional.empty();
    }
}

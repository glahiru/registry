package datastore;

import registry.models.Id;
import registry.models.Name;
import registry.models.Person;

import java.util.Optional;

public interface Datastore {
    /**
     * Adds a person to the registry.
     * @param person Person to register.
     * @return returns true if the adding is successful otherwise returns false.
     */
    boolean addPerson(Person person) throws InvalidPersonException, RecordExistException;

    /**
     * @param id of the person to query.
     * @return a person if exists in the store with the given id, else returns Empty.
     * @throws InvalidIdException when the given id is invalid.
     */
    Optional<Person> getPerson(Id id) throws InvalidIdException;

    /**
     * Returns person's oldest child if any children, otherwise return an empty.
     * @param id person's id to query the oldest child.
     * @return name of the oldest child.
     * @throws NoChildException
     * @throws InvalidIdException
     */
    Optional<Name> getOldestChild(Id id) throws NoChildException, InvalidIdException;
}

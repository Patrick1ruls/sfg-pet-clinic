package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if(object  != null) { // Make sure object is not null
            if(object.getId()  == null) { // Try to get objects id.
                object.setId(getNextId()); // But if objects id is null grab the next id (ex: if last id was 3L. Next id would be 4L)
            }
            map.put(object.getId(), object);
        } else {  // If object is null
            throw new RuntimeException("Object cannot be null"); // Fail gracefully
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;

        try { // Check if there is an id value in the map
            nextId = Collections.max(map.keySet()) +  1; // If there is a value in the map, then code will add 1L to it
        } catch (NoSuchElementException e) {
            nextId = 1L; // If there is no id value in the map, then initalize with value of 1L
        }

        return nextId;
    }
}

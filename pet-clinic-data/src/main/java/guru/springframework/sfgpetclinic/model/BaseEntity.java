package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

/**
 * Ensures that all models that extend this class bus have an id.
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package springframework.petclinic.model;

/**
 * Created by revin on 15.02.2019.
 */
public class Specialty extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

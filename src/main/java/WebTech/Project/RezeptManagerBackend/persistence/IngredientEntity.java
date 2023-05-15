package WebTech.Project.RezeptManagerBackend.persistence;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "ingredient")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    @NotBlank(message = "the name must not be empty")
    @Size(min = 3, max = 30, message = "please provide a name between 3 and 30 characters ")
    private String name;
    @Column(name = "vegetarian")
    @NotNull
    private boolean vegetarian;
    @Column(name = "vegan")
    @NotNull
    private boolean vegan;


    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public boolean isVegetarian() {return vegetarian;}

    public void setVegetarian(boolean vegetarian) {
        if (!vegetarian) {this.setVegan(false);}
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {return vegan;}

    public void setVegan(boolean vegan) {
        if (vegan) {this.setVegetarian(true);}
        this.vegan = vegan;
    }

    public IngredientEntity(Long id, String name, boolean vegetarian, boolean vegan) {
        this.id = id;
        this.name = name;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    public IngredientEntity() {
    }

    @Override
    public String toString() {
        return "IngredientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                '}';
    }
}

package zhy2002.moneytracker.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * An item (good or service) that can be purchased.
 */
@Entity
public class Merchandise {

    private Long id;
    private String name;
    private Category category;
    private Boolean integerQuantity;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 1, max = 128)
    @Column(length = 128, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return True if the quantity of this merchandise must be an integer; e.g. mobile phone.
     */
    @NotNull
    @Column(nullable = false)
    public Boolean getIntegerQuantity() {
        return integerQuantity;
    }

    public void setIntegerQuantity(Boolean integerQuantity) {
        this.integerQuantity = integerQuantity;
    }
}

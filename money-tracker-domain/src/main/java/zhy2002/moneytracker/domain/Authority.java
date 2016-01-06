package zhy2002.moneytracker.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Authorities of a spring security user.
 */
@Entity
public class Authority {

    private Long id;
    private User user;
    private String value;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NotNull
    @Size(min = 1, max = 32)
    @Column(length = 32, nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority1 = (Authority) o;
        return Objects.equals(getUser(), authority1.getUser()) && Objects.equals(getValue(), authority1.getValue());
    }

    @Override
    public int hashCode() {
        int result = getUser().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }
}

package zhy2002.moneytracker.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * A budget amount for a category or a user.
 */
@Entity
public class Budget {

    private Long id;
    private BigDecimal amount;
    private Period period;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(nullable = false)
    @DecimalMin(value = "0")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @NotNull
    @OneToOne(optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false, unique = true, updatable = false)
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }
}

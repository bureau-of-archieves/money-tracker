package zhy2002.moneytracker.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * An expenditure record.
 */
@Entity
public class Expenditure {

    private Long id;
    private Account account;
    private BigDecimal amount;
    private Merchandise merchandise;
    private BigDecimal quantity = BigDecimal.ONE;
    private LocalDateTime dateTime = LocalDateTime.now();
    private Location location;
    private Period paybackPeriod;
    private Period recurringPeriod;
    private Boolean paidUpfront = true;
    private String description;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    public Period getRecurringPeriod() {
        return recurringPeriod;
    }

    public void setRecurringPeriod(Period recurringPeriod) {
        this.recurringPeriod = recurringPeriod;
    }

    @NotNull
    @Column(nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST})
    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    @NotNull
    @Column(nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @OneToOne
    public Period getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(Period paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }

    @NotNull
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @NotNull
    @Column(nullable = false)
    public Boolean getPaidUpfront() {
        return paidUpfront;
    }

    public void setPaidUpfront(Boolean paidUpfront) {
        this.paidUpfront = paidUpfront;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

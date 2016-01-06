package zhy2002.moneytracker.domain;

import zhy2002.moneytracker.domain.type.PeriodGranularity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Defines a period.
 */
@Entity
public class Period {

    private Long id;
    private PeriodGranularity granularity = PeriodGranularity.Month;
    private LocalDate startDate = LocalDate.now();
    private Integer multiplier = 1;
    private Integer repeatCount = 1;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public PeriodGranularity getGranularity() {
        return granularity;
    }

    public void setGranularity(PeriodGranularity granularity) {
        this.granularity = granularity;
    }

    @NotNull
    @Column(nullable = false)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @NotNull
    @Column(nullable = false)
    @Min(value = 1)
    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }

    @NotNull
    @Column(nullable = false)
    @Min(value = 0) //repeatCount = 0 means infinite
    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }
}

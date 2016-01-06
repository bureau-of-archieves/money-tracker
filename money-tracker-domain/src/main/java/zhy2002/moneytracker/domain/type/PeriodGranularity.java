package zhy2002.moneytracker.domain.type;

/**
 * Created by JOHNZ on 6/01/2016.
 */
public enum  PeriodGranularity {

    Day,
    Month;

    public enum Alias {

        Daily,
        Weekly,
        Fortnightly,
        Monthly,
        Quarterly,
        HalfYearly,
        Yearly
    }
}

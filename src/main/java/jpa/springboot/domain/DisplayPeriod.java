package jpa.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jpa.springboot.support.LocalDatePersistenceConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author omwomw@sk.com
 *         created on 16. 5. 23.
 */
@Embeddable
public class DisplayPeriod {

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "start_date")
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate startDate;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "end_date")
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate endDate;

    public DisplayPeriod() {
    }

    public DisplayPeriod(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isInDisplayPeriod(LocalDate baseDate) {
        return (baseDate.isEqual(startDate) || baseDate.isAfter(startDate))
                && (baseDate.isBefore(endDate) || baseDate.isEqual(endDate));
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisplayPeriod that = (DisplayPeriod) o;

        if (!startDate.equals(that.startDate)) return false;
        return endDate.equals(that.endDate);

    }

    @Override
    public String toString() {
        return "DisplayPeriod{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

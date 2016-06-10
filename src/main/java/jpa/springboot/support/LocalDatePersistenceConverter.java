package jpa.springboot.support;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author omwomw@sk.com
 *         created on 16. 5. 31.
 */
@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate entityValue) {

        return Date.from(entityValue.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public LocalDate convertToEntityAttribute(Date databaseValue) {
        return Instant.ofEpochMilli(databaseValue.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

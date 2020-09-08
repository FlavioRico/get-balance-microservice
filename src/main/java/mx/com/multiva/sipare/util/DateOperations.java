package mx.com.multiva.sipare.util;

import mx.com.multiva.sipare.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.StreamSupport;

@Component
public class DateOperations {

    @Autowired
    private HolidaysRepository holidaysRepository;

    public Date fromLocalDate(LocalDate localDate) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public LocalDate toLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Date addBusinessDays(Date date, int businessDays) {
        return fromLocalDate(addBusinessDays(toLocalDate(date), businessDays));
    }

    public Date subtractBusinessDays(Date date, int businessDays) {
        return fromLocalDate(subtractBusinessDays(toLocalDate(date),businessDays));
    }


    public LocalDate addBusinessDays(LocalDate localDate, int businessDays) {
        if (businessDays > 0) {

            do {
                localDate = localDate.plusDays(1);

                if (!isBusinessDay(localDate)){
                    localDate = addBusinessDays(localDate, 1);
                }

            } while (--businessDays != 0);

            return localDate;
        } else if (businessDays < 0)
            return subtractBusinessDays(localDate, (businessDays * -1));
        else
            return localDate;
    }

    public LocalDate subtractBusinessDays(LocalDate localDate, int businessDays){
        if (businessDays > 0) {

            do {
                localDate = localDate.minusDays(1);

                if (!isBusinessDay(localDate)){
                    localDate = subtractBusinessDays(localDate, 1);
                }

            } while (--businessDays != 0);

            return localDate;
        } else if (businessDays < 0)
            return addBusinessDays(localDate, (businessDays * -1));
        else
            return localDate;
    }

    public boolean isBusinessDay(Date date){
        LocalDate localDate = toLocalDate(date);
        return isBusinessDay(localDate);
    }

    public boolean isBusinessDay(LocalDate localDate){
        if(localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY)
            return false;
        else {

            return !StreamSupport.stream(
                    holidaysRepository.findAll().spliterator(), false)
                    .anyMatch(fromLocalDate(localDate)::equals);
        }
    }

    public Date todayDate() {
        return fromLocalDate(LocalDate.now());
    }

    //Only for testing purposes
    public Date parse(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            return todayDate();
        }
    }

    public String formatDate(Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                .withZone(ZoneId.systemDefault());

        return toLocalDate(date).format(formatter);

    }

    public String formatDateFile(Date date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
                .withZone(ZoneId.systemDefault());

        return toLocalDate(date).format(formatter);

    }
}


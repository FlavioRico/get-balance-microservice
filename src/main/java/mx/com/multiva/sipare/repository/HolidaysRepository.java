package mx.com.multiva.sipare.repository;

import mx.com.multiva.sipare.model.entity.Holidays;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface HolidaysRepository extends CrudRepository<Holidays, Date> {
}

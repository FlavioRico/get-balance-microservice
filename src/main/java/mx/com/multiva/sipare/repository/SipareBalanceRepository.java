package mx.com.multiva.sipare.repository;

import mx.com.multiva.sipare.model.entity.SipareBalance;
import org.springframework.data.repository.Repository;

public interface SipareBalanceRepository extends Repository<SipareBalance, Integer> {

    SipareBalance findByDispatchDateAndType(String date, String type);
}

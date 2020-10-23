package mx.com.multiva.sipare.repository;

import mx.com.multiva.sipare.model.entity.SipareContentFileT24;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SipareContentFileT24Repository
        extends CrudRepository<SipareContentFileT24,Integer> {

    @Query(value = "select SUM (importRCV) " +
            "from tb_sipare_content_file_t24 " +
            "where dateIMSSACV = ?1",
            nativeQuery = true)
    public BigDecimal getTotalRcv(String date);

    @Query(value = "select SUM " +
            "(importIMSS + importACV + importVivienda) " +
            "from tb_sipare_content_file_t24 " +
            "where dateIMSSACV = ?1",
            nativeQuery = true)
    public BigDecimal getTotalAcv(String date);
}

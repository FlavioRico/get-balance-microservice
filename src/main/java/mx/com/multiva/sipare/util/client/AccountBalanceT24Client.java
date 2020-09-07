package mx.com.multiva.sipare.util.client;

import mx.com.multiva.sipare.model.util.AccountBalanceT24;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://10.160.14.213:8083", name = "accountBalanceT24")
public interface AccountBalanceT24Client {

    @PostMapping("/sipareMSProcessFileApp/multiva/sipare/getAccountBalanceT24")
    AccountBalanceT24 getAccAccountBalanceT24();

}

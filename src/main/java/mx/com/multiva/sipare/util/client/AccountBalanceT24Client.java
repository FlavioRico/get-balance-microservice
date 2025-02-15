package mx.com.multiva.sipare.util.client;

import mx.com.multiva.sipare.model.request.AccountBalanceT24;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${yaxche.ribbon.listOfServers}", name = "accountBalanceT24")
public interface AccountBalanceT24Client {

    @PostMapping("/sipareMSProcessFileApp/multiva/sipare/getAccountBalanceT24")
    AccountBalanceT24 getAccAccountBalanceT24();

}

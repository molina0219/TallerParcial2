package co.com.poli.showtimesservice.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", fallback = UserClientImplHystrixFallback.class)
public interface UserClient {

}

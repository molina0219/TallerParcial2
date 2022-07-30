package co.com.poli.showtimesservice.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "movie-service", fallback = MovieClientImplHystrixFallback.class)
public interface MovieClient {

}

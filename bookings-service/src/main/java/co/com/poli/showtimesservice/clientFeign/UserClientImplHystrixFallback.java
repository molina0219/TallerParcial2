package co.com.poli.showtimesservice.clientFeign;

import co.com.poli.showtimesservice.helpers.ResponseBuild;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserClientImplHystrixFallback implements UserClient {

    private final ResponseBuild builder;

}
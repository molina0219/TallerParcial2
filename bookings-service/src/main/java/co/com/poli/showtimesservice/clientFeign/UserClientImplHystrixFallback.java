package co.com.poli.showtimesservice.clientFeign;

import co.com.poli.showtimesservice.helpers.Response;
import co.com.poli.showtimesservice.helpers.ResponseBuild;
import co.com.poli.showtimesservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserClientImplHystrixFallback implements UserClient {

    private final ResponseBuild builder;

    @Override
    public Response findById(Long id) {
        return builder.success(new User());
    }
}

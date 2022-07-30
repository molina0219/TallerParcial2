package co.com.poli.userservice.controller;

import co.com.poli.userservice.helpers.ErrorMessage;
import co.com.poli.userservice.helpers.Response;
import co.com.poli.userservice.helpers.ResponseBuild;
import co.com.poli.userservice.persistence.entity.User;
import co.com.poli.userservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        userService.save(user);
        return builder.success(user);
    }
    @GetMapping
    public Response findAll(){
        return builder.success(userService.findAll());
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        userService.delete(user);
        return builder.success(user);
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
            ErrorMessage errorMessage = ErrorMessage.builder()
                .error(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}

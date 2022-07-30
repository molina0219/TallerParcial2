package co.com.poli.customerservice.controller;

import co.com.poli.customerservice.helpers.ErrorMessage;
import co.com.poli.customerservice.helpers.Response;
import co.com.poli.customerservice.helpers.ResponseBuild;
import co.com.poli.customerservice.persistence.entity.Movies;
import co.com.poli.customerservice.service.MoviesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesService customerService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@Valid @RequestBody Movies movies, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        customerService.save(movies);
        return builder.success(movies);
    }
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("numberID") long numberID){
        Movies movies = (Movies) findByID(numberID).getData();
        if(movies ==null){
            return builder.failed("Not found");
        }
        return builder.success(movies);
    }

    @GetMapping
    public Response findAll(){
        return builder.success(customerService.findAll());
    }

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id){
        return builder.success(customerService.findById(id));
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

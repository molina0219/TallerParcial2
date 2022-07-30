package co.com.poli.showtimesservice.controller;

import co.com.poli.showtimesservice.helpers.ErrorMessage;
import co.com.poli.showtimesservice.helpers.Response;
import co.com.poli.showtimesservice.helpers.ResponseBuild;
import co.com.poli.showtimesservice.persistence.entity.Showtime;
import co.com.poli.showtimesservice.service.ShowtimeService;
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
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild builder;

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id) {
        return builder.success(showtimeService.findById(id));
    }

    @GetMapping
    public Response findAll() {
        return builder.success(showtimeService.findAll());
    }

    @PostMapping
    public Response save(@Valid @RequestBody Showtime showtime, BindingResult result) {
        if (result.hasErrors()) {
            return builder.failed(this.formatMessage(result));
        }
        showtimeService.save(showtime);
        return builder.success(showtime);
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

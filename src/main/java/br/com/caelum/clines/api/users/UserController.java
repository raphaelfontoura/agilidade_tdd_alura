package br.com.caelum.clines.api.users;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    UserView show(@PathVariable Long id) { return service.findById(id); }

    @GetMapping
    List<UserView> list() {
        return service.listAll();
    }

    @PostMapping
    ResponseEntity<?> createBy(@RequestBody @Valid UserForm form) {
        var code = service.createUserBy(form);

        var uri = URI.create("/users/").resolve(code.toString());

        return created(uri).build();
    }
}

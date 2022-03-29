package stuba.fei.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stuba.fei.bp.entity.request.UsersRequest;
import stuba.fei.bp.entity.response.UsersResponse;
import stuba.fei.bp.service.UsersService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {

    @Autowired
    private UsersService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsersResponse addUser(@RequestBody UsersRequest request){
        return new UsersResponse(this.service.create(request));
    }

    @GetMapping("/{username}")
    public UsersResponse getProductByUsername(@PathVariable("username") String username) {
        return new UsersResponse(this.service.getUserByUsername(username));
    }

    @GetMapping("/{username}/{password}")
    public UsersResponse updatePassword(@PathVariable("username") String username, @PathVariable("password") String password) {
        return new UsersResponse(this.service.updatePassword(username, password));
    }

    @GetMapping("/login/{username}/{password}")
    public UsersResponse loginUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        return new UsersResponse(this.service.loginUser(username, password));
    }

    @GetMapping("/loginTrainer/{username}/{password}")
    public UsersResponse loginTrainer(@PathVariable("username") String username, @PathVariable("password") String password) {
        return new UsersResponse(this.service.loginTrainer(username, password));
    }
}

package stuba.fei.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stuba.fei.bp.entity.request.PlayerRequest;
import stuba.fei.bp.entity.response.PlayerResponse;
import stuba.fei.bp.service.PlayersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayersController {

    @Autowired
    private PlayersService service;

    @GetMapping
    public List<PlayerResponse> getAllPlayers(){
        return this.service.getAll().stream().map(PlayerResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlayerResponse gePlayerById(@PathVariable("id") Long id) {
        return new PlayerResponse(this.service.getPlayerById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse addPlayer(@RequestBody PlayerRequest request){
        return new PlayerResponse(this.service.create(request));
    }
}

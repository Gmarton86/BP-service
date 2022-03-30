package stuba.fei.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stuba.fei.bp.entity.request.MatchesRequest;
import stuba.fei.bp.entity.response.MatchesResponse;
import stuba.fei.bp.service.MatchesService;

@RestController
@RequestMapping("/matches")
public class MatchesController {

    @Autowired
    private MatchesService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchesResponse addPlayer(@RequestBody MatchesRequest request){
        return new MatchesResponse(this.service.create(request));
    }

    @GetMapping("/{player1ID}/{player2ID}/{score}/{winnerID}")
    public MatchesResponse updatePassword(@PathVariable("player1ID") Integer player1ID, @PathVariable("player2ID") Integer player2ID, @PathVariable("score") String score, @PathVariable("winnerID") Integer winnerID) {
        return new MatchesResponse(this.service.update(player1ID, player2ID, score, winnerID));
    }

    @DeleteMapping("/{name}")
    public void deleteMatch(@PathVariable("name") String name){
        this.service.delete(name);
    }
}

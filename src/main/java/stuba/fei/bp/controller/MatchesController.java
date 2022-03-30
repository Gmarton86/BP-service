package stuba.fei.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stuba.fei.bp.entity.request.MatchesRequest;
import stuba.fei.bp.entity.request.MatchesUpdateRequest;
import stuba.fei.bp.entity.response.MatchesResponse;
import stuba.fei.bp.service.MatchesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matches")
public class MatchesController {

    @Autowired
    private MatchesService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchesResponse addMatch(@RequestBody MatchesRequest request){
        return new MatchesResponse(this.service.create(request));
    }

    @GetMapping("/{player1ID}/{player2ID}/{score}/{winnerID}")
    public MatchesResponse updateMatch(@PathVariable("player1ID") Integer player1ID, @PathVariable("player2ID") Integer player2ID, @PathVariable("score") String score, @PathVariable("winnerID") Integer winnerID) {
        return new MatchesResponse(this.service.update(player1ID, player2ID, score, winnerID));
    }

    @GetMapping("/{player1ID}/{player2ID}/{stol}")
    public MatchesResponse updateMatch(@PathVariable("player1ID") Integer player1ID, @PathVariable("player2ID") Integer player2ID, @PathVariable("stol") Integer stol) {
        return new MatchesResponse(this.service.updateStol(player1ID, player2ID, stol));
    }

    @DeleteMapping("/{name}")
    public void deleteMatch(@PathVariable("name") String name){
        this.service.delete(name);
    }

    @GetMapping("/{name}")
    public List<MatchesResponse> getMatches(@PathVariable("name") String name){
        return this.service.getMatches(name).stream().map(MatchesResponse::new).collect(Collectors.toList());
    }

    @PostMapping("/update")
    public MatchesResponse update(@RequestBody MatchesUpdateRequest request) {
        return new MatchesResponse(this.service.updateMatch(request));
    }
}

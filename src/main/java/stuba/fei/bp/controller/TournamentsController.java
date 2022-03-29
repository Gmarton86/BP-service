package stuba.fei.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stuba.fei.bp.entity.request.TournamentsRequest;
import stuba.fei.bp.entity.response.TournamentResponse;
import stuba.fei.bp.entity.response.UsersResponse;
import stuba.fei.bp.service.TournamentsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tournaments")
public class TournamentsController {

    @Autowired
    private TournamentsService tournamentsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TournamentResponse addTournament(@RequestBody TournamentsRequest request){
        return new TournamentResponse(this.tournamentsService.create(request));
    }

    @GetMapping
    public List<TournamentResponse> getAllTournaments(){
        return this.tournamentsService.getAll().stream().map(TournamentResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping("/{name}")
    public void deleteTournament(@PathVariable("name") String name){
        this.tournamentsService.delete(name);
    }


    @GetMapping("/{name}")
    public TournamentResponse geTournamentByName(@PathVariable("name") String name) {
        return new TournamentResponse(this.tournamentsService.getTournamentByName(name));
    }
}

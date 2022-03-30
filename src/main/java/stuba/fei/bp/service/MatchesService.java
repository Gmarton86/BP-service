package stuba.fei.bp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stuba.fei.bp.entity.Matches;
import stuba.fei.bp.entity.repositary.MatchesRepository;
import stuba.fei.bp.entity.request.MatchesRequest;

@Service
public class MatchesService {

    private MatchesRepository repository;

    @Autowired
    public MatchesService(MatchesRepository repository) {
        this.repository = repository;
    }

    public Matches create(MatchesRequest request) {
        Matches matches = new Matches();
        matches.setID(request.getID());
        matches.setTournamentName(request.getTournamentName());
        matches.setPlayer1ID(request.getPlayer1ID());
        matches.setPlayer2ID(request.getPlayer2ID());
        matches.setWinnerId(request.getWinnerId());
        matches.setStol(request.getStol());
        matches.setScore(request.getScore());
        return this.repository.save(matches);
    }

    public Matches getMatchByPlayers(Integer player1ID, Integer player2ID) {
        return this.repository.getMatchByPlayers(player1ID, player2ID);
    }

    public Matches update(Integer player1ID, Integer player2ID, String score, Integer winnerID) {
        Matches matches = this.getMatchByPlayers(player1ID, player2ID);
        matches.setWinnerId(winnerID);
        matches.setScore(score);
        this.repository.save(matches);
        return matches;
    }

    public void delete(String name) {
        this.repository.customDelete(name);
    }

}

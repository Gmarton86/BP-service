package stuba.fei.bp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stuba.fei.bp.entity.Matches;
import stuba.fei.bp.entity.repositary.MatchesRepository;
import stuba.fei.bp.entity.request.MatchesRequest;
import stuba.fei.bp.entity.request.MatchesUpdateRequest;

import java.util.List;

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

    public List<Matches> getMatches(String name) {
        return this.repository.getAllByName(name);
    }

    public Matches updateMatch(MatchesUpdateRequest request) {
        Matches matches = this.getMatchByPlayers(request.getPlayer1ID(), request.getPlayer2ID());
        matches.setWinnerId(request.getWinnerID());
        matches.setPlayer1ID(request.getUpdatePlayer1ID());
        matches.setPlayer2ID(request.getUpdatePlayer2ID());
        matches.setStol(request.getStol());
        matches.setScore(request.getScore());
        this.repository.save(matches);
        return matches;
    }

    public Matches updateStol(Integer player1ID, Integer player2ID, Integer stol) {
        Matches matches = this.getMatchByPlayers(player1ID, player2ID);
        matches.setStol(stol);
        this.repository.save(matches);
        return matches;
    }
}

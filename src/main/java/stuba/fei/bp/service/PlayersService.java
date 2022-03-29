package stuba.fei.bp.service;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stuba.fei.bp.entity.Players;
import stuba.fei.bp.entity.Tournaments;
import stuba.fei.bp.entity.Users;
import stuba.fei.bp.entity.repositary.PlayersRepository;
import stuba.fei.bp.entity.request.PlayerRequest;
import stuba.fei.bp.entity.request.TournamentsRequest;
import stuba.fei.bp.entity.response.PlayerResponse;

import java.util.List;

@Service
public class PlayersService {

    private PlayersRepository repository;

    @Autowired
    public PlayersService(PlayersRepository repository) {
        this.repository = repository;
    }

    public List<Players> getAll() {
        return this.repository.findAll();
    }

    public Players getPlayerById(Long id) {
        Players player = this.repository.findById(id);
        if(player == null){
            return null;
        }
        return player;
    }

    public Players create(PlayerRequest request) {
        Players players = new Players();
        players.setName(request.getName());
        players.setUsername(request.getUsername());
        players.setRank(request.getRank());
        return this.repository.save(players);
    }
}

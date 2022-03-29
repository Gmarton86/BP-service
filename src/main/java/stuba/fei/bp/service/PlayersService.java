package stuba.fei.bp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stuba.fei.bp.entity.Players;
import stuba.fei.bp.entity.repositary.PlayersRepository;
import stuba.fei.bp.entity.request.PlayerRequest;

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
        Players players = this.repository.findCustomById(id);
        if(players == null){
            return null;
        }
        return players;
    }

    public Players create(PlayerRequest request) {
        Players players = new Players();
        players.setUsername(request.getUsername());
        players.setSurname(request.getSurname());
        players.setPlayerRank(request.getRank());
        return this.repository.save(players);
    }
}

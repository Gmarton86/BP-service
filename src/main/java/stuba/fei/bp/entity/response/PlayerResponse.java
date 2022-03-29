package stuba.fei.bp.entity.response;

import lombok.Getter;
import stuba.fei.bp.entity.Players;

@Getter
public class PlayerResponse {
    private Long ID;
    private String username;
    private String surname;
    private Integer Rank;

    public PlayerResponse(Players players) {
        this.ID = players.getID();
        this.username = players.getUsername();
        this.surname = players.getSurname();
        this.Rank = players.getPlayerRank();
    }
}

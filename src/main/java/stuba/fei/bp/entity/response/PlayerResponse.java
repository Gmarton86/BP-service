package stuba.fei.bp.entity.response;

import lombok.Getter;
import stuba.fei.bp.entity.Players;

@Getter
public class PlayerResponse {
    private Long ID;
    private String Name;
    private String Username;
    private Integer Rank;

    public PlayerResponse(Players player) {
        this.ID = player.getID();
        this.Name = player.getName();
        this.Username = player.getUsername();
        this.Rank = player.getRank();
    }
}

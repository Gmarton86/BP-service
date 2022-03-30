package stuba.fei.bp.entity.response;

import lombok.Getter;
import stuba.fei.bp.entity.Matches;

@Getter
public class MatchesResponse {
    private Long ID;
    private String TournamentName;
    private Integer Player1ID;
    private Integer Player2ID;
    private Integer WinnerId;
    private Integer Stol;
    private String Score;

    public MatchesResponse(Matches matches) {
        this.ID = matches.getID();
        this.TournamentName = matches.getTournamentName();
        this.Player1ID = matches.getPlayer1ID();
        this.Player2ID = matches.getPlayer2ID();
        this.WinnerId = matches.getWinnerId();
        this.Stol = matches.getStol();
        this.Score = matches.getScore();
    }
}

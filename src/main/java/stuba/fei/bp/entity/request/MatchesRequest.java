package stuba.fei.bp.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchesRequest {
    private Long ID;
    private String TournamentName;
    private Integer Player1ID;
    private Integer Player2ID;
    private Integer WinnerId;
    private Integer Stol;
    private String Score;
}

package stuba.fei.bp.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchesUpdateRequest {
    private Integer WinnerID;
    private Integer Player1ID;
    private Integer Player2ID;
    private Integer UpdatePlayer1ID;
    private Integer UpdatePlayer2ID;
    private Integer Stol;
    private String Score;
}

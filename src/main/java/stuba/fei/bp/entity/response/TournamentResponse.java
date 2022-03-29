package stuba.fei.bp.entity.response;

import lombok.Getter;
import stuba.fei.bp.entity.Tournaments;

@Getter
public class TournamentResponse {
    private Long ID;
    private String Name;
    private Integer Tables;
    private Integer AdminID;
    private String Time;
    private String Date;
    private String Place;

    public TournamentResponse(Tournaments request) {
        this.ID = request.getID();
        this.Name = request.getName();
        this.Tables = request.getTables();
        this.AdminID = request.getAdminID();
        this.Time = request.getTime();
        this.Date = request.getDate();
        this.Place = request.getPlace();
    }
}

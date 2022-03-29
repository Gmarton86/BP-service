package stuba.fei.bp.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TournamentsRequest {
    private Long ID;
    private String Name;
    private Integer Tables;
    private Integer AdminID;
    private String Time;
    private String Date;
    private String Place;
}

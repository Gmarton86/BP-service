package stuba.fei.bp.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRequest {
    private Long ID;
    private String Name;
    private String Username;
    private Integer Rank;
}

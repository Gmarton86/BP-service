package stuba.fei.bp.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRequest {
    private Long ID;
    private String username;
    private String surname;
    private Integer Rank;
}

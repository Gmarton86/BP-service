package stuba.fei.bp.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequest {
    private Long ID;
    private String Username;
    private String Password;
    private String TrainerUsr;
    private String TrainerPasswd;
    private Integer tournamentID;
}

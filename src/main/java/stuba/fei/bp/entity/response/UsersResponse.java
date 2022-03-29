package stuba.fei.bp.entity.response;

import lombok.Getter;
import stuba.fei.bp.entity.Users;

@Getter
public class UsersResponse {
    private Long ID;
    private String Username;
    private String Password;
    private String TrainerUsr;
    private String TrainerPasswd;
    private Integer tournamentID;

    public UsersResponse(Users user) {
        this.ID = user.getID();
        this.Username = user.getUsername();
        this.Password = user.getPassword();
        this.TrainerUsr = user.getTrainerUsr();
        this.TrainerPasswd = user.getTrainerPasswd();
        this.tournamentID = user.getTournamentID();
    }
}

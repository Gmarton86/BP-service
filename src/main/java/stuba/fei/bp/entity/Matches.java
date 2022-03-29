package stuba.fei.bp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Matches implements Serializable {
    @Id
    @GeneratedValue
    private Long ID;
    private String TournamentName;
    private Integer Player1ID;
    private Integer Player2ID;
    private Integer WinnerId;
    private Integer Stol;
}

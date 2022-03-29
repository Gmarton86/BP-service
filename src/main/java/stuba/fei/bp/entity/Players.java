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
public class Players implements Serializable {
    @Id
    @GeneratedValue
    private Long ID;
    private String username;
    private String surname;
    private Integer PlayerRank;
}

package stuba.fei.bp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Tournaments implements Serializable {
    @Id
    @GeneratedValue
    private Long ID;
    @Column(unique = true)
    private String Name;
    private Integer Tables;
    private Integer AdminID;
    private String Time;
    private String Date;
    private String Place;
}

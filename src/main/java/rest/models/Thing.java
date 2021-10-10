package rest.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "things")
@Entity
public class Thing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Lob
    @Column
    private String description;


}

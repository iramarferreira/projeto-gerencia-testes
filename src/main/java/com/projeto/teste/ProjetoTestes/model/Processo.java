package com.projeto.teste.ProjetoTestes.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Builder
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
// Anotações lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// Anotações JPA
@Entity
@Table(name = "tb_processo")
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String orgaoJudic;
    private String relator;

    @ManyToMany
//    @JsonBackReference(value = "JsonBackReference")
//    @JsonManagedReference(value = "JsonManagedReference")
    @JsonIgnore
    Set<Advogado> advogados;

}

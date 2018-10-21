package com.gress.fortochka.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman_Radetskiy.
 */
@Entity
@Table(name = "kindergarten")
@Setter
@Getter
public class Kindergarten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "kindergarten",targetEntity=Kindergroup.class, cascade = CascadeType.ALL)
    private List<Kindergroup> kindergroups = new ArrayList<>();
}

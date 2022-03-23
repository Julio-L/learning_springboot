package com.example.playground.exploreEntityRelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class E {
    @Id
    long e_id;

    @OneToMany(mappedBy = "eRelation")
    List<F> fRelation;

}

package com.example.playground.exploreEntityRelations;

import javax.persistence.*;

@Entity
public class F {
    @Id
    long f_id;

    @ManyToOne
    @JoinTable(name="e_f",
            joinColumns = @JoinColumn(name = "f_id", referencedColumnName = "f_id"),
            inverseJoinColumns= @JoinColumn(name="e_id", referencedColumnName = "e_id"))
    private E eRelation;

}

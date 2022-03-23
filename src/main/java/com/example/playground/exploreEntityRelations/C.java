package com.example.playground.exploreEntityRelations;

import javax.persistence.*;
import java.util.List;

@Entity
public class C {

        @Id
        long id;

        private int aNum;

        @OneToMany(mappedBy = "cRelation")
        private List<D> dRelation;

}

package com.glosys.lms.entity;

import javax.persistence.*;

@Entity
@Table(name = "workshop")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "workshop_type_id")
    private WorkshopType workshopType;


    public Workshop() {
    }

    public Workshop(WorkshopType workshopType) {
        this(null, workshopType);
    }

    public Workshop(Integer id, WorkshopType workshopType) {
        this.id = id;
        this.workshopType = workshopType;
    }

    public Workshop(Integer id) {
        this.id = id;
    }
}

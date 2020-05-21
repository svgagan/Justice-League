package com.svgagan.justiceleague.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name="super_heroes", schema="public")
public class SuperHeroes implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "super_hero_name")
    private String superHeroName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "comic_details_id")
    private String comicDetailsId;

    public SuperHeroes(String id, String superHeroName, Boolean status, Date createdDate, Date updatedDate, String comicDetailsId) {
        this.id = id;
        this.comicDetailsId = comicDetailsId;
        this.superHeroName = superHeroName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}

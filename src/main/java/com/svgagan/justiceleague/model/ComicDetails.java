package com.svgagan.justiceleague.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners({AuditingEntityListener.class})
@Table(name="comic_details", schema="public")
public class ComicDetails {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "comic_name")
    private String comicName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;
}

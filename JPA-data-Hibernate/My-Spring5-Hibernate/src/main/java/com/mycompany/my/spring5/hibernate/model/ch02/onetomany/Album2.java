/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.hibernate.model.ch02.onetomany;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author Denys.Prokopiuk
 */
@Entity
@Table(name = "album2")
public class Album2 implements Serializable {

    private Long id;
    private String title;
    private Date releaseDate;
    private int version;
    private Singer2 singer;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return this.id;
    }

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    public Singer2 getSinger() {
        return this.singer;
    }

    public void setSinger(Singer2 singer) {
        this.singer = singer;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    @Column
    public String getTitle() {
        return this.title;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Album - Id: " + id + ", Title: "
                + title + ", Release Date: " + releaseDate;
    }

}

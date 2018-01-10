package com.it.agency.beans;

import com.it.agency.outils.Other;

import javax.persistence.*;

@Entity
@Table(name = "t_offre", schema = Other.DATEBASE_NAME)
public class Offre {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_offre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle = "";

    @Column(name = "location")
    private String location;

    @Column(name = "resume")
    private String resume;

    @Column(name = "detail")
    private String detail;

    public Offre() {
    }

    public Offre(String title, String subtitle, String location, String resume, String detail) {
        this.title = title;
        this.subtitle = subtitle;
        this.location = location;
        this.resume = resume;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", location='" + location + '\'' +
                ", resume='" + resume + '\'' +
                ", detail='" + detail + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}

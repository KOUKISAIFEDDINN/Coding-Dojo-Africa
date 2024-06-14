package com.dojoandninjas.testdojoandninjas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="dojos")
public class Dojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Size(min=1 , max=50)
    private String name;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "dojo" , fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

    public Dojo(){

    }
    public Dojo(Long id , Date createdAt , Date updatedAt , List<Ninja> ninjas , String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.ninjas = ninjas;
        this.name = name;
    }
//    Getter And Setter
    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){

        this.updatedAt = new Date();
    }
}

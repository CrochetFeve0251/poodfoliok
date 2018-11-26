package com.poodfoliok.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String;
import java.util.Set;

@Data
@Entity
@Table(name = "companys")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @Column(name = "image")
    private String image;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set getProject() {
		return project;
	}

	public void setProject(Set project) {
		this.project = project;
	}

	@ManyToOne
	private User user;

    @OneToMany(targetEntity = Project.class)
	private Set project;

	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	public void setDescription(String description) {this.description = description;}
	public String getDescription() {return description;}
	public void setLink(String link) {this.link = link;}
	public String getLink() {return link;}
	public void setImage(String image) {this.image = image;}
	public String getImage() {return image;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
package com.poodfoliok.model;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String;
import java.util.Set;


@Entity
@Table(name = "schools")
public class School implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "link")
    private String link;

    @OneToMany(targetEntity = Diploma.class)
	private Set diploma;

	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	public void setDescription(String description) {this.description = description;}
	public String getDescription() {return description;}
	public void setImage(String image) {this.image = image;}
	public String getImage() {return image;}
	public void setLink(String link) {this.link = link;}
	public String getLink() {return link;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
package com.poodfoliok.model;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String; 
import java.lang.String; 
import java.util.Date; 
import java.util.Date; 
import java.lang.String; 
import java.lang.String;
import java.util.Set;


@Entity
@Table(name = "projects")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "link")
    private String link;

    @Column(name = "image")
    private String image;

    @ManyToOne
	private User user;

    @ManyToMany(targetEntity = Skill.class)
	private Set skill;

    @ManyToOne
	private Company company;

	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	public void setDescription(String description) {this.description = description;}
	public String getDescription() {return description;}
	public void setStart(Date start) {this.start = start;}
	public Date getStart() {return start;}
	public void setEnd(Date end) {this.end = end;}
	public Date getEnd() {return end;}
	public void setLink(String link) {this.link = link;}
	public String getLink() {return link;}
	public void setImage(String image) {this.image = image;}
	public String getImage() {return image;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
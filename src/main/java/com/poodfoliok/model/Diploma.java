package com.poodfoliok.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date; 
import java.lang.String; 


@Entity
@Table(name = "diplomas")
public class Diploma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "name")
    private String name;

	@ManyToOne(targetEntity = User.class)
	private User user;

	@ManyToOne
	private School school;

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {this.name = name;}
	public String getName() {return name;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
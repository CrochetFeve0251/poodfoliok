package com.poodfoliok.model;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 
import java.lang.Integer;
import java.util.Set;


@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(Set socialMedia) {
		this.socialMedia = socialMedia;
	}

	public Set getDiploma() {
		return diploma;
	}

	public void setDiploma(Set diploma) {
		this.diploma = diploma;
	}

	public Set getProject() {
		return project;
	}

	public void setProject(Set project) {
		this.project = project;
	}

	public Set getHobby() {
		return hobby;
	}

	public void setHobby(Set hobby) {
		this.hobby = hobby;
	}

	public Set getCountry() {
		return country;
	}

	public void setCountry(Set country) {
		this.country = country;
	}

	public Set getCompany() {
		return company;
	}

	public void setCompany(Set company) {
		this.company = company;
	}

	@Column(name = "password")
	private String password;

	@Column(name = "passwordConfirm")
	private String passwordConfirm;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "age")
    private Integer age;

    @ManyToMany(targetEntity = SocialMedia.class)
	private Set socialMedia;

    @OneToMany(targetEntity = Diploma.class)
	private Set diploma;

    @OneToMany(targetEntity = Project.class)
	private Set project;

    @OneToMany(targetEntity = Hobby.class)
	private Set hobby;

    @OneToMany(targetEntity = Country.class)
	private Set country;

    @OneToMany(targetEntity = Company.class)
	private Set company;

	public void setFirstname(String firstname) {this.firstname = firstname;}
	public String getFirstname() {return firstname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public String getLastname() {return lastname;}
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	public void setCity(String city) {this.city = city;}
	public String getCity() {return city;}
	public void setAge(Integer age) {this.age = age;}
	public Integer getAge() {return age;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
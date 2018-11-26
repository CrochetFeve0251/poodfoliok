package com.poodfoliok.model;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String; 
import java.lang.String;
import java.util.Set;


@Entity
@Table(name = "countrys")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne(targetEntity = User.class)
	private Set user;

	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	public void setCode(String code) {this.code = code;}
	public String getCode() {return code;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}
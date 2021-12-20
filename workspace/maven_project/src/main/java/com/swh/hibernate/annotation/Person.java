package com.swh.hibernate.annotation;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name", columnDefinition="TEXT")
	private String lastName;

	@Column(name = "salary")
	private int salary;  

	public Person() {}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String first_name ) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( String last_name ) {
		this.lastName = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary( int salary ) {
		this.salary = salary;
	}
}
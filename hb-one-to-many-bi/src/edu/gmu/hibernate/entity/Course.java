package edu.gmu.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// annotate the class as an entity and map to database table
@Entity
@Table(name="course")
public class Course {
	
	// define fields
	// annotate the fields with database column names
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	// add new field for instructor (also add getter/setters)
	// add @ManytoOne annotation.
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	// create constructors.
	public Course() {}
	
	public Course(String title) {
		this.title = title;
	}

	// generate getter and setter.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	// generate toString() method.
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
}
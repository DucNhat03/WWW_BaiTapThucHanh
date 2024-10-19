package iuh.exercise.entities;

public class Student {
	private int id;
	private String name;
	private Class_ class_;

	public Student() {
		super();
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Student(int id, String name, Class_ class_) {
		super();
		this.id = id;
		this.name = name;
		this.class_ = class_;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Class_ getClass_() {
		return class_;
	}

	public void setClass_(Class_ class_) {
		this.class_ = class_;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", class_=" + class_ + "]";
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + "]";
//	}

}

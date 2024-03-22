package practice;

import java.util.HashMap;
import java.util.StringTokenizer;

class Student{
	String name;
	String age;
	String birthday;
	String course;
	String gender;
	String studentid;

	public Student(String s) {
		// initializer our tokenizer
		StringTokenizer st = new StringTokenizer(s, "|");
		// set the values
		this.setStudentid(st.nextToken());
		this.setName(st.nextToken());
		this.setBirthday(st.nextToken());
		this.setAge(st.nextToken());
		this.setCourse(st.nextToken());
		this.setGender(st.nextToken());
	}
	public Student() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
}

public class Hashmap1 {
		public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<String, Student>();
		map = init();
		// iterate to all the keys stored on our hashmap
		for (String s : map.keySet()) {
			// print the student id and age	
		System.out.println(map.get(s).getName()+" "+map.get(s).getAge()+" "+map.get(s).getBirthday()+" "+map.get(s).getCourse()+" "+map.get(s).getGender());
		}
	}

	private static HashMap<String, Student> init() {
		// initialize our student objects
		Student s1 = new Student("1|salma|1999|23|nodejs|female");
		// initialize of hashmap
		HashMap<String, Student> map = new HashMap<String, Student>();
		// assign each student id as key and the student objects as values on our hashmap
		map.put(s1.getStudentid(), s1);
		return map;
	}
}

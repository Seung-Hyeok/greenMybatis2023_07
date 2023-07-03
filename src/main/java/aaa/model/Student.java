package aaa.model;

import lombok.Data;

@Data
public class Student {
	
	String name;
	int kor,eng,mat;
	int tot = 0;
	int avg = 0;
	
	public Student(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = tot/3;
		
		
	}
	
	

}

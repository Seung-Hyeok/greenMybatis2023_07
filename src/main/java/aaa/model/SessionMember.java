package aaa.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SessionMember {
	//아이디,이름,전화번호,나이,사진,이력서
		String pid, pname, tel, pw;
		int age;
		boolean marriage;
		MultipartFile img, resume; 
		String imgName, resumeName;
		
		public SessionMember() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		public boolean isMarriage() {
			return marriage;
		}



		public void setMarriage(boolean marriage) {
			this.marriage = marriage;
		}


		public SessionMember(String pid, String pname, String pw) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.pw = pw;
		}
		
		
		
		public SessionMember(String pname, int age, boolean marriage) {
			super();
			this.pname = pname;
			this.age = age;
			this.marriage = marriage;
		}



		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getImgName() {
			return imgName;
		}
		public void setImgName(String imgName) {
			this.imgName = imgName;
		}
		public String getResumeName() {
			return resumeName;
		}
		public void setResumeName(String resumeName) {
			this.resumeName = resumeName;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public MultipartFile getImg() {
			return img;
		}
		public void setImg(MultipartFile img) {
			this.img = img;
		}
		public MultipartFile getResume() {
			return resume;
		}
		public void setResume(MultipartFile resume) {
			this.resume = resume;
		}
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}



		@Override
		public String toString() {
			return "Member [pid=" + pid + ", pname=" + pname + ", tel=" + tel + ", pw=" + pw + ", age=" + age
					+ ", marriage=" + marriage + ", imgName=" + imgName + ", resumeName=" + resumeName + "]";
		}
	
}






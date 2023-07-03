package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/basic/st")
	String st(Model mm) {
		
		mm.addAttribute("st1", new Student("서승혁", 87, 76, 65));
		mm.addAttribute("st2", new Student("홍기훈", 80, 80, 80));
		mm.addAttribute("st3", new Student("조민기", 70, 70, 70));
		mm.addAttribute("st4", new Student("이혜미", 60, 60, 60));
		
		return "basic/st";
	}

}

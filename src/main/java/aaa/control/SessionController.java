package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.SessionMember;
import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
	
	
	// session 이용하여 로그인 기능 만들기
	
	@RequestMapping("/session/makemem")
	public String makemem(HttpSession session, Model mm) {
		
		//session.setAttribute("st", new Stud("사씨",77,78,79));
		session.setAttribute("mem", new SessionMember("zzz","서씨","3367"));
		mm.addAttribute("msg","가입완료");
		
		System.out.println(session.getAttribute("mem"));
		

		
		return "session/makemem";
	}
	
	@RequestMapping("/session/ddd")
	public String ddd(HttpSession session, Model mm) {
		
		session.removeAttribute("mem");
		
		mm.addAttribute("msg", "세션 삭제");
		return "session/login";
	}
	
	@RequestMapping("/session/login")
	public String login(HttpSession session, Model mm, SessionMember mem) {
		
		System.out.println(session.getAttribute("mem"));
		
		mem = (SessionMember)session.getAttribute("mem");
		
		System.out.println(mem);
		
		System.out.println(mem.getPname());
		
		mm.addAttribute("mem", mem);
		
		mm.addAttribute("pname", mem.getPname());
		
		mm.addAttribute("msg","로그인 성공");
		
		

		return "session/login";
	}
	
	
}

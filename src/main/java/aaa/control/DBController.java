package aaa.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.db.AnnoMapper;
import aaa.db.BoardDTO;
import aaa.db.BoardMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DBController {

	@Resource
	BoardMapper bm;
	//AnnoMapper bm; 이걸 이용할 수도 있다
	
	@RequestMapping("/db/list")
	String dbListttt(Model mm, BoardDTO dto) {
		
		List<BoardDTO> mainData = bm.list(dto);
		//System.out.println("mainData:"+mainData);
		System.out.println("list:"+dto.getSch()); // http://localhost/db/list 로 들어가면 null이나옴 그냥 검색 누르면 잘나옴, 그래서 xml에서 if를 줌
		System.out.println("cnt:"+dto.getCnt());
		mm.addAttribute("mainData", mainData);
		return "db/list";
	}
	
	@RequestMapping("/db/listPname/{pno}")
	String dblistPname(Model mm, BoardDTO dto) {
		
		List<BoardDTO> mainData = bm.listPname(dto);
		
		mm.addAttribute("mainData", mainData);
		return "db/list";
	}
	
	
	@RequestMapping("/db/detail/{id}")
	String dbDetail(Model mm, BoardDTO dto) {
		
		mm.addAttribute("mainData", bm.detail(dto));
		return "db/detail";
	}
	
	@GetMapping("/db/insert")
	String dbInsertForm(BoardDTO dto) {
		return "db/insertForm";
	}
	
	@PostMapping("/db/insert")
	String  dbInsertComplete(Model mm, BoardDTO dto) {
		bm.inserttt(dto);
		mm.addAttribute("msg", "입력되었습니다.");
		mm.addAttribute("goUrl", "detail/"+dto.getId());
		System.out.println("InsertComplete:"+dto);
		return "db/alert";
	}
	
	@GetMapping("/db/insertList")
	String  dbInsertList(Model mm) {
		ArrayList<BoardDTO> arr = new ArrayList<>();
		
		arr.add(new BoardDTO("무슨제목11", "칠공1", "1111", "무슨 내용1"));
		arr.add(new BoardDTO("무슨제목21", "칠공2", "1111", "무슨 내용2"));
		arr.add(new BoardDTO("무슨제목31", "칠공3", "1111", "무슨 내용3"));
		
		bm.insertList(arr);
		mm.addAttribute("msg", "입력되었습니다.");
		mm.addAttribute("goUrl", "list");
		System.out.println("InsertList:");
		return "db/alert";
	}
	
	@GetMapping("/db/delete/{id}")
	String dbDeleteForm(BoardDTO dto) {
		
		return "db/deleteForm";
	}
	
	@PostMapping("/db/delete/{id}")
	String dbDeleteComplete(Model mm, BoardDTO dto) {
		
		System.out.println(dto);
		
		int cnt = bm.deleteee(dto);
		
		System.out.println(dto.getId());
		
		System.out.println(dto.getPw());
		
		mm.addAttribute("msg", "비밀번호가 맞지 않습니다.");
		mm.addAttribute("goUrl", "/db/delete/"+dto.getId());
		
		if(cnt == 1) {
			mm.addAttribute("msg", "삭제되었습니다.");
			mm.addAttribute("goUrl", "/db/list");
		}
			
		return "db/alert";
		
	}
	
	@GetMapping("/db/modify/{id}")
	String dbModifyForm(Model mm, BoardDTO dto) {
		
		mm.addAttribute("mainData", bm.detail(dto));
		return "db/modifyForm";
	}
	
	@PostMapping("/db/modify/{id}")
	String dbModifyComplete(Model mm,BoardDTO dto) {
		int cnt = bm.modifyyy(dto);
		String msg = "암호 에러";
		String goUrl = "/db/modify/"+dto.getId();
		if(cnt>0) {
			msg = "수정되었습니다.";
			goUrl = "/db/detail/"+dto.getId();
		}
		System.out.println("수정갯수:"+cnt);
		mm.addAttribute("msg", msg);
		mm.addAttribute("goUrl", goUrl);
		return "db/alert";
	}
	
}

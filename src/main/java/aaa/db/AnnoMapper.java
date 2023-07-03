package aaa.db;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AnnoMapper {

	@Select(value = "select * from board")
	List<BoardDTO> list(BoardDTO erefr);
	
	List<BoardDTO> listPname(BoardDTO erefr);
	
	@Select(value = "select * from board where id = #{id}")
	BoardDTO detail(BoardDTO bdedsde);
	
	
	@SelectKey( keyProperty="id", resultType=Integer.class, before = true ,statement = "select max(id)+1 from board")
	@Insert({
		"insert into board (id, title, pname, pw, content, upfile, reg_date, level, seq, cnt, gid)",
		"values",
		"(#{id}, #{title}, #{pname}, #{pw}, #{content}, #{upfile}, sysdate(), 0,0,0, #{id})"
	})
	void inserttt(BoardDTO efev45rtrg);
	
	
	@Insert({
		"insert into board ( title, pname, pw, content, upfile, reg_date, level, seq, cnt)",
		"values",
		"<foreach collection=\"list\" item=\"dd\" separator=\",\" index=\"i\">",
		"( #{title}, #{pname}, #{pw}, #{content}, #{upfile}, sysdate(), 0,0,0 )",
		"</foreach>"
	})
	void insertList(ArrayList<BoardDTO> arr);
	
	
	@Delete("delete from board where id = #{id} and pw = #{pw}")
	int deleteee(BoardDTO efev45rtrg);
	
	@Update({"update board set title = #{title}, pname =  #{pname}, content = #{content}",
			"		where id = #{id} and pw = #{pw}"})
	int modifyyy(BoardDTO refv);
	
}

package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.EmployeeDTO;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Component
@Repository(value = "kosaShoppingMall.mapper.MemberMapper")
public interface MemberMapper {
	public Integer memberInsert(MemberDTO dto);
	public String numberGenerate();
	public List<MemberDTO> selectAll(StartEndPageDTO dto);
	public MemberDTO selectOne(String memNum);
	public Integer memberUpdate(MemberDTO dto);
	public Integer memberDelete(String memNum);
	public Integer memberDels(String[] deletes);
	public int memberCount();
}

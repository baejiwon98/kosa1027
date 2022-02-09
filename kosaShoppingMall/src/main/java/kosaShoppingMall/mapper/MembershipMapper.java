package kosaShoppingMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.MemberDTO;

@Component
@Repository(value = "kosaShoppingMall.mapper.MembershipMapper")
public interface MembershipMapper {
	public Integer memberJoin(MemberDTO dto);
	public String numberGenerate();
	public MemberDTO selectOne (String memId);
	public Integer updatePassword(MemberDTO dto);
	public Integer memberDrop(String memId);
}

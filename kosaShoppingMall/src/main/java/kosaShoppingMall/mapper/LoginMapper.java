package kosaShoppingMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;

@Component
@Repository(value= "kosaShoppingMall.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfo loginSelect(String id);
	public AuthInfo findId(String email);
	public String emailSelect(String memId);
}

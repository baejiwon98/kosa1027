package school.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import school.domain.AuthInfo;

@Component
@Repository(value = "school.mapper.LoginMapper")
public interface LoginMapper {
	public AuthInfo loginSelect(String userId);

}

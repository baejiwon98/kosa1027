package springBootTest2.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.GoodsDTO;

@Component
@Repository(value="springBootTest2.mapper.GoodsMapper")
public interface GoodsMapper {
	public String numberGenerate();
	public Integer goodsInsert(GoodsDTO dto);
}

package springBootTest2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.GoodsDTO;
import springBootTest2.domain.MemberDTO;

@Component
@Repository(value="springBootTest2.mapper.GoodsMapper")
public interface GoodsMapper {
	public String numberGenerate();
	public Integer goodsInsert(GoodsDTO dto);
	public Integer empnumGenerate(GoodsDTO dto);
	public List<GoodsDTO> selectAll();
	public GoodsDTO selectOne(String goodsNum);
	public Integer goodsDel(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
}

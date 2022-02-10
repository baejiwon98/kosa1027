package kosaShoppingMall.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.domain.GoodsIpgoGoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Component
@Repository(value = "kosaShoppingMall.mapper.GoodsMapper")
public interface GoodsMapper {
	public Integer goodsInsert(GoodsDTO dto);
	public String numberGenerate();
	public Integer visitCount(String goodsNum);
	public List<GoodsDTO> selectAll(StartEndPageDTO dto);
	public GoodsDTO selectOne(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDelete(String goodsNum);
	public List<GoodsDTO> searchGoods(String goodsWord);
	public List<GoodsDTO> goodsItems(StartEndPageDTO dto);
	public Integer ipgoInsert(GoodsIpgoDTO dto);
	public List<GoodsIpgoDTO> ipgoSelect(StartEndPageDTO dto);
	// 1 대 1 정보
	public GoodsIpgoGoodsDTO ipgoDetail(GoodsIpgoDTO idto);
	public GoodsDTO getGoodsIpgoInfo(GoodsIpgoDTO idto);
	public Integer goodsIpgoUpdate(GoodsIpgoDTO dto);
	public Integer goodsIpgoDelete(String goodsNum);
	//배열
	public Integer goodsDels(String[] deletes);
	//리스트
	public Integer goodsDeletes(List<String> cs);
	// Map을 사용한 방법
	public Integer goodsRemove(Map<String, Object> condition);
	
	public Integer goodsIpgoDels(List<String[]> condition);
	public int goodsCount();
	public int goodsIpgoCount();
	public int count(String goodsWord);
	public int itemcount(String goodsWord);
}

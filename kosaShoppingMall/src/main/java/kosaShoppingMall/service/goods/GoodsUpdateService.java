package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand) {
		GoodsDTO dto = goodsMapper.selectOne(goodsCommand.getGoodsNum());
		
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		
		goodsMapper.goodsUpdate(dto);
	}
}

package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsNumberService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand) {
		String goodsNum = goodsMapper.numberGenerate();
		goodsCommand.setGoodsNum(goodsNum);
	}
}

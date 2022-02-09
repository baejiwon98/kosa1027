package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum) {
		goodsMapper.goodsDelete(goodsNum);
	}
}

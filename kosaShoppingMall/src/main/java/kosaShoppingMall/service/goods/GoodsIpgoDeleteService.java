package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsIpgoDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum) {
		goodsMapper.goodsIpgoDelete(goodsNum);
	}
}

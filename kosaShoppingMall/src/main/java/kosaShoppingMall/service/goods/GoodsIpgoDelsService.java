package kosaShoppingMall.service.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsIpgoDelsService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String [] deletes) {
		List<String[]> condition = new ArrayList<String[]>();
		
		for(String num : deletes) {
			String [] n = num.split("`");
			condition.add(n);
		}
		
		goodsMapper.goodsIpgoDels(condition);
	}
}

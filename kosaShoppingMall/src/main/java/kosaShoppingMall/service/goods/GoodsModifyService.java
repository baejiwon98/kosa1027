package kosaShoppingMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsModifyService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum, Model model) {
		GoodsDTO dto = goodsMapper.selectOne(goodsNum);
		model.addAttribute("goodsCommand", dto);
	}
}

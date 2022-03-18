package kosaShoppingMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.domain.GoodsDTO;
import kosaShoppingMall.domain.StartEndPageDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Component
@Service
public class GoodsItemService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsWord, Model model, Integer page) {
		System.out.println("knasvkojgsBDgvaq");
		int limit = 3;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * limit +1;
		Long endRow = startRow + limit - 1;
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		dto.setGoodsWord(goodsWord);
		
		int count = goodsMapper.itemcount(goodsWord);		
		List<GoodsDTO> list = goodsMapper.goodsItems(dto);
		int maxPage = (int)((double)count / limit + 0.9);
		
		int startPage = ((int)((double)page / limitPage + 0.9) -1) * limitPage + 1;
		
		int endPage = startPage + limitPage - 1;
		if(endPage > maxPage) endPage = maxPage;
		
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("goodsWord", goodsWord);
		
		model.addAttribute("page", page);
		model.addAttribute("list", list);
		
		
	}
}

package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springBootTest2.command.GoodsCommand;
import springBootTest2.service.goods.GoodsNumberService;
import springBootTest2.service.goods.GoodsWriteService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsNumberService goodsNumberService;
	
	@RequestMapping("goodsList")
	public String goodsList() {
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping("goodsRegist")
	public String goodsRegist(GoodsCommand goodsCommand, HttpServletRequest request) {
		goodsWriteService.execute(goodsCommand, request);
		return "redirect:goodList";
	}
	
	@RequestMapping("goodsWrite")
	public String goodsWrite(Model model) {
		goodsNumberService.execute(model);
		return "thymeleaf/goods/goodsForm";
	}
	
}

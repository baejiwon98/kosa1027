package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.GoodsCommand;
import springBootTest2.service.goods.GoodsDelService;
import springBootTest2.service.goods.GoodsDetailService;
import springBootTest2.service.goods.GoodsInfoService;
import springBootTest2.service.goods.GoodsListService;
import springBootTest2.service.goods.GoodsModifyService;
import springBootTest2.service.goods.GoodsNumberService;
import springBootTest2.service.goods.GoodsWriteService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsNumberService goodsNumberService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsDelService goodsDelService;
	@Autowired
	GoodsInfoService goodsInfoService;
	@Autowired
	GoodsModifyService goodsModifyService;
	
	@RequestMapping(value="goodsModify", method = RequestMethod.POST)
	public String goodsModify(GoodsCommand goodsCommand, HttpServletRequest request) {
		goodsModifyService.execute(goodsCommand, request);
		return "redirect:goodsDetail?num="+goodsCommand.getGoodsNum();
	}
	
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(@RequestParam(value = "num") String goodsNum, Model model) {
		goodsInfoService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	
	@RequestMapping(value="goodsDel", method = RequestMethod.GET)
	public String goodsDel(@RequestParam(value="num") String goodsNum) {
		goodsDelService.execute(goodsNum);
		return "redirect:goodsList";
	}
	
	@RequestMapping(value = "goodsDetail", method = RequestMethod.GET)
	public String goodsDetail(@RequestParam(value="num") String goodsNum, Model model) {
		goodsDetailService.execute(model, goodsNum);
		return "thymeleaf/goods/goodsInfo";
	}
	
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping("goodsRegist")
	public String goodsRegist(GoodsCommand goodsCommand, HttpServletRequest request) {
		goodsWriteService.execute(goodsCommand, request);
		return "redirect:goodsList";
	}
	
	@RequestMapping("goodsWrite")
	public String goodsWrite(Model model) {
		goodsNumberService.execute(model);
		return "thymeleaf/goods/goodsForm";
	}
	
}

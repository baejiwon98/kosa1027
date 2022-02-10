package kosaShoppingMall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kosaShoppingMall.command.GoodsCommand;
import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.service.goods.GoodsDeleteService;
import kosaShoppingMall.service.goods.GoodsDelsService;
import kosaShoppingMall.service.goods.GoodsInfoService;
import kosaShoppingMall.service.goods.GoodsIpgoDeleteService;
import kosaShoppingMall.service.goods.GoodsIpgoDelsService;
import kosaShoppingMall.service.goods.GoodsIpgoDetailService;
import kosaShoppingMall.service.goods.GoodsIpgoListService;
import kosaShoppingMall.service.goods.GoodsIpgoModifyService;
import kosaShoppingMall.service.goods.GoodsIpgoService;
import kosaShoppingMall.service.goods.GoodsIpgoUpdateService;
import kosaShoppingMall.service.goods.GoodsItemService;
import kosaShoppingMall.service.goods.GoodsListService;
import kosaShoppingMall.service.goods.GoodsModifyService;
import kosaShoppingMall.service.goods.GoodsNumberService;
import kosaShoppingMall.service.goods.GoodsSearchService;
import kosaShoppingMall.service.goods.GoodsUpdateService;
import kosaShoppingMall.service.goods.GoodsWriteService;

@RequestMapping("goods")
@Controller
public class GoodsController {
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsNumberService goodsNumberService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsInfoService goodsInfoService;
	@Autowired
	GoodsModifyService goodsModifyService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@Autowired
	GoodsSearchService goodsSearchService;
	@Autowired
	GoodsItemService goodsItemService;
	@Autowired
	GoodsIpgoService goodsIpgoService;
	@Autowired
	GoodsIpgoListService goodsIpgoListService;
	@Autowired
	GoodsIpgoDetailService goodsIpgoDetailService;
	@Autowired
	GoodsIpgoModifyService goodsIpgoModifyService;
	@Autowired
	GoodsIpgoUpdateService goodsIpgoUpdateService;
	@Autowired
	GoodsIpgoDeleteService goodsIpgoDeleteService;
	@Autowired
	GoodsDelsService goodsDelsService;
	@Autowired
	GoodsIpgoDelsService goodsIpgoDelsService;
	
	@RequestMapping(value="goodsIpgodels", method=RequestMethod.POST)
	public String goodsIpgodels(@RequestParam(value="delete") String [] deletes) {
		goodsIpgoDelsService.execute(deletes);
		return "redirect:goodsIpgoList";
	}
	
	@RequestMapping(value="goodsDels", method=RequestMethod.POST)
	public String goodsDels(@RequestParam(value="delete") String [] deletes) {
		goodsDelsService.execute(deletes);
		return "redirect:goodsList";
	}
	
	
	@RequestMapping("goodsIpgoDelete")
	public String goodsIpgoDelete(@RequestParam(value="goodsNum") String goodsNum) {
		goodsIpgoDeleteService.execute(goodsNum);
		return "redirect:goodsIpgoList";
	}
	
	@RequestMapping(value="goodsIpgoModify", method=RequestMethod.POST)
	public String goodsIpgoUpdate(@Validated GoodsIpgoCommand goodsIpgoCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsIpgoUpdate";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(goodsIpgoCommand.getIpgoDate());
		goodsIpgoUpdateService.execute(goodsIpgoCommand);
		//return "redirect:/";
		return "redirect:goodsIpgoDetail?goodsNum="+goodsIpgoCommand.getGoodsNum()+"&ipgoDate="+now;
	}
	
	@RequestMapping("goodsIpgoModify")
	public String goodsIpgoModify(GoodsIpgoCommand goodsIpgoCommand, @RequestParam(value="goodsNum") String goodsNum, @RequestParam(value="ipgoDate") String ipgoDate, Model model) {
		goodsIpgoModifyService.execute(goodsNum, ipgoDate, model);
		return "thymeleaf/goods/goodsIpgoUpdate";
	}
	
	@RequestMapping("goodsIpgoDetail")
	public String goodsIpgoDetail(@RequestParam(value="goodsNum") String goodsNum, @RequestParam(value="ipgoDate") String ipgoDate, Model model) {
		goodsIpgoDetailService.execute(goodsNum, ipgoDate, model);
		return "thymeleaf/goods/goodsIpgoDetail";
	}
	
	@RequestMapping(value="ipgoRegist", method = RequestMethod.GET)
	public String ipgoRegist1() {
		return "redirect:/";
	}
	
	@RequestMapping(value="ipgoRegist", method = RequestMethod.POST)
	public String ipgoRegist(@Validated GoodsIpgoCommand goodsIpgoCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsIpgo";
		}
		goodsIpgoService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoList";
	}
	
	@RequestMapping(value="goodsItem")
	public String goodsItems(@RequestParam(value="page", defaultValue = "1", required = false)Integer page, 
							 @RequestParam(value="goodsWord", required = false) String goodsWord, Model model) {
		goodsItemService.execute(goodsWord, model, page);
		return "thymeleaf/goods/goodsItem";
	}
/*	
	@RequestMapping(value="goodsItem", method=RequestMethod.GET)
	public String goodsItem(Model model) {
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", 0);
		return "thymeleaf/goods/goodsItem";
	}
*/	
	@RequestMapping("goodsIpgo")
	public String goodsIpgo(GoodsIpgoCommand goodsIpgoCommand, Model model) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ipgoDate = sdf.format(now);
		goodsIpgoCommand.setIpgoDate(now);
		return "thymeleaf/goods/goodsIpgo";
	}
	
	@RequestMapping("goodsIpgoList")
	public String goodsIpgoList(@RequestParam(value="page", defaultValue = "1", required = false)Integer page, Model model) {
		goodsIpgoListService.execute(model, page);
		return "thymeleaf/goods/goodsIpgoList";
	}
	
	@RequestMapping(value = "goodsDelete")
	public String goodsDelete(@RequestParam(value="goodsNum") String goodsNum) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:goodsList";
	}
	
	@RequestMapping(value = "goodsUpdate", method=RequestMethod.POST)
	public String goodsUpdate(@Validated GoodsCommand goodsCommand, BindingResult result){
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsModify";
		}
		goodsUpdateService.execute(goodsCommand);
		return "redirect:goodsDetail/"+goodsCommand.getGoodsNum();
	}
	
	@RequestMapping("goodsModify")
	public String goodsModify(@RequestParam(value="goodsNum") String goodsNum, Model model){
		goodsModifyService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsModify";
	}
	
	@RequestMapping(value="goodsDetail/{goodsNum}")
	public String goodsDetail(@PathVariable(value="goodsNum") String goodsNum, Model model) {
		goodsInfoService.execute(goodsNum, model);
		return "thymeleaf/goods/goodsDetail";
	}
	
	@RequestMapping("goodsSearch")
	public String goodsSearch(@RequestParam(value="page", defaultValue = "1", required = false)Integer page, @RequestParam(value = "goodsWord")String goodsWord, Model model) {
		goodsSearchService.execute(goodsWord, model, page);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping("goodsList")
	public String goodsList(@RequestParam(value="goodsWord", required = false)String goodsWord, 
			@RequestParam(value="page", defaultValue = "1", required = false) Integer page, GoodsCommand goodsCommand, Model model) {
		goodsListService.execute(goodsWord, model, page);
		return "thymeleaf/goods/goodsList";
	}
	
	@RequestMapping(value="goodsRegist", method=RequestMethod.GET)
	public String goodsRegist1(GoodsCommand goodsCommand) {
		goodsNumberService.execute(goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	
	@RequestMapping(value="goodsRegist", method = RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		goodsWriteService.execute(goodsCommand);
		return "redirect:goodsList";
	}
}

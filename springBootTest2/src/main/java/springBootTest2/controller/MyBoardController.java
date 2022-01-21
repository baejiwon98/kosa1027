package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.MyBoardCommand;
import springBootTest2.service.myboard.MyBoardDelService;
import springBootTest2.service.myboard.MyBoardDetailService;
import springBootTest2.service.myboard.MyBoardInfoService;
import springBootTest2.service.myboard.MyBoardListService;
import springBootTest2.service.myboard.MyBoardModifyService;
import springBootTest2.service.myboard.MyBoardWriteService;

@Controller
@RequestMapping("myboard")
public class MyBoardController {
	@Autowired
	MyBoardListService boardListService;
	@Autowired
	MyBoardWriteService boardWriteService;
	@Autowired
	MyBoardDetailService boardDetailService;
	@Autowired
	MyBoardDelService boardDelService;
	@Autowired
	MyBoardInfoService boardInfoService;
	@Autowired
	MyBoardModifyService boardModifyService;
	
	@RequestMapping(value="boardModify", method = RequestMethod.POST)
	public String boardModify(MyBoardCommand boardCommand, HttpServletRequest request) {
		boardModifyService.execute(boardCommand, request);
		return "redirect:boardDetail?num="+boardCommand.getBoardNum();
	}
	
	@RequestMapping("boardUpdate")
	public String boardUpdate(@RequestParam(value = "num") Integer boardNum, Model model) {
		boardInfoService.execute(boardNum , model);
		return "thymeleaf/myboard/boardDetail";
	}
	
	@RequestMapping(value = "boardDel", method = RequestMethod.GET)
	public String boardDel(@RequestParam(value="num") Integer boardNum) {
		boardDelService.execute(boardNum);
		return "redirect:boardList";
	}
	
	@RequestMapping(value="boardDetail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam(value = "num") Integer boardNum, Model model) {
		boardDetailService.execute(model, boardNum);
		return "thymeleaf/myboard/boardInfo";
	}
	
	@RequestMapping(value="boardRegist", method = RequestMethod.POST)
	public String boardRegist(MyBoardCommand boardCommand, HttpServletRequest request) {
		boardWriteService.execute(boardCommand, request);
		return "redirect:boardList";
	}
	
	@RequestMapping("boardWrite")
	public String boardWrite() {
		return "thymeleaf/myboard/boardForm";
	}
	
	@RequestMapping("boardList")
	public String boardList(Model model){
		boardListService.execute(model);
		return "thymeleaf/myboard/boardList";
	}
}

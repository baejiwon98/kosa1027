package springBootTest2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBootTest2.command.BoardCommand;
import springBootTest2.service.BoardDelService;
import springBootTest2.service.BoardDetailService;
import springBootTest2.service.BoardInfoService;
import springBootTest2.service.BoardListService;
import springBootTest2.service.BoardModifyService;
import springBootTest2.service.BoardWriteService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardDetailService boardDetailService;
	@Autowired
	BoardDelService boardDelService;
	@Autowired
	BoardInfoService boardInfoService;
	@Autowired
	BoardModifyService boardModifyService;
	
	@RequestMapping(value="boardModify", method = RequestMethod.POST)
	public String boardModify(BoardCommand boardCommand) {
		boardModifyService.execute(boardCommand);
		return "redirect:boardDetail?num="+boardCommand.getBoardNum();
	}
	
	@RequestMapping("boardUpdate")
	public String boardUpdate(HttpServletRequest request) {
		boardInfoService.execute(request);
		return "thymeleaf/board/boardDetail";
	}
	
	@RequestMapping(value = "boardDel", method = RequestMethod.GET)
	public String boardDel(@RequestParam(value="num") Integer boardNum) {
		boardDelService.execute(boardNum);
		return "redirect:boardList";
	}
	
	@RequestMapping(value="boardDetail", method = RequestMethod.GET)
	public String boardDetail(@RequestParam(value = "num") Integer boardNum, Model model) {
		boardDetailService.execute(model, boardNum);
		return "thymeleaf/board/boardInfo";
	}
	
	@RequestMapping("boardList")
	public String boardList(Model model) {
		boardListService.execute(model);
		return "thymeleaf/board/boardList";
	}
	
	@RequestMapping(value="boardRegist" , method = RequestMethod.POST)
	public String boardRegist(BoardCommand boardCommand, HttpServletRequest request) {
		boardWriteService.execute(boardCommand, request);
		return "redirect:boardList";
	}
	
	@RequestMapping("boardWrite")
	public String boardWrite() {
		return "thymeleaf/board/boardForm";
	}
	
}

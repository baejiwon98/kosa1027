package springBootTest2.service.goods;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springBootTest2.command.GoodsCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsDelService {
	@Autowired
	GoodsMapper goodsMapper;
	public String execute(GoodsCommand goodsCommand, HttpSession session, Model model) {
		String path = null;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		GoodsDTO dto = goodsMapper.selectOne(goodsCommand.getGoodsNum());
		
		model.addAttribute("dto", dto);
		
		dto.setEmpId(authInfo.getUserId());
		Integer i = goodsMapper.goodsDel(goodsCommand.getGoodsNum());
		if(i > 0) {
			String storeFileNames[] = dto.getGoodsImage().split("`");
			String fileDir = session.getServletContext().getRealPath("/view/empLib");
			for(String fileName : storeFileNames) {
				File file = new File(fileDir + "/" + fileName);
				if(file.exists())file.delete();
			}
		}

		path = "redirect:goodsList";
		
		return path;
	}
}

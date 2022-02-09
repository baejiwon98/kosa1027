package springBootTest2.service.goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.GoodsCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.GoodsDTO;
import springBootTest2.mapper.GoodsMapper;

@Component
@Service
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");	
		
		GoodsDTO dto = new GoodsDTO();
		
		dto.setEmpId(authInfo.getUserId());
		
		dto.setEmpNum(goodsMapper.empnumGenerate(dto));
		dto.setGoodsNum(goodsMapper.numberGenerate());
		dto.setGoodsCompany(goodsCommand.getGoodsCompany());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsDate(goodsCommand.getGoodsDate());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsQty(goodsCommand.getGoodsQty());
		
		String storeTotal = "";
		String path = "/view/goods";
		String fileDir = request.getServletContext().getRealPath(path);
		
		for(MultipartFile mf : goodsCommand.getGoodsImage()) {
		 	String original = mf.getOriginalFilename();
			String extension = original.substring(original.lastIndexOf("."));
			// 중복 파일명이 있을 때를 대비하여 유일한 이름의 파일명을 생성
			String store = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = store + extension;
			File file = new File (fileDir + "/" + storeFileName);
			String fileSize = Long.toString(mf.getSize());
			try {
				mf.transferTo(file);
			}catch(Exception e) {e.printStackTrace();}
			storeTotal += storeFileName + "`";
		}
		dto.setGoodsImage(storeTotal);
		
		goodsMapper.goodsInsert(dto);
	}
}

package kosaShoppingMall.service.goods;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.command.GoodsIpgoCommand;
import kosaShoppingMall.domain.GoodsIpgoDTO;
import kosaShoppingMall.mapper.GoodsMapper;

@Service
public class GoodsIpgoUpdateService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand) {		
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		System.out.println("수량 변경"+goodsIpgoCommand.getMadeDate());
		dto.setMadeDate(Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
		System.out.println("날짜");
		goodsMapper.goodsIpgoUpdate(dto);
	}
}

package kosaShoppingMall.domain;

import lombok.Data;

@Data
public class GoodsDTO {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsImages;
	String goodsMain;
	String goodsContent;
	Integer deliveryCost;
	Integer visitCount;
	
	GoodsIpgoDTO goodsIpgoDTO;
}

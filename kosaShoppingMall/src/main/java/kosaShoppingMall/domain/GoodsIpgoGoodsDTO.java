package kosaShoppingMall.domain;

import lombok.Data;

@Data
public class GoodsIpgoGoodsDTO {
	GoodsDTO goodsDTO;
	GoodsIpgoDTO goodsIpgoDTO;
	public GoodsDTO getGoodsDTO() {
		return goodsDTO;
	}
	public void setGoodsDTO(GoodsDTO goodsDTO) {
		this.goodsDTO = goodsDTO;
	}
	public GoodsIpgoDTO getGoodsIpgoDTO() {
		return goodsIpgoDTO;
	}
	public void setGoodsIpgoDTO(GoodsIpgoDTO goodsIpgoDTO) {
		this.goodsIpgoDTO = goodsIpgoDTO;
	}
	
	
}

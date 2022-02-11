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

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsImages() {
		return goodsImages;
	}

	public void setGoodsImages(String goodsImages) {
		this.goodsImages = goodsImages;
	}

	public String getGoodsMain() {
		return goodsMain;
	}

	public void setGoodsMain(String goodsMain) {
		this.goodsMain = goodsMain;
	}

	public String getGoodsContent() {
		return goodsContent;
	}

	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}

	public Integer getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(Integer deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	public GoodsIpgoDTO getGoodsIpgoDTO() {
		return goodsIpgoDTO;
	}

	public void setGoodsIpgoDTO(GoodsIpgoDTO goodsIpgoDTO) {
		this.goodsIpgoDTO = goodsIpgoDTO;
	}
	
}

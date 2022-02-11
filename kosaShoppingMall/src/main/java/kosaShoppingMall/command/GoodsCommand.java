package kosaShoppingMall.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GoodsCommand {
	@NotBlank(message = "상품번호를 입력하세요.")
	String goodsNum;
	@NotBlank(message = "상품이름을 입력하세요.")
	String goodsName;
	@NotNull(message = "상품가격을 입력하세요.")
	Integer goodsPrice;
	@NotBlank(message = "상품내용을 입력하세요.")
	String goodsContent;
	@NotNull(message = "배송비를 입력하세요.")
	Integer deliveryCost;
	Integer visitCount;
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
	
}

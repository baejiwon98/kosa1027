package kosaShoppingMall.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "goodsIpgoDTO")
public class GoodsIpgoDTO {
	Date ipgoDate;
	String goodsNum;
	Integer ipgoQty;
	Timestamp madeDate;
	public Date getIpgoDate() {
		return ipgoDate;
	}
	public void setIpgoDate(Date ipgoDate) {
		this.ipgoDate = ipgoDate;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Integer getIpgoQty() {
		return ipgoQty;
	}
	public void setIpgoQty(Integer ipgoQty) {
		this.ipgoQty = ipgoQty;
	}
	public Timestamp getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(Timestamp madeDate) {
		this.madeDate = madeDate;
	}
	
}

package kosaShoppingMall.command;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class GoodsIpgoCommand {
	@Size(min=10, max=10, message = "번호를 10글자 입력하여 주세요.")
	String goodsNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message ="입고일을 입력해주세요")
	Date ipgoDate;
	@NotNull(message = "입고 수량을 입력해주세요")
	Integer ipgoQty;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull(message = "제조일을 입력해주세요")
	LocalDateTime madeDate;
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Date getIpgoDate() {
		return ipgoDate;
	}
	public void setIpgoDate(Date ipgoDate) {
		this.ipgoDate = ipgoDate;
	}
	public Integer getIpgoQty() {
		return ipgoQty;
	}
	public void setIpgoQty(Integer ipgoQty) {
		this.ipgoQty = ipgoQty;
	}
	public LocalDateTime getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(LocalDateTime madeDate) {
		this.madeDate = madeDate;
	}
	
}

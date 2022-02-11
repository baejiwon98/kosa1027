package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("StartEndPageDTO")
public class StartEndPageDTO {
	Long startRow;
	Long endRow;
	
	String goodsWord;
	String goodsName;
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getEndRow() {
		return endRow;
	}
	public void setEndRow(Long endRow) {
		this.endRow = endRow;
	}
	public String getGoodsWord() {
		return goodsWord;
	}
	public void setGoodsWord(String goodsWord) {
		this.goodsWord = goodsWord;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
}

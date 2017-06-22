package com.topone.entry;

import java.io.Serializable;

/**
 * 库存表
 * 
 * @author liliang
 *
 */
public class Stock implements Serializable {

	private Integer commodityId;
	private Integer stock;

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "SeckStock [commodityId=" + commodityId + ", stock=" + stock + "]";
	}

}

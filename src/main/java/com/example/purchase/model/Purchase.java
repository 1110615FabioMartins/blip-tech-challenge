package com.example.purchase.model;



import org.joda.time.DateTime;

import com.example.purchase.utils.JsonJodaDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Purchase {
	
	private Long id;
	
	private String productType;
	
	@JsonSerialize(using = JsonJodaDateTimeSerializer.class)
	private DateTime expires;
	
	private Detail detail;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public DateTime getExpires() {
		return expires;
	}

	public void setExpires(DateTime expires) {
		this.expires = expires;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	
	
	
	

}

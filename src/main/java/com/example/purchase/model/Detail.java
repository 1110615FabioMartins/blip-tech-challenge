package com.example.purchase.model;
/**
 * Model class that represent's a detail for a purchase.
 * 
 * @author fabio.martins
 * @since 27-10-2016
 * @version 0.0.1
 *
 */
public class Detail {
	
	/**ID detail**/
	private Long id;
	
	/**Description of a purchase**/
	private String description;
	
	/**Quantity purchased**/
	private Integer quantity;
	
	/**Value of a purchase**/
	private Double value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Detail other = (Detail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Detail [id=" + id + ", description=" + description + ", quantity=" + quantity + ", value=" + value
				+ "]";
	}
	

}

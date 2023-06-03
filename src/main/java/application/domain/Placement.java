package application.domain;

import java.sql.Timestamp;

public class Placement {

	private Long id;
	private Long tableId;
	private Long registeredCustomerId;
	private String orderType;
	private Timestamp placedTime;
	private Long visitHour;
	
	public Placement(Long tableId, Long registeredCustomerId, String orderType, Timestamp placedTime, Long visitHour) {
		this.tableId = tableId;
		this.registeredCustomerId = registeredCustomerId;
		this.orderType = orderType;
		this.placedTime = placedTime;
		this.visitHour = visitHour;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getTableId() {
		return tableId;
	}
	
	public String getOrderType() {
		return orderType;
	}
	
	public Long getRegisteredCustomerId() {
		return registeredCustomerId;
	}
	
	public Timestamp getPlacedTime() {
		return placedTime;
	}
	
	public Long getVisitHour() {
		return visitHour;
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public void setRegisteredCustomerId(Long registeredCustomerId) {
		this.registeredCustomerId = registeredCustomerId;
	}
	
	public void setVisitHour(Long visitHour) {
		this.visitHour = visitHour;
	}
	
}

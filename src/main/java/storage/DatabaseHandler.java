package storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import application.domain.RegisteredCustomer;
import application.domain.Placement;

public class DatabaseHandler {
	
	private JdbcTemplate jdbcTemplate;
	
	public DatabaseHandler(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public RegisteredCustomer selectCustomerByPhoneNumber(String phoneNumber) {
		
		List<RegisteredCustomer> results = jdbcTemplate.query("SELECT * FROM BOOK_SYSTEM.RegisteredCustomer where PHONENUMBER = ?", 
				new RowMapper<RegisteredCustomer>() {
					@Override
					public RegisteredCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
						RegisteredCustomer rc = new RegisteredCustomer(
								rs.getString("PHONENUMBER"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"));
						return rc; }
		}, phoneNumber);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Long insertRegisteredCustomer(RegisteredCustomer registeredCustomer) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
				"INSERT INTO BOOK_SYSTEM.RegisteredCustomer (PHONENUMBER, PASSWORD, NAME)" + "VALUES(?, ?, ?)", new String[] {"OID"});
				pstmt.setString(1, registeredCustomer.getPhoneNumber());
				pstmt.setString(2, registeredCustomer.getPassword());
				pstmt.setString(3, registeredCustomer.getName());
				return pstmt; } 
			}, keyHolder);
		Number keyValue = keyHolder.getKey();
		
		return keyValue.longValue();
	}
	
	public RegisteredCustomer checkLoginRequestCorrect(String phoneNumber, String password) {
		List<RegisteredCustomer> results = jdbcTemplate.query("SELECT * FROM BOOK_SYSTEM.RegisteredCustomer where PHONENUMBER = ? and PASSWORD = ?",
				new RowMapper<RegisteredCustomer>() {
			@Override
			public RegisteredCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
				RegisteredCustomer rc = new RegisteredCustomer(
						rs.getString("PHONENUMBER"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"));
				return rc; }
		}, phoneNumber, password);
		
		return results.isEmpty() ? null : results.get(0);
	}

	public List<Placement> selectAllPlacement() {
		List<Placement> results = jdbcTemplate.query("SELECT * FROM BOOK_SYSTEM.Placement", 
				new RowMapper<Placement>() {
					@Override
					public Placement mapRow(ResultSet rs, int rowNum) throws SQLException {
						Placement p = new Placement(
								rs.getLong("TABLE_OID"),
								rs.getLong("REGISTERED_CUSTOMER_OID"),
								rs.getString("ORDER_TYPE"),
								rs.getTimestamp("PLACED_TIME"),
								rs.getLong("VISIT_HOUR"));
						return p; } });
		
		return results;
		
	}
	
	public void insertReservationPlacement(Placement placement) {
		jdbcTemplate.update( new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
				"INSERT INTO BOOK_SYSTEM.Placement (TABLE_OID, REGISTERED_CUSTOMER_OID, ORDER_TYPE, PLACED_TIME, VISIT_HOUR)" + "VALUES(?, ?, ?, ?, ?)");
				pstmt.setString(1, placement.getTableId().toString());
				pstmt.setString(2, "Reservation");
				pstmt.setString(3, placement.getRegisteredCustomerId().toString());
				pstmt.setString(4, placement.getPlacedTime().toString());
				pstmt.setString(5, placement.getVisitHour().toString());
				return pstmt; } }
		);
	}
	
	public void insertWalkInPlacement(Placement placement) {
		jdbcTemplate.update( new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
				"INSERT INTO BOOK_SYSTEM.Placement (TABLE_OID, REGISTERED_CUSTOMER_OID, ORDER_TYPE, PLACED_TIME, VISIT_HOUR)" + "VALUES(?, ?, ?, ?, ?)");
				pstmt.setString(1, placement.getTableId().toString());
				pstmt.setString(2, "WalkIn");
				pstmt.setString(3, placement.getRegisteredCustomerId().toString());
				pstmt.setString(4, placement.getPlacedTime().toString());
				pstmt.setString(5, placement.getVisitHour().toString());
				return pstmt; } }
		);
	}
	
	// public void cancelPlacement(Placement placement) { }
	
}

package com.checonbinh.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseShop {
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		
	}
	
	public void getListEmployee() {
		String sql = "select * from employee";
		List<NhanVien> listNhanViens = jdbcTemplate.query(sql, new RowMapper<NhanVien>() {

			public NhanVien mapRow(ResultSet rowResult, int rowNum) throws SQLException {
				NhanVien nv = new NhanVien();
				nv.name = rowResult.getString("UserName");
				nv.age = rowResult.getInt("Age");
				return nv;
			}
			
		});
		
		for(NhanVien nv : listNhanViens) {
			System.out.println(nv.getName() + nv.getAge());
		}
	}
}

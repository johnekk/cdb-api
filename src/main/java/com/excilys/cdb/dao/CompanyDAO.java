package com.excilys.cdb.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.excilys.cdb.exceptions.DAOException;
import com.excilys.cdb.mapper.CompanyMapper;
import com.excilys.cdb.model.Company;

@Repository
public class CompanyDAO {

	JdbcTemplate jdbcTemplate;
	
	private static final String CREATE_COMPUTER = "	INSERT INTO company (name)"
												+ "	VALUES (?)";
	
	private static final String FIND_ALL_COMPANIES	= "SELECT id, name "
													+ "FROM company ";
	
	private static final String FIND_COMPANY_BY_ID	= "SELECT ca.id, ca.name "
													+ "FROM company ca "
													+ "WHERE id = ? ";
	
	private static final String FIND_NUMBER_OF_COMPANY	= "	SELECT count(company.id) AS 'nbCompany' "
														+ "	FROM company ";
	
	private static final String UPDATE_COMPANY 	= "	UPDATE company "
												+ "	SET name = ? "
												+ "	WHERE id = ? ";

	private static final String DELETE_COMPUTER_BY_COMPANYID 	= " DELETE"
																+ "	FROM computer"
																+ " WHERE company_id = ? ";
	
	private static final String DELETE_COMPANY	= " DELETE "
												+ "	FROM company "
												+ " WHERE id = ?";

	public CompanyDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public boolean createCompany(Company company) {
		return jdbcTemplate.update(CREATE_COMPUTER, company.getName()) > 0;
	}
	
	public List<Company> findAllCompanies() throws DAOException {
		return jdbcTemplate.query(FIND_ALL_COMPANIES, new CompanyMapper());
	}
	
	public Company findCompanyById(int id) throws DAOException {
		return jdbcTemplate.queryForObject(FIND_COMPANY_BY_ID, new Object[] { id }, new CompanyMapper());
	}
	
	public int findNumberOfCompanies() throws DAOException {
		return jdbcTemplate.queryForObject(FIND_NUMBER_OF_COMPANY, Integer.class);
	}
	
	public boolean updateCompany(Company company) {	
		return jdbcTemplate.update(UPDATE_COMPANY, company.getName(), 
													company.getId()) > 0;	
	}
	
	public boolean deleteCompany(int id) throws DAOException {
		return jdbcTemplate.update((DELETE_COMPUTER_BY_COMPANYID + DELETE_COMPANY), id) > 0;
	}
}

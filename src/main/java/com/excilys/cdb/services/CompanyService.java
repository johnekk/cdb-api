package com.excilys.cdb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.excilys.cdb.dao.CompanyDAO;
import com.excilys.cdb.dtos.CompanyDTO;
import com.excilys.cdb.mapper.CompanyMapper;
import com.excilys.cdb.model.Company;


@Service
public class CompanyService {
	/**START Constructor Spring*/
	private final CompanyDAO companyDAO;

	public CompanyService(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	/**END Constructor Spring*/
	
	public boolean create(Company company) {
		return companyDAO.createCompany(company);
	}
	
	public List<Company> getListCompany() {
		return companyDAO.findAllCompanies();
	}
	public List<CompanyDTO> findAll() { 
		return CompanyMapper.listCompanyToCompanyDTO(getListCompany()); 
	}
	
	public int nbCompany() { 
		return companyDAO.findNumberOfCompanies();
	}
	
	public Company findByID(int id) {
		return companyDAO.findCompanyById(id);
	}
	
	public boolean update(Company company) { 
		return companyDAO.updateCompany(company);
	}
	
	public boolean delete(int id) {
		return companyDAO.deleteCompany(id);
	}

}

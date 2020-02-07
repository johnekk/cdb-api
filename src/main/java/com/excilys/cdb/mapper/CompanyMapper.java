package com.excilys.cdb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.excilys.cdb.dtos.CompanyDTO;
import com.excilys.cdb.model.Company;

public class CompanyMapper implements RowMapper<Company> {

	public static Company companyDTOtoCompany(CompanyDTO companyDTO) {
		return new Company.	CompanyBuilder().
							setId(companyDTO.getId()).
							setName(companyDTO.getName()).build();
	}
	
	public static CompanyDTO companyToCompanyDTO(Company company) {
		return new CompanyDTO.	CompanyDTOBuilder().
								setId(company.getId()).
								setName(company.getName()).build();
	}

	public static List<CompanyDTO> listCompanyToCompanyDTO(List<Company> list){
		List<CompanyDTO> listDTO = new ArrayList<CompanyDTO> ();
		
		for (Company company : list) {
			listDTO.add(companyToCompanyDTO(company));
		}
		
		return listDTO;
		
	}
	
	@Override
	public Company mapRow(ResultSet res, int rowNum) throws SQLException {
		Company company = 	new Company.CompanyBuilder().
							setId(res.getInt("id")).
							setName(res.getString("name")).
							build();
		return company;
	}
}

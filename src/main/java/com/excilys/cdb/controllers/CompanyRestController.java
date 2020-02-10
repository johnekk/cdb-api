package com.excilys.cdb.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excilys.cdb.dtos.CompanyDTO;
import com.excilys.cdb.mapper.CompanyMapper;
import com.excilys.cdb.services.CompanyService;

@RestController
@RequestMapping(value = "/companys")
public class CompanyRestController {

	private CompanyService companyService;
	
	public CompanyRestController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@CrossOrigin
	@GetMapping
	//@ApiOperation(value = "${swagger.computers}")
	public List<CompanyDTO> getAll() {	
		return companyService.findAll();
	}
	
	@CrossOrigin
	@PostMapping
	public boolean create(@RequestBody CompanyDTO companyDTO) {
		return companyService.create(CompanyMapper.companyDTOtoCompany(companyDTO));
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public boolean edit(@RequestBody CompanyDTO companyDTO, @PathVariable int id) {
		companyDTO.setId(id);
		return companyService.update(CompanyMapper.companyDTOtoCompany(companyDTO));
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id) {	
		return companyService.delete(id);
	}
}

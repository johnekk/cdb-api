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

import com.excilys.cdb.dtos.ComputerDTO;
import com.excilys.cdb.mapper.ComputerMapper;
import com.excilys.cdb.services.ComputerService;


@RestController
@RequestMapping(value = "/computers")
public class ComputerRestController {
	
	private ComputerService computerService;
	
		
	public ComputerRestController(ComputerService computerService) {
		this.computerService = computerService;
	}
	
	@CrossOrigin
	@GetMapping
	//@ApiOperation(value = "${swagger.computers}")
	public List<ComputerDTO> getAll() {	
		return computerService.findAll();
	}
	
	@CrossOrigin
	@PostMapping
	public boolean create(@RequestBody ComputerDTO computerDTO) {
		return computerService.create( ComputerMapper.computerDTOToComputer(computerDTO));
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}/")
	public boolean delete(@PathVariable int id) {	
		return computerService.delete(id);
	}
	
	@CrossOrigin
	@PutMapping
	public boolean edit(ComputerDTO computerDTO) {
		return computerService.update( ComputerMapper.computerDTOToComputer(computerDTO) );
	}
	
}

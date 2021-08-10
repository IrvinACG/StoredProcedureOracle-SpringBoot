package com.iacg.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iacg.domain.model.Domain;
import com.iacg.domain.service.DomainServiceImpl;

@RestController
@RequestMapping("/v1/domain")
@CrossOrigin(origins = "*", methods = RequestMethod.GET, allowedHeaders = "*")
public class DomainController {

	@Autowired
	private DomainServiceImpl domainService;

	@GetMapping("")
	public ResponseEntity<List<Domain>> listDomain() {
		List<Domain> listDomain = domainService.findAll();
		return new ResponseEntity<>(listDomain, HttpStatus.OK);
	}

	@GetMapping("/{idDomain}")
	public ResponseEntity<Domain> retrieveDomain(@PathVariable(required = true) String idDomain) {
		Domain domain = domainService.findById(idDomain);
		return new ResponseEntity<>(domain, HttpStatus.OK);
	}

	public void setDomainService(DomainServiceImpl domainService) {
		this.domainService = domainService;
	}
}

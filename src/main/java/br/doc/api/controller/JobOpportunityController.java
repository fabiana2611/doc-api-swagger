package br.doc.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.doc.api.model.JobOpportunity;
import br.doc.api.repository.JobOpportunities;
import br.doc.api.service.JobOpportunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class to control access of funcionalities
 * - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/rest/opportunities")
@Api(value = "Restaurant Controller", description = "shows Job Opportunities")
public class JobOpportunityController {
	
	@Autowired
	private JobOpportunities opportunities;
	
	@Autowired
	private JobOpportunityService service;
	
	@ApiOperation(value = "Returns a List of Opportunity")
    @ApiResponses( value = {  @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful List")})
	@GetMapping
	public List<JobOpportunity> listar() {
		return opportunities.findAll();
	}
	
	@ApiOperation(value = "Returns a List of Opportunity by Restaurant")
    @ApiResponses( value = {  @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful List")})
	@GetMapping ("/restaurant/{id}")
	public List<JobOpportunity> findByRestaurant(@PathVariable Integer id) {
		return opportunities.findByRestaurantId(id);
	}
	
	@ApiOperation(value = "Returns Opportunity")
	@PostMapping
	public JobOpportunity addNewOpportunity(@RequestBody @Valid JobOpportunity opportunity) {
		return service.addNewOpportunity(opportunity);
	}

}

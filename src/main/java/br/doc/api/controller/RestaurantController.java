package br.doc.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.doc.api.model.Restaurant;
import br.doc.api.repository.Restaurants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class to control access of funcionalities
 *  - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping ("/rest/restaurants")
@Api(value = "Restaurant Controller", description = "shows restaurants")
public class RestaurantController {
	
	@Autowired
	private Restaurants restaurants;
	
	@ApiOperation(value = "Returns a List of Restaurant")
    @ApiResponses( value = {  @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful List")})
	@GetMapping
	public List<Restaurant> listar() {
		return restaurants.findAll();
	}

	@ApiOperation(value = "Returns the new Restaurant")
	@PostMapping
	public Restaurant addNewRestaurant(@RequestBody @Valid Restaurant restaurant) {
		return restaurants.save(restaurant);
	}
}

	
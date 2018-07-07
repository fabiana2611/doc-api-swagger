package br.doc.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.doc.api.model.JobOpportunity;
import br.doc.api.model.Restaurant;
import br.doc.api.repository.JobOpportunities;
import br.doc.api.repository.Restaurants;

@Service
public class JobOpportunityService {

	@Autowired
	private Restaurants restaurants;
	
	@Autowired
	private JobOpportunities opportunities; 
	
	public JobOpportunity addNewOpportunity(JobOpportunity opportunity) {
		
		opportunity.setDateStartAnnounce(LocalDateTime.now());
		
		Integer restaurantId = opportunity.getRestaurant().getId();
		
		Restaurant restaurant = restaurants.findById(restaurantId).get();
		
		opportunity.setRestaurant(restaurant);
		
		return opportunities.save(opportunity);

	}
	
}

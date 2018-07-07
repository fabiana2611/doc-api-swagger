package br.doc.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.doc.api.model.JobOpportunity;

public interface JobOpportunities extends JpaRepository<JobOpportunity, Integer> {

	public List<JobOpportunity> findByRestaurantId(Integer id);
}

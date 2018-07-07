package br.doc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.doc.api.model.Restaurant;

public interface Restaurants extends JpaRepository<Restaurant, Integer> {

}

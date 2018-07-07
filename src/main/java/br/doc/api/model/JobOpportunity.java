package br.doc.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.doc.api.model.domain.Position;
import io.swagger.annotations.ApiModelProperty;

@Entity (name = "jobopportunity")
public class JobOpportunity {

	@ApiModelProperty(notes = "Id of the JobOpportunity")
	@Id
	@GeneratedValue (strategy  = GenerationType.IDENTITY)
	private Integer id;
	
	@ApiModelProperty(notes = "Position Code of the JobOpportunity [WAITER:0, MANAGER:1, COOKER:2]")
	@Column (name = "position_code")
	private Integer positionCode;
	
	@ApiModelProperty(notes = "Date that Announce was published")
	private LocalDateTime dateStartAnnounce;
	
	@ApiModelProperty(notes = "Restaurant where there is the opportunity")
	@JsonIgnoreProperties("opportunities")
	@ManyToOne
	private Restaurant restaurant;
	

	// --- Getters && Setters ---
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(Integer positionCode) {
		this.positionCode = positionCode;
	}
	
	public String getPositionDescription() {
		return Position.getByCode(positionCode).getDesciption();
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	
	// ------ EQUAL AND HASH
	
	public LocalDateTime getDateStartAnnounce() {
		return dateStartAnnounce;
	}

	public void setDateStartAnnounce(LocalDateTime dateStartAnnounce) {
		this.dateStartAnnounce = dateStartAnnounce;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		JobOpportunity review = (JobOpportunity) o;

		if (!positionCode.equals(review.positionCode))
			return false;
		if (!restaurant.equals(review.restaurant))
			return false;
		return dateStartAnnounce.equals(review.dateStartAnnounce);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + positionCode.hashCode();
		result = 31 * result + restaurant.hashCode();
		result = 31 * result + dateStartAnnounce.hashCode();
		return result;
	}
}

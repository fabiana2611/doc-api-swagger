package br.doc.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * Entity to represent restaurants
 * 
 * @author fabiana.araujo
 *
 */
@Entity
public class Restaurant {

	@ApiModelProperty(notes = "Id of the restaurant")
	@Id
	@GeneratedValue (strategy  = GenerationType.IDENTITY)
	private Integer id;
	
	@ApiModelProperty(notes = "Name of the restaurant")
	private String name;
	
	@ApiModelProperty(notes = "Address of the restaurant")
	private String address;
	
	@ApiModelProperty(notes = "E-mail of the restaurant")
	private String email;
	
	@ApiModelProperty(notes = "List of opportunities")
	@JsonIgnoreProperties("restaurant")
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<JobOpportunity> opportunities;
	

	// --- Getters && Setters ----
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// --- Equals && Hashcode ----
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!address.equals(that.address)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + id;
        return result;
    }
	
}

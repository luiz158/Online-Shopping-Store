package cs544.project.onlineshoppingstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Customer extends ACLUser{
	
	@NotBlank(message = "Name cannot be blank.")
	private String name;
	
	@OneToOne(mappedBy="customer")
	private ShippingAddress shipingAddress;
	
	@OneToOne(mappedBy="customer")
	private BilingAddress bilingAddress;
	
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
	private List<Order> order;
	
	@Email(message = "Invalid email format.")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShippingAddress getShipingAddress() {
		return shipingAddress;
	}

	public void setShipingAddress(ShippingAddress shipingAddress) {
		this.shipingAddress = shipingAddress;
	}

	public BilingAddress getBilingAddress() {
		return bilingAddress;
	}

	public void setBilingAddress(BilingAddress bilingAddress) {
		this.bilingAddress = bilingAddress;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

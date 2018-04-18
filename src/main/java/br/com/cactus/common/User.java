package br.com.cactus.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String email;
	private String password;
	private UserRole role;
	
	/**
	 * @deprecated JPA eyes only
	 */
	User(){}
	
	private User(String email, String password, UserRole role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public User of(String email, String password, UserRole role){
		return new User(email, password, role);
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}

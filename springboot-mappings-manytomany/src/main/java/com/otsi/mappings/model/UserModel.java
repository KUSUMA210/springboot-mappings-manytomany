package com.otsi.mappings.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String mobile;
	@Column(unique = true)
	private String email;
	@ManyToMany(targetEntity = RoleModel.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(name = "t_user_role", joinColumns =  @JoinColumn(name = "user_id",referencedColumnName = "id") , inverseJoinColumns = 
			@JoinColumn(name = "role_id",referencedColumnName = "id" ))
	private List<RoleModel> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}

	public void addRole(RoleModel role) {
		this.roles.add(role);
		role.getUsers().add(this);
	}

	public void removeRoles(RoleModel role) {
		this.getRoles().remove(role);
		role.getUsers().remove(this);
	}

	public void removeRoles() {
		for (RoleModel role : new ArrayList<>(roles)) {
			removeRoles(role);
		}
	}

}
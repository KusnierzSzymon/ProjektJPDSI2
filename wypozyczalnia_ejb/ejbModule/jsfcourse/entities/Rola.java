package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_rola;

	private String nazwa_rola;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="rola")
	private List<User> users;

	public Rola() {
	}

	public int getId_rola() {
		return this.id_rola;
	}

	public void setId_rola(int id_rola) {
		this.id_rola = id_rola;
	}

	public String getNazwa_rola() {
		return this.nazwa_rola;
	}

	public void setNazwa_rola(String nazwa_rola) {
		this.nazwa_rola = nazwa_rola;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRola(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRola(null);

		return user;
	}

}
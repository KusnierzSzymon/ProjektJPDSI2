package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the wypozyczenie database table.
 * 
 */
@Entity
@NamedQuery(name="Wypozyczenie.findAll", query="SELECT w FROM Wypozyczenie w")
public class Wypozyczenie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_wypozyczenia;

	private byte akceptacja;

	@Temporal(TemporalType.DATE)
	private Date data_wypozyczenia;

	private int liczba_dni;

	private byte zakonczone;

	//bi-directional many-to-many association to Sprzet
	@ManyToMany
	@JoinTable(
		name="wypozsprzet"
		, joinColumns={
			@JoinColumn(name="Id_wypozyczenia")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Id_sprzet")
			}
		)
	private List<Sprzet> sprzets;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Id_user")
	private User user;

	//bi-directional many-to-one association to Wypozyczalnia
	@ManyToOne
	@JoinColumn(name="Id_wypozyczalnia")
	private Wypozyczalnia wypozyczalnia;

	public Wypozyczenie() {
	}

	public int getId_wypozyczenia() {
		return this.id_wypozyczenia;
	}

	public void setId_wypozyczenia(int id_wypozyczenia) {
		this.id_wypozyczenia = id_wypozyczenia;
	}

	public byte getAkceptacja() {
		return this.akceptacja;
	}

	public void setAkceptacja(byte akceptacja) {
		this.akceptacja = akceptacja;
	}

	public Date getData_wypozyczenia() {
		return this.data_wypozyczenia;
	}

	public void setData_wypozyczenia(Date data_wypozyczenia) {
		this.data_wypozyczenia = data_wypozyczenia;
	}

	public int getLiczba_dni() {
		return this.liczba_dni;
	}

	public void setLiczba_dni(int liczba_dni) {
		this.liczba_dni = liczba_dni;
	}

	public byte getZakonczone() {
		return this.zakonczone;
	}

	public void setZakonczone(byte zakonczone) {
		this.zakonczone = zakonczone;
	}

	public List<Sprzet> getSprzets() {
		return this.sprzets;
	}

	public void setSprzets(List<Sprzet> sprzets) {
		this.sprzets = sprzets;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Wypozyczalnia getWypozyczalnia() {
		return this.wypozyczalnia;
	}

	public void setWypozyczalnia(Wypozyczalnia wypozyczalnia) {
		this.wypozyczalnia = wypozyczalnia;
	}

}
package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the wypozyczalnia database table.
 * 
 */
@Entity
@NamedQuery(name="Wypozyczalnia.findAll", query="SELECT w FROM Wypozyczalnia w")
public class Wypozyczalnia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_wypozyczalnia;

	private int kod_pocztowy;

	private String miasto;

	private String ulica;

	//bi-directional many-to-one association to Wypozyczenie
	@OneToMany(mappedBy="wypozyczalnia")
	private List<Wypozyczenie> wypozyczenies;

	public Wypozyczalnia() {
	}

	public int getId_wypozyczalnia() {
		return this.id_wypozyczalnia;
	}

	public void setId_wypozyczalnia(int id_wypozyczalnia) {
		this.id_wypozyczalnia = id_wypozyczalnia;
	}

	public int getKod_pocztowy() {
		return this.kod_pocztowy;
	}

	public void setKod_pocztowy(int kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}

	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public List<Wypozyczenie> getWypozyczenies() {
		return this.wypozyczenies;
	}

	public void setWypozyczenies(List<Wypozyczenie> wypozyczenies) {
		this.wypozyczenies = wypozyczenies;
	}

	public Wypozyczenie addWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenies().add(wypozyczeny);
		wypozyczeny.setWypozyczalnia(this);

		return wypozyczeny;
	}

	public Wypozyczenie removeWypozyczeny(Wypozyczenie wypozyczeny) {
		getWypozyczenies().remove(wypozyczeny);
		wypozyczeny.setWypozyczalnia(null);

		return wypozyczeny;
	}

}
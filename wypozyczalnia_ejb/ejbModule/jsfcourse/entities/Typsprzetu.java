package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typsprzetu database table.
 * 
 */
@Entity
@NamedQuery(name="Typsprzetu.findAll", query="SELECT t FROM Typsprzetu t")
public class Typsprzetu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_typsprzetu;

	private byte dla_dzieci;

	private int liczba_dostepnych;

	private String nazwa_typ;

	//bi-directional many-to-one association to Sprzet
	@OneToMany(mappedBy="typsprzetu")
	private List<Sprzet> sprzets;

	public Typsprzetu() {
	}

	public int getId_typsprzetu() {
		return this.id_typsprzetu;
	}

	public void setId_typsprzetu(int id_typsprzetu) {
		this.id_typsprzetu = id_typsprzetu;
	}

	public byte getDla_dzieci() {
		return this.dla_dzieci;
	}

	public void setDla_dzieci(byte dla_dzieci) {
		this.dla_dzieci = dla_dzieci;
	}

	public int getLiczba_dostepnych() {
		return this.liczba_dostepnych;
	}

	public void setLiczba_dostepnych(int liczba_dostepnych) {
		this.liczba_dostepnych = liczba_dostepnych;
	}

	public String getNazwa_typ() {
		return this.nazwa_typ;
	}

	public void setNazwa_typ(String nazwa_typ) {
		this.nazwa_typ = nazwa_typ;
	}

	public List<Sprzet> getSprzets() {
		return this.sprzets;
	}

	public void setSprzets(List<Sprzet> sprzets) {
		this.sprzets = sprzets;
	}

	public Sprzet addSprzet(Sprzet sprzet) {
		getSprzets().add(sprzet);
		sprzet.setTypsprzetu(this);

		return sprzet;
	}

	public Sprzet removeSprzet(Sprzet sprzet) {
		getSprzets().remove(sprzet);
		sprzet.setTypsprzetu(null);

		return sprzet;
	}

}
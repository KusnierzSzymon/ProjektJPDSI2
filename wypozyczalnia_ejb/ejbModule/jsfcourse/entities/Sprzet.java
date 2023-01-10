package jsfcourse.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sprzet database table.
 * 
 */
@Entity
@NamedQuery(name="Sprzet.findAll", query="SELECT s FROM Sprzet s")
public class Sprzet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_sprzet;

	private int cena_dzien;

	private String model;

	private String producent;

	private int rozmiar;

	//bi-directional many-to-one association to Typsprzetu
	@ManyToOne
	@JoinColumn(name="Id_typsprzetu")
	private Typsprzetu typsprzetu;

	//bi-directional many-to-many association to Wypozyczenie
	@ManyToMany(mappedBy="sprzets")
	private List<Wypozyczenie> wypozyczenies;

	public Sprzet() {
	}

	public int getId_sprzet() {
		return this.id_sprzet;
	}

	public void setId_sprzet(int id_sprzet) {
		this.id_sprzet = id_sprzet;
	}

	public int getCena_dzien() {
		return this.cena_dzien;
	}

	public void setCena_dzien(int cena_dzien) {
		this.cena_dzien = cena_dzien;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProducent() {
		return this.producent;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

	public int getRozmiar() {
		return this.rozmiar;
	}

	public void setRozmiar(int rozmiar) {
		this.rozmiar = rozmiar;
	}

	public Typsprzetu getTypsprzetu() {
		return this.typsprzetu;
	}

	public void setTypsprzetu(Typsprzetu typsprzetu) {
		this.typsprzetu = typsprzetu;
	}

	public List<Wypozyczenie> getWypozyczenies() {
		return this.wypozyczenies;
	}

	public void setWypozyczenies(List<Wypozyczenie> wypozyczenies) {
		this.wypozyczenies = wypozyczenies;
	}

}
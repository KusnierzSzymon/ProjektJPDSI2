package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KalkulatorBB {
	private Integer kwota;
	private Double oprocentowanie;
	private Integer lat;
	private Double result;

	@Inject
	FacesContext ctx;

	

	public Integer getKwota() {
		return kwota;
	}

	public void setKwota(Integer kwota) {
		this.kwota = kwota;
	}

	public Double getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(Double oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public Integer getLat() {
		return lat;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			

			result = (kwota + kwota * (lat * (oprocentowanie/100))) / (lat * 12);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	

	public String info() {
		return "info";
	}
}

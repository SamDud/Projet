package fr.eni.clinique.bo;

import java.time.LocalDate;

public class Agenda {

	private int CodeVeto;
	private LocalDate DateRdv;
	private int CodeAnimal;
	
	public Agenda(int codeVeto, LocalDate dateRdv, int codeAnimal) {
		super();
		CodeVeto = codeVeto;
		DateRdv = dateRdv;
		CodeAnimal = codeAnimal;
	}

	public int getCodeVeto() {
		return CodeVeto;
	}

	public void setCodeVeto(int codeVeto) {
		CodeVeto = codeVeto;
	}

	public LocalDate getDateRdv() {
		return DateRdv;
	}

	public void setDateRdv(LocalDate dateRdv) {
		DateRdv = dateRdv;
	}

	public int getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(int codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	@Override
	public String toString() {
		return "Agendas [CodeVeto=" + CodeVeto + ", DateRdv=" + DateRdv + ", CodeAnimal=" + CodeAnimal + "]";
	}
	
}

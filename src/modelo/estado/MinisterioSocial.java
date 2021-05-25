package modelo.estado;

import java.util.ArrayList;

import modelo.ser.Adulto;
import modelo.ser.Menor;
import modelo.ser.Ser;

//Se encargad de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {

	private final ArrayList<Menor> menores = new ArrayList<>();
	private final ArrayList<Ser> ancianos = new ArrayList<>();
	private ArrayList<Adulto> parados = null;

	public MinisterioSocial(ArrayList<Adulto> parados) {
		this.parados = parados;
	}
	
	public ArrayList<Adulto> getParados() {
		return parados;
	}
	
	public ArrayList<Menor> getMenores() {
		return menores;
	}
	
	public ArrayList<Ser> getAncianos() {
		return ancianos;
	}
	
	public int getNumeroParados() {
		return parados.size();
	}
	
	public int getNumeroAncianos() {
		return ancianos.size();
	}
	
	public int getNumeroMenores() {
		return menores.size();
	}

	public void aniadirMenor() {
		menores.add(new Menor());
	}

}

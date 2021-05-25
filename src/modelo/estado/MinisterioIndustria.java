package modelo.estado;

import java.util.ArrayList;

import modelo.ser.Adulto;
import modelo.ser.Ser;

//Se encarga de los trabajadores y parados
//porque se encarga de contratar y despedir
public class MinisterioIndustria {
	
	// el aumento de produccion en este periodo
	private float porcentajeAumento;
	// lo cantidad que puede producir el estado
	private long produccionPotencial = 0;
	// lo que realmente produce el estado
	private long produccion;
	// La cantidad que cada trabajador produce por periodo
	private int potenciaTrabajador = 450;
	
	private final ArrayList<Adulto> trabajadores = new ArrayList<Adulto>();
	private ArrayList<Adulto> parados = null;
	
	
	public MinisterioIndustria(ArrayList<Adulto> parados) {
		this.parados=parados;
	}
	
	public void contratar(long trabajadoresNecesarios) {
		// TODO Auto-generated method stub
		
	}

	public long calcularTrabajadoresNecesarios(long demanda) {
		return demanda-produccionPotencial;
		
	}
	
	public long calcularTrabajadoresFaltantes(long trabajadoresNecesarios) {
		return trabajadoresNecesarios-trabajadores.size();
		
	}

	public long realizarContrataciones(long demanda) {
		long trabajadoresNecesarios = calcularTrabajadoresNecesarios(demanda);
		contratar(trabajadoresNecesarios);
		long trabajadoresFaltantes = calcularTrabajadoresFaltantes(trabajadoresNecesarios);
		return trabajadoresFaltantes;
	}
	

	public long getPotenciaTrabajador() {
		return potenciaTrabajador;
	}
	
	public ArrayList<Adulto> getParados() {
		return parados;
	}
	
	public ArrayList<Adulto> getTrabajadores() {
		return trabajadores;
	}
	

	public int getNumeroParados() {
		return parados.size();
	}
	
	public int getNumeroTrabajadores() {
		return trabajadores.size();
	}
	
	

}

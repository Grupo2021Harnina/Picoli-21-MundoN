package presentador;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.estado.MinisterioHacienda;
import modelo.estado.MinisterioIndustria;
import modelo.estado.MinisterioSocial;
import modelo.ser.Adulto;
import modelo.ser.Menor;
import modelo.ser.Ser;

public class Estado {
	
	//Singleton
	private static Estado estado = null;
	
	// Lo que le piden al estado que fabrique
	private long demanda = 0;

	private final ArrayList<Ser> seres = new ArrayList<Ser>();
	
	private MinisterioHacienda ministerioHacienda = null;
	private MinisterioIndustria ministerioIndustria = null;
	private MinisterioSocial ministerioSocial = null;
	
	//Singleton
	public static Estado getEstado() {
		if(estado==null) {
			estado = new Estado(); 
		}
		return estado;
	}
	

	private Estado() {
		crearMinisterios();
		
		long numeroNacimientos = demanda / ministerioIndustria.getPotenciaTrabajador();
		generarNacimientos(numeroNacimientos);
		
		// Esto es la historia
		for (int historia = 0; historia<120; historia++) {
			terminarPeriodo();
			comenzarPeriodo();
		}
	}
	

	private void crearMinisterios() {
		ministerioHacienda = new MinisterioHacienda();
		ArrayList<Adulto> parados = new ArrayList<Adulto>();
		ministerioIndustria=new MinisterioIndustria(parados);
		ministerioSocial=new MinisterioSocial(parados);
	}

	private void comenzarPeriodo() {
		long trabajadoresFaltantes = ministerioIndustria.realizarContrataciones(demanda);
		generarNacimientos(trabajadoresFaltantes);
	}

	private void generarNacimientos(long numeroNacimientos) {
		for (int i = 0; i <numeroNacimientos; i++) {
			naceSer();
		}
	}


	private void terminarPeriodo() {
		ministerioHacienda.hacerLiquidacion(ministerioSocial.getNumeroMenores(), ministerioSocial.getNumeroAncianos(), ministerioIndustria.getNumeroTrabajadores(),ministerioIndustria.getParados());
		envejecer();
	}

	//Tenemos que envejecerlo en las dos lista que este el ser
	//Ver comprobar si se muere y borrarlo de la lista
	private void envejecer() {
		for (Iterator iterator = seres.iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			ser.envejecer();
			
		}
		
		for (Iterator iterator = ministerioSocial.getAncianos().iterator(); iterator.hasNext();) {
			Ser ser = (Ser) iterator.next();
			
			
		}
		
		for (Iterator iterator = ministerioSocial.getMenores().iterator(); iterator.hasNext();) {
			Menor menor = (Menor) iterator.next();
		}
		
		for (Iterator iterator = ministerioIndustria.getTrabajadores().iterator(); iterator.hasNext();) {
			Adulto adulto = (Adulto) iterator.next();

		}
		
	}



	private void naceSer() {
		seres.add(new Ser());
		ministerioSocial.aniadirMenor();
	}
}

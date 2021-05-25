package modelo.estado;

import java.util.ArrayList;

import modelo.presupuesto.Presupuesto;
import modelo.ser.Adulto;

//Elabora el presupuesto y decide sobre capital y deuda 
public class MinisterioHacienda {
	
	// dinero que tiene el estado o deuda
	private long capital = 0;

	public void hacerLiquidacion(int numeroMenores, int numeroAncianos, int numeroTrabajadores, ArrayList<Adulto> parados) {
		// TODO Auto-generated method stub
		capital+=calculamosProduccionPeriodica();
		capital-=pagarCostesFabricacion();
		Presupuesto presupuesto=new Presupuesto(numeroMenores, numeroAncianos, numeroTrabajadores,parados);
		presupuesto.establecerPorcentajes(capital);
		capital-=presupuesto.getTotal();
		
	}

	private long pagarCostesFabricacion() {
		// TODO Auto-generated method stub
		return 0;
	}

	private long calculamosProduccionPeriodica() {
		// TODO Auto-generated method stub
		return 0;
	}

}

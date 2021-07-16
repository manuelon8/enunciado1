package com.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;


@Service("servicio")
public class CodigosService {
	
	/*
	 * a)
	 * */
	public boolean esPrioritario(String cod) throws IllegalArgumentException{
		boolean resp = false;
		char codigo=cod.charAt(0);	 
		
		if((codigo=='P') || (codigo=='W'))  
			resp = true; 		
		
		return resp;
	}
	
	/*
	 * b)
	 * */
	public boolean vErificar(String cod)  throws IllegalArgumentException{
		boolean resp = false;	
		int digitoVerificador=0, sumatoria=0;
		
		String[] parts = cod.split("-");		 
		String part2 = parts[1]; 	 
  
	    for(int x=0; x<part2.length(); x++) {
	    	sumatoria = sumatoria + Character.getNumericValue(part2.charAt(x)); 			
		}
	    
	    if(sumatoria>10 && sumatoria<100) {
	    	String  cifra = String.valueOf(sumatoria);
	    	char primerCaracter = cifra.charAt(0);
	    	char segundoCaracter = cifra.charAt(1); 
	        digitoVerificador  = Character.getNumericValue(primerCaracter) + Character.getNumericValue(segundoCaracter);
	    	resp=true;
	    }
	    else {	    	
	    	resp=true;	
	    	digitoVerificador = sumatoria;
	    }
	    
		System.out.println("EL   DIGITO VERIFICADOR  SERIA   "  + digitoVerificador);
	 
		return resp;
	}
	/*
	 * c)
	 * */
	public ArrayList<String> oRdenarLista(ArrayList<String> codigosSinOrdenar){
		ArrayList<String> listaCaracteres= new ArrayList<>();
		
		for(String codigos: codigosSinOrdenar ) {
			listaCaracteres.add(codigos.substring(0, 3));
		}
		Collections.sort(listaCaracteres);
		
		for(String  lista: listaCaracteres) {
			System.out.println("Imprimiendo lista:  " + lista);
		}
		return listaCaracteres;
		
	}
/*
 * d)
 * */
	public ArrayList<String> uNificarListas(ArrayList<String> listaUno, ArrayList<String> listaDos){
		ArrayList<String> listaFinal= new ArrayList<>();
		
		listaFinal.addAll(listaUno);
		listaFinal.addAll(listaDos);
		
		for(String  lista: listaFinal) {
			System.out.println("Imprimiendo lista:  " + lista);
		}
		return listaFinal;
	}
	
	/*
	 * d)
	 * */
	public ArrayList<String> iNterceptarListas(ArrayList<String> listaUno, ArrayList<String> listaDos){
		ArrayList<String> listaFinal= new ArrayList<>();
		listaFinal = uNificarListas(listaUno, listaDos);
		Set<String> set = new HashSet<>(listaFinal);
		
		listaFinal.clear();
		listaFinal.addAll(set);
		for(String  lista: listaFinal) {
			System.out.println("Imprimiendo lista final:  " + lista);
		}
		return listaFinal;
	}
}

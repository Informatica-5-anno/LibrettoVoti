package it.edu.falcone_righi.LibrettoVoti.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLibretto {

	public static void main(String[] args) {
		//Scanner sc=new Scanner(System.in);
		Libretto l=new Libretto();
		l.add(new Voto("informatica", 28, LocalDate.of(2024, 1, 22)));
		l.add(new Voto("statistica", 22, LocalDate.of(2024, 3, 17)));
		l.add(new Voto("calcolo", 20, LocalDate.of(2024, 5, 30)));
		l.add(new Voto("linguaggi", 27, LocalDate.of(2024, 7, 25)));
		l.add(new Voto("fisica 1", 18, LocalDate.of(2024, 1, 22)));
		l.add(new Voto("analisi 1", 25, LocalDate.of(2024, 1, 21)));
		l.add(new Voto("fisica 2", 20, LocalDate.of(2024, 2, 12)));
		l.add(new Voto("analisi 2", 21, LocalDate.of(2025, 1, 12)));
		l.add(new Voto("inglese", 28, LocalDate.of(2024, 11, 14)));
		Voto v1=new Voto("sistemi", 30, LocalDate.of(2024, 12, 2));
		l.add(v1);
		System.out.println(l);
		System.out.println("Esami con votazione 25 o più");
		for (Voto v: l.getListaVoti() ) {
			if (v.getVotoOttenuto()>=25) {
				System.out.println(v);
			}
		}
		//System.out.println("Inserisci un corso");
		//String corso=sc.nextLine();
		//Voto v=l.get(corso);
		//if (v!=null) {
			//System.out.println(v);
		//} else {
			//System.out.println("Corso non trovato");
	//	}
		if ( ! l.add(v1) ) {
			System.out.println( l.getErrorMsg() );
		}
		
//		l.update(new Voto("fisica 1", 28, LocalDate.of(2024, 1, 22)));
//		v=l.get("fisica 1");
//		if (v!=null) {
//			System.out.println(v);
//		} else {
//			System.out.println("Corso non trovato");
//		}
		Collections.sort(l.getListaVoti(), new Comparator<Voto>() {
			@Override public int compare(Voto o1, Voto o2) {
	            return o1.getNomeCorso().compareToIgnoreCase(o2.getNomeCorso());
	        }
	    }); 
		System.out.println("Lista ordinata per nome");
		for (Voto vx : l.getListaVoti() ) {
			System.out.println(vx);
		}
		
		Collections.sort(l.getListaVoti(), new Comparator<Voto>() {
			@Override public int compare(Voto o1, Voto o2) {
	            return o1.getVotoOttenuto()-(o2.getVotoOttenuto());
	        }
	    }); 
		
		System.out.println("Lista ordinata - per voto >25");
		for ( Voto vx: ((Stream<Voto>)l.getListaVoti().stream().filter(voto -> voto.getVotoOttenuto() > 25)).collect(Collectors.toList())) 
		{
			System.out.println(vx);
		}
		
		System.out.println("Lista ordinata per voto");
		for (Voto vx : l.getListaVoti() ) {
			System.out.println(vx);
		}
	}

}

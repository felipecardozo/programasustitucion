package com.pnis.observer;

import java.util.ArrayList;
import java.util.List;

public class DemoObserver {
	
	public static void main(String[] args) {
		List<String> email1 = new ArrayList<>();
		email1.add("delegado1@gmail.com");
		
		Subject subject = new NotificarDelegados(email1, "1 sustitucion ha finalizado");
		
		email1.add("delegado2@gmail.com");
		
		Subject subject2 = new NotificarDelegados(email1, "2 sustitucion ha finalizado");
		
		Observer observer = new DelegadoObserver(subject);
		Observer observer2 = new DelegadoObserver(subject2);
		
		subject.registerObserver(observer);
		subject2.registerObserver(observer2);
		
		System.out.println("********************* luego alguien finaliza un documento");
		
		subject.notifyObserver();
		
	}

}

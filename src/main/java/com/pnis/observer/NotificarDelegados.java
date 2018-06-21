package com.pnis.observer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificarDelegados implements Subject {
	
	private List<Observer> delegados;
	private List<String> email;
	private String sustitucion;
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificarDelegados.class);
	
	public NotificarDelegados(List<String> email, String sustitucion) {
		delegados = new ArrayList<>();
		this.email = email;
		this.sustitucion = sustitucion;
	}

	@Override
	public void registerObserver(Observer observer) {
		LOGGER.info("*** Se ha agregado un observer ***");
		delegados.add(observer);
		notifyObserver();
	}

	@Override
	public void notifyObserver() {
		delegados.forEach( f -> f.update() );
	}

	@Override
	public void unRegisterObserver(Observer observer) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<String> getEmail() {
		return email;
	}
	
	@Override
	public String getSustitucion() {
		return sustitucion;
	}

}

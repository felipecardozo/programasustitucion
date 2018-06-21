package com.pnis.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelegadoObserver implements Observer {

	private Logger LOGGER = LoggerFactory.getLogger(DelegadoObserver.class);
	
	private Subject subject;
	
	public DelegadoObserver(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public void update() {
		LOGGER.info("*** Email sent to {}, sustitcion {} ***", subject.getEmail(), subject.getSustitucion() );
	}

}

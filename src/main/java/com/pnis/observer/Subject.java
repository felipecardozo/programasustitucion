package com.pnis.observer;

import java.util.List;

public interface Subject {

	void registerObserver(Observer observer);

    void notifyObserver();

    void unRegisterObserver(Observer observer);

    List<String> getEmail();
    
    String getSustitucion();
	
}

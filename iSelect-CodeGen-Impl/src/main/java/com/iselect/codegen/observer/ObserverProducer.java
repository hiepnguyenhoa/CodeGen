/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hiep
 */
public class ObserverProducer {
    static Map<Integer, CGObserver> observers = new HashMap<>();

    public static CGObserver getObserver(CGObserverTypeImpl otype) {
        CGObserver observer = null;
        switch (otype) {
            case XML_OBSERVER:
                observer = observers.get(CGObserverTypeImpl.XML_OBSERVER);
                if(observer==null){
                    observer = new CGObserverImpl();
                    observers.put(otype.getId(), observer);
                }
                break;
        }
        return observer;
    }
}

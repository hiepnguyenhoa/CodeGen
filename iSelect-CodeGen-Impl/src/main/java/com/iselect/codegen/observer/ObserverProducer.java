/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;

/**
 *
 * @author Hiep
 */
public class ObserverProducer {
    public static CGObserver getObserver(CGObserverTypeImpl otype) {
        CGObserver observer = null;
        switch (otype) {
            case XML_OBSERVER:
                observer = CGObserverImpl.getInstance();
                break;
        }
        return observer;
    }
}

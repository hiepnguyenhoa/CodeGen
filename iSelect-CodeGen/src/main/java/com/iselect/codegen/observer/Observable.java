/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;

import com.iselect.codegen.parser.component.CGComponent;
import com.iselect.codegen.parser.event.CGParserEvent;
import com.iselect.codegen.parser.event.CGParserEventType;

/**
 *
 * @author Hiep
 * @param <T>
 * @param <V>
 * @param <E>
 * @param <C>
 */
public interface Observable<T extends CGObserver, V extends CGParserEventType, E extends CGParserEvent, C extends CGComponent> {
    public void addObserver(T observer);
    public void removeObserver(T observer);
    public void notifyObserver(E event);
    public void notifyObserver(V eventType, C property);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser.event;

import com.iselect.codegen.parser.component.CGComponent;

/**
 *
 * @author Hiep
 * @param <E>
 * @param <T>
 */
public class CGParserEventAbst<E extends CGParserEventType, T extends CGComponent> implements CGParserEvent<E, T> {

    private final E type;
    private final T component;

    public CGParserEventAbst(E type, T component) {
        this.type = type;
        this.component = component;
    }
    
    @Override
    public E getEventType() {
        return this.type;
    }

    @Override
    public T getComponent() {
        return this.component;
    }


}

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
public interface CGParserEvent<E extends CGParserEventType, T extends CGComponent> {
    public E getEventType(); 
    public T getComponent();
}

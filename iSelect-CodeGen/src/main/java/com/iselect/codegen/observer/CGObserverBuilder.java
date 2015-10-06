/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;


/**
 *
 * @author Hiep
 * @param <T>
 */
public interface CGObserverBuilder<T extends CGObserverType> {

    public <O extends CGObserver> O buildObserver(T oType);
    
}

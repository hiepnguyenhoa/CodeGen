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
public enum CGObserverTypeImpl implements CGObserverType{
    XML_OBSERVER(1);
    
    private int id;
    
    CGObserverTypeImpl(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }
    
}

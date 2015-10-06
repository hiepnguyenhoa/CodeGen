/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.factory;

/**
 *
 * @author Hiep
 */
public enum FactoryType {
    FACTORY_XML(1);
    
    private int id;
    
    FactoryType(int i){
        this.id=i;
    }
    
    public int getId(){
        return this.id;
    }
}

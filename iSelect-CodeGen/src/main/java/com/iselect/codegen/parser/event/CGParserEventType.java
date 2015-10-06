/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser.event;

/**
 *
 * @author Hiep
 */
public enum CGParserEventType {
    NEW_CLASS(1), END_CLASS(2), NEW_PROPERTY(3);
    
    private int id;
    CGParserEventType(int id){
        this.id=id;
    }
    
    public int getId(){
        return this.id;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.component;

/**
 *
 * @author Hiep
 */
public interface CGPropertyComponent extends CGComponent{
    public void setType(String type);
    public String getType();
    
    public void setConstraint(String constraint);
    public String getConstraint();
    
    public String getTemplateId();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.generator;

import com.iselect.codegen.component.CGClassComponent;
import com.iselect.codegen.component.CGPropertyComponent;
import org.stringtemplate.v4.STGroup;

/**
 *
 * @author Hiep
 * @param <C>
 * @param <P>
 */
public interface CGCodeGenerator<C extends CGClassComponent, P extends CGPropertyComponent> {
    
    public STGroup loadTemplateGroup();
    
    public void generateCode(C t);
}

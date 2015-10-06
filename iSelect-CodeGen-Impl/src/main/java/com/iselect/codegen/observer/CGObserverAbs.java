/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;

import com.iselect.codegen.generator.CGCodeGenerator;
import com.iselect.codegen.component.CGClassComponent;
import com.iselect.codegen.factory.CGComponentFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiep
  implements CGObserver
 * @param <P>
 * @param <F>
 * @param <C>
 */
public abstract class CGObserverAbs<P extends CGClassComponent, F extends CGComponentFactory, C extends CGCodeGenerator> implements CGObserver<F, C>{
    
    protected String templatePath;
    protected F factory;
    protected List<C> codegeners = new ArrayList<>();
    protected P classProperty;

    public CGObserverAbs() {
        
    }

    @Override
    public F getFactory() {
        return factory;
    }

    @Override
    public void setFactory(F factory) {
        this.factory = factory;
    }

    @Override
    public List<C> getCodegeners() {
        return codegeners;
    }

    @Override
    public void addCodegener(C codegener) {
        this.codegeners.add(codegener);
    }

    public P getClassProperty() {
        return classProperty;
    }

    public void setClassProperty(P classProperty) {
        this.classProperty = classProperty;
    }
    
    
}

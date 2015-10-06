/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;

import com.iselect.codegen.generator.CGCodeGenerator;
import com.iselect.codegen.factory.CGComponentFactory;
import com.iselect.codegen.parser.event.CGParserEvent;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <F>
 * @param <C>
 */
public interface CGObserver<F extends CGComponentFactory, C extends CGCodeGenerator> {

    public F getFactory();

    public void setFactory(F factory);

    public List<C> getCodegeners();

    public void addCodegener(C codegener);

    public void eventPerformed(CGParserEvent event);

    public void generateCode() throws IOException;
}

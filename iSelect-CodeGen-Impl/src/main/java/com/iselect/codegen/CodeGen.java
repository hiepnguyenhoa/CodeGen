/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen;

import com.iselect.codegen.parser.Parser;
import com.iselect.codegen.observer.CGObserverImpl;
import com.iselect.codegen.observer.CGObserverBuilderImpl;
import com.iselect.codegen.observer.CGObserverTypeImpl;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hiep
 */
public class CodeGen {

    public static void main(String[] args) {
        try {
            Configuration config = new Configuration();
            config.loadConfig();
            
            CGObserverBuilderImpl bulder = new CGObserverBuilderImpl(config);
            
            File file = new File("E:\\iSelect\\documents\\iSelect-DD.ods");
            Parser _parser = new Parser(file);
            
            CGObserverImpl _xmlObserver = (CGObserverImpl) bulder.buildObserver(CGObserverTypeImpl.XML_OBSERVER);

            _parser.addObserver(_xmlObserver);

            _parser.parser();
            config.closeConfig();
        } catch (IOException ex) {
            Logger.getLogger(CodeGen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.observer;

import com.iselect.codegen.component.CGPropertyComponentAbs;
import com.iselect.codegen.generator.CGCodeGenerator;
import com.iselect.codegen.component.ClassComponentImpl;
import com.iselect.codegen.factory.CGComponentFactoryImpl;
import com.iselect.codegen.observer.CGObserverAbs;
import com.iselect.codegen.parser.component.CGClassInfo;
import com.iselect.codegen.parser.component.CGPropertyInfo;
import com.iselect.codegen.parser.event.CGParserEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author Hiep
 */
public final class CGObserverImpl extends CGObserverAbs<ClassComponentImpl, CGComponentFactoryImpl, CGCodeGenerator> {

    private ClassComponentImpl classTag;
    
    public CGObserverImpl() {
    }

    @Override
    public void eventPerformed(CGParserEvent event) {
        switch (event.getEventType()) {
            case NEW_CLASS:
                newClassTag((CGClassInfo) event.getComponent());
                break;
            case END_CLASS:
                endClassTag();
                break;
            case NEW_PROPERTY:
                newPropertyTag((CGPropertyInfo) event.getComponent());
                break;
        }
    }

    private void newClassTag(CGClassInfo property) {
        classTag = new ClassComponentImpl();
        try {
            BeanUtils.copyProperties(classTag, property);
//            this.getCodegeners().stream().forEach((generator) -> {
//                generator.setClassComponent(classTag);
//            });
        } catch (IllegalAccessException | InvocationTargetException ex) {
//            Logger.getLogger(CGObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void endClassTag() {
        try {
            generateCode();
        } catch (IOException ex) {
//            Logger.getLogger(CGObserverImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void newPropertyTag(CGPropertyInfo property) {
        CGPropertyComponentAbs hbnProperty = this.getFactory().buildComponent(property);
        classTag.addPropertyComponent(hbnProperty);
    }

    @Override
    public void generateCode() throws IOException {
        this.getCodegeners().stream().forEach(
                (generator)->{
                    generator.generateCode(classTag);
                }
        );
    }

}

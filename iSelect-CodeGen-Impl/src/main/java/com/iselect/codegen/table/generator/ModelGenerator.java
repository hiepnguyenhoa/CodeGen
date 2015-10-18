/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.table.generator;

import com.iselect.codegen.component.CGPropertyComponentAbs;
import com.iselect.codegen.generator.CGCodeGeneratorAbs;
import com.iselect.codegen.component.ClassComponentImpl;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

/**
 *
 * @author Hiep
 */
public class ModelGenerator extends CGCodeGeneratorAbs<ClassComponentImpl, CGPropertyComponentAbs>{

    public ModelGenerator(String template, String baseDir, String subDir) {
        super(template, baseDir, subDir);
    }

    @Override
    public void generateCode(ClassComponentImpl t) {
        STGroup _group = this.loadTemplateGroup();
        StringBuilder sb = new StringBuilder();

        ST template = null;
        template = _group.getInstanceOf("DOC_TYPE");
        sb.append(template.render());
        
        sb.toString();
    }
    
}

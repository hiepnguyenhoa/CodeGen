/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.generator;

import com.iselect.codegen.component.CGClassComponent;
import com.iselect.codegen.component.CGPropertyComponent;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 *
 * @author Hiep
 * @param <T>
 * @param <C>
 */
public abstract class CGCodeGeneratorAbs<T extends CGClassComponent<C>, C extends CGPropertyComponent> implements CGCodeGenerator<T, C> {

    private final String template;
    private final String baseDir;
    private final String subDir;

    public CGCodeGeneratorAbs(String template, String baseDir, String subDir) {
        this.template = template;
        this.baseDir = baseDir;
        this.subDir=subDir;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public String getSubDir() {
        return subDir;
    }

    @Override
    public STGroup loadTemplateGroup() {
        STGroup.trackCreationEvents = true;
        STGroup group = new STGroupFile(template);
        return group;
    }
}

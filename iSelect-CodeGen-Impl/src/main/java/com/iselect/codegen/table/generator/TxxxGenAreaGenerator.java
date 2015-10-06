/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.table.generator;

import com.iselect.codegen.component.CGPropertyComponentAbs;
import com.iselect.codegen.generator.CGCodeGeneratorAbs;
import com.iselect.codegen.component.ClassComponentImpl;
import com.iselect.codegen.util.FileUtil;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

/**
 *
 * @author Hiep
 */
public class TxxxGenAreaGenerator extends CGCodeGeneratorAbs<ClassComponentImpl, CGPropertyComponentAbs>{

    public TxxxGenAreaGenerator(String template, String baseDir, String subDir) {
        super(template, baseDir, subDir);
    }

    @Override
    public void generateCode(ClassComponentImpl t) {
        STGroup _group = this.loadTemplateGroup();
        StringBuilder sb = new StringBuilder();

        ST template = null;
        template = _group.getInstanceOf("DOC_TYPE");
        sb.append(template.render());
        sb.append("\n\r");
        
        template = _group.getInstanceOf(ClassComponentImpl.TEMP_ID);
        template.add("package", t.getPackageName());
        template.add("className", t.getName());
        template.add("tableName", t.getDbName() == null || "".equals(t.getDbName().trim()) ? t.getName() : t.getDbName());
        sb.append(template.render());
        sb.append("\n\r");
        
        for (CGPropertyComponentAbs prop : t.getPropertyComponents()) {
            if(prop.getInherit()!=null&&!prop.getInherit().equalsIgnoreCase("InnerClass"))
                continue;
            template = _group.getInstanceOf(prop.getTemplateId());
            template.add("name", prop.getName().substring(0, 1).toUpperCase() + prop.getName().substring(1));
            template.add("dbName", prop.getDbName() == null || "".equals(prop.getDbName().trim()) ? prop.getName() : prop.getDbName());
            template.add("type", prop.getType());
            sb.append(template.render());
            sb.append("\n\r");
        }
        
        template = _group.getInstanceOf("CLASS_TEMP_END");
        sb.append(template.render());
        
        try {
            Path path=FileUtil.createFile(this.getBaseDir(), this.getSubDir(), t.getPackageName());
            FileUtil.writeFile(path, t.getName()+"GenArea.java", sb.toString());
        } catch (IOException ex) {
            Logger.getLogger(MappingGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

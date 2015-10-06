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
public class MappingGenerator extends CGCodeGeneratorAbs<ClassComponentImpl, CGPropertyComponentAbs> {

    public MappingGenerator(String template, String baseDir, String subDir) {
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

        for (CGPropertyComponentAbs _prop : t.getPropertyComponents()) {
            if(_prop.getInherit()!=null&&_prop.getInherit().equalsIgnoreCase("InnerClass"))
                continue;
            template = _group.getInstanceOf(_prop.getTemplateId());
            template.add("name", _prop.getName());
            template.add("dbName", _prop.getDbName() == null || "".equals(_prop.getDbName().trim()) ? _prop.getName() : _prop.getDbName());
            sb.append(template.render());
            sb.append("\n\r");
        }

        template = _group.getInstanceOf("CLASS_TEMP_END");
        sb.append(template.render());
         //        template.inspect();
        
        try {
            Path path=FileUtil.createFile(this.getBaseDir(), this.getSubDir(), t.getPackageName());
            FileUtil.writeFile(path, t.getName()+".hbn.xml", sb.toString());
        } catch (IOException ex) {
            Logger.getLogger(MappingGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

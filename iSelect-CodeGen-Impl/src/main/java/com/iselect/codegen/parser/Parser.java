/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.parser;

import com.iselect.codegen.observer.Observable;
import com.iselect.codegen.observer.CGObserver;
import com.iselect.codegen.parser.component.CGPropertyInfoImpl;
import com.iselect.codegen.parser.component.CGClassInfo;
import com.iselect.codegen.parser.component.CGClassInfoImpl;
import com.iselect.codegen.parser.component.CGComponent;
import com.iselect.codegen.parser.component.CGPropertyInfo;
import com.iselect.codegen.parser.event.CGParserEvent;
import com.iselect.codegen.parser.event.CGParserEventImpl;
import com.iselect.codegen.parser.event.CGParserEventType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 *
 * @author Hiep
 */
public class Parser implements Observable<CGObserver, CGParserEventType, CGParserEvent, CGComponent> {

    private final File file;
    private final List<CGObserver> observers = new ArrayList<>();

    public Parser(File file) {
        this.file = file;
    }

    public void parser() throws IOException {
        SpreadSheet _sheets = SpreadSheet.createFromFile(file);
        int _ish = _sheets.getSheetCount();
        for (int i = 0; i < _ish; i++) {
            Sheet _sheet = _sheets.getSheet(i);
            parserSheet(_sheet);
        }
    }

    @Override
    public void addObserver(CGObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(CGObserver observer) {
        this.observers.remove(observer);
    }
    
    @Override
    public void notifyObserver(CGParserEventType eventType, CGComponent property) {
        CGParserEventImpl _event = new CGParserEventImpl(eventType, property);
        this.notifyObserver(_event);
    }

    @Override
    public void notifyObserver(CGParserEvent event) {
        this.observers.stream().forEach((ob) -> {
            ob.eventPerformed(event);
        });
    }

    private void parserSheet(Sheet sheet) {
        String packageValue = (String) sheet.getValueAt(1, 0);
        String className = (String) sheet.getValueAt(1, 1);
        String dbName = (String) sheet.getValueAt(2, 1);

        CGClassInfo classInfo = new CGClassInfoImpl(packageValue, className, dbName, null);
        notifyObserver(CGParserEventType.NEW_CLASS, classInfo);

        String type = null;
        String constraint = null;
        String inherit = null;
        int size = sheet.getRowCount();
        for (int i = 3; i < size; i++) {
            className = (String) sheet.getValueAt(1, i);
            dbName = (String) sheet.getValueAt(2, i);
            type = (String) sheet.getValueAt(3, i);
            constraint = (String) sheet.getValueAt(4, i);
            inherit = (String) sheet.getValueAt(5, i);
            CGPropertyInfo _row = new CGPropertyInfoImpl(className, dbName, type, constraint, inherit);
            notifyObserver(CGParserEventType.NEW_PROPERTY, _row);
        }
        notifyObserver(CGParserEventType.END_CLASS, null);
    }

}

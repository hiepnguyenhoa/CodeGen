/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.util;

import java.util.HashMap;

/**
 *
 * @author Hiep
 */
public class MappingType {
    private static final HashMap<String,String> JAVA_TO_HIBERANTE = new HashMap<>();
    static{
        JAVA_TO_HIBERANTE.put("null","null");
        JAVA_TO_HIBERANTE.put("BYTE","byte");
        JAVA_TO_HIBERANTE.put("SHORT","short");
        JAVA_TO_HIBERANTE.put("INTEGER","integer");
        JAVA_TO_HIBERANTE.put("INT","integer");
        JAVA_TO_HIBERANTE.put("LONG","long");
        JAVA_TO_HIBERANTE.put("FLOAT","float");
        JAVA_TO_HIBERANTE.put("DOUBLE","double");
        JAVA_TO_HIBERANTE.put("CHAR","character");
        JAVA_TO_HIBERANTE.put("BOOLEAN","boolean");
        JAVA_TO_HIBERANTE.put("STRING","string");
        JAVA_TO_HIBERANTE.put("STRINGS","text");
        JAVA_TO_HIBERANTE.put("DATE","date");
        JAVA_TO_HIBERANTE.put("DATETIME","timestamp");
        JAVA_TO_HIBERANTE.put("LOCALE","locale");
        JAVA_TO_HIBERANTE.put("TIMEZONE","timezone");
        JAVA_TO_HIBERANTE.put("CURRENCY","Currency");
        JAVA_TO_HIBERANTE.put("CLASS","class");        
    }
    
    public static final String getHibernateType(String jType){
        return MappingType.JAVA_TO_HIBERANTE.get(jType.toUpperCase());
    }
}
/*
class TypePair{
    private String key;
    private String value;

    public TypePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
*/

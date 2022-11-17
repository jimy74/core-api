package com.machinevc.coreapi.domain;


import lombok.NonNull;

import java.util.List;

public enum AttributeTypes {
    TEXT,
    NUMBER,
    BOOLEAN,
    DATE;

    /**
     *  NEVER USE .values(), use this instead!
     *
     * This methode is to avoid the INVOKEVIRTUAL instruction that each time copy the entire enum in memory,
     * and lead to decreased performance and can even crash the JVM.
     *
     *  For your information, a .values() is doing that on the JVM:
     *
     *  GETSTATIC string/WidgetProperty.$VALUES : [Lstring/WidgetProperty;
     *  INVOKEVIRTUAL [Lstring/WidgetProperty;.clone ()Ljava/lang/Object;
     *  CHECKCAST [Lstring/WidgetProperty;
     *  ARETURN
     *
     * You can do your own analysis using the compiler (javac) and the disassembler (javap).
     *
     * @return all possible attribute types of this enum
     */
    public final static List<AttributeTypes> allPossibleAttributeTypes() {
        return List.of(AttributeTypes.values());
    }
}

package com.badlogic.gdx.utils.reflect;

import java.lang.reflect.Array;

public final class ArrayReflection {
    public static Object newInstance(Class cls, int i) {
        return Array.newInstance(cls, i);
    }

    public static int getLength(Object obj) {
        return Array.getLength(obj);
    }

    public static Object get(Object obj, int i) {
        return Array.get(obj, i);
    }

    public static void set(Object obj, int i, Object obj2) {
        Array.set(obj, i, obj2);
    }
}

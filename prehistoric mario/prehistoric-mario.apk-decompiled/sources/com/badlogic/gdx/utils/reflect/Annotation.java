package com.badlogic.gdx.utils.reflect;

public final class Annotation {
    private java.lang.annotation.Annotation annotation;

    Annotation(java.lang.annotation.Annotation annotation2) {
        this.annotation = annotation2;
    }

    public <T extends java.lang.annotation.Annotation> T getAnnotation(Class<T> cls) {
        if (this.annotation.annotationType().equals(cls)) {
            return (T) this.annotation;
        }
        return null;
    }

    public Class<? extends java.lang.annotation.Annotation> getAnnotationType() {
        return this.annotation.annotationType();
    }
}

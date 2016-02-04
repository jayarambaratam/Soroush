package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    public ReflectiveProperty(Class<T> cls, Class<V> cls2, String str) {
        Class type;
        super(cls2, str);
        char toUpperCase = Character.toUpperCase(str.charAt(0));
        String str2 = toUpperCase + str.substring(1);
        String str3 = PREFIX_GET + str2;
        try {
            this.mGetter = cls.getMethod(str3, (Class[]) null);
        } catch (NoSuchMethodException e) {
            try {
                this.mGetter = cls.getDeclaredMethod(str3, (Class[]) null);
                this.mGetter.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                str3 = PREFIX_IS + str2;
                try {
                    this.mGetter = cls.getMethod(str3, (Class[]) null);
                } catch (NoSuchMethodException e3) {
                    try {
                        this.mGetter = cls.getDeclaredMethod(str3, (Class[]) null);
                        this.mGetter.setAccessible(true);
                    } catch (NoSuchMethodException e4) {
                        this.mField = cls.getField(str);
                        type = this.mField.getType();
                        if (!typesMatch(cls2, type)) {
                            throw new NoSuchPropertyException("Underlying type (" + type + ") " + "does not match Property type (" + cls2 + ")");
                        }
                        return;
                    } catch (NoSuchFieldException e5) {
                        throw new NoSuchPropertyException("No accessor method or field found for property with name " + str);
                    }
                }
            }
        }
        type = this.mGetter.getReturnType();
        if (typesMatch(cls2, type)) {
            str2 = PREFIX_SET + str2;
            try {
                this.mSetter = cls.getDeclaredMethod(str2, new Class[]{type});
                this.mSetter.setAccessible(true);
                return;
            } catch (NoSuchMethodException e6) {
                return;
            }
        }
        throw new NoSuchPropertyException("Underlying type (" + type + ") " + "does not match Property type (" + cls2 + ")");
    }

    private boolean typesMatch(Class<V> cls, Class cls2) {
        return cls2 != cls ? cls2.isPrimitive() ? (cls2 == Float.TYPE && cls == Float.class) || ((cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class))))))) : false : true;
    }

    public V get(T t) {
        V invoke;
        if (this.mGetter != null) {
            try {
                invoke = this.mGetter.invoke(t, (Object[]) null);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField != null) {
            try {
                invoke = this.mField.get(t);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
        return invoke;
    }

    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }

    public void set(T t, V v) {
        if (this.mSetter != null) {
            try {
                this.mSetter.invoke(t, new Object[]{v});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField != null) {
            try {
                this.mField.set(t, v);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + getName() + " is read-only");
        }
    }
}

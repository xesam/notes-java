package io.github.xesam.lang.reflect;

import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * Created by xe on 14-12-19.
 */
public class Rutils {
    public static class ClassUtils {

        public static Class<?>[] getDeclaredClasses(Class clazz) {
            return clazz.getDeclaredClasses();
        }

        public static Class descPrimitiveTypes() {
            return null;
        }

        public static String getType(Class clazz) {
            String s = "";
            if (clazz.isArray()) {
                s = "Array";
            } else if (clazz.isInterface()) {
                s = "Interface";
            } else if (clazz.isPrimitive()) {
                s = "Primitive";
            } else {
                s = "Object";
            }
            return s;
        }

        //declared and inherits public
        public static Method[] getAllPublicMethods(Class clazz) {
            Method[] methods = clazz.getMethods();
            return methods;
        }

        //declared and inherits public
        public static Method getPublicMethod(Class clazz, String methodString, Class[] parameterTypes) {
            try {
                return clazz.getMethod(methodString, parameterTypes);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        }

        //explicitly declared  methods of all visibilities
        public static Method[] getAllDeclaredMethods(Class clazz) {
            Method[] methods = clazz.getDeclaredMethods();
            return methods;
        }

        //explicitly declared  methods of all visibilities
        public static Method getDeclaredMethod(Class clazz, String methodString, Class[] parameterTypes) {
            try {
                return clazz.getDeclaredMethod(methodString, parameterTypes);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Method[] getAllSupportedMethods(Class clazz) {

            return null;
        }

        public static Method getSupportedMethod(Class clazz, String methodString, Class[] parameterTypes) {
            if (null == clazz) {
                return null;
            }
            try {
                return clazz.getDeclaredMethod(methodString, parameterTypes);
            } catch (NoSuchMethodException e) {
                return getSupportedMethod(clazz.getSuperclass(), methodString, parameterTypes);
            }
        }

        public static Class[] getDirectInterfaces(Class clazz) {
            return clazz.getInterfaces();
        }

        public static ArrayList<Class> getAllInterfaces(Class clazz) {
            ArrayList<Class> classes = new ArrayList<Class>();
            Class[] is = clazz.getInterfaces();
            for (Class c : is) {
                classes.add(c);
            }
            while (null != (clazz = clazz.getSuperclass())) {
                for (Class c : clazz.getInterfaces()) {
                    classes.add(c);
                }
            }
            return classes;
        }

        public static Class getDirectSuperclass(Class clazz) {
            return clazz.getSuperclass();
        }

        public static ArrayList<Class> getAllSuperclass(Class clazz) {
            ArrayList<Class> classes = new ArrayList<Class>();
            clazz = clazz.getSuperclass();
            while (null != clazz) {
                classes.add(clazz);
                clazz = clazz.getSuperclass();
            }
            return classes;
        }

        public static ArrayList<Class> getClassHierarchy(Class clazz) {
            return getAllSuperclass(clazz);
        }

        public static Field getPublicField(Class clazz, String fieldName) {
            try {
                return clazz.getField(fieldName);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        }

        public static Field[] getAllPublicField(Class clazz) {
            return clazz.getFields();
        }

        public static Field getDeclaredField(Class clazz, String fieldName) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        }

        public static Field[] getAllDeclaredField(Class clazz) {
            return clazz.getDeclaredFields();
        }

        public static ArrayList<Field> getAllFields(Class clazz) {
            ArrayList<Field> r = new ArrayList<Field>();
            while (null != clazz) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field f : fields) {
                    r.add(f);
                }
                clazz = clazz.getSuperclass();
            }
            return r;
        }

        public static ArrayList<Field> getDeclaredStaticFields(
                Class clazz,
                boolean _public,
                boolean _protected,
                boolean _private,
                boolean _default) {
            ArrayList<Field> r = new ArrayList<Field>();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                int fieldModifier = field.getModifiers();
                if (!Modifier.isStatic(fieldModifier)) {
                    continue;
                }
                boolean addFlag = false;
                if (Modifier.isPublic(fieldModifier) && _public) {
                    addFlag = true;
                } else if (Modifier.isProtected(fieldModifier) && _protected) {
                    addFlag = true;
                } else if (Modifier.isPrivate(fieldModifier) && _private) {
                    addFlag = true;
                } else if (!Modifier.isPublic(fieldModifier) && !Modifier.isProtected(fieldModifier) && !Modifier.isPrivate(fieldModifier) && _default) {
                    addFlag = true;
                }

                if (addFlag) {
                    r.add(field);
                }
            }
            return r;
        }

        public static Class loadClass(String className) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        }

        public static Object makeInstance(String className) {
            try {
                Class clazz = Class.forName(className);
                return clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InstantiationException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        }

        public static Constructor getPublicConstructor(Class clazz, Class[] params) {
            try {
                return clazz.getConstructor(params);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        }

        public static Constructor[] getAllPublicConstructor(Class clazz) {
            return clazz.getConstructors();
        }

        public static Constructor getDeclaredConstructor(Class clazz, Class[] params) {
            try {
                return clazz.getDeclaredConstructor(params);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        }

        public static Constructor[] getAllDeclaredConstructor(Class clazz) {
            return clazz.getDeclaredConstructors();
        }

        public static String descArrayClassName() {
            StringBuffer sb = new StringBuffer();
            sb.append("byte[]").append(":").append(byte[].class.getName()).append("\n")
                    .append("char[]").append(":").append(char[].class.getName()).append("\n")
                    .append("short[]").append(":").append(short[].class.getName()).append("\n")
                    .append("int[]").append(":").append(int[].class.getName()).append("\n")
                    .append("long[]").append(":").append(long[].class.getName()).append("\n")
                    .append("float[]").append(":").append(float[].class.getName()).append("\n")
                    .append("double[]").append(":").append(double[].class.getName()).append("\n")
                    .append("boolean[]").append(":").append(boolean[].class.getName()).append("\n")
                    .append("ref[]").append(":").append(String[].class.getName());
            return sb.toString();

        }
    }


    public static class FieldUtils {
        public static String descField(Field field) {
            StringBuffer sb = new StringBuffer();
            return sb.append("DeclaringClass:").append(field.getDeclaringClass())
                    .append(" Name:").append(field.getName())
                    .append(" Type:").append(field.getType())
                    .append(" Modifier:").append(field.getModifiers())
                    .toString();
        }

        public static void setVaule(Object target, Field field, Object param) {
            if (!Modifier.isPublic(field.getModifiers())) {
                field.setAccessible(true);
            }
            try {
                field.set(target, param);
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public static class MethodUtils {

        public static void iterate(Method[] methods) {
            for (Method m : methods) {
                System.out.println(m);
            }
        }

        public static Object invoke(Method method, Object obj, Object... args) {
            try {
                return method.invoke(obj, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InvocationTargetException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return null;
        }

        public static String descMethod(Method method) {
            StringBuffer sb = new StringBuffer();
            sb.append("DeclaringClass:").append(method.getDeclaringClass().toString()).append("\n")
                    .append("getName:").append(method.getName()).append("\n")
                    .append("getModifiers:").append(method.getModifiers()).append(":")
                    .append(Modifier.toString(method.getModifiers())).append("\n")
                    .append("ExceptionTypesDesc:").append(getExceptionTypesDesc(method)).append("\n")
                    .append("getParameterTypesDesc:").append(getParameterTypesDesc(method)).append("\n")
                    .append("getReturnType:").append(method.getReturnType()).append("\n")
            ;
            return sb.toString();
        }

        public static String getExceptionTypesDesc(Method method) {
            StringBuffer sb = new StringBuffer();
            for (Class c : method.getExceptionTypes()) {
                sb.append(c.toString()).append(",");
            }
            return sb.toString();
        }

        public static String getParameterTypesDesc(Method method) {
            StringBuffer sb = new StringBuffer();
            for (Class c : method.getParameterTypes()) {
                sb.append(c.toString()).append(",");
            }
            return sb.toString();
        }
    }


    public static class ModifierUtils {
        public static String getAllJavaModifiers() {
            return "1.public\n" +
                    "2.volatile\n" +
                    "3.synchronized\n" +
                    "4.final\n" +
                    "5.static\n" +
                    "6.protected\n" +
                    "7.strictfp\n" +
                    "8.transient\n" +
                    "9.native\n" +
                    "10.abstract\n" +
                    "11.private" +
                    "????.interface";
        }

        public static String getModifierDesc(int modifiers) {
            return Modifier.toString(modifiers);
        }

        public static void main(String[] args) {
            System.out.println(getModifierDesc(Member.class.getModifiers()));
        }
    }

    public static class ProxyUtils {
        public static void main(String[] args) {
            System.out.println("hello");
        }

        public static Object createProxy(Object obj, InvocationHandler h) {
            Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), h);
            return o;
        }

        public static Class getProxyClass(ClassLoader loader,
                                          Class[] interfaces) {
            return Proxy.getProxyClass(loader, interfaces);
        }

        public static Object newProxyInstance(ClassLoader loader,
                                              Class[] interfaces,
                                              InvocationHandler h) {
            return Proxy.newProxyInstance(loader, interfaces, h);
        }

        public static boolean isProxyClass(Class cl) {
            return Proxy.isProxyClass(cl);
        }

        public static InvocationHandler getInvocationHandler(Object proxy) {
            return Proxy.getInvocationHandler(proxy);
        }

    }

    public static class StackTraceUtils {
        public static String desc(StackTraceElement ele) {
            return new StringBuffer()
                    .append("fileName:").append(ele.getFileName()).append(":\n")
                    .append("className:").append(ele.getClassName()).append(":\n")
                    .append("methodName:").append(ele.getMethodName()).append(":\n")
                    .append("lineNumber:").append(ele.getLineNumber()).append(":\n")
                    .append("isNativeMethod():").append(ele.isNativeMethod())
                    .toString();
        }
    }

    public static class ArrayUtils {

        public static int getLength(Object array) {
            return Array.getLength(array);
        }

        public static Object makeInstance(Class clazz, int lenght) {
            return Array.newInstance(clazz, lenght);
        }

        public static Object makeInstance(Class clazz, int... dimensions) {
            return Array.newInstance(clazz, dimensions);
        }

        public static boolean isArray(Object array) {
            return array.getClass().isArray();
        }

    }


}


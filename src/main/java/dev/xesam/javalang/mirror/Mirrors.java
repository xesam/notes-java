package dev.xesam.javalang.mirror;


import javax.lang.model.type.*;


/**
 * Created by xe on 14-12-22.
 */
public class Mirrors {

    static TypeMirror typeMirror;

    //-TypeMirror
    static ExecutableType executableType;
    static IntersectionType intersectionType;
    static NoType noType;
    static PrimitiveType primitiveType;
    static ReferenceType referenceType;
    static UnionType unionType;
    static WildcardType wildcardType;

    //-ReferenceType
    static NullType nullType;
    static ArrayType arrayType; //-ReferenceType
    static DeclaredType declaredType;//-ReferenceType
    static TypeVariable typeVariable;

    //-DeclaredType
    static ErrorType errorType;


    //
    TypeKind typeKind;
}

package com.example.springintilizr.utils;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Modifier;
import java.io.IOException;

public class RestControllerGeneratorUtil {

  public static JavaFile generateRestController() throws IOException {

    AnnotationSpec getMappingAnnotationSpec =
        AnnotationSpec.builder(GetMapping.class).addMember("value", "\"test\"").build();
    AnnotationSpec requestMappingAnnotationSpec =
        AnnotationSpec.builder(RequestMapping.class).addMember("value", "\"api/v1\"").build();
    MethodSpec methodSpec =
        MethodSpec.methodBuilder("test")
            .addParameter(String.class, "message")
            .returns(String.class)
            .addAnnotation(getMappingAnnotationSpec)
            .addModifiers(Modifier.PUBLIC)
            .addStatement("return \"Hello \" + message")
            .build();
    TypeSpec testController =
        TypeSpec.classBuilder("TestController")
            .addModifiers(Modifier.PUBLIC)
            .addMethod(methodSpec)
            .addAnnotation(RestController.class)
            .addAnnotation(requestMappingAnnotationSpec)
            .build();

    return JavaFile.builder("com.jpmorgan.gti.sf.osb.controller", testController)
        .indent("    ")
        .build();
  }
}

package com.example.motilal.di.scope


import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import javax.xml.transform.OutputKeys.METHOD

@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class ServiceScoped
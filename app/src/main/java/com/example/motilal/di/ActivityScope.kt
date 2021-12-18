package com.example.motilal.di


import javax.inject.Scope


@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ActivityScope

package com.example.motilal.di.scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.inject.Scope;


@Scope
@Retention(RUNTIME)
public @interface AppScope {
}
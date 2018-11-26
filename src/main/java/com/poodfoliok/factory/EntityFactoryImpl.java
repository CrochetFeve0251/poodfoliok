package com.poodfoliok.factory;

import com.github.javafaker.Faker;

/**
 * Created by eisti on 26/11/18.
 */
public abstract class EntityFactoryImpl implements EntityFactory {
    protected Faker faker;

    public EntityFactoryImpl(){
        faker = new Faker();
    }

}

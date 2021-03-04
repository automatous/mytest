package com.example.demo.syntax;

public class AbstractApplicationContext {
    PathMatchingResourcePatternResolver resourcePatternResolver;

    public AbstractApplicationContext() {
        this.resourcePatternResolver = getResourcePatternResolver();
    }

    public PathMatchingResourcePatternResolver getResourcePatternResolver() {
        return new PathMatchingResourcePatternResolver(this);
    }

    public void setResourcePatternResolver(PathMatchingResourcePatternResolver resourcePatternResolver) {
        this.resourcePatternResolver = resourcePatternResolver;
    }

    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext = new AbstractApplicationContext();
        PathMatchingResourcePatternResolver resourcePatternResolver = abstractApplicationContext.resourcePatternResolver;
        AbstractApplicationContext resourceLoader = resourcePatternResolver.resourceLoader;
        PathMatchingResourcePatternResolver resourcePatternResolver1 = resourceLoader.resourcePatternResolver;
        AbstractApplicationContext resourceLoader1 = resourcePatternResolver1.resourceLoader;
        System.out.println(abstractApplicationContext == resourceLoader);
        System.out.println(resourcePatternResolver == resourcePatternResolver1);
        System.out.println(resourceLoader == resourceLoader1);
        System.out.println(abstractApplicationContext);
    }

}

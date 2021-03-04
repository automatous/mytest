package com.example.demo.syntax;

public class PathMatchingResourcePatternResolver {
    AbstractApplicationContext resourceLoader;

    public PathMatchingResourcePatternResolver(AbstractApplicationContext resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}

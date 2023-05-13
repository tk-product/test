package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class CustomPropertiesLoader {
    public String loadProperties(String fileName, String propertyKey) {

        String propertyValue = null;
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            propertyValue = properties.getProperty(propertyKey);

            // プロパティの値を使用する処理
            System.out.println(propertyValue);

        } catch (IOException e) {
            // ファイルの読み込みエラー処理
            e.printStackTrace();
        }
        return propertyValue;
    }
}
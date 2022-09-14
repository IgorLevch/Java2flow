package ru.gb.may_chat.props;


import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static PropertyReader instance;
    private String host;
    private int port;
    private long authTimeout;

    private PropertyReader() {
        getPropValues();
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    public void getPropValues() {
        var propFileName = "application.properties";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            // входящий поток данных ,получаем данные по пропертиес
            Properties properties = new Properties(); // класс пропертиес из пакета джава утил
            properties.load(inputStream); // чтбы получить значения из файла, вызываем метод лоад и скачиваем из
            // него наш поток
            host = properties.getProperty("host");  //эта и две следующие строки - получаем значение пропертиес.Строка
            port = Integer.parseInt(properties.getProperty("port")); // число. поэтому делаем парс инт
            authTimeout = Long.parseLong(properties.getProperty("auth.timeout"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }  // используем геттеры, чтобы получить занчение этих пропертей.

    public int getPort() {
        return port;
    }

    public long getAuthTimeout() {
        return authTimeout;
    }
}

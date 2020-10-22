package com.example.miniproject.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.concurrent.Executor;

public class AppConfig {
    @Value("${spring.datasource.username}")
    private String springUsername;

    @Value("${spring.datasource.password}")
    private String springPassword;

    @Value("${spring.datasource.url}")
    private String springURL;

    @Value("${spring.datasource.driver-class-name}")
    private String springDriver;

    @Value("${async.executor.core.pool.size:10}")
    private Integer aeCorePoolSize;

    @Value("${async.executor.max.pool.size:50}")
    private Integer aeMaxPoolSize;

    @Value("${async.executor.queue.capacity:10000}")
    private Integer aeQueueCapacity;

    @Value("${async.executor.keep.alive.seconds:20}")
    private Integer aeKeepAliveSeconds;

    @Value("${async.executor.threadname.prefix:AsynchThread-}")
    private String aeThreadnamePrefix;

    public HttpClient httpClient(final int noOfConnections) {
        PoolingHttpClientConnectionManager
                connectionManager =
                new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(noOfConnections);
        return HttpClientBuilder.create().setConnectionManager(connectionManager).build();
    }

    public ClientHttpRequestFactory httpRequestFactory(final int connectionTimeout, final int readTimeout,
                                                       final int maxConnections) {
        HttpComponentsClientHttpRequestFactory
                factory =
                new HttpComponentsClientHttpRequestFactory(httpClient(maxConnections));
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);
        return factory;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(springURL);
        dataSource.setUsername(springUsername);
        dataSource.setPassword(springPassword);
        dataSource.setDriverClassName(springDriver);
        return dataSource;
    }

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(aeCorePoolSize);
        executor.setMaxPoolSize(aeMaxPoolSize);
        executor.setQueueCapacity(aeQueueCapacity);
        executor.setThreadNamePrefix(aeThreadnamePrefix);
        executor.setKeepAliveSeconds(aeKeepAliveSeconds);
        executor.initialize();
        return executor;
    }

}

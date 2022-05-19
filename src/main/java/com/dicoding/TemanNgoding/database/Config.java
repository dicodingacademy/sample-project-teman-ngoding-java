package com.dicoding.TemanNgoding.database;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.parser.LineSignatureValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
    @Autowired
    private Environment mEnv;

    @Bean(name = "line.bot.channelSecret")
    public String getChannelSecret() {
        return mEnv.getProperty("line.bot.channelSecret");
    }

    @Bean(name = "line.bot.channelToken")
    public String getChannelAccessToken() {
        return mEnv.getProperty("line.bot.channelToken");
    }

    @Bean(name = "lineMessagingClient")
    public LineMessagingClient getMessagingClient() {
        return LineMessagingClient
                .builder(getChannelAccessToken())
                .apiEndPoint(URI.create("https://api.line.me/"))
                .connectTimeout(10_000)
                .readTimeout(10_000)
                .writeTimeout(10_000)
                .build();
    }

    @Bean(name = "lineSignatureValidator")
    public LineSignatureValidator getSignatureValidator() {
        return new LineSignatureValidator(getChannelSecret().getBytes());
    }

    @Bean
    DataSource getDataSource() {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(dbUrl);
        ds.setUsername(username);
        ds.setPassword(password);

        return ds;
    }

    @Bean
    public Dao getPersonDao() {
        return new DaoImpl(getDataSource());
    }
}
package jp.co.isegorup;
import org.apache.tomcat.jdbc.pool.DataSource;

//@Component
//@Configuration
public class DatasourceConfig {

//    @Bean
    public DataSource datasource(){
        DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/sample01");
        ds.setUsername("user01");
        ds.setPassword("pass");
        return ds;
    }
}
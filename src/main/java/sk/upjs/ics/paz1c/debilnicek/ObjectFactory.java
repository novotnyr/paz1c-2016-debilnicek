package sk.upjs.ics.paz1c.debilnicek;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum ObjectFactory {
    INSTANCE;
    
    private JdbcTemplate jdbcTemplate;
    
    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/debilnicek?serverTimezone=UTC");
            dataSource.setUser("debilnicek");
            dataSource.setPassword("debilnicek");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;        
    }
}

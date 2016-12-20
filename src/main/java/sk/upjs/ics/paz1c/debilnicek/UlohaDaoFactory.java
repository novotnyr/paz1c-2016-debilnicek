package sk.upjs.ics.paz1c.debilnicek;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum UlohaDaoFactory {
    INSTANCE;
    
    private JdbcTemplate jdbcTemplate;
    
    public UlohaDao getUlohaDao() {
        return new MysqlUlohaDao(getJdbcTemplate());
    }
    
    private JdbcTemplate getJdbcTemplate() {
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

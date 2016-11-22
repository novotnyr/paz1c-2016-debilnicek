package sk.upjs.ics.paz1c.debilnicek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;


public class MysqlKategoriaDao implements KategoriaDao {
    private JdbcTemplate jdbcTemplate;

    public MysqlKategoriaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Kategoria> dajKategorie() {
        String sql = "SELECT * FROM kategoria";
        
        BeanPropertyRowMapper<Kategoria> mapper = BeanPropertyRowMapper.newInstance(Kategoria.class);
        
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Kategoria najdiPodlaId(Long id) {
        String sql = "SELECT * FROM kategoria WHERE id = ?";        
        BeanPropertyRowMapper<Kategoria> mapper = BeanPropertyRowMapper.newInstance(Kategoria.class);        
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public void uloz(Kategoria kategoria) {
        String sql = "INSERT INTO kategoria VALUES (?, ?)";
             
        jdbcTemplate.update(sql, null, kategoria.getNazov());
    }
    
}

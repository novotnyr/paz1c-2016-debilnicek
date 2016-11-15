package sk.upjs.ics.paz1c.debilnicek;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

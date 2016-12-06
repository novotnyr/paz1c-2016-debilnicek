package sk.upjs.ics.paz1c.debilnicek;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlUlohaDao implements UlohaDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlUlohaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Uloha> dajUlohy() {
        String sql = "SELECT \n" +
                        "	uloha.id AS uloha_id,\n" +
                        "    uloha.popis AS uloha_popis,\n" +
                        "    uloha.termin AS uloha_termin,\n" +
                        "    uloha.stav AS uloha_stav,\n" +
                        "    \n" +
                        "    kategoria.id AS kategoria_id,\n" +
                        "    kategoria.nazov AS kategoria_nazov\n" +
                        "    \n" +
                        "FROM uloha\n" +
                        "JOIN kategoria ON kategoria.id = uloha.kategoria_id";
        return jdbcTemplate.query(sql, new UlohaRowMapper());
    }

    @Override
    public void saveOrUpdate(Uloha uloha) {
        if (uloha.getId() == null) {
        
            jdbcTemplate.update("INSERT INTO uloha (popis, termin, stav, kategoria_id) VALUES(?,?,?,?)",
                    uloha.getPopis(), uloha.getTermin(), uloha.isStav(), uloha.getKategoria().getId());
        } else {
            String sql = "UPDATE uloha SET popis = ?, termin = ?, stav = ?, kategoria_id = ? WHERE id = ?";
            
            jdbcTemplate.update(sql, 
                    uloha.getPopis(), 
                    uloha.getTermin(), 
                    uloha.isStav(), 
                    uloha.getKategoria().getId(), 
                    uloha.getId());
        }
        
    }

    @Override
    public List<Uloha> najdiPodlaKategorie(Kategoria kategoria) {
        String sql = "SELECT * FROM uloha WHERE kategoria_id = ?";
        return jdbcTemplate.query(sql, new UlohaRowMapper(), kategoria.getId());
    }
    
    private class UlohaRowMapper implements RowMapper<Uloha> {

        @Override
        public Uloha mapRow(ResultSet rs, int i) throws SQLException {
            Uloha uloha = new Uloha();
            uloha.setId(rs.getLong("uloha_id"));
            uloha.setPopis(rs.getString("uloha_popis"));
            uloha.setStav(rs.getBoolean("uloha_stav"));
            uloha.setTermin(rs.getDate("uloha_termin"));
            
            Kategoria kategoria = new Kategoria();
            kategoria.setId(rs.getLong("kategoria_id"));
            kategoria.setNazov(rs.getString("kategoria_nazov"));
            
            uloha.setKategoria(kategoria);
            
            return uloha;
        }
        
    }
}

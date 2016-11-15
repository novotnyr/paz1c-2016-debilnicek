package sk.upjs.ics.paz1c.debilnicek;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlUlohaDaoTest {
    
    public MysqlUlohaDaoTest() {
    }

    @Test
    public void testDajUlohy() {
        System.out.println("dajUlohy");
        UlohaDao instance = UlohaDaoFactory.INSTANCE.getUlohaDao();
        List<Uloha> result = instance.dajUlohy();
        System.out.println(result.get(0).getPopis());
        assertTrue(result.size()>0);
    }
    
}
package sk.upjs.ics.paz1c.debilnicek;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ZoznamUlohTest {
    @Test
    public void testZobrazUlohy() {
        ZoznamUloh zoznamUloh = new ZoznamUloh();
        List<Uloha> ulohy = zoznamUloh.dajUlohy();
        Assert.assertEquals(2, ulohy.size());
    }
    
    @Test
    public void testPridatUlohu() {
        ZoznamUloh zoznamUloh = new ZoznamUloh();
        
        Uloha uloha = new Uloha();
        uloha.setPopis("Otestovat pridavanie");
        uloha.setTermin(new Date(2016 - 1900, Calendar.JANUARY, 1));
        
        int pocetUloh = zoznamUloh.dajUlohy().size();
        zoznamUloh.saveOrUpdate(uloha);
        
        int pocetUlohPoPridani = zoznamUloh.dajUlohy().size();
        
        Assert.assertEquals(pocetUlohPoPridani, pocetUloh + 1);
    }
    
    @Test
    public void testHladatDoDatumu() {
        ZoznamUloh zoznamUloh = new ZoznamUloh();
        
        List<Uloha> ulohy = zoznamUloh.dajUlohyDoTerminu(new Date(2016 - 1900, Calendar.OCTOBER, 7));
        
        Assert.assertEquals(2, ulohy.size());
    }
}

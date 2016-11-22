package sk.upjs.ics.paz1c.debilnicek;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class KategoriaComboBoxModel extends DefaultComboBoxModel<Kategoria>  {
    private KategoriaDao kategoriaDao = ObjectFactory.INSTANCE.getKategoriaDao();

    public KategoriaComboBoxModel() {        
        refresh();
    }
    
    public void refresh() {
        removeAllElements();
     
        List<Kategoria> kategorie = kategoriaDao.dajKategorie();
        
        for(Kategoria kategoria : kategorie) {
            addElement(kategoria);
        }        
    }
}

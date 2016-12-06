package sk.upjs.ics.paz1c.debilnicek;

import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class UlohaTableModel extends AbstractTableModel {
    private UlohaDao ulohaDao = UlohaDaoFactory.INSTANCE.getUlohaDao();
    
    private static final String[] NAZVY_STLPCOV = { "Popis", "Termín", "Stav", "Kategória" };

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    
    @Override
    public int getRowCount() {
        return ulohaDao.dajUlohy().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Uloha uloha = ulohaDao.dajUlohy().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return uloha.getPopis();
            case 1:
                Date termin = uloha.getTermin();
                if (termin == null) {
                    return "žiadny";
                } else {
                    return termin;
                }
            case 2:
                return uloha.isStav();
            case 3:
                return uloha.getKategoria().getNazov();
            default:
                return "???";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Boolean.class;
        }
        
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    void aktualizovat() {
        fireTableDataChanged();
    }
    
    public Uloha getUlohaAt(int riadok) {
        return ulohaDao.dajUlohy().get(riadok);
    }
    
}

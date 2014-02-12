package personel_takip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Emre TALU
 */
public class Personel_Takip {
    private static Giris g;
    private static Anasayfa ana;

    public static void main(String[] args) throws SQLException {
        g = new Giris();
        g.setVisible(true);
    }
    
    public static void GirisYap(String eposta, String parola) throws SQLException{
        Baglan bgln = new Baglan();
        int id = bgln.SorguLogin(eposta, parola);
        
        if (id == -1) {
            JOptionPane.showMessageDialog(g, "E-Posta yanlış");
        }
        else if (id == -2) {
            JOptionPane.showMessageDialog(g, "Parola yanlış");
        }
        else {
            ana = new Anasayfa(id);
            Calistir();
            g.setVisible(false);
            ana.setVisible(true);
            int departNo = bgln.SorguDNo(id);
            if (departNo == 1) {
                ana.AnaEnableButton();
            }
        }
        bgln.Kapat();
    }
    
    public static void Calistir() throws SQLException{
        Baglan bgln = new Baglan();
        ResultSet rs = bgln.Sorgu();
        
        ArrayList<Object[]> aro = new ArrayList<>();
        
        while(rs.next()){
            Object[] data = new Object[7];
            data[0] = rs.getString("Ad");
            data[1] = rs.getString("Soyad");
            data[2] = rs.getString("Yas");
            data[3] = rs.getString("Cinsiyet");
            data[4] = rs.getString("EPosta");
            data[5] = rs.getString("Telefon");
            Baglan b = new Baglan();
            data[6] = b.SorguDeptAd(rs.getInt("DepartmanNo"));
            b.Kapat();
            aro.add(data);
        }
        
        Object[][] data = new Object[aro.size()][7];
        
        for (int i = 0; i < aro.size(); i++) {
            data[i] = aro.get(i);
        }
        ana.setTableModel(data);
        bgln.Kapat();
    }
}

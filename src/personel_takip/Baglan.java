package personel_takip;
import java.sql.*;

/**
 *
 * @author Emre TALU
 */
public class Baglan {
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    public Baglan(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
        
        String url = "jdbc:mysql://localhost:3306/person_db";
        String user = "root";
        String pwd = "123456";
        
        try {
            con = DriverManager.getConnection(url,user,pwd);
            st = con.createStatement();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int SorguLogin(String eposta, String parola){
        try {
            String sql = "select Id,Parola from personel WHERE EPosta='"+eposta+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                if (parola.equals(rs.getString("Parola"))) {
                    return rs.getInt("Id");
                }
                else  {
                    return -2;  // parola yanlış
                }
            }
            else  {
                return -1;  // e-posta sistemde yok
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return 0;
    }
    
    public ResultSet Sorgu(){
        try {
            rs = st.executeQuery("select * from personel");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet SorguDept(){
        try {
            rs = st.executeQuery("select * from departman");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    public int SorguDNo(int id){
        try {
            String sql = "select DepartmanNo from personel WHERE Id='"+id+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("DepartmanNo");
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public int SorguDeptID(String dep){
        try {
            String sql = "select Id from departman WHERE Ad='"+dep+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("Id");
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public String SorguDeptAd(int dep_id){
        try {
            String sql = "select Ad from departman WHERE Id="+dep_id+"";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("Ad");
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    public boolean SorguKayit(int d_no, String ad, String soyad, int yas, int cinsiyet, String telefon, String eposta, String parola){
        try {
            String sql = "insert into personel(DepartmanNo, Ad, Soyad, Yas, Cinsiyet, Telefon, EPosta, Parola) "
                    + "Values("+d_no+",'"+ad+"','"+soyad+"',"+yas+","+cinsiyet+",'"+telefon+"','"+eposta+"','"+parola+"')";
            System.out.println(sql);
            st.executeUpdate(sql);
            return true;
        }
        catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean SorguDuzenle(int d_no, String ad, String soyad, int yas, int cinsiyet, String telefon, String eposta, String parola, int id){
        try {
            String sql = "update personel set DepartmanNo="+d_no+", Ad='"+ad+"', Soyad='"+soyad+"',"
                    + "Yas="+yas+", Cinsiyet="+cinsiyet+", Telefon='"+telefon+"', EPosta='"+eposta+"', Parola='"+parola+"' where Id = "+id+"";
            System.out.println(sql);
            st.executeUpdate(sql);
            return true;
        }
        catch (SQLException ex) {
            return false;
        }
    }
    
    public void Kapat(){
        try {
            if(rs != null)
                rs.close();
            if(st != null)
                st.close();
            if(con != null)
                con.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int SorguPersonelDuzenle(String eposta){
        try {
            String sql = "select * from personel WHERE Eposta='"+eposta+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("Id");
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public boolean SorguPersonelSil(String eposta){
        try {
            String sql = "delete from personel WHERE Eposta='"+eposta+"'";
            int sonuc = st.executeUpdate(sql);
            if (sonuc == 1) {
                return true;
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public ResultSet SorguPersonel(int id){
        try {
            String sql = "select * from personel WHERE Id = "+id;
            rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs;
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
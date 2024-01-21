package ATM;

import java.util.Date;

public class History {
    private String nomorRekening;
    private String jenisOperasi;
    private String keterangan;
    private Date createdOn;
    
    public History(String nomorRekening, String jenisOperasi, String keterangan, Date createdOn) {
        this.nomorRekening = nomorRekening;
        this.jenisOperasi = jenisOperasi;
        this.keterangan = keterangan;
        this.createdOn = createdOn;
    }
    
    public String getNomorRekening() {
        return nomorRekening;
    }
    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }
    public String getJenisOperasi() {
        return jenisOperasi;
    }
    public void setJenisOperasi(String jenisOperasi) {
        this.jenisOperasi = jenisOperasi;
    }
    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    @Override
    public String toString() {
        return "[NomorRekening= " + nomorRekening + ", Jenis Operasi= " + jenisOperasi + ", Keterangan="
                + keterangan + ", CreatedOn=" + createdOn + "]";
    }

    

    
}

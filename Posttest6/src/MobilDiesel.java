public class MobilDiesel implements Mobil {
    private String merk;
    private String nama;
    private String mesin;
    private long harga;

    public MobilDiesel(String merk, String nama, String mesin, long harga) {
        this.merk = merk;
        this.nama = nama;
        this.mesin = mesin;
        this.harga = harga;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMesin() {
        return mesin;
    }

    public void setMesin(String mesin) {
        this.mesin = mesin;
    }

    public long getHarga() {
        return harga;
    }

    public void setHarga(long harga) {
        this.harga = harga;
    }

    public String getBahanBakar() {
        return "Solar";
    }
}

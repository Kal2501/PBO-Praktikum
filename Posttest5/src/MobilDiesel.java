class MobilDiesel extends Mobil {
    public MobilDiesel(String merk, String nama, String mesin, long harga) {
        super(merk, nama, mesin, harga);
    }

    @Override
    public String getBahanBakar() {
        return "Solar";
    }
}
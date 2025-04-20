class MobilListrik extends Mobil {
    public MobilListrik(String merk, String nama, String mesin, long harga) {
        super(merk, nama, mesin, harga);
    }

    @Override
    public String getBahanBakar() {
        return "Listrik";
    }
}
class MobilBensin extends Mobil {
    public MobilBensin(String merk, String nama, String mesin, long harga) {
        super(merk, nama, mesin, harga);
    }

    @Override
    public String getBahanBakar() {
        return "Bensin";
    }
}
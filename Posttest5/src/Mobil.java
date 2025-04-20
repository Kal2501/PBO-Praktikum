import java.util.Scanner;
import java.util.ArrayList;

abstract class Mobil {
    private String merk;
    protected String nama;
    private String mesin;
    protected long harga;

    private static final ArrayList<Mobil> daftarMobil = new ArrayList<>();

    public Mobil(String merk, String nama, String mesin, long harga) {
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

    public abstract String getBahanBakar();

    public static final ArrayList<Mobil> getDaftarMobil() {
        return daftarMobil;
    }

    public static final void tambahMobil(Scanner scanner) {
        System.out.println("Menu Tambah Data Mobil Tersedia");
        System.out.println("===============================");
        System.out.print("Masukkan merk mobil: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan nama mobil: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan mesin mobil: ");
        String mesin = scanner.nextLine();
        long harga = 0;
        while (true) {
            System.out.print("Masukkan harga mobil: ");
            try {
                harga = scanner.nextLong();
                if (harga <= 0) {
                    System.out.println("Mana ada mobil gratis? Silakan masukkan harga.");
                    continue;
                }
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Masukin angka bang.");
                scanner.nextLine();
            }
        }

        int pilihan = 0;
        while (true) {
            System.out.println("Pilih jenis bahan bakar:");
            System.out.println("1. Bensin");
            System.out.println("2. Listrik");
            System.out.println("3. Solar");
            System.out.print("Pilihan (1/2/3): ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                if (pilihan < 1 || pilihan > 3) {
                    System.out.println("Pilihan hanya 1, 2, atau 3.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Masukkan angka 1, 2, atau 3!");
                scanner.nextLine();
            }
        }

        tambahMobil(merk, nama, mesin, harga, pilihan);
    }

    public static final void tambahMobil(String merk, String nama, String mesin, long harga, int jenisBahanBakar) {
        Mobil mobilBaru;
        switch (jenisBahanBakar) {
            case 2:
                mobilBaru = new MobilListrik(merk, nama, mesin, harga);
                break;
            case 3:
                mobilBaru = new MobilDiesel(merk, nama, mesin, harga);
                break;
            case 1:
            default:
                mobilBaru = new MobilBensin(merk, nama, mesin, harga);
                break;
        }

        daftarMobil.add(mobilBaru);
        System.out.println("Data mobil berhasil ditambahkan.\n");
    }

    public static final void tampilkanMobil(Scanner scanner) {
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        } else {
            Utility.dataMobil();
        }
    }

    public static final void updateDataMobil(Scanner scanner) {
        System.out.println("Update Data Mobil Tersedia");
        System.out.println("==========================");
        ArrayList<Mobil> daftarMobil = Mobil.getDaftarMobil();
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        }
        Utility.dataMobil();
        int nomor = 0;
        while (true) {
            System.out.print("Pilih nomor data mobil yang ingin diubah: ");
            try {
                nomor = scanner.nextInt();
                scanner.nextLine();
                if (nomor < 1 || nomor > daftarMobil.size()) {
                    System.out.println("Pilihan tidak ada dalam data!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                scanner.nextLine();
            }
        }
        System.out.println("===============================");
        System.out.print("Masukkan merk baru: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan nama baru: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan mesin baru: ");
        String mesin = scanner.nextLine();
        long harga = 0;
        while (true) {
            System.out.print("Masukkan harga baru: ");
            try {
                harga = scanner.nextLong();
                scanner.nextLine();
                if (harga <= 0) {
                    System.out.println("Mana ada mobil gratis? Silakan masukkan harga.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Masukin angka bang.");
                scanner.nextLine();
            }
        }

        int pilihan = 0;
        while (true) {
            System.out.println("Pilih jenis bahan bakar:");
            System.out.println("1. Bensin");
            System.out.println("2. Listrik");
            System.out.println("3. Solar");
            System.out.print("Pilihan (1/2/3): ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                if (pilihan < 1 || pilihan > 3) {
                    System.out.println("Pilihan hanya 1, 2, atau 3.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Input tidak valid. Masukkan angka 1, 2, atau 3.");
                scanner.nextLine();
            }
        }
        updateDataMobil(nomor, merk, nama, mesin, harga, pilihan);
    }

    public static final void updateDataMobil(int nomor, String merk, String nama, String mesin, long harga,
            int jenisBahanBakar) {
        Mobil mobilBaru;
        switch (jenisBahanBakar) {
            case 2:
                mobilBaru = new MobilListrik(merk, nama, mesin, harga);
                break;
            case 3:
                mobilBaru = new MobilDiesel(merk, nama, mesin, harga);
                break;
            case 1:
            default:
                mobilBaru = new MobilBensin(merk, nama, mesin, harga);
                break;
        }

        daftarMobil.set(nomor - 1, mobilBaru);
        System.out.println("Data mobil berhasil diubah.\n");
    }

    public static final void hapusDataMobil(Scanner scanner) {
        System.out.println("Hapus Data Mobil Tersedia");
        System.out.println("=========================");
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        } else {
            Utility.dataMobil();
            System.out.print("Pilih mobil yang ingin dihapus: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();
            if (nomor > daftarMobil.size()) {
                System.out.println("Pilihan tidak valid!");
            } else {
                daftarMobil.remove(nomor - 1);
                System.out.println("Data mobil berhasil dihapus.\n");
            }
        }
    }
}
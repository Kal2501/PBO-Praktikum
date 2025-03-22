import java.util.Scanner;
import java.util.ArrayList;

class Mobil {
    private String merk;
    protected String nama;
    private String mesin;
    protected long harga;

    private static ArrayList<Mobil> daftarMobil = new ArrayList<>();

    private Mobil(String merk, String nama, String mesin, long harga) {
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

    public static ArrayList<Mobil> getDaftarMobil() {
        return daftarMobil;
    }

    public static void tambahMobil(Scanner scanner) {
        System.out.println("Menu Tambah Data Mobil Tersedia");
        System.out.println("===============================");
        System.out.print("Masukkan merk mobil: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan nama mobil: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan mesin mobil: ");
        String mesin = scanner.nextLine();
        System.out.print("Masukkan harga mobil: ");
        long harga = scanner.nextLong();
        scanner.nextLine();
        Mobil mobilBaru = new Mobil(merk, nama, mesin, harga);
        daftarMobil.add(mobilBaru);
        System.out.println("Data mobil berhasil ditambahkan.\n");
    }

    public static void tampilkanMobil(Scanner scanner) {
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        } else {
            Utility.dataMobil();
        }
    }

    public static void updateDataMobil(Scanner scanner) {
        System.out.println("Update Data Mobil Tersedia");
        System.out.println("==========================");
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        } else {
            Utility.dataMobil();
            System.out.print("Pilih data mobil yang ingin diubah: ");
            int nomor = scanner.nextInt();
            scanner.nextLine();
            if (nomor > daftarMobil.size()) {
                System.out.println("Pilihan tidak valid!");
            } else {
                System.out.println("===============================");
                System.out.print("Masukkan merk mobil: ");
                String merk = scanner.nextLine();
                System.out.print("Masukkan nama mobil: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan mesin mobil: ");
                String mesin = scanner.nextLine();
                System.out.print("Masukkan harga mobil: ");
                long harga = scanner.nextLong();
                scanner.nextLine();
                Mobil mobilBaru = new Mobil(merk, nama, mesin, harga);
                daftarMobil.set((nomor - 1), mobilBaru);
                System.out.println("Data mobil berhasil diubah.\n");
            }
        }
    }

    public static void hapusDataMobil(Scanner scanner) {
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
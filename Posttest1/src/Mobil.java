import java.util.Scanner;
import java.util.ArrayList;

class Mobil {
    String merk;
    String nama;
    String mesin;
    long harga;

    static ArrayList<Mobil> daftarMobil = new ArrayList<>();

    public Mobil(String merk, String nama, String mesin, long harga) {
        this.merk = merk;
        this.mesin = mesin;
        this.nama = nama;
        this.harga = harga;
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

    public static void dataMobil() {
        System.out.println("Daftar Mobil Tersedia:");
        System.out.println("================================================================================");
        System.out.printf("%-5s | %-15s | %-15s | %-15s | %-10s\n", "No", "Merk", "Nama", "Mesin", "Harga");
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < daftarMobil.size(); i++) {
            Mobil mobil = daftarMobil.get(i);
            System.out.printf("%-5d | %-15s | %-15s | %-15s | Rp%,10d\n", (i + 1), mobil.merk, mobil.nama,
                    mobil.mesin, mobil.harga);
        }
        System.out.println("================================================================================");
    }

    public static void tampilkanMobil(Scanner scanner) {
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        } else {
            dataMobil();
        }
    }

    public static void updateDataMobil(Scanner scanner) {
        System.out.println("Update Data Mobil Tersedia");
        System.out.println("==========================");
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        } else {
            dataMobil();
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
            dataMobil();
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
import java.util.ArrayList;
import java.util.Scanner;

public class ManageMobil {
    private static final ArrayList<Mobil> daftarMobil = new ArrayList<>();

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

        Mobil mobil;
        switch (pilihan) {
            case 2:
                mobil = new MobilListrik(merk, nama, mesin, harga);
                break;
            case 3:
                mobil = new MobilDiesel(merk, nama, mesin, harga);
                break;
            default:
                mobil = new MobilBensin(merk, nama, mesin, harga);
        }

        daftarMobil.add(mobil);
        System.out.println("Mobil berhasil ditambahkan!\n");
    }

    public static void tampilkanMobil() {
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada data.");
        } else {
            Utility.dataMobil();
        }
        System.out.println();
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

    public static void updateDataMobil(Scanner scanner) {
        System.out.println("Update Data Mobil Tersedia");
        System.out.println("==========================");
        tampilkanMobil();
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil saat ini.");
            return;
        }
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

        Mobil mobil;
        switch (pilihan) {
            case 2:
                mobil = new MobilListrik(merk, nama, mesin, harga);
                break;
            case 3:
                mobil = new MobilDiesel(merk, nama, mesin, harga);
                break;
            default:
                mobil = new MobilBensin(merk, nama, mesin, harga);
        }

        daftarMobil.set(nomor - 1, mobil);
        System.out.println("Data mobil berhasil diubah.\n");
    }
}

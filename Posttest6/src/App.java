import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Utility.clearScreen();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("Selamat datang di OtoUsed for Admin:");
            System.out.println("====================================");
            System.out.println("1. Tambah Mobil");
            System.out.println("2. List Mobil Tersedia");
            System.out.println("3. Ubah Data Mobil Tersedia");
            System.out.println("4. Hapus Data Mobil Tersedia");
            System.out.println("0 Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    Utility.clearScreen();
                    ManageMobil.tambahMobil(scanner);
                    Utility.tekanEnter(scanner);
                    break;
                case 2:
                    Utility.clearScreen();
                    ManageMobil.tampilkanMobil();
                    Utility.tekanEnter(scanner);
                    break;
                case 3:
                    Utility.clearScreen();
                    ManageMobil.updateDataMobil(scanner);
                    Utility.tekanEnter(scanner);
                    break;
                case 4:
                    Utility.clearScreen();
                    ManageMobil.hapusDataMobil(scanner);
                    Utility.tekanEnter(scanner);
                    break;
                default:
                    System.out.println("====================================");
                    System.out.println("Terima kasih telah menggunakan OtoUsed for Admin.");
            }
        } while (pilihan != 0);
    }
}

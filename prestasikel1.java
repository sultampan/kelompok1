import java.util.Scanner;

public class prestasikel1 {
    private static int maxData = 100;
    private static String[][] prestasiData = new String[maxData][5];
    private static int entryCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihMenu;

        do {
            TampilanMenu();
            pilihMenu = sc.nextInt();
            sc.nextLine(); 

            switch (pilihMenu) {
                case 1:
                    tambahPrestasiData(sc);
                    break;
                case 2:
                    tampilkanPrestasiData();
                    break;
                case 3:
                    analisisPrestasiData(sc);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihMenu != 4);
    }

    private static void TampilanMenu() {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Daftar Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void tambahPrestasiData(Scanner sc) {
        if (entryCount >= maxData) {
            System.out.println("Maaf, data prestasi sudah mencapai kapasitas maksimal.");
            return;
        }

        System.out.print("Masukkan nama mahasiswa: ");
        prestasiData[entryCount][0] = sc.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        prestasiData[entryCount][1] = sc.nextLine();

        System.out.print("Masukkan jenis prestasi: ");
        prestasiData[entryCount][2] = sc.nextLine();

        System.out.print("Masukkan tingkat prestasi (Lokal/Nasional/Internasional): ");
        prestasiData[entryCount][3] = sc.nextLine();

        System.out.print("Masukkan tahun prestasi (2010 - 2024): ");
        int tahun = sc.nextInt();
        sc.nextLine();

        if (tahun < 2010 || tahun > 2024) {
            System.out.println("Tahun prestasi tidak valid. Silakan coba lagi.");
            return;
        }

        prestasiData[entryCount][4] = String.valueOf(tahun);
        entryCount++;
        System.out.println("Data prestasi berhasil ditambahkan.");
    }

    private static void tampilkanPrestasiData() {
        System.out.println("=== DAFTAR PRESTASI MAHASISWA ===");
        System.out.println("Nama\tNIM\tJenis\tTingkat\tTahun");

        for (int i = 0; i < entryCount; i++) {
            System.out.println(prestasiData[i][0] + "\t" +
                              prestasiData[i][1] + "\t" +
                              prestasiData[i][2] + "\t" +
                              prestasiData[i][3] + "\t" +
                              prestasiData[i][4]);
        }
    }

    private static void analisisPrestasiData(Scanner sc) {
        System.out.println("=== ANALISIS PRESTASI ===");
        System.out.print("Masukkan jenis prestasi yang ingin dianalisis: ");
        String jenisPrestasiTarget = sc.nextLine();

        int localCount = 0;
        int nasionalCount = 0;
        int internasionalCount = 0;

        for (int i = 0; i < entryCount; i++) {
            if (prestasiData[i][2].equals(jenisPrestasiTarget)) {
                if (prestasiData[i][3].equals("Lokal")) {
                    localCount++;
                } else if (prestasiData[i][3].equals("Nasional")) {
                    nasionalCount++;
                } else if (prestasiData[i][3].equals("Internasional")) {
                    internasionalCount++;
                }
            }
        }

        System.out.println("Jumlah prestasi " + jenisPrestasiTarget + " berdasarkan tingkat:");
        System.out.println("Lokal: " + localCount);
        System.out.println("Nasional: " + nasionalCount);
        System.out.println("Internasional: " + internasionalCount);
    }
}
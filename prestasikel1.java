import java.util.Scanner;

public class prestasikel1 {
     static int maxData = 100;
     static String[][] prestasiData = new String[maxData][5];
     static int jumlahData = 0;
     static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihMenu;

        do {
            TampilanMenu();
            pilihMenu = sc.nextInt();
            sc.nextLine(); 

            switch (pilihMenu) {
                case 1:
                    tambahPrestasiData();
                    break;
                case 2:
                    tampilkanPrestasiData();
                    break;
                case 3:
                    analisisPrestasiData();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihMenu != 4);
    }

     static void TampilanMenu() {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Daftar Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

     static void tambahPrestasiData() {
        String namaMhs, nim, jenisPrestasi, tingkatPrestasi, tahunPrestasi;
        System.out.print("Masukkan Nama Mahasiswa: ");
        namaMhs = sc.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        nim = sc.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        jenisPrestasi = sc.nextLine();

        while (true) {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkatPrestasi = sc.nextLine();
            if (tingkatPrestasi.equalsIgnoreCase("Lokal") ||
                tingkatPrestasi.equalsIgnoreCase("Nasional") ||
                tingkatPrestasi.equalsIgnoreCase("Internasional")) {
                break;
            } else {
                System.out.println("Input Tingkat Prestasi tidak valid. Coba lagi!");
            }
        }
        while (true) {
            System.out.print("Masukkan Tahun Prestasi (2010 - 2024) : ");
            tahunPrestasi = sc.nextLine();

            int tahun = Integer.parseInt(tahunPrestasi);
            if (tahun >= 2010 || tahun <= 2024) {
                break;
            } else {
                System.out.println("Tahun tidak valid. Coba lagi!");
            }
        }

       prestasiData[jumlahData][0] = namaMhs;
       prestasiData[jumlahData][1] = nim;
       prestasiData[jumlahData][2] = jenisPrestasi;
       prestasiData[jumlahData][3] = tingkatPrestasi;
       prestasiData[jumlahData][4] = tahunPrestasi;
        jumlahData++;

        System.out.println("Prestasi berhasil ditambahkan.");
    }

     static void tampilkanPrestasiData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi");
        }else{
        System.out.println("=== DAFTAR PRESTASI MAHASISWA ===");
        System.out.println("Nama\tNIM\tJenis\tTingkat\tTahun");

        for (int i = 0; i < jumlahData; i++) {
            System.out.println(prestasiData[i][0] + "\t" +
                              prestasiData[i][1] + "\t" +
                              prestasiData[i][2] + "\t" +
                              prestasiData[i][3] + "\t" +
                              prestasiData[i][4]);
            }
         }   
    }

     static void analisisPrestasiData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data untuk di analisis");
            return;
        }
        System.out.print("Masukkan jenis prestasi untuk analisis: ");
        String jenisPrestasi = sc.nextLine();

        System.out.println("\n===== Hasil Analisis =====");
        boolean cari = true;

        for (int i = 0; i < jumlahData; i++) {
            if (prestasiData[i][2].equalsIgnoreCase(jenisPrestasi)) {
                System.out.printf("%d. Nama: %s | NIM: %s | Tingkat: %s | Tahun: %s%n",
                        i + 1, prestasiData[i][0], prestasiData[i][1], prestasiData[i][3], prestasiData[i][4]);
                cari = true;
            }
        }
        if (!cari) {
            System.out.printf("Tidak ada prestasi dengan jenis \"%s\".%n", jenisPrestasi);
        }
    }
}
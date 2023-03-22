package Swalayan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Swalayan a = new Swalayan();
        System.out.println("Selamat Datang di Swalayan FILKOM");
        do {
            System.out.println("========================================");
            System.out.println("Silahkan pilih Menu dibawah: ");
            System.out.println("1. Buat Akun");
            System.out.println("2. Cek Akun");
            System.out.println("3. Ganti Nama");
            System.out.println("4. Top Up Saldo");
            System.out.println("5. Pembelian");
            System.out.println("6. Keluar");
            System.out.print("Masukkan Pilihan Anda : ");
            a.Menu(in.nextLine());
            if (a.attempt == 3){
                System.out.println("========================================");
                System.out.println("Maaf Akun Anda Terblokir.");
            }
        } while ( a.attempt < 3 );
    }
}

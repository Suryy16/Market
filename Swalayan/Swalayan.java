package Swalayan;
import java.text.DecimalFormat;
import java.util.*;

public class Swalayan {
    private String name;
    private String NoPelanggan;
    private String PIN;
    private double saldo;
    int attempt = 0;
    Product [] product = new Product[5];
    Scanner in = new Scanner(System.in);
    String pattern = "###,###.###";
    DecimalFormat format = new DecimalFormat(pattern);

    public void setName(String name) {
        this.name = name;
    }

    public void setNoPelanggan(String noPelanggan) {
        int minimum = 10000000;
        int maximum = 99999999;
        int range = maximum - minimum + 1;
        Random random = new Random ();
        String NoPel = Integer.toString(random.nextInt(range) + minimum);
        if (noPelanggan.equalsIgnoreCase("silver")){
            this.NoPelanggan = "38" + NoPel;
        } else if (noPelanggan.equalsIgnoreCase("gold")) {
            this.NoPelanggan = "56" + NoPel;
        } else if (noPelanggan.equalsIgnoreCase("platinum")) {
            this.NoPelanggan = "74" + NoPel;
        }
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSaldo() {
        return "Rp. " + format.format(saldo);
    }

    public String getName() {
        return name;
    }

    public String getPIN() {
        return PIN;
    }

    public String getNoPelanggan() {
        return NoPelanggan;
    }

    public void TopUp(double JumlahTopUp) {
            if (this.saldo + JumlahTopUp < 50000){
                System.out.println("Maaf Saldo Tidak Mencukupi Batas Minimal");
            }else {
                this.saldo += JumlahTopUp;
                System.out.println("Transaksi Berhasil");
                System.out.println("Saldo Anda Sekarang : " + getSaldo());
            }
        }

    public double CashBack(double jumlahPembelian){
        String [] pin = new String[10];
        pin = this.NoPelanggan.split("");
        String type = pin[0]+pin[1];

        if (type.equalsIgnoreCase("38") && jumlahPembelian > 1000000) {
            return jumlahPembelian * 0.05;
        } else if (type.equalsIgnoreCase("56") && jumlahPembelian > 1000000) {
            return jumlahPembelian * 0.07;
        } else if (type.equalsIgnoreCase("56")) {
            return jumlahPembelian * 0.02;
        } else if (type.equalsIgnoreCase("74") && jumlahPembelian > 1000000) {
            return jumlahPembelian * 0.10;
        } else if (type.equalsIgnoreCase("74")) {
            return jumlahPembelian * 0.05;
        } else {
            return 0;
        }
    }
    public void BuatAkun(){
        System.out.print("Masukkan Nama Anda : ");
        setName(in.nextLine());
        System.out.print("Masukkan Jenis Akun : ");
        setNoPelanggan(in.nextLine());
        System.out.print("Masukkan PIN Anda : ");
        setPIN(in.nextLine());
        System.out.print("Masukkan Saldo Awal Anda (minimal Rp 50.000) : ");
        double top = in.nextDouble();
        if (top<50000){
            System.out.println("Maaf Jumlah Saldo Tidak Mencukupi.");
        }else {
            setSaldo(top);
        }
    }
    public void printDataAkun(){
        System.out.println("========================================");
        System.out.println("Nama            : " + getName());
        System.out.println("No Pelanggan    : " + getNoPelanggan());
        System.out.println("Saldo           : " + getSaldo());
    }
    public void Menu(String MenuOption){
        if (MenuOption.equalsIgnoreCase("1")){
            System.out.println("========================================");
            BuatAkun();
        } else if (MenuOption.equalsIgnoreCase("2")) {
            System.out.println("========================================");
            printDataAkun();
        } else if (MenuOption.equalsIgnoreCase("3")) {
            System.out.println("========================================");
            gantiNama();
        } else if (MenuOption.equalsIgnoreCase("4")) {
            System.out.println("========================================");
            System.out.print("Masukkan Jumlah Saldo : ");
            double inputtopUp = in.nextDouble(); in.nextLine();
            System.out.print("Masukkan PIN Anda : ");
            String inputPin = in.nextLine();
            if (this.PIN.equals(inputPin)){
                TopUp(inputtopUp);
            }else {
                System.out.println("Maaf PIN Anda Salah, Transaksi Gagal.");
                attempt++;
            }
        } else if (MenuOption.equalsIgnoreCase("5")) {
            System.out.println("========================================");
            daftarBarang();
            System.out.print("Masukkan Barang yang Anda Beli : ");
            String inputan = in.nextLine();

            System.out.print("Masukkan PIN Anda : ");
            String inputPin = in.nextLine();
            if (this.PIN.equals(inputPin)){
                Pembelian(inputan);
            }else {
                System.out.println("Maaf PIN Anda Salah, Transaksi Gagal.");
                attempt++;
            }
        } else if (MenuOption.equalsIgnoreCase("6")) {
            System.out.println("========================================");
            System.exit(0);
        }
    }
    public void gantiNama() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Baru Anda : ");
        String namaBaru = scanner.nextLine();
        setName(namaBaru);
    }
    public void daftarBarang(){
        product[0] = new Product(1600000, "Samsul bima sakit");
        product[1] = new Product(24000000,"ASEP zepiros" );
        product[2] = new Product(3000000, "Somai Pocong x9");
        product[3] = new Product(500000, "Adsan Tab 7x");
        product[4] = new Product(15500000, "Letoyo Yoga 6");
        System.out.println("Daftar Barang yang Tersedia : ");
        System.out.println("1. " + product[0].getNameProduct() + "\t : Rp. " + format.format(product[0].getPrice()));
        System.out.println("2. " + product[1].getNameProduct() + "\t\t\t : Rp. " + format.format(product[1].getPrice()));
        System.out.println("3. " + product[2].getNameProduct() + "\t\t : Rp. " + format.format(product[2].getPrice()));
        System.out.println("4. " + product[3].getNameProduct() + "\t\t\t : Rp. " + format.format(product[3].getPrice()));
        System.out.println("5. " + product[4].getNameProduct() + "\t\t : Rp. " + format.format(product[4].getPrice()));
    }
    public void Pembelian(String inpuBeli){
        if (inpuBeli.equals("1")){
            if (this.saldo - product[0].getPrice() < 50000){
                    System.out.println("Saldo Anda Kurang, Transaksi Gagal.");
            }else{
                    this.saldo+=CashBack(product[0].getPrice());
                    this.saldo -= product[0].getPrice();
                    System.out.println("Transaksi Berhasil");
                    System.out.println("Saldo Anda Sekarang : " + getSaldo());
            }
        } else if (inpuBeli.equals("2")) {
            if (this.saldo - product[1].getPrice() < 50000){
                    System.out.println("Saldo Anda Kurang, Transaksi Gagal.");
            }else{
                    this.saldo+=CashBack(product[1].getPrice());
                    this.saldo -= product[1].getPrice();
                    System.out.println("Transaksi Berhasil");
                    System.out.println("Saldo Anda Sekarang : " + getSaldo());
            }
        } else if (inpuBeli.equals("3")) {
            if (this.saldo - product[2].getPrice() < 50000){
                    System.out.println("Saldo Anda Kurang, Transaksi Gagal.");
            }else{
                    this.saldo+=CashBack(product[2].getPrice());
                    this.saldo -= product[2].getPrice();
                    System.out.println("Transaksi Berhasil");
                    System.out.println("Saldo Anda Sekarang : " + getSaldo());
            }
        }else if (inpuBeli.equals("4")) {
            if (this.saldo - product[3].getPrice() < 50000){
                    System.out.println("Saldo Anda Kurang, Transaksi Gagal.");
            }else{
                    this.saldo+=CashBack(product[3].getPrice());
                    this.saldo -= product[3].getPrice();
                    System.out.println("Transaksi Berhasil");
                    System.out.println("Saldo Anda Sekarang : " + getSaldo());
            }
        }else if (inpuBeli.equals("5")) {
            if (this.saldo - product[4].getPrice() < 50000){
                    System.out.println("Saldo Anda Kurang, Transaksi Gagal.");
            }else{
                    this.saldo+=CashBack(product[4].getPrice());
                    this.saldo -= product[4].getPrice();
                    System.out.println("Transaksi Berhasil");
                    System.out.println("Saldo Anda Sekarang : " + getSaldo());
            }
        }else {
            System.out.println("Maaf Pilihan Anda Tidak Ada.");
        }
    }
}
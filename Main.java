import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        ArrayList<Pesan> p = new ArrayList();
        Scanner sc = new Scanner(System.in);
        Integer pilihan = 0;
 
       do{
           /*
           jika pilih 1, maka input data, 
           jika 2, maka tampilkan data
           jika 3 maka keluar sistem
           */
 
            System.out.println("----------------------------");
            System.out.println("--- BINTANG BUCK COFFEE ----");
            System.out.println("----------------------------");
            System.out.println("  1. Pembelian");
            System.out.println("  2. Bayar");
            System.out.println("  3. Keluar sistem");
            System.out.println("----------------------------");
            System.out.print("  Pilihanmu: ");
            pilihan = sc.nextInt();
 
           if(pilihan == 1 ){
               p = beli( p );
           }else if(pilihan == 2){
                p = bayar( p );
           }
       }while (pilihan != 3);
 
    }
 
    private static ArrayList<Pesan> beli( ArrayList<Pesan> p ){ 
        Scanner sc = new Scanner(System.in);
        String nama, tipe, gula, output;
        Integer harga, qty;
        boolean ok;
        
        do {
            System.out.print("Nama : ");
            nama = sc.nextLine();            
            ok = cekKopi(nama);
        }while(ok == false);
        
        System.out.print("Tipe: ");
        tipe = sc.nextLine();
        
        System.out.print("Gula: ");
        gula = sc.nextLine();
 
        System.out.print("Harga: ");
        harga = sc.nextInt();
 
        do {
            System.out.print("Qty : ");
            qty = sc.nextInt();      
            ok = cekQty(qty);
        }while(ok == false);
        
        p.add( new Pesan( nama, tipe, gula, harga, qty ) );
        return p;
    }
 
    private static ArrayList<Pesan> bayar( ArrayList<Pesan> p ){
        Scanner sc = new Scanner(System.in);
        Integer harga, total_pembayaran;
        boolean ok;
 
        //tampilkan data 
        System.out.println("Jumlah data: "+ p.size());
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                "No",
                "Nama",
                "Tipe",
                "Gula",
                "Harga",
                "Qty",
                "Jumlah");
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
 
        int total_harga = 0;
        for(int i = 0; i < p.size(); i++ ){
            System.out.printf("| %-3s | %-10s | %-10s | %-5s | %-7s | %-3s  | %-7s |", 
                i + 1,
                p.get(i).getNama(),
                p.get(i).getTipe(),
                p.get(i).getGula(),
                p.get(i).getHarga(),
                p.get(i).getQty(),
                harga = (p.get(i).getHarga() * p.get(i).getQty()));
                total_harga += harga;
            System.out.println();
            System.out.println("--------------------------------------------------------------------");
 
        }

        System.out.println("Total Pembayaran : " + total_harga);
        
        do {
            System.out.print("Masukkan Pembayaran : ");
            total_pembayaran = sc.nextInt();
            ok = cekPembayaran(total_pembayaran, total_harga);
        }while(ok == false);
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Terima kasih telah berbelanja disini :)");
         
        p.clear();
        return p;
    }
    
    public static boolean cekKopi(String k) {
        boolean ok = false;
        if(k.equals("Americano") || k.equals("Latte") || k.equals("Arabika")) {
            ok = true;
        }else {
            System.out.println("Tipe Harus Americano, Latte, Arabika");
        }
        return ok;
    }
    
    public static boolean cekQty(int q) {
        boolean ok = false;
        
        if(q > 0) {
            ok = true;
        }else {
            System.out.println("QTY Harus lebih dari 0");
        }
        
        return ok;
    }
    
    public static boolean cekPembayaran(int p, int h) {
        Integer kembalian;
        boolean ok = false;
        
        if(p >= h) {
            kembalian = p - h;
            if(kembalian != 0) {
                System.out.println("Total Kembalian : " + kembalian);
            }
            
            ok = true;
        }else {
            System.out.println("Pembayaran yang dimasukkan kurang");
        }
        
        return ok;
    }
}
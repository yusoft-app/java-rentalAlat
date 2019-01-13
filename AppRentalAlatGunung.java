/**
 +==============================+
 | Nama     : Wahyu Tri Kusumo  |
 | NIM      : 18.230.0100       |
 | Kelas    : 1M51              |
 +==============================+
**/

package apprentalalatgunung;
import java.util.*;

public class AppRentalAlatGunung {
    public static boolean appRun = true;
    public static ArrayList daftarJadwal = new ArrayList();
    public static Scanner inputan = new Scanner(System.in);
    static alat peralatan = new alat();
    
    public static void menuUtama(){
        System.out.println("");
        System.out.println("+======== MENU UTAMA ========+");
        System.out.println("| [1] Daftar Alat            |");
        System.out.println("| [2] Daftar Booking         |");
        System.out.println("| [3] Keluar                 |");
        System.out.println("+============================+");
        System.out.print("Pilih menu : ");
        int menu = inputan.nextInt();
        
        switch (menu){
            case 1: peralatan.menuAlat(); break;
            case 2: System.out.println("Belum dibuat"); break;
            case 3: System.exit(0); break;
            default: System.out.println("Pilihan salah. Ulangi!");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== APLIKASI RENTAL ALAT GUNUNG AMANAH ADVENTURE ===");
        do {
            menuUtama();
        } while (appRun);
    }

}

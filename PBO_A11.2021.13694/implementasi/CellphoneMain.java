import java.util.Scanner;

public class CellphoneMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cellphone cp = new Cellphone("Iphone", "11 pro max");
        cp.powerOn();

        boolean exit = false; 

        while (!exit) { 
            System.out.println("Menu:");
            System.out.println("1. Isi pulsa");
            System.out.println("2. Cek Sisa Pulsa");
            System.out.println("3. Tambah contact");
            System.out.println("4. Liat contacts");
            System.out.println("5. Cari contact");
            System.out.println("6. Matikan HP");
            
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt(); 

            switch (choice) { 
                case 1: 
                    System.out.print("Masukkan Ingin Mengisi pulsa berapa: ");
                    int amount = sc.nextInt();
                    cp.topUp(amount);
                    break;
                case 2:
                    cp.CekPulsa();
                    break;
                case 3: 
                    sc.nextLine();
                    System.out.print("Beri nama kontak baru: ");
                    String name = sc.nextLine();
                    System.out.print("Masukkan Nomor kontak baru: ");
                    String number = sc.nextLine();
                    cp.addContact(name, number);
                    break;
                case 4: 
                    cp.viewContacts();
                    break;
                case 5:
                    sc.nextLine();
                    System.out.print("Masukkan nama kotak yang ingin di cari: ");
                    String search = sc.nextLine();
                    Contact c = cp.findContact(search);
                    if (c != null) {
                        System.out.println("Kontak ketemu: " + c.getNama() + " - " + c.getNomor());
                    } else {
                        System.out.println("kontak tidak dapat ditemukan");
                    }
                    break;
                case 6: 
                    cp.powerOff();
                    exit = true; 
                    break;
                
                default: 
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
    }
}
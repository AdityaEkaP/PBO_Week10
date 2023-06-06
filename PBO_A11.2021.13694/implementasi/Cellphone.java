import java.util.ArrayList; // import the ArrayList class

public class Cellphone implements Phone{
  String merk;
  String type;
  int batteryLevel;
  int status;
  int volume;
  int balance; // a field to store the current balance
  ArrayList<Contact> contacts; // a field to store the contacts
  
  public Cellphone(String merk,String type)
  {
    this.merk = merk;
    this.type = type;
    this.batteryLevel = (int)(Math.random()*(100-0+1)+0);
    this.balance = 0; // initialize the balance to zero
    this.contacts = new ArrayList<Contact>(); // initialize the contacts list
  }
  
  public void powerOn(){
    this.status = 1;
    System.out.println("Ponsel menyala");
  }
  
  public void powerOff(){
    this.status = 0;
    System.out.println("Ponsel mati");
  }
  
  public void volumeUp(){
    if(this.status == 0){
      System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
    }
    else
    {
      this.volume++;
      if(this.volume>=100)
      {
        this.volume = 100;
      }
    }
  }
  
  public void volumeDown(){
    if(this.status == 0){
      System.out.println("Ponsel mati. Tidak dapat menurunkan volume");
    }
    else
    {
      this.volume--;
      if(this.volume<=0)
      {
        this.volume = 0;
      }
    }
    
}
  
public int getVolume(){
   return this.volume; 
}

public void topUp(int amount){
   if(this.status == 0){
     System.out.println("Ponsel mati. Tidak dapat melakukan top up");
   }
   else
   {
     this.balance += amount; // add the amount to the balance
     System.out.println("Top up berhasil.");
   }
}
public void CekPulsa(){
  if(this.status == 0){
    System.out.println("Ponsel mati. Tidak dapat melihat kontak");
  
  }
    else
  {
    System.out.println("Sisa pulsa anda : "+this.balance);
  }
  
}
public int getBalance(){
   if(this.status == 0){
     System.out.println("Ponsel mati. Tidak dapat melihat sisa pulsa");
     return -1; // return a negative value to indicate an error
   }
   else
   {
     return this.balance; // return the balance
   }
}

public void addContact(String nama, String nomor){
   if(this.status == 0){
     System.out.println("Ponsel mati. Tidak dapat menambahkan kontak");
   }
   else
   {
     Contact c = new Contact(nama, nomor); // create a new Contact object
     this.contacts.add(c); // add it to the contacts list
     System.out.println("Kontak berhasil ditambahkan");
   }
}

public void viewContacts(){
   if(this.status == 0){
     System.out.println("Ponsel mati. Tidak dapat melihat kontak");
   }
   else
   {
     System.out.println("Daftar kontak:");
     for(Contact c : this.contacts){ // loop over each contact in the list
       System.out.println(c.getNama() + " - " + c.getNomor()); // print their name and number
     }
   }
}

public Contact findContact(String nama){
   if(this.status == 0){
     System.out.println("Ponsel mati. Tidak dapat mencari kontak");
     return null; // return null to indicate an error
   }
   else
   {
     for(Contact c : this.contacts){ // loop over each contact in the list
       if(c.getNama().equals(nama)){ // compare their name with the given name
         return c; // return the matching contact object
       }
     }
     return null; // return null if no match is found
   }
}
}
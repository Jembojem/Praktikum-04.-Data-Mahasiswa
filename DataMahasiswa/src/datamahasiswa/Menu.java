/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Collections;

/**
 *
 * @author User
 */
public class Menu {
    ArrayList<String> arrayNama = new ArrayList<>();
    ArrayList<String> arrayNim = new ArrayList<>();
    ArrayList<Integer> arrayKelamin = new ArrayList<>();
    ArrayList<Date> arrayLahir = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Scanner input = new Scanner(System.in);
    
    //Display
    void display(){
       boolean tamp = true;
       
       while(tamp){
           System.out.println("=================================");
           System.out.println("         Data Mahasiswa          ");
           System.out.println("================================= \n");
           System.out.println("1. Tambah Data");
           System.out.println("2. Hapus Data"); //Berdasar NIM Tertentu
           System.out.println("3. Cari Data"); //Berdasar gender, atau berdasar NIM
           System.out.println("4. Tampil Data \n"); //Menampilkan semua data mahasiswa+jumlah total mahasiswa yang terecord
           System.out.print("Pilih Menu : ");
           String menu = input.nextLine();

           switch (menu){
               case "1":
                   char ulang = 'y';
                   while(ulang=='y'){
                       System.out.println("==================================");
                       System.out.println("           Tambah Data            ");
                       System.out.println("================================== \n");

                       System.out.println("Masukkan data mahasiswa yang akan ditambahkan \n");
                       System.out.print("Nama : ");
                       String nama = input.nextLine();
                       System.out.print("NIM : ");
                       String nim = input.nextLine();
                       System.out.println("*Isi 0 jika jenis kelamin Laki-laki, isi 1 jika perempuan");
                       System.out.print("Jenis kelamin : ");
                       int kelamin = input.nextInt();
                       //Tanggal Lahir
                       System.out.println("Tanggal lahir (dd/mm/yyyy): ");
                       System.out.print("Tanggal : ");
                       int tanggal = input.nextInt();
                       System.out.print("Bulan : ");
                       int bulan = input.nextInt();
                       System.out.print("Tahun : ");
                       int tahun = input.nextInt();
                       Date lahir = new GregorianCalendar(tahun, bulan-1, tanggal).getTime();

                       arrayNama.add(nama);
                       arrayNim.add(nim);
                       arrayKelamin.add(kelamin);
                       arrayLahir.add(lahir);
                       System.out.println("Data telah berhasil ditambahkan");
                       System.out.print("Ingin menambah data lagi? (y/n): ");
                       ulang = input.next().charAt(0);
                   }
                   break;

               case "2":
                   System.out.println("==================================");
                   System.out.println("            Hapus Data            ");
                   System.out.println("================================== \n");
                   System.out.print("Masukkan NIM mahasiswa yang akan dihapus : ");
                   String nomers = input.next();
                   int index = Collections.binarySearch(arrayNim, nomers);
                   arrayNama.remove(index);
                   arrayNim.remove(index);
                   arrayKelamin.remove(index);
                   arrayLahir.remove(index);
                   System.out.println("Data telah berhasil dihapus");
                   break;

               case "3":
                   System.out.println("===================================");
                   System.out.println("             Cari Data             ");
                   System.out.println("=================================== \n");
                   System.out.println("Cari data dapat dilakukan berdasarkan :");
                   System.out.println("1. Gender");
                   System.out.println("2. NIM");
                   System.out.print("Masukkan pilihan anda :");
                   int pil = input.nextInt();
                   
                   if (pil==1){
                       System.out.print("Pilih Gender (0 / 1): ");
                       int gender = input.nextInt();
                       for(int n=0; n<arrayNama.size(); n++){
                           SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
                           if (arrayKelamin.get(n)==0){
                               System.out.println("Nama Mahasiswa : "+arrayNama.get(n));
                               System.out.println("NIM : "+arrayNim.get(n));
                               System.out.println("Tanggal Lahir : "+format.format(arrayLahir.get(n)));
                               System.out.println("Jenis Kelamin : "+arrayKelamin.get(n)+"\n");
                           }else if (arrayKelamin.get(n)==1){
                               System.out.println("Nama Mahasiswa : "+arrayNama.get(n));
                               System.out.println("NIM : "+arrayNim.get(n));
                               System.out.println("Tanggal Lahir : "+format.format(arrayLahir.get(n)));
                               System.out.println("Jenis Kelamin : "+arrayKelamin.get(n)+"\n");
                           }   
                       }
                   }else if(pil==2){
                       SimpleDateFormat format= new SimpleDateFormat("dd MMMM yyyy");
                       System.out.println("Masukkan NIM : ");
                       String nomor = input.next();
                       int indek = Collections.binarySearch(arrayNim, nomor);
                           String findName = arrayNama.get(indek);
                           String findNim = arrayNim.get(indek);
                           Date findDate = arrayLahir.get(indek);
                           int findGender = arrayKelamin.get(indek);

                           System.out.println("Nama Mahasiswa : "+findName);
                           System.out.println("NIM : "+findNim);
                           System.out.println("Tanggal Lahir : "+format.format(findDate));
                           System.out.println("Jenis Kelamin : "+findGender);
                   }            
               break;

               case "4":
                   System.out.println("===================================");
                   System.out.println("            Tampil Data            ");
                   System.out.println("=================================== \n");
                   for( int n = 0; n < arrayNama.size(); n++){
                       SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
                       System.out.println("Nama : "+arrayNama.get(n));
                       System.out.println("NIM : "+arrayNim.get(n));
                       System.out.println("Tanggal lahir : "+format.format(arrayLahir.get(n)));
                       System.out.println("Jenis kelamin : "+arrayKelamin.get(n));
                       System.out.println("Jumlah mahasiswa : "+arrayNama.size());
                   }
                   break;

               default:
                   System.out.println("Menu yang anda pilih tidak ada");
           }
       }
    }
}

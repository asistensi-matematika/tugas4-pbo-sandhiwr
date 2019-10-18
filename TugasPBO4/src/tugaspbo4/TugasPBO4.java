/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspbo4;



/**
 *
 * @author USER
 */
import java.util.Scanner;
public class TugasPBO4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        BangunDatar A = new BangunDatar();
        A.view();
        System.out.print("1. Persegi \n2. Lingkaran \n3. Segitiga \n\nMasukkan Pilihan : ");
        int pilihan= input.nextInt();
                switch(pilihan){
            case 1:        
                Persegi ABCD = new Persegi();
                System.out.print("\nMasukkan Sisi = ");
                double Sisi = input.nextDouble();
                ABCD.setSisi(Sisi);
                ABCD.view();
                break;
        
             case 2:
                 Lingkaran bundar = new Lingkaran();
                 System.out.print("\nMasukkan Jari-Jari = ");
                 double Radius = input.nextDouble();
                 bundar.setRadius(Radius);
                  bundar.view();
                break;
                 
             case 3:
                 System.out.print("\nMasukkan Segitiga yang Anda Inginkan : \n1. Segitiga Siku-Siku \n2. Segitiga Sama Sisi \n\nMasukkan Pilihan : ");
                 int inginkan = input.nextInt();
                 
                 switch(inginkan){
                     case 1:
                          Segitiga ABC = new Segitiga();
                         System.out.print("\nMasukkan Alas = ");
                         double Alas = input.nextDouble();
                         ABC.setAlas(Alas);
                         System.out.print("Masukkan Tinggi = ");
                         double Tinggi = input.nextDouble();
                          ABC.setTinggi(Tinggi);
                         ABC.view();
                         JenisSegitiga siku = new JenisSegitiga();
                         siku.view(Alas, Tinggi);
                         break;
                 
                     case 2:
                         Segitiga HIJ = new Segitiga();
                         System.out.print("\nMasukkan Alas = ");
                         double Alass = input.nextDouble();
                         HIJ.setAlas(Alass);
                         System.out.print("Masukkan Tinggi = ");
                         double Tinggii = input.nextDouble();
                         HIJ.setTinggi(Tinggii);
                         HIJ.view();
                         JenisSegitiga sisi = new JenisSegitiga();
                         sisi.view(Alass);
                         break;
                 }
                }
    }
    }

class BangunDatar {
    protected String jenis;
    
    public void view(){
        System.out.println("Pilih Bangun Datar yang Diinginkan : ");
    }
}

class Persegi extends BangunDatar {
    protected double sisi;
    
    public Persegi(){
        sisi = 0;
    }
    
    public Persegi(double sisi){
        this.sisi = sisi;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }
    
    public double Luas(double sisi){
        return sisi*sisi;
    }
    
    public double Keliling(double sisi){
        return 4*sisi;
    }
    
    @Override
    public void view(){
        System.out.println("Nama Bangun Datar Adalah Persegi");
        System.out.println("Luas Persegi = "+Luas(sisi)+"cm^2");
        System.out.println("Keliling Persegi = "+Keliling(sisi)+"cm");
    }
}

class Lingkaran extends BangunDatar {
    protected double radius;
    
    public Lingkaran(){
        radius = 0;
    }
    
    public Lingkaran(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double Luas(double radius){
        return Math.PI*radius*radius;
    }
    
    public double Keliling(){
        return Math.PI*2*radius;
    }
    
    @Override
    public void view(){
        System.out.println("Nama Bangun Datar Adalah Lingkaran");
        System.out.println("Luas Lingkaran = "+Luas(radius)+"cm^2");
        System.out.println("Keliling Lingkaran = "+Keliling()+"cm");
    }
}

class Segitiga extends BangunDatar{
    protected double alas;
    protected double tinggi;
    
    public Segitiga(){
        alas = 0;
        tinggi = 0;
    }
    
    public Segitiga(double alas, double tinggi){
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    
    public double Luas(double alas, double tinggi){
        return (alas*tinggi)/2;
    }
    
    @Override
    public void view(){
        System.out.println("Nama Bangun Datar Adalah Segitiga");
        System.out.println("Luas Segitiga = "+Luas(alas, tinggi)+"cm^2");
    }
}

class JenisSegitiga extends Segitiga {
    
    public double sisimiring(double alas, double tinggi){
        return Math.sqrt(Math.pow(alas, 2)+Math.pow(tinggi, 2));
    }
    
    public double Keliling(double alas, double tinggi){
        return alas+tinggi+sisimiring(alas, tinggi);
    }
    
    public double Keliling(double k){
            return 3*k;
}
    
    public void view(double k){
        System.out.println("Jenis Segitiga Adalah Sama Sisi");
        System.out.println("Keliling Segitiga = "+Keliling(k)+"cm");
    }
    
    public void view(double alas, double tinggi){
        System.out.println("Jenis Segitiga Adalah Siku-Siku");
        System.out.println("Keliling Segitiga = "+Keliling(alas, tinggi)+"cm");
    }
}
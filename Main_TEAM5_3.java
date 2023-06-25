import java.util.Scanner;


public class Main {
  static Object[][] foods = {
    {"Nasi Goreng Spesial        ", 9999.99},
    {"Ayam Bakar Spesial         ", 12345.67},
    {"Steak Sirloin Spesial      ", 21108.40},
    {"Kwetiaw Siram Spesial      ", 13579.13},
    {"Kambing Guling Spesial     ", 98765.43},
  };

  static String devider = "========================";

  static double total_nasgor, total_ayam, total_steak, total_kwetiaw,
    total_kambing, harga_kotor, harga_disc, harga_bersih, harga_setiap_orang;

  static double disc = 0.1;

  static int person;


  public static void main (String[]args)
  {

    // variable
    int qty_nasgor, qty_ayam, qty_steak, qty_kwetiaw, qty_kambing;

    String pemesan;

    // Init 
    Scanner sc = new Scanner (System.in);

    // Catat pemesan
    println ("Selamat Siang...");

    print ("Pesan untuk berapa orang : ");

    person = sc.nextInt ();

    sc.nextLine ();
    print ("Pesanan atas nama        : ");
    pemesan = sc.nextLine ();


    // Menampilkan menu
    println ();
    println ("Menu Spesial hari ini");

    println (devider);
    showMenu ();
    println ();


    // Isi pesanan 
    println ("Pesanan Anda [batas pesanan 0-10 porsi per menu]");

    print ("1. Nasi Goreng Spesial     = ");
    qty_nasgor = sc.nextInt ();
    print ("2. Ayam Bakar Spesial      = ");
    qty_ayam = sc.nextInt ();
    print ("3. Steak Sirloin Spesial   = ");
    qty_steak = sc.nextInt ();
    print ("4. Kwetiaw Siram Spesial   = ");
    qty_kwetiaw = sc.nextInt ();
    print ("5. Kambing Guling Spesial  = ");
    qty_kambing = sc.nextInt ();
    
    println ();
    println ();


    // Result 
    println ("Selamat menikmati makanan anda...");
    println ();
    println ("Pembelian : ");

    total_nasgor = countOrder(qty_nasgor, 9999.99);
    total_ayam = countOrder(qty_ayam, 12345.67);
    total_steak = countOrder(qty_steak, 21108.40);
    total_kwetiaw = countOrder(qty_kwetiaw, 13579.13);
    total_kambing = countOrder(qty_kambing, 98765.43);

    println ("1. Nasi Goreng Spesial          " + qty_nasgor +
	     " porsi * Rp. 9999.99      = Rp." + String.format ("%.2f",
							     total_nasgor));

    println ("2. Ayam Bakar Spesial           " + qty_ayam +
	     " porsi * Rp. 12345.67     = Rp." + String.format ("%.2f",
							      total_ayam));

    println ("3. Steak Sirloin Spesial        " + qty_steak +
	     " porsi * Rp. 21108.40     = Rp." + String.format ("%.2f",
							      total_steak));

    println ("4. Kwetiaw Siram Spesial        " + qty_kwetiaw +
	     " porsi * Rp. 13579.13     = Rp." + String.format ("%.2f",
							      total_kwetiaw));

    println ("5. Kambing Guling Spesial       " + qty_kambing +
	     " porsi * Rp. 98765.43     = Rp." + String.format ("%.2f",
							      total_kambing));

    println (devider + devider + devider + devider);

    harga_kotor = countTotal();
    harga_disc = countDiscount(harga_kotor);

    println ("Total Pembelian                                   = Rp. " + String.format ("%.2f", harga_kotor));
    println ("Disc 10% <masa promosi>                           = Rp. " + String.format ("%.2f", harga_disc) + " -");
    println (devider + devider + devider + devider);
    harga_bersih = harga_kotor - harga_disc;
    println ("Total pembelian setelah disc 10%                  = Rp. " + String.format ("%.2f", harga_bersih));
    harga_setiap_orang = countPricePerPerson(harga_bersih);

    println ();
    println ("Pembelian per orang < untuk " + person + " orang >= Rp. " + String.format ("%.2f", harga_setiap_orang));
    println("                                Terima kasih atas kunjungan anda...");
    println("                                ...tekan ENTER untuk keluar...");

    exit ();
  }
  
  public static void print (String msg)
  {
    System.out.print (msg);
  }

  public static void println (String msg)
  {
    System.out.println (msg);
  }

  public static void println ()
  {
    System.out.println ();
  }

  public static void showMenu ()
  {
      int i = 1;
      for (Object[]food:foods) {
          println (i + ". " + food[0] + "@ Rp. " + food[1]);
          i++;
      }
  }


  public static void exit ()
  {
    try{
      System.in.read ();
    } catch (Exception e) {
        
    }
  }

  public static double countPricePerPerson(double net_price)
  {
    return net_price / person;
  }

  public static double countOrder (int qty, double price)
  {
    return (double) qty * price;
  }

  public static double countDiscount (double gross_price)
  {
    return gross_price * disc;
  }


  public static double countTotal ()
  {
    return total_nasgor + total_ayam + total_steak + total_kwetiaw +
      total_kambing;
  }
}

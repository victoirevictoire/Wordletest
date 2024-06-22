//import du Scanner pour l'entrée utilisateur
import java.util.Scanner;
public class Lettre {
 //declaration des attributs
 private String let; //une lettre comporte une lettre...
 private int rang;//...et un rang (véritable ou supposé)
 public static int compteur_verif=1 ; //permet de savoir quelle lettre doit être vérifiée
 //initialisé à 1 pour la première lettre de l'essai 1
  //Introduction des couleurs
 public static final String ANSI_RESET = "\u001b[36;1m";
 public static final String ANSI_RED = "\u001b[31;1m";
 public static final String ANSI_BLACK = "\u001b[30;1m";
 public static final String ANSI_GREEN = "\u001b[32;1m";
 //couleurs
 private static String couleur1="" ;
 private static String couleur2="" ;
 private static String couleur3="";
 private static String couleur4="";
 private static String couleur5="";
 //constructeurs
public Lettre(String let, int rang){
 this.setLet(let);
 this.setRang(rang);
}
public Lettre(char let, int rang) {
 this.setLet(Character.toString(let));;
   this.setRang(rang);
 }
//Fonction de construction du tableau
public static Lettre[] tab(Lettre L1, Lettre L2, Lettre L3, Lettre L4, Lettre L5) {
 Lettre[] tab = new Lettre[5];
 tab[0]=L1;
 tab[1]=L2;
 tab[2]=L3;
 tab[3]=L4;
 tab[4]=L5;
 return tab;	
}//c est un tableau qui contient le vrai mot
//Fonction estPresent - appel quelconque (Lut, vrai tab)
public boolean estPresent(Lettre L, Lettre[] vraitab) {
   for (int i = 0; i < vraitab.length; i++) {
     if (vraitab[i].let.equals(L.let)) {
       return true; //true si la valeur de la lettre existe bien
     }
   }
   return false ;
 }
//Vérification - impression des lettres
public void verif(Lettre L, Lettre[] tab) { //vraitab et Lut1 en argument ; appel avec la vraie lettre
//Lettre 1
if (compteur_verif==1) {
 if (!L.estPresent(L, tab)) { // On voit si la lettre est présente
   couleur1="gris"; // gris si n'est pas présente
 }else {
	  if (L.getLet().equals(tab[0].getLet())) { // On voit si la lettre est présente mais à la mauvaise place
   couleur1="vert";
	  } else {
   couleur1="rouge"; // gris si même pas présente
 }
}
}
//Lettre 2
if (compteur_verif==2) {
	  if (!L.estPresent(L, tab)) { // On voit si la lettre est presente 
	    couleur2="gris"; // gris si n'est pas présente
	  }else {
		  if (L.getLet().equals(tab[1].getLet())) { // On voit si la lettre est présente mais à la mauvaise place
	    couleur2="vert";
		  } else {
	    couleur2="rouge"; // gris si même pas présente
	  }
	}
	}
//Lettre 3
if (compteur_verif==3) {
	  if (!L.estPresent(L, tab)) { // On voit si la lettre est presente
	    couleur3="gris"; // gris si n est pas présente
	  }else {
		  if (L.getLet().equals(tab[2].getLet())) { // On voit si la lettre est présente mais à la mauvaise place
	    couleur3="vert";
		  } else {
	    couleur3="rouge"; // gris si même pas présente
	  }
	}
	}
//Lettre 4
if (compteur_verif==4) {
	  if (!L.estPresent(L, tab)) { // On voit si la lettre est presente
	    couleur4="gris"; // gris si n'est pas presente 
	  }else {
		  if (L.getLet().equals(tab[3].getLet())) { // On voit si la lettre est présente mais a la mauvaise place
	    couleur4="vert";
		  } else {
	    couleur4="rouge"; // gris si même pas presente
	  }
	}
	}
//Lettre 5
if (compteur_verif==5) {
	  if (!L.estPresent(L, tab)) { // On voit si la lettre est présente
	    couleur5="gris"; // gris si n'est pas présente
	  }else {
		  if (L.getLet().equals(tab[4].getLet())) { // On voit si la lettre est présente mais à la mauvaise place
	    couleur5="vert";
		  } else {
	    couleur5="rouge"; // gris si même pas présente
	  }
	}
	}
}
//toString
public String toString() {
 return this.let;
}
//MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN-MAIN
 public static void main(String[] args) {
   Lettre L1 = new Lettre("a",1); //1ere lettre du vrai mot
   Lettre L2 = new Lettre("p",2); //2eme lettre du vrai mot
   Lettre L3 = new Lettre("p",3);
   Lettre L4 = new Lettre("e",4);
   Lettre L5 = new Lettre("l",5);
   Lettre[] vraitab = Lettre.tab(L1,L2,L3,L4,L5);
   //***ESSAI 1***
   Scanner keyboard = new Scanner(System.in);
   System.out.println("Entrez le premier essai");
   String essai1 = keyboard.nextLine();
   if (essai1.length() != 5) {
     System.out.println("Veuillez entrer cinq lettres.");
     return;
   }
   Lettre Lut1 = new Lettre(essai1.charAt(0),1);
   Lettre Lut2 = new Lettre(essai1.charAt(1),2);
   Lettre Lut3 = new Lettre(essai1.charAt(2),3);
   Lettre Lut4 = new Lettre(essai1.charAt(3),4);
   Lettre Lut5 = new Lettre(essai1.charAt(4),5);
   //verif - sortie lettre 1
   vraitab[0].verif(Lut1,vraitab);
   compteur_verif++;
   if (Lettre.couleur1.equals("vert")) {
     System.out.println(ANSI_GREEN + Lut1.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur1.equals("rouge")) {
     System.out.println(ANSI_RED + Lut1.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur1.equals("gris")) {
     System.out.println(ANSI_BLACK + Lut1.toString() + ANSI_RESET);
   }	
   //verif - sortie lettre 2
   vraitab[1].verif(Lut2,vraitab);
   compteur_verif++;
   if (Lettre.couleur2.equals("vert")) {
     System.out.println(ANSI_GREEN + Lut2.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur2.equals("rouge")) {
     System.out.println(ANSI_RED + Lut2.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur2.equals("gris")) {
     System.out.println(ANSI_BLACK + Lut2.toString() + ANSI_RESET);
   }
 //verif - sortie lettre 3
   vraitab[2].verif(Lut3,vraitab);
   compteur_verif++;
   if (Lettre.couleur3.equals("vert")) {
     System.out.println(ANSI_GREEN + Lut3.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur3.equals("rouge")) {
     System.out.println(ANSI_RED + Lut3.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur3.equals("gris")) {
     System.out.println(ANSI_BLACK + Lut3.toString() + ANSI_RESET);
   }
  
 //verif - sortie lettre 4
   vraitab[3].verif(Lut4,vraitab);
   compteur_verif++;
   if (Lettre.couleur4.equals("vert")) {
     System.out.println(ANSI_GREEN + Lut4.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur4.equals("rouge")) {
     System.out.println(ANSI_RED + Lut4.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur4.equals("gris")) {
     System.out.println(ANSI_BLACK + Lut4.toString() + ANSI_RESET);
   }
  
 //verif - sortie lettre 5
   vraitab[4].verif(Lut5,vraitab);
   compteur_verif++;
   if (Lettre.couleur5.equals("vert")) {
     System.out.println(ANSI_GREEN + Lut5.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur5.equals("rouge")) {
     System.out.println(ANSI_RED + Lut5.toString() + ANSI_RESET);
   }
   else if (Lettre.couleur5.equals("gris")) {
     System.out.println(ANSI_BLACK + Lut5.toString() + ANSI_RESET);
   }
  
 //***ESSAI 2***
 System.out.println("Second essai");
 String essai2 = keyboard.nextLine();
 if (essai2.length() != 5) {
   System.out.println("Veuillez entrer cinq lettres.");
   keyboard.close();
   return;
 }
 Lut1.setLet(Character.toString(essai2.charAt(0)));
 Lut2.setLet(Character.toString(essai2.charAt(1)));
 Lut3.setLet(Character.toString(essai2.charAt(2)));
 Lut4.setLet(Character.toString(essai2.charAt(3)));
 Lut5.setLet(Character.toString(essai2.charAt(4)));
  //verif - sortie lettre 1
 compteur_verif=1;
 vraitab[0].verif(Lut1,vraitab);
 compteur_verif++;
 if (Lettre.couleur1.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("rouge")) {
   System.out.println(ANSI_RED + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut1.toString() + ANSI_RESET);
 }	
  //verif - sortie lettre 2
 vraitab[1].verif(Lut2,vraitab);
 compteur_verif++;
 if (Lettre.couleur2.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("rouge")) {
   System.out.println(ANSI_RED + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut2.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 3
 vraitab[2].verif(Lut3,vraitab);
 compteur_verif++;
 if (Lettre.couleur3.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("rouge")) {
   System.out.println(ANSI_RED + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut3.toString() + ANSI_RESET);
 }
 
//verif - sortie lettre 4
 vraitab[3].verif(Lut4,vraitab);
 compteur_verif++;
 if (Lettre.couleur4.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("rouge")) {
   System.out.println(ANSI_RED + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut4.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 5
 vraitab[4].verif(Lut5,vraitab);
 if (Lettre.couleur5.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("rouge")) {
   System.out.println(ANSI_RED + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut5.toString() + ANSI_RESET);
 }
 //***ESSAI 3***
 System.out.println("Troisième essai");
 String essai3 = keyboard.nextLine();
 if (essai3.length() != 5) {
   System.out.println("Veuillez entrer cinq lettres.");
   keyboard.close();
   return;
 }
 Lut1.setLet(Character.toString(essai3.charAt(0)));
 Lut2.setLet(Character.toString(essai3.charAt(1)));
 Lut3.setLet(Character.toString(essai3.charAt(2)));
 Lut4.setLet(Character.toString(essai3.charAt(3)));
 Lut5.setLet(Character.toString(essai3.charAt(4)));
  //verif - sortie lettre 1
 compteur_verif=1;
 vraitab[0].verif(Lut1,vraitab);
 compteur_verif++;
 if (Lettre.couleur1.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("rouge")) {
   System.out.println(ANSI_RED + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut1.toString() + ANSI_RESET);
 }	
  //verif - sortie lettre 2
 vraitab[1].verif(Lut2,vraitab);
 compteur_verif++;
 if (Lettre.couleur2.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("rouge")) {
   System.out.println(ANSI_RED + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut2.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 3
 vraitab[2].verif(Lut3,vraitab);
 compteur_verif++;
 if (Lettre.couleur3.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("rouge")) {
   System.out.println(ANSI_RED + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut3.toString() + ANSI_RESET);
 }
 
//verif - sortie lettre 4
 vraitab[3].verif(Lut4,vraitab);
 compteur_verif++;
 if (Lettre.couleur4.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("rouge")) {
   System.out.println(ANSI_RED + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut4.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 5
 vraitab[4].verif(Lut5,vraitab);
 if (Lettre.couleur5.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("rouge")) {
   System.out.println(ANSI_RED + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut5.toString() + ANSI_RESET);
 }
 
 
//***ESSAI 4***
 System.out.println("Quatrième essai");
 String essai4 = keyboard.nextLine();
 if (essai3.length() != 5) {
   System.out.println("Veuillez entrer cinq lettres.");
   keyboard.close();
   return;
 }
 Lut1.setLet(Character.toString(essai4.charAt(0)));
 Lut2.setLet(Character.toString(essai4.charAt(1)));
 Lut3.setLet(Character.toString(essai4.charAt(2)));
 Lut4.setLet(Character.toString(essai4.charAt(3)));
 Lut5.setLet(Character.toString(essai4.charAt(4)));
  //verif - sortie lettre 1
 compteur_verif=1;
 vraitab[0].verif(Lut1,vraitab);
 compteur_verif++;
 if (Lettre.couleur1.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("rouge")) {
   System.out.println(ANSI_RED + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut1.toString() + ANSI_RESET);
 }	
  //verif - sortie lettre 2
 vraitab[1].verif(Lut2,vraitab);
 compteur_verif++;
 if (Lettre.couleur2.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("rouge")) {
   System.out.println(ANSI_RED + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut2.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 3
 vraitab[2].verif(Lut3,vraitab);
 compteur_verif++;
 if (Lettre.couleur3.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("rouge")) {
   System.out.println(ANSI_RED + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut3.toString() + ANSI_RESET);
 }
 
//verif - sortie lettre 4
 vraitab[3].verif(Lut4,vraitab);
 compteur_verif++;
 if (Lettre.couleur4.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("rouge")) {
   System.out.println(ANSI_RED + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut4.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 5
 vraitab[4].verif(Lut5,vraitab);
 if (Lettre.couleur5.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("rouge")) {
   System.out.println(ANSI_RED + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut5.toString() + ANSI_RESET);
 }
 //***ESSAI 5***
 System.out.println("Cinquième essai");
 String essai5 = keyboard.nextLine();
 if (essai3.length() != 5) {
   System.out.println("Veuillez entrer cinq lettres.");
   keyboard.close();
   return;
 }
 Lut1.setLet(Character.toString(essai5.charAt(0)));
 Lut2.setLet(Character.toString(essai5.charAt(1)));
 Lut3.setLet(Character.toString(essai5.charAt(2)));
 Lut4.setLet(Character.toString(essai5.charAt(3)));
 Lut5.setLet(Character.toString(essai5.charAt(4)));
  //verif - sortie lettre 1
 compteur_verif=1;
 vraitab[0].verif(Lut1,vraitab);
 compteur_verif++;
 if (Lettre.couleur1.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("rouge")) {
   System.out.println(ANSI_RED + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut1.toString() + ANSI_RESET);
 }	
  //verif - sortie lettre 2
 vraitab[1].verif(Lut2,vraitab);
 compteur_verif++;
 if (Lettre.couleur2.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("rouge")) {
   System.out.println(ANSI_RED + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut2.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 3
 vraitab[2].verif(Lut3,vraitab);
 compteur_verif++;
 if (Lettre.couleur3.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("rouge")) {
   System.out.println(ANSI_RED + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut3.toString() + ANSI_RESET);
 }
 
//verif - sortie lettre 4
 vraitab[3].verif(Lut4,vraitab);
 compteur_verif++;
 if (Lettre.couleur4.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("rouge")) {
   System.out.println(ANSI_RED + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut4.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 5
 vraitab[4].verif(Lut5,vraitab);
 if (Lettre.couleur5.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("rouge")) {
   System.out.println(ANSI_RED + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut5.toString() + ANSI_RESET);
 }
 
//***ESSAI 6***
 System.out.println("!!! Dernier essai !!!");
 String essai6 = keyboard.nextLine();
 if (essai3.length() != 5) {
   System.out.println("Veuillez entrer cinq lettres.");
   keyboard.close();
   return;
 }
 Lut1.setLet(Character.toString(essai6.charAt(0)));
 Lut2.setLet(Character.toString(essai6.charAt(1)));
 Lut3.setLet(Character.toString(essai6.charAt(2)));
 Lut4.setLet(Character.toString(essai6.charAt(3)));
 Lut5.setLet(Character.toString(essai6.charAt(4)));
  //verif - sortie lettre 1
 compteur_verif=1;
 vraitab[0].verif(Lut1,vraitab);
 compteur_verif++;
 if (Lettre.couleur1.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("rouge")) {
   System.out.println(ANSI_RED + Lut1.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur1.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut1.toString() + ANSI_RESET);
 }	
  //verif - sortie lettre 2
 vraitab[1].verif(Lut2,vraitab);
 compteur_verif++;
 if (Lettre.couleur2.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("rouge")) {
   System.out.println(ANSI_RED + Lut2.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur2.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut2.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 3
 vraitab[2].verif(Lut3,vraitab);
 compteur_verif++;
 if (Lettre.couleur3.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("rouge")) {
   System.out.println(ANSI_RED + Lut3.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur3.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut3.toString() + ANSI_RESET);
 }
 
//verif - sortie lettre 4
 vraitab[3].verif(Lut4,vraitab);
 compteur_verif++;
 if (Lettre.couleur4.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("rouge")) {
   System.out.println(ANSI_RED + Lut4.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur4.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut4.toString() + ANSI_RESET);
 }
 //verif - sortie lettre 5
 vraitab[4].verif(Lut5,vraitab);
 if (Lettre.couleur5.equals("vert")) {
   System.out.println(ANSI_GREEN + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("rouge")) {
   System.out.println(ANSI_RED + Lut5.toString() + ANSI_RESET);
 }
 else if (Lettre.couleur5.equals("gris")) {
   System.out.println(ANSI_BLACK + Lut5.toString() + ANSI_RESET);
 }
  keyboard.close();
 }//fin du main
 //Setters et getters
 public int getRang() {
   return this.rang;
 }
 public void setRang(int rang) {
   this.rang = rang;
 }
 public String getLet() {
   return this.let;
 }
 public void setLet(String let) {
   this.let = let;
 }
}


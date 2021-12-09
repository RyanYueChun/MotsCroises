package ryanYueChun.tp1;

public class PointEntree {

	public static void main(String[] args) {
		int hauteur = 7;
		int largeur = 9;
		Grille grille = new Grille(hauteur, largeur);

		grille.setCellule(1, 1, "aa");
		grille.setCellule(1, 9, "bb");
		grille.setCellule(7, 1, "cc");
		grille.setCellule(7, 9, "dd");
		
		System.out.println("4 coins : " + grille.getCellule(1, 1) + " /"
				 + grille.getCellule(1, 9) + " /"
				 + grille.getCellule(7, 1) + " /"
				 + grille.getCellule(7, 9)
				 );
		System.out.println(grille.toString());
	}

}

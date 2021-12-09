package ryanYueChun.tp2;

public class PointEntree {

	public static void main(String[] args) {
		int hauteur = 7;
		int largeur = 9;
		Grille<String> grille = new Grille<>(hauteur, largeur);

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
		
		System.out.println("---------------------");
		
		Grille<String> maGrille = new Grille<String>(3,5);
		
		for (int l=1; l<=maGrille.getHauteur(); l++)
		{
			String texteLigne = Integer.toString(l);
			for (int c=1; c<=maGrille.getLargeur(); c++)
			{
				maGrille.setCellule
				(l, c, texteLigne + ',' + Integer.toString(c));
			}
		}
		System.out.println(maGrille) ;
	}
	

}

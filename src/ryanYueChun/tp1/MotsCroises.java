package ryanYueChun.tp1;

public class MotsCroises {
	private Grille solution;
	private Grille proposition;
	private Grille definitionHorizontal;
	private Grille definitionVerticale;
	
	public MotsCroises (int hauteur, int largeur) {
		solution = new Grille(hauteur, largeur);
		proposition = new Grille(hauteur, largeur);
		definitionHorizontal = new Grille(hauteur, largeur);
		definitionVerticale = new Grille(hauteur, largeur);
	}
	
//	private class GilleNoircissable {
//		public Grille grille;
//		
//		public GilleNoircissable(int lignes, int colonnes) {
//			this.grille = new Grille(lignes, colonnes);
//		}
//		
//		public void setCelluleVerifiee(int ligne, int colonne, String chaine) {
//			if (!estCaseNoire(ligne, colonne)) {
//				grille.setCellule(ligne, colonne, chaine);
//			} else {
//				throw new AssertionError(messageMauvaisCoordonnees("noire."));
//			}
//		}
//		
//		public String getCelluleVerifiee(int ligne, int colonne) {
//			if (!estCaseNoire(ligne, colonne)) {
//				return grille.getCellule(ligne, colonne);
//			} else {
//				throw new AssertionError(messageMauvaisCoordonnees("noire."));
//			}
//		}
//	}
	
	private static final String messageMauvaisCoordonnees (String elementRecherchee) {
		return "Cette case est " + elementRecherchee;
	}
	
	public int getHauteur() {
		return solution.getHauteur();
	}
	
	public int getLargeur() {
		return solution.getLargeur();
	}
	
	public boolean coordonneesEstDansGrille(int ligne, int colonne) {
		return solution.coordonneesEstDansGrille(ligne, colonne);
	}
	
	public boolean estCaseNoire(int ligne, int colonne) {
		return solution.getCellule(ligne, colonne) == null;
	}
	
	public boolean coordonneesEstRemplissable(int ligne, int colonne) {
		return coordonneesEstDansGrille(ligne, colonne) && !estCaseNoire(ligne, colonne);
	}
	
	public void setCaseNoire(int ligne, int colonne, boolean noire) {
		if (coordonneesEstDansGrille(ligne, colonne) && noire) {
			solution.setCellule(ligne, colonne, null);
		} else {
			solution.setCellule(ligne, colonne, "");
		}
	}
	
	public char getSolution(int ligne, int colonne) {
		Character solutionCellule = null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			solutionCellule = solution.getCellule(ligne, colonne).toCharArray()[0];
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return solutionCellule;
	}
	
	public void setSolution(int ligne, int colonne, char solutionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			solution.setCellule(ligne, colonne, String.valueOf(solutionCellule));
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}
	
	public char getProposition(int ligne, int colonne) {
		Character propositionCellule =  null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			propositionCellule = proposition.getCellule(ligne, colonne).toCharArray()[0];
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return propositionCellule;
	}
	
	public void setProposition(int ligne, int colonne, char propositionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			proposition.setCellule(ligne, colonne, String.valueOf(propositionCellule));
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}
	
	public String getDefinition(int ligne, int colonne, boolean horizontal) {
		String definition = null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			if (horizontal) {
				definition = definitionHorizontal.getCellule(ligne, colonne);
			} else {
				definition = definitionVerticale.getCellule(ligne, colonne);
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return definition;
	}
	
	public void setDefinition(int ligne, int colonne, boolean horizontal, String nouvelleDefinition) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			if (horizontal) {
				definitionHorizontal.setCellule(ligne, colonne, nouvelleDefinition);
			} else {
				definitionVerticale.setCellule(ligne, colonne, nouvelleDefinition);
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}

}

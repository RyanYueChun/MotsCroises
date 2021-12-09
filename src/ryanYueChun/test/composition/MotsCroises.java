package ryanYueChun.test.composition;

public class MotsCroises {
	private GilleNoircissable solution;
	private GilleNoircissable proposition;
	private GilleNoircissable definitionHorizontal;
	private GilleNoircissable definitionVerticale;
	
	public MotsCroises (int hauteur, int largeur) {
		solution = new GilleNoircissable(hauteur, largeur);
		proposition = new GilleNoircissable(hauteur, largeur);
		definitionHorizontal = new GilleNoircissable(hauteur, largeur);
		definitionVerticale = new GilleNoircissable(hauteur, largeur);
	}
	
	private class GilleNoircissable {
		public Grille grille;
		
		public GilleNoircissable(int lignes, int colonnes) {
			this.grille = new Grille(lignes, colonnes);
		}
		
		public void setCelluleVerifiee(int ligne, int colonne, String chaine) {
			if (!estCaseNoire(ligne, colonne)) {
				grille.setCellule(ligne, colonne, chaine);
			} else {
				throw new AssertionError(messageMauvaisCoordonnees("noire."));
			}
		}
		
		public String getCelluleVerifiee(int ligne, int colonne) {
			if (!estCaseNoire(ligne, colonne)) {
				return grille.getCellule(ligne, colonne);
			} else {
				throw new AssertionError(messageMauvaisCoordonnees("noire."));
			}
		}
	}
	
	private static final String messageMauvaisCoordonnees (String elementRecherchee) {
		return "Cette case est " + elementRecherchee;
	}
	
	public int getHauteur() {
		return solution.grille.getHauteur();
	}
	
	public int getLargeur() {
		return solution.grille.getLargeur();
	}
	
	public boolean coordonneesEstDansGrille(int ligne, int colonne) {
		return solution.grille.coordonneesEstDansGrille(ligne, colonne);
	}
	
	public boolean estCaseNoire(int ligne, int colonne) {
		return solution.grille.getCellule(ligne, colonne) == null;
	}
	
	public boolean coordonneesEstRemplissable(int ligne, int colonne) {
		return coordonneesEstDansGrille(ligne, colonne) && !estCaseNoire(ligne, colonne);
	}
	
	public void setCaseNoire(int ligne, int colonne, boolean noire) {
		if (coordonneesEstDansGrille(ligne, colonne) && noire) {
			solution.setCelluleVerifiee(ligne, colonne, null);
		} else {
			solution.setCelluleVerifiee(ligne, colonne, "");
		}
	}
	
	public char getSolution(int ligne, int colonne) {
		Character solutionCellule = null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			solutionCellule = solution.getCelluleVerifiee(ligne, colonne).toCharArray()[0];
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return solutionCellule;
	}
	
	public void setSolution(int ligne, int colonne, char solutionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			solution.setCelluleVerifiee(ligne, colonne, String.valueOf(solutionCellule));
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}
	
	public char getProposition(int ligne, int colonne) {
		Character propositionCellule =  null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			propositionCellule = proposition.getCelluleVerifiee(ligne, colonne).toCharArray()[0];
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return propositionCellule;
	}
	
	public void setProposition(int ligne, int colonne, char propositionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			proposition.setCelluleVerifiee(ligne, colonne, String.valueOf(propositionCellule));
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}
	
	public String getDefinition(int ligne, int colonne, boolean horizontal) {
		String definition = null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			if (horizontal) {
				definition = definitionHorizontal.getCelluleVerifiee(ligne, colonne);
			} else {
				definition = definitionVerticale.getCelluleVerifiee(ligne, colonne);
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return definition;
	}
	
	public void setDefinition(int ligne, int colonne, boolean horizontal, String nouvelleDefinition) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			if (horizontal) {
				definitionHorizontal.setCelluleVerifiee(ligne, colonne, nouvelleDefinition);
			} else {
				definitionVerticale.setCelluleVerifiee(ligne, colonne, nouvelleDefinition);
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}

}

package ryanYueChun.tp2;

public class MotsCroises {
	private Grille<String> solution;
	private Grille<String> proposition;
	private Grille<String> definitionHorizontal;
	private Grille<String> definitionVerticale;
	
	public MotsCroises (int hauteur, int largeur) {
		solution = new Grille<>(hauteur, largeur);
		proposition = new Grille<>(hauteur, largeur);
		definitionHorizontal = new Grille<>(hauteur, largeur);
		definitionVerticale = new Grille<>(hauteur, largeur);
	}
	
	private static final String messageMauvaisCoordonnees (String elementRecherchee) {
		return "Cette case est " + elementRecherchee;
	}
	
	public int getHauteur() {
		return solution.getHauteur();
	}
	
	public int getLargeur() {
		return solution.getLargeur();
	}
	
	public boolean coordonneesDansGrille(int ligne, int colonne) {
		return solution.coordonneesEstDansGrille(ligne, colonne);
	}
	
	public boolean estCaseNoire(int ligne, int colonne) {
		return solution.getCellule(ligne, colonne) == null;
	}
	
	public boolean coordonneesEstRemplissable(int ligne, int colonne) {
		return coordonneesDansGrille(ligne, colonne) && !estCaseNoire(ligne, colonne);
	}
	
	public void setCaseNoire(int ligne, int colonne, boolean noire) {
		if (coordonneesDansGrille(ligne, colonne)) {
			if (noire) {
				solution.setCellule(ligne, colonne, null);
			} else {
				solution.setCellule(ligne, colonne, "");
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("hors limite."));
		}
	}
	
	public char getSolution(int ligne, int colonne) {
		Character solutionCellule = null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			solutionCellule = solution.getCellule(ligne, colonne).toCharArray()[0];
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("est noire."));
		}
		
		return solutionCellule;
	}
	
	public void setSolution(int ligne, int colonne, char solutionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			solution.setCellule(ligne, colonne, String.valueOf(solutionCellule));
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("est noire."));
		}
	}
	
	public char getProposition(int ligne, int colonne) {
		Character propositionCellule =  null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			propositionCellule = proposition.getCellule(ligne, colonne).toCharArray()[0];
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("est noire."));
		}
		
		return propositionCellule;
	}
	
	public void setProposition(int ligne, int colonne, char propositionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			proposition.setCellule(ligne, colonne, String.valueOf(propositionCellule));
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("est noire."));
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
			throw new AssertionError(messageMauvaisCoordonnees("est noire."));
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
			throw new AssertionError(messageMauvaisCoordonnees("est noire."));
		}
	}

}

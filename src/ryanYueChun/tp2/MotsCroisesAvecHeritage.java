package ryanYueChun.tp2;

import static java.lang.String.valueOf;

public class MotsCroisesAvecHeritage extends Grille<Case<String>> {
	
	public MotsCroisesAvecHeritage (int hauteur, int largeur) {
		super(hauteur, largeur);
	}
	
	private static final String messageMauvaisCoordonnees (String elementRecherchee) {
		return "Cette case " + elementRecherchee;
	}
	
	public boolean coordonneesEstRemplissable(int ligne, int colonne) {
		return coordonneesEstDansGrille(ligne, colonne) && !estCaseNoire(ligne, colonne);
	}
	
	public boolean estCaseNoire(int ligne, int colonne) {
		return getCellule(ligne, colonne).isCaseNoire();
	}
	
	public void setCaseNoire(int ligne, int colonne, boolean noire) {
		if (coordonneesEstDansGrille(ligne, colonne)) {
			if (noire) {
				setCellule(ligne, colonne,  new Case<String>(true));
			} else {
				Case<String> caseCourante = getCellule(ligne, colonne);
				
				if (caseCourante == null) {
					setCellule(ligne, colonne, new Case<String>(null, null, null, null));
				}
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("hors limite."));
		}
	}
	
	public char getSolution(int ligne, int colonne) {
		Character solutionCellule = null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			solutionCellule = getCellule(ligne, colonne).getSolution().charAt(0);
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return solutionCellule;
	}
	
	public void setSolution(int ligne, int colonne, char solutionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			Case<String> ancienneCase = getCellule(ligne, colonne);
			Case<String> nouvelleCase = new Case<String>(
					valueOf(solutionCellule),
					ancienneCase.getProposition(),
					ancienneCase.getDefinitionHorizontal(),
					ancienneCase.getDefinitionVerticale());
			
			setCellule(ligne, colonne, nouvelleCase);
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}
	
	public char getProposition(int ligne, int colonne) {
		Character propositionCellule =  null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			propositionCellule = getCellule(ligne, colonne).getProposition().toCharArray()[0];
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return propositionCellule;
	}
	
	public void setProposition(int ligne, int colonne, char propositionCellule) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			Case<String> ancienneCase = getCellule(ligne, colonne);
			Case<String> nouvelleCase = new Case<String>(
					ancienneCase.getSolution(),
					valueOf(propositionCellule),
					ancienneCase.getDefinitionHorizontal(),
					ancienneCase.getDefinitionVerticale());
			
			setCellule(ligne, colonne, nouvelleCase);
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}
	
	public String getDefinition(int ligne, int colonne, boolean horizontal) {
		String definition = null;
		
		if (coordonneesEstRemplissable(ligne, colonne)) {
			if (horizontal) {
				definition = getCellule(ligne, colonne).getDefinitionHorizontal();
			} else {
				definition = getCellule(ligne, colonne).getDefinitionVerticale();
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
		
		return definition;
	}
	
	public void setDefinition(int ligne, int colonne, boolean horizontal, String nouvelleDefinition) {
		if (coordonneesEstRemplissable(ligne, colonne)) {
			Case<String> ancienneCase = getCellule(ligne, colonne);
			if (horizontal) {
				Case<String> nouvelleCase = new Case<String>(
						ancienneCase.getSolution(),
						ancienneCase.getProposition(),
						nouvelleDefinition,
						ancienneCase.getDefinitionVerticale());
				
				setCellule(ligne, colonne, nouvelleCase);
			} else {
				Case<String> nouvelleCase = new Case<String>(
						ancienneCase.getSolution(),
						ancienneCase.getProposition(),
						ancienneCase.getDefinitionHorizontal(),
						nouvelleDefinition);

				setCellule(ligne, colonne, nouvelleCase);
			}
		} else {
			throw new AssertionError(messageMauvaisCoordonnees("noire."));
		}
	}

}

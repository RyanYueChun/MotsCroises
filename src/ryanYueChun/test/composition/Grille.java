package ryanYueChun.test.composition;

public class Grille {
	private final int lignes;
	private final int colonnes;
	private final String[][] tableau;
	
	public Grille (int lignes, int colonnes) {
		assert (lignes >= 0) && (colonnes >= 0);
		
		this.lignes = lignes;
		this.colonnes = colonnes;
		tableau = new String[lignes][colonnes];
	}

	public int getLargeur() {
		return colonnes;
	}

	public int getHauteur() {
		return lignes;
	}
	
	public boolean coordonneesEstDansGrille(int ligne, int colonne) {
		return (1 <= ligne && ligne <= lignes) && (1 <= colonne && colonne <= colonnes);
	}
	
	public String getCellule(int ligne, int colonne) {
		String cellule = "";
		
		if (coordonneesEstDansGrille(ligne, colonne)) {
			cellule = tableau[ligne - 1][colonne - 1];
		} else {
			throw new AssertionError(String.format("Les coordonnees (%s, %s) ne sont pas correctes", ligne, colonne));
		}
		
		return cellule; 
	}
	
	public void setCellule(int ligne, int colonne, String chaine) {
		if (coordonneesEstDansGrille(ligne, colonne)) {
			this.tableau[ligne - 1][colonne - 1] = chaine;
		} else {
			throw new AssertionError(String.format("Les coordonnees (%s, %s) ne sont pas correctes", ligne, colonne));
		}
	}
	
	@Override
	public String toString() {
		String sortie = "";
		
		for (int ligne = 1; ligne <= lignes; ligne++) {
			for (int colonne = 1; colonne <= colonnes; colonne++) {
				String cellule = getCellule(ligne, colonne); 
				
				sortie += (cellule == null || cellule.isEmpty()) ? "??" : cellule;
				
				if (colonne != colonnes) {
					sortie += "|";
				}
			}
			
			sortie += System.lineSeparator();
		}
		
		return sortie;
	}

}

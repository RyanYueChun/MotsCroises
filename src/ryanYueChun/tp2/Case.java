package ryanYueChun.tp2;

public class Case<Type> {
	private final Type solution;
	private final Type proposition;
	private final Type definitionHorizontal;
	private final Type definitionVerticale;
	private final boolean caseNoire;

	public Case(Type solution, Type proposition, Type definitionHorizontal,
			Type definitionVerticale) {
		this.solution = solution;
		this.proposition = proposition;
		this.definitionHorizontal = definitionHorizontal;
		this.definitionVerticale = definitionVerticale;
		this.caseNoire = false;
	}
	
	public Case(boolean estCaseNoire) {
		solution = proposition = definitionHorizontal = definitionVerticale = null;
		this.caseNoire = estCaseNoire;
	}

	public Type getSolution() {
		return solution;
	}

	public Type getProposition() {
		return proposition;
	}

	public Type getDefinitionHorizontal() {
		return definitionHorizontal;
	}

	public Type getDefinitionVerticale() {
		return definitionVerticale;
	}

	public boolean isCaseNoire() {
		return caseNoire;
	}
	
	
}

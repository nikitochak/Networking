package com.sirma.itt.javacourse.reversemess;

/**
 * The originator for the Mamento design pattern.
 * 
 * @author Nikolay Ch
 * 
 */
class Originator {
	private String state;

	/**
	 * Setter for the state field.
	 * 
	 * @param state
	 *            the value
	 */
	public void set(String state) {
		this.state = state;
	}

	/**
	 * @return new Mamento object
	 */
	public Memento saveToMemento() {
		return new Memento(state);
	}

	/**
	 * Getter from a Mamento.
	 * 
	 * @param memento
	 *            the Mamento from which to get the value
	 */
	public void restoreFromMemento(Memento memento) {
		state = memento.getSavedState();
	}

	/**
	 * The Mamento class.
	 * 
	 * @author Nikolay Ch
	 * 
	 */
	public static class Memento {
		private final String state;

		/**
		 * Initializes the field.
		 * 
		 * @param stateToSave
		 *            the value for the field
		 */
		public Memento(String stateToSave) {
			state = stateToSave;
		}

		/**
		 * Getter for the state field.
		 * 
		 * @return the value of the field
		 */
		public String getSavedState() {
			return state;
		}
	}
}
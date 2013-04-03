package edu.rutgers.cs541;

import java.util.Vector;

public class Strategy {
	// all doubles are assigned with integers
	Vector<Integer> maxInt;
	Vector<Integer> maxLength;
	Vector<String> candidateCharacter;
	Vector<Double> nullProbability;
	int index;

	Strategy() {
		index = 2;

		maxInt = new Vector<Integer>();
		maxInt.add(2);
		maxInt.add(10);
		maxInt.add(100);

		maxLength = new Vector<Integer>();
		maxLength.add(1);
		maxLength.add(2);
		maxLength.add(5);

		candidateCharacter = new Vector<String>();
		candidateCharacter.add("a");
		candidateCharacter.add("aB");
		candidateCharacter.add("aB0 ");

		nullProbability = new Vector<Double>();
		nullProbability.add(0.5);
		nullProbability.add(0.2);
		nullProbability.add(0.1);

	}

	void changeIndex() {
		index = (index + 1) % maxInt.size();
	}

	public int getMaxInt() {
		return maxInt.elementAt(index);
	}

	public int getMaxLength() {
		return maxLength.elementAt(index);
	}

	public String getCandidateCharacter() {
		return candidateCharacter.elementAt(index);
	}

	public double getNullProbability() {
		return nullProbability.elementAt(index);
	}
}

package edu.rutgers.cs541;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Random;
import java.util.Vector;

public class DBOperation {

	Random randomGenerator;

	public DBOperation() {
		randomGenerator = new Random();
	}

	public StringBuilder generateTuple(Vector<Integer> dataTypes,
			Vector<Boolean> isNullables, Strategy strt) {
		// c is the number of columns

		int c = dataTypes.size();
		int dataType;
		StringBuilder tuple = new StringBuilder();
		boolean isNullable;
		// this method return a tuple as "xia", 123, 0.11, no parenthesis
		for (int i = 0; i < c; i++) {
			dataType = dataTypes.get(i);
			isNullable = isNullables.get(i);
			if (i > 0) {
				tuple.append(", ");
			}
			// generate a value appropriate for the column's type

			if (isNullable) {

				double setNull = randomGenerator.nextDouble();
				if (setNull < strt.getNullProbability()) {
					tuple.append("NULL");
					continue;
				}
			}
			if (dataType == Types.INTEGER) {
				int v = randomGenerator.nextInt(strt.getMaxInt() + 1);
				tuple.append(Integer.toString(v));
			} else if (dataType == Types.DOUBLE) {
				// double v = (randomGenerator.nextDouble() - 0.5) * intRange;
				int v = randomGenerator.nextInt(strt.getMaxInt() + 1);
				tuple.append(Integer.toString(v));
			} else if (dataType == Types.VARCHAR) {
				int len = strt.getMaxLength();
				String v = "'"
						+ generateString(len, strt.getCandidateCharacter())
						+ "'";
				tuple.append(v);
			} else {
				// this should report error
			}
		}
		return tuple;
	}

	private String generateString(int length, String candidateCharacters) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = candidateCharacters.charAt(randomGenerator
					.nextInt(candidateCharacters.length()));
		}
		return new String(text);
	}

	public StringBuilder generateInsertStatement(StringBuilder tuple,
			String tableName) {
		StringBuilder insertSb = new StringBuilder();
		insertSb.append("INSERT INTO ");
		insertSb.append(tableName);
		insertSb.append(" VALUES (");
		insertSb.append(tuple);
		insertSb.append(")");
		return insertSb;
	}

	private StringBuilder generateDeleteStatement(String table) {
		StringBuilder delete = new StringBuilder();
		delete.append("DELETE FROM ");
		delete.append(table);
		return delete;
	}

	private void deleteAllTuplesFromSingleTable(String table, Statement stmt) {
		StringBuilder comm = generateDeleteStatement(table);
		try {
			stmt.executeUpdate(comm.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clearAllTables(Vector<String> tables, Statement stmt) {
		for (String table : tables) {
			deleteAllTuplesFromSingleTable(table, stmt);
		}
	}

	public Vector<Vector<String>> minimizeSolution(
			Vector<Vector<String>> solution, Statement stmt) {
		// we assume in the H2 db, we have the separating tuples
		Vector<Vector<String>> res = new Vector<Vector<String>>();
		return res;
	}

	public Vector<String> minimizeSingleTable(Vector<String> tuples,
			String table, Statement stmt) {
		
		return tuples;
	}

	public static void main(String[] args) {
	}
}

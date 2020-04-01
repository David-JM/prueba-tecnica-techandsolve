/**
 * 
 */
package com.techsolve.mudanza.util;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for managing general functions and global const for all the
 * project
 * 
 * @author David Martinez
 *
 */
public class Util {

	public static final String NEW_LINE = "\n";
	public static final String CASE = "Case #";
	public static final String TWO_DOT = ": ";

	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int FIVE_HUNDRED = 500;
	public static final int MIN_WEIGHT_BY_TRAVEL = 50;

	public static final String JSON_KEY_OUTPUT_FILE = "outputFile";
	public static final String EXCEPTION_MESSAGE_DATA_BASE = "Ocurrio un error al guardar en la base de datos: ";
	public static final String EXCEPTION_MESSAGE_TOTAL_DAYS = "El numero de dias debe ser minimo 1 y maximo 500";
	public static final String EXCEPTION_MESSAGE_ITEMS_PER_DAY = "El numero de items a llevar por dia debe ser minimo 1 y maximo 100";
	public static final String EXCEPTION_MESSAGE_MAX_WEIGHT = "El peso de un elemento debe ser minimo 1 y maximo 100";

	public static String decodeBase64(String base64) {
		byte[] decodedBytes = Base64.getDecoder().decode(base64);
		return new String(decodedBytes);
	}

	public static String encodeBase64(String inString) {
		return Base64.getEncoder().encodeToString(inString.getBytes());
	}

	public static List<Integer> split(String str, String character) {
		return Arrays.stream(str.split(character)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
	}

}

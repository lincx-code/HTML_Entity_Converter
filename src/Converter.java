/*
 * Author: 		Chenxin Lin
 * Description: Converter method class
 * Copyright:	Chenxin Lin @2015
 */

import java.io.UnsupportedEncodingException;

public class Converter {
	private String copyAfter = "";

	// Convert basic HTML entities
	public String htmlEntityConverter(final String copyBefore) throws UnsupportedEncodingException {
		// Remove extra white spaces
		this.copyAfter = copyBefore.trim();

		// Start replacing special characters

		// Step 1: Replace all new line characters with spaces and delete the last new line
		this.copyAfter = copyBefore.replaceAll("\n", " ").replaceAll(" +", " ").trim();

		// Step 2: Replace all special characters
		this.copyAfter = this.copyAfter.replaceAll("&", "&amp;").replaceAll("‘", "&#8216;").replaceAll("’", "&#8217;")
				.replaceAll("“", "&#8220;").replaceAll("”", "&#8221;").replaceAll("—", "&#8212;").replaceAll("–", "&#8211;")
				.replaceAll("†", "&#8224;").replaceAll("‡", "&#8225;").replaceAll("©", "&copy;").replaceAll("™", "&#8482;")
				.replaceAll("®", "&reg;").replaceAll("§", "&sect;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
				.replaceAll("€", "&euro;").replaceAll("≤", "&le;").replaceAll("≥", "&ge;").replaceAll("¢", "&cent;");

		return this.copyAfter;
	}

	// Convert basic HTML entities and Spanish character
	public String spanishEntityConverter(final String copyBefore) throws UnsupportedEncodingException {
		// Remove extra white spaces
		this.copyAfter = copyBefore.trim();

		// Step 1: Replace all new line characters with spaces and delete the last new line
		this.copyAfter = copyBefore.replaceAll("\n", " ").replaceAll(" +", " ").trim();

		// Step 2: Replace all special characters
		this.copyAfter = this.copyAfter.replaceAll("&", "&amp;").replaceAll("‘", "&#8216;").replaceAll("’", "&#8217;")
				.replaceAll("“", "&#8220;").replaceAll("”", "&#8221;").replaceAll("—", "&#8212;").replaceAll("–", "&#8211;")
				.replaceAll("†", "&#8224;").replaceAll("‡", "&#8225;").replaceAll("©", "&copy;").replaceAll("™", "&#8482;")
				.replaceAll("®", "&reg;").replaceAll("§", "&sect;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
				.replaceAll("€", "&euro;").replaceAll("≤", "&le;").replaceAll("≥", "&ge;").replaceAll("¢", "&cent;")
				.replaceAll("À", "&Agrave;").replaceAll("Á", "&Aacute;").replaceAll("Â", "&Acirc;").replaceAll("Ã", "&Atilde;")
				.replaceAll("Ä", "&Auml;").replaceAll("Å", "&Aring;").replaceAll("Æ", "&AElig;").replaceAll("Ç", "&Ccedil;")
				.replaceAll("È", "&Egrave;").replaceAll("É", "&Eacute;").replaceAll("Ê", "&Ecirc;").replaceAll("Ë", "&Euml;")
				.replaceAll("Ì", "&Igrave;").replaceAll("Í", "&Iacute;").replaceAll("Î", "&Icirc;").replaceAll("Ï", "&Iuml;")
				.replaceAll("Ð", "&ETH;").replaceAll("Ñ", "&Ntilde;").replaceAll("Ò", "&Ograve;").replaceAll("Ó", "&Oacute;")
				.replaceAll("Ô", "&Ocirc;").replaceAll("Õ", "&Otilde;").replaceAll("Ö", "&Ouml;").replaceAll("×", "&times;")
				.replaceAll("Ø", "&Oslash;").replaceAll("Ù", "&Ugrave;").replaceAll("Ú", "&Uacute;").replaceAll("Û", "&Ucirc;")
				.replaceAll("Ü", "&Uuml;").replaceAll("Ý", "&Yacute;").replaceAll("Þ", "&THORN;").replaceAll("ß", "&szlig;")
				.replaceAll("à", "&agrave;").replaceAll("á", "&aacute;").replaceAll("â", "&acirc;").replaceAll("ã", "&atilde;")
				.replaceAll("ä", "&auml;").replaceAll("å", "&aring;").replaceAll("æ", "&aelig;").replaceAll("ç", "&ccedil;")
				.replaceAll("è", "&egrave;").replaceAll("é", "&eacute;").replaceAll("ê", "&ecirc;").replaceAll("ë", "&euml;")
				.replaceAll("ì", "&igrave;").replaceAll("í", "&iacute;").replaceAll("î", "&icirc;").replaceAll("ï", "&iuml;")
				.replaceAll("ð", "&eth;").replaceAll("ñ", "&ntilde;").replaceAll("ò", "&ograve;").replaceAll("ó", "&oacute;")
				.replaceAll("ô", "&ocirc;").replaceAll("õ", "&otilde;").replaceAll("ö", "&ouml;").replaceAll("÷", "&divide;")
				.replaceAll("ø", "&oslash;").replaceAll("ù", "&ugrave;").replaceAll("ú", "&uacute;").replaceAll("û", "&ucirc;")
				.replaceAll("ü", "&uuml;").replaceAll("ý", "&yacute;").replaceAll("þ", "&thorn;").replaceAll("ÿ", "&yuml;")
				.replaceAll("¿", "&iquest;").replaceAll("¡", "&iexcl;");

		return this.copyAfter;
	}

	// Convert to plan text
	public String textConverter(final String copyBefore) throws UnsupportedEncodingException {
		// Remove extra white spaces
		this.copyAfter = copyBefore.trim();

		// Step 1: Replace all new line characters with spaces and delete the last new line
		this.copyAfter = copyBefore.replaceAll("\n", " ").replaceAll(" +", " ").trim();

		// Step 2: Replace all special characters
		this.copyAfter = this.copyAfter.replaceAll("‘", "'").replaceAll("’", "'").replaceAll("“", "\"").replaceAll("”", "\"")
				.replaceAll("—", "--").replaceAll("–", "-").replaceAll("†", "(+)").replaceAll("‡", "(^)").replaceAll("©", "(C)")
				.replaceAll("™", "(TM)").replaceAll("®", "(R)").replaceAll("§", "(~)").replaceAll("<", "<").replaceAll(">", ">")
				.replaceAll("≤", "<=").replaceAll("≥", ">=");

		return this.copyAfter;
	}
}

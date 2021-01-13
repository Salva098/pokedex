package Util;

import java.text.Normalizer;

public class TextHelp {
	public String toMayus(String palabra) {
		String [] PalabraArr;
		PalabraArr =palabra.split(" ");
		String textoMayus = PalabraArr[0].toUpperCase().charAt(0)+PalabraArr[0].toLowerCase().substring(1, PalabraArr[0].length());
		if (PalabraArr.length>1) {
			textoMayus=textoMayus+" "+PalabraArr[1].toUpperCase().charAt(0)+PalabraArr[1].toLowerCase().substring(1, PalabraArr[1].length());
		}
		return textoMayus;
	}
	public String quitarTildes(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("\\p{M}", "");
		return texto;
	}
}

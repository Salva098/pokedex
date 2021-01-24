package Util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;

import javax.imageio.ImageIO;

public class TextHelp {
	/**
	 * metodo para poner el texto con la primera en mayuscula
	 * @param palabra texto que quieres convertir
	 * @return palabra con la mayusculas puesta
	 */
	public String toMayus(String palabra) {
		String[] PalabraArr;
		PalabraArr = palabra.split(" ");
		String textoMayus = PalabraArr[0].toUpperCase().charAt(0)
				+ PalabraArr[0].toLowerCase().substring(1, PalabraArr[0].length());
		if (PalabraArr.length > 1) {
			textoMayus = textoMayus + " " + PalabraArr[1].toUpperCase().charAt(0)
					+ PalabraArr[1].toLowerCase().substring(1, PalabraArr[1].length());
		}
		return textoMayus;
	}

	/**
	 * metodo para quitar las tildes y las enye
	 * @param texto a cambiar
	 * @return texto cambiado
	 */
	public String quitarTildes(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("\\p{M}", "");
		return texto;
	}

	/**
	 * valida si la imagen en la url existe
	 * @param url que se quiere comprobar
	 * @return true si existe la imagen
	 */
	public boolean validadorUrl(String url) {

		BufferedImage image;
		try {
			image = ImageIO.read(new URL(url));
			if (image != null) {
				return true;
			} else {
				return false;
			}
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

	}
}

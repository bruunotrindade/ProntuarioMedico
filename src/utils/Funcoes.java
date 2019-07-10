package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Funcoes 
{
	public static String converterData(String antiga, String formatoAntiga, String formatoNova)
	{
		try 
		{
			Date date = new SimpleDateFormat(formatoAntiga).parse(antiga);
			return new SimpleDateFormat(formatoNova).format(date);
		} 
		catch (ParseException e) 
		{
			return "";
		}
	}
	
	public static String converterDataBR(String antiga)
	{
		return converterData(antiga, "yyyy-MM-dd", "dd/MM/yyyy");
	}
	
	public static String converterDataEUA(String antiga)
	{
		return converterData(antiga, "dd/MM/yyyy", "yyyy-MM-dd");
	}
	
	public static String md5(String senha)
	{
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(16);			
		return sen;
	}
	
	public static void mostrarMensagemErro(String str)
	{
		JOptionPane.showMessageDialog(null, str, "Falha", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mostrarMensagemSucesso(String str)
	{
		JOptionPane.showMessageDialog(null, str, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}
}

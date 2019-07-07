package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}

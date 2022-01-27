package altaUsuario;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UtilidadesFechas {
	private static final String pattern = "dd/MM/yyyy";
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	private static LocalDate getFecha(Date fecha) {
		return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static boolean esFechaPosterior(Date fecha1, Date fecha2) {
		return getFecha(fecha1).isAfter(getFecha(fecha2));
	}

	public static Date transformarAFecha(String fechaCadena) {
		try {
			return simpleDateFormat.parse(fechaCadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static String transformarACadena(Date fecha) {
		return simpleDateFormat.format(fecha);
	}
}

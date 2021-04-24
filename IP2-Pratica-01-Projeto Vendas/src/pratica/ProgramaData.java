package pratica;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ProgramaData {

	public static void main(String[] args) {
		
		// LocalTime
		LocalTime horaAgora = LocalTime.now();
		LocalTime horaEspecifica = LocalTime.of(20, 30, 50);
		LocalTime horaEspecificaDoTexto = LocalTime.parse("20:30:50");
		
		// LocalDate		
		LocalDate dataHoje = LocalDate.now();
		LocalDate dataEspecifica = LocalDate.of(2017, 12, 25);
		LocalDate dataEspecificaDoTexto = LocalDate.parse("2020-12-25");
		
		// LocalDateTime 
		LocalDateTime dataHoraAgora = LocalDateTime.now();
		LocalDateTime dataHoraEspecifica = LocalDateTime.of(2020, 12, 25, 20, 30, 50);
		LocalDateTime dataHoraEspecificaDoTexto =  LocalDateTime.parse("2020-12-25T20:30:50");
		
		// Instant 
		Instant momentoAgora = Instant.now();
		Instant momentoDoTexto = Instant.parse("2020-12-25T20:30:50Z");
		
		
		// ZonedDateTime 
		ZonedDateTime dataHoraZonaAgora = ZonedDateTime.now();
		ZonedDateTime dataHoraZonaEspecifica = ZonedDateTime.of(dataHoraEspecifica, ZoneId.of("America/Recife"));
		ZonedDateTime dataHoraZonaEspecificaDoTexto = ZonedDateTime.parse("2020-12-25T20:30:50-02:00[America/Recife]");
		
	
	}

}

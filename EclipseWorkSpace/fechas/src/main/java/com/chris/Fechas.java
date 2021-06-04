package com.chris;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

public class Fechas {

    public static void main(String[] args) {
        // eDate5();
        // eLocalDate8();
        // eLocalTime8();
        // eLocalDateTime();
        // ePeriod8();
        // eDuration8();
        // eZoneId();
        // eTemporalAdjusters();
        // eParse8();
    }

    public static void eDate5() {
        Date fecha = new Date();
        System.out.println(fecha); // Date of today
        Date fecha2 = new Date(121, 5, 2);
        System.out.println(fecha2);
        Date fecha3 = new Date("27/07/1976");
        System.out.println(fecha3);
        Date fecha4 = new Date("07/27/1976");
        System.out.println(fecha4);

        try {
            Date fecha5 = new SimpleDateFormat("dd/MM/yyyy").parse("27/07/1976");
            System.out.println(fecha5);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void eLocalDate8() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDateOf = LocalDate.of(2021, 6, 2);
        System.out.println(localDateOf);
        LocalDate suma30 = localDate.plusDays(30);
        System.out.println(suma30);
        LocalDate finPlazo = LocalDate.of(2021, 06, 3);
        System.out.println(LocalDate.now().isAfter(finPlazo) ? "te has pasado" : "Estas en plazo");

    }

    public static void eLocalTime8() {
        LocalTime localTime = LocalTime.now(); // Hora Actual
        System.out.println(localTime);
        LocalTime localTimeOf = LocalTime.of(20, 50, 50);
        System.out.println(localTimeOf);
        LocalTime suma3horas = LocalTime.now().plusHours(3);
        System.out.println(suma3horas);
        LocalTime suma20horas = LocalTime.now().plus(20, ChronoUnit.HOURS); // Lo mismo que plusHours
        LocalTime suma20horas2 = LocalTime.now().plusHours(20);
        System.out.println(suma20horas);
        System.out.println(suma20horas2);
    }

    public static void eLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTimeOf = LocalDateTime.of(2021, Month.JANUARY, 22, 10, 3, 22);
        System.out.println(localDateTimeOf);
    }

    public static void ePeriod8() {
        LocalDate fechaNacimiento = LocalDate.of(1996, 9, 29);
        LocalDate hoy = LocalDate.now();
        int myYears = Period.between(fechaNacimiento, hoy).getYears();
        System.out.println(myYears);
    }

    public static void eDuration8() {
        LocalTime horaActual = LocalTime.now();
        LocalTime finClase = LocalTime.of(14, 0);
        System.out.println("Faltan " + Duration.between(horaActual, finClase).toMinutes());
    }

    public static void eZoneId() {
        Set<String> zonasHorarias = ZoneId.getAvailableZoneIds();
        zonasHorarias.stream().sorted().forEach(z -> System.out.println(z));
        System.out.println("La hora de Tokio es: " + LocalDateTime.now(ZoneId.of("Asia/Tokyo")));
    }

    public static void eTemporalAdjusters() {
        System.out.println("El ultimo dia de este mes es: ");
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
    }

    public static void eParse8() {
        LocalDate hoy = LocalDate.parse("2021-06-02"); // ISO
        System.out.println(hoy);
        LocalDateTime ahora = LocalDateTime.parse("2021-06-02T10:22:45");
        System.out.println(ahora.getDayOfWeek());
        LocalDate nowSpain = LocalDate.parse("02/06/2021", DateTimeFormatter.ofPattern("d/M/yyyy"));
        System.out.println(nowSpain.getDayOfWeek());
        DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("d/M/yyyy hh:mm:ss");
        DateTimeFormatter esDateFormatLargo = DateTimeFormatter.ofPattern("EEEE, dd 'de' yyyy 'a las' hh:mm:ss ")
                .withLocale(new Locale("es", "ES"));
        System.out.println(ahora.format(esDateFormat));
        System.out.println(ahora.format(esDateFormatLargo));
        String idiomaLocal = System.getProperty("user.language");
        String paisLocal = System.getProperty("user.country");
        // Properties properties = System.getProperties();
        // System.out.println(properties);
        System.out.println(paisLocal);
        System.out.println(idiomaLocal);
        DateTimeFormatter esDateFormatLargoSistema = DateTimeFormatter
                .ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss ");
        System.out.println(LocalDateTime.now().format(esDateFormatLargoSistema));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    }
}

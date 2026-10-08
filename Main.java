import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente(
                "1001",
                "Laura Gómez",
                "laura@gmail.com",
                "3001234567",
                "Calle 15 #20-30"
        );

        ProfesionalSalud profesional = new ProfesionalSalud(
                "2001",
                "Carlos Martínez",
                "carlos@medihome.com",
                "RM-45879",
                "Medicina General"
        );

        EquipoMedico equipo = new EquipoMedico("EQ-01", "Equipo Norte", "Zona Norte");
        equipo.agregarProfesional(profesional);

        LocalDateTime fechaServicio = LocalDateTime.of(2026, 10, 7, 9, 0);
        ServicioDomiciliario servicio = paciente.solicitarServicio(
                "SD-001",
                fechaServicio,
                "Calle 15 #20-30",
                "Fiebre y malestar general"
        );

        servicio.programar(profesional);
        servicio.iniciarAtencion();

        LocalDateTime fechaInicioAtencion = LocalDateTime.of(2026, 10, 7, 9, 30);
        LocalDateTime fechaFinAtencion = LocalDateTime.of(2026, 10, 7, 10, 30);

        AtencionMedica atencion = profesional.registrarAtencion(
                servicio,
                fechaInicioAtencion,
                fechaFinAtencion,
                "Paciente presenta cuadro febril leve.",
                "Mantener hidratación, reposo y controlar la temperatura."
        );

        MedicionSignosVitales medicion = new MedicionSignosVitales(
                fechaInicioAtencion.plusMinutes(15),
                38.2,
                92,
                120,
                80,
                97.0
        );
        atencion.registrarMedicion(medicion);

        servicio.finalizar();

        System.out.println("========== MEDIHOME ==========");
        System.out.println();
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Profesional asignado: " + profesional.getNombre());
        System.out.println("Especialidad: " + profesional.getEspecialidad());
        System.out.println();
        System.out.println("Servicio:");
        System.out.println("Código: " + servicio.getCodigoUnico());
        System.out.println("Dirección: " + servicio.getDireccionAtencion());
        System.out.println("Motivo: " + servicio.getMotivo());
        System.out.println("Estado: " + servicio.getEstado());
        System.out.println();
        System.out.println("Atención médica:");
        System.out.println("Inicio: " + atencion.getFechaHoraInicio());
        System.out.println("Finalización: " + atencion.getFechaHoraFinalizacion());
        System.out.println();
        System.out.println("Signos vitales:");
        System.out.println("Temperatura: " + medicion.getTemperatura() + " °C");
        System.out.println("Frecuencia cardíaca: " + medicion.getFrecuenciaCardiaca() + " bpm");
        System.out.println("Presión arterial: " + medicion.getPresionSistolica() + "/" + medicion.getPresionDiastolica() + " mmHg");
        System.out.println("Saturación de oxígeno: " + medicion.getSaturacionOxigeno() + " %");
        System.out.println();
        System.out.println("Observaciones:");
        System.out.println(atencion.getObservaciones());
        System.out.println();
        System.out.println("Recomendaciones:");
        System.out.println(atencion.getRecomendaciones());
        System.out.println();
        System.out.println("El paciente " + paciente.getNombre() + " fue atendido por " + profesional.getNombre() + ".");
        System.out.println();

        paciente.notificar("Su atención domiciliaria ha finalizado.");
        profesional.notificar("La atención del servicio " + servicio.getCodigoUnico() + " fue registrada correctamente.");
    }
}

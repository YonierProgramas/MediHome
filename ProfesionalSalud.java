import java.time.LocalDateTime;

public class ProfesionalSalud extends Usuario implements Notificable {
    private String numeroRegistroProfesional;
    private String especialidad;

    public ProfesionalSalud(String identificacion, String nombre, String correo, String numeroRegistroProfesional, String especialidad) {
        super(identificacion, nombre, correo);
        this.numeroRegistroProfesional = numeroRegistroProfesional;
        this.especialidad = especialidad;
    }

    public String getNumeroRegistroProfesional() {
        return numeroRegistroProfesional;
    }

    public void setNumeroRegistroProfesional(String numeroRegistroProfesional) {
        this.numeroRegistroProfesional = numeroRegistroProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificación para " + getNombre() + ": " + mensaje);
    }

    public AtencionMedica registrarAtencion(
            ServicioDomiciliario servicio,
            LocalDateTime fechaHoraInicio,
            LocalDateTime fechaHoraFinalizacion,
            String observaciones,
            String recomendaciones
    ) {
        AtencionMedica atencionMedica = new AtencionMedica(
                fechaHoraInicio,
                fechaHoraFinalizacion,
                observaciones,
                recomendaciones,
                servicio
        );

        servicio.setAtencionMedica(atencionMedica);
        return atencionMedica;
    }
}

import java.time.LocalDateTime;

public class ServicioDomiciliario {
    public static final String SOLICITADO = "SOLICITADO";
    public static final String PROGRAMADO = "PROGRAMADO";
    public static final String EN_ATENCION = "EN_ATENCION";
    public static final String FINALIZADO = "FINALIZADO";
    public static final String CANCELADO = "CANCELADO";

    private String codigoUnico;
    private LocalDateTime fechaHora;
    private String direccionAtencion;
    private String motivo;
    private String estado;
    private Paciente paciente;
    private ProfesionalSalud profesionalAsignado;
    private AtencionMedica atencionMedica;

    public ServicioDomiciliario(String codigoUnico, LocalDateTime fechaHora, String direccionAtencion, String motivo, Paciente paciente) {
        this.codigoUnico = codigoUnico;
        this.fechaHora = fechaHora;
        this.direccionAtencion = direccionAtencion;
        this.motivo = motivo;
        this.paciente = paciente;
        this.estado = SOLICITADO;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDireccionAtencion() {
        return direccionAtencion;
    }

    public void setDireccionAtencion(String direccionAtencion) {
        this.direccionAtencion = direccionAtencion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfesionalSalud getProfesionalAsignado() {
        return profesionalAsignado;
    }

    public void setProfesionalAsignado(ProfesionalSalud profesionalAsignado) {
        this.profesionalAsignado = profesionalAsignado;
    }

    public AtencionMedica getAtencionMedica() {
        return atencionMedica;
    }

    public void setAtencionMedica(AtencionMedica atencionMedica) {
        this.atencionMedica = atencionMedica;
        if (atencionMedica != null) {
            atencionMedica.setServicio(this);
        }
    }

    public void programar(ProfesionalSalud profesional) {
        this.profesionalAsignado = profesional;
        this.estado = PROGRAMADO;
    }

    public void iniciarAtencion() {
        this.estado = EN_ATENCION;
    }

    public void finalizar() {
        this.estado = FINALIZADO;
    }

    public void cancelar() {
        this.estado = CANCELADO;
    }
}

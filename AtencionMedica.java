import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AtencionMedica {
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private String observaciones;
    private String recomendaciones;
    private List<MedicionSignosVitales> mediciones;
    private ServicioDomiciliario servicio;

    public AtencionMedica(
            LocalDateTime fechaHoraInicio,
            LocalDateTime fechaHoraFinalizacion,
            String observaciones,
            String recomendaciones,
            ServicioDomiciliario servicio
    ) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
        this.servicio = servicio;
        this.mediciones = new ArrayList<>();
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(LocalDateTime fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public ServicioDomiciliario getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDomiciliario servicio) {
        this.servicio = servicio;
    }

    public void registrarMedicion(MedicionSignosVitales medicion) {
        if (medicion != null) {
            mediciones.add(medicion);
        }
    }

    public List<MedicionSignosVitales> getMediciones() {
        return Collections.unmodifiableList(mediciones);
    }
}

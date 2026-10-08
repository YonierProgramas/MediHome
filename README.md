YONIER DAVID BURBANO

# MediHome

MediHome es un sistema académico desarrollado en Java para representar la gestión de servicios médicos domiciliarios.

El proyecto fue realizado como parte de la asignatura **Diseño de Software**, aplicando conceptos de programación orientada a objetos y modelado UML como clases, objetos, encapsulamiento, herencia, interfaces, asociaciones, agregación, composición y multiplicidades.

---

## Descripción

MediHome permite representar el proceso básico de atención médica domiciliaria.

Un paciente puede solicitar servicios domiciliarios y, cuando el servicio es programado, se le asigna un profesional de la salud.

Durante el servicio se registra una atención médica y dentro de esta pueden registrarse diferentes mediciones de signos vitales.

Los pacientes y profesionales de salud son usuarios del sistema y pueden recibir notificaciones relacionadas con los servicios en los que participan.

Los profesionales también pueden pertenecer a equipos de atención domiciliaria.

---

## Funcionalidades principales

- Registro de pacientes.
- Registro de profesionales de salud.
- Gestión de equipos médicos.
- Asociación de profesionales a equipos.
- Solicitud de servicios domiciliarios.
- Programación de servicios.
- Asignación de profesionales de salud.
- Inicio y finalización de una atención.
- Registro de atención médica.
- Registro de mediciones de signos vitales.
- Registro de observaciones clínicas.
- Registro de recomendaciones.
- Manejo del estado del servicio domiciliario.
- Notificaciones para pacientes y profesionales.
- Visualización del resumen de la atención desde consola.

---

## Clases principales

### Usuario

Clase general que contiene la información compartida por los usuarios del sistema.

Atributos principales:

- identificación
- nombre
- correo electrónico

De esta clase heredan `Paciente` y `ProfesionalSalud`.

### Paciente

Representa a la persona que solicita los servicios médicos domiciliarios.

Además de los datos heredados de `Usuario`, contiene:

- teléfono
- dirección principal

Puede solicitar diferentes servicios domiciliarios e implementa la interfaz `Notificable`.

### ProfesionalSalud

Representa al profesional encargado de realizar la atención domiciliaria.

Contiene:

- número de registro profesional
- especialidad

Hereda de `Usuario`, implementa `Notificable` y puede atender diferentes servicios domiciliarios.

### EquipoMedico

Representa un equipo de atención domiciliaria.

Contiene:

- código
- nombre
- zona de cobertura

Un equipo puede agrupar varios profesionales de salud.

La relación con `ProfesionalSalud` se modela mediante **agregación**, ya que un profesional puede dejar de pertenecer a un equipo sin dejar de existir en el sistema.

### ServicioDomiciliario

Representa un servicio solicitado por un paciente.

Contiene información como:

- código único
- fecha y hora programada
- dirección de atención
- motivo
- estado

Los estados manejados por el programa son:

- `SOLICITADO`
- `PROGRAMADO`
- `EN_ATENCION`
- `FINALIZADO`
- `CANCELADO`

Cada servicio corresponde a un paciente y puede tener un profesional de salud asignado.

### AtencionMedica

Representa la atención realizada durante un servicio domiciliario.

Registra:

- fecha y hora de inicio
- fecha y hora de finalización
- observaciones clínicas
- recomendaciones

La atención médica depende del servicio domiciliario, por lo que esta relación se representa mediante **composición**.

### MedicionSignosVitales

Representa una medición realizada durante una atención médica.

Registra:

- fecha y hora
- temperatura
- frecuencia cardíaca
- presión sistólica
- presión diastólica
- saturación de oxígeno

Una atención puede registrar cero o varias mediciones.

Las mediciones existen como parte de una atención médica, por lo que también se utiliza **composición**.

### Notificable

Interfaz que define el contrato:

```java
void notificar(String mensaje);

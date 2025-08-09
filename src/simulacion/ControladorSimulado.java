package simulacion;

import entidades.Paciente;
import entidades.Turno;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public class ControladorSimulado {

    @Operation(
            summary = "Registrar un nuevo paciente",
            description = "Crea un registro de paciente en el sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Paciente registrado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos")
            }
    )
    public void registrarPaciente(
            @Parameter(description = "Objeto Paciente a registrar", required = true)
            Paciente paciente) {
        // Aquí iría la lógica real, pero solo estamos simulando
    }

    @Operation(
            summary = "Obtener información de un turno",
            description = "Retorna los datos de un turno según su ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Turno encontrado",
                            content = @Content(schema = @Schema(implementation = Turno.class))
                    ),
                    @ApiResponse(responseCode = "404", description = "Turno no encontrado")
            }
    )
    public Turno obtenerTurno(
            @Parameter(description = "ID del turno", required = true)
            int id) {
        // Simulación
        return null;
    }

    @Operation(
            summary = "Cancelar un turno",
            description = "Elimina un turno existente del sistema",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Turno cancelado exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Turno no encontrado")
            }
    )
    public void cancelarTurno(
            @Parameter(description = "ID del turno a eliminar", required = true)
            int id) {
        // Simulación
    }
}

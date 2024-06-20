package TFG.AdmisionProject.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TFG.AdmisionProject.Repositorio.estudianteRepositorio;
import TFG.AdmisionProject.modelo.estudiantes;

@RestController
@RequestMapping(path = "/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class estudianteControlador {

	@Autowired
	private estudianteRepositorio repositorio;

	//metodo para listar estudiantes
	@GetMapping("/estudiantes")
	public List<estudiantes> listarTodosLosestudiantes() {

		return repositorio.findAll();

	}
	
	
	//metodo para listar estudiantes
	@PostMapping("estudiantes")
	public estudiantes guardarEstudiante(@RequestBody estudiantes estudiante) {
		return repositorio.save(estudiante);
	}
	
	//metodo para buscar un estudiante por id
	@GetMapping("/estudiantes/{id}")
		public ResponseEntity<estudiantes> obtenerEstudiantePorId(@PathVariable Long id){
			estudiantes estudiante = repositorio.findById(id)
									 .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el id:" +id));
			return ResponseEntity.ok(estudiante);
	}
		
	@PutMapping("/estudiantes/{id}")
	public ResponseEntity<estudiantes> actualizarEstudiante(@PathVariable Long id, @RequestBody estudiantes detallesEstudiante){
		estudiantes estudiante = repositorio.findById(id)
								 .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el id:" +id));
		estudiante.setNombre(detallesEstudiante.getNombre());
		estudiante.setApellidos(detallesEstudiante.getApellidos());
		estudiante.setFechanacimiento(detallesEstudiante.getFechanacimiento());
		estudiante.setDireccion(detallesEstudiante.getDireccion());
		estudiante.setTelefono(detallesEstudiante.getTelefono());
		estudiante.setCorreo(detallesEstudiante.getCorreo());
		
		estudiantes estudianteActualizado = repositorio.save(estudiante);
		return ResponseEntity.ok(estudianteActualizado);
	}
	
	@DeleteMapping("/estudiantes/{id}")
	public ResponseEntity<Map<String,Boolean>>eliminarEstudiante(@PathVariable Long id){
		estudiantes estudiante = repositorio.findById(id)
								 .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el id:" +id));
		repositorio.delete(estudiante);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}

}

package iuh.exercise.controllers;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.exercise.entities.Employee;
import iuh.exercise.services.EmployeeService;
import jakarta.validation.Valid;

@RestController
//@RepositoryRestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	public ResponseEntity<Map<String, Object>> getEmmployeeById(@PathVariable int id) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		response.put("data", employeeService.findById(id));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/employees")
//	public ResponseEntity<Map<String, Object>> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,
//			BindingResult bindingResult) {
//		Map<String, Object> response = new LinkedHashMap<String, Object>();
//		if (bindingResult.hasErrors()) {
//			Map<String, Object> errors = new LinkedHashMap<String, Object>();
//			bindingResult.getFieldErrors().stream().forEach(result -> {
//				errors.put(result.getField(), result.getDefaultMessage());
//			});
//			System.out.println(bindingResult);
//			response.put("status", HttpStatus.BAD_REQUEST.value()); // 400
//			response.put("errors", errors);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		} else {
//			response.put("status", HttpStatus.OK.value());
//			response.put("data", employeeService.save(employee));
//			return ResponseEntity.status(HttpStatus.OK).body(response);
//		}
//	}
//
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable int id,
//			@Valid @RequestBody Employee employee, BindingResult bindingResult) {
//		Map<String, Object> response = new LinkedHashMap<String, Object>();
//		if (bindingResult.hasErrors()) {
//			Map<String, Object> errors = new LinkedHashMap<String, Object>();
//			bindingResult.getFieldErrors().stream().forEach(result -> {
//				errors.put(result.getField(), result.getDefaultMessage());
//			});
//			response.put("status", HttpStatus.BAD_REQUEST.value());
//			response.put("errors", errors);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		} else {
//			response.put("status", HttpStatus.OK.value());
//			response.put("data", employeeService.update(id, employee));
//			return ResponseEntity.status(HttpStatus.OK).body(response);
//		}
//	}
//
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int id) {
//		Map<String, Object> response = new LinkedHashMap<String, Object>();
//		response.put("status", HttpStatus.OK.value());
//		response.put("data", employeeService.delete(id));
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}

	@GetMapping("/employees")
	public ResponseEntity<Map<String, Object>> getEmployees(@RequestParam(required = false) String keyword) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		if (keyword == null || keyword.isEmpty()) {
			response.put("data", employeeService.findAll());
		} else {
			response.put("data", employeeService.search(keyword));
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
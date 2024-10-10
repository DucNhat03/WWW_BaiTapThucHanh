package iuh.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Random;

import iuh.entities.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {

	// Giả lập cơ sở dữ liệu trong bộ nhớ
	private static Map<Integer, User> userDatabase = new ConcurrentHashMap<>();
	private static String aplphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	static {
		// random 26 user có fisrtname là "Nguyen Van"
		// random 26 user có lastname là các ký tự từ a-z
		// random 26 user có dob là ngày tháng năm sinh
		try {
			for (int j = 0; j < aplphabet.length(); j++) {
				User user = new User();
				user.setId(j);
				user.setFirst_name("Nguyen Van");
				try {
					try {
						user.setLast_name(aplphabet.charAt(j) + "");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// LastName = 1 trong 26 ký tự từ a-z
				user.setLast_name(aplphabet.charAt(ThreadLocalRandom.current().nextInt(0, aplphabet.length())) + "");
				// dob = năm 2003, tháng random từ 1-12, ngày random từ 1-28
				user.setDob("2003" +"-"+ ThreadLocalRandom.current().nextInt(1, 13) + "-" + ThreadLocalRandom.current().nextInt(1, 29));

				userDatabase.put(j, user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{person-id}")
	public Response getPerson(@PathParam("person-id") int id) {
		User user = userDatabase.get(id);
		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	// Endpoint: /api/users -> Thêm mới 1 user
	/*
	 * Dùng Postman, phuong thức POST, địa chỉ:
	 * http://localhost:8080/rest-api/apiUser/users Chọn tab Body, chọn raw và đặt
	 * định dạng thành JSON. Nhập dữ liệu Send { "first_name": "Nguyen",
	 * "last_name": "Duc", "dob": "1990-01-01" }
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		int newId = userDatabase.size() + 1; // Tạo ID mới (đơn giản)
		user.setId(newId);
		userDatabase.put(newId, user);
		return Response.status(Response.Status.CREATED).entity("User added with ID: " + newId).build();
	}

	// Endpoint: /api/users/{id} -> Cập nhật 1 user
	/*
	 * Dùng Postman, phuong thức PUT, địa chỉ:
	 * http://localhost:8080/rest-api/apiUser/users/1 Chọn tab Body, chọn raw và đặt
	 * định dạng thành JSON. Nhập dữ liệu Send { "first_name": "Nguyen",
	 * "last_name": "Duc Nhat Update", "dob": "1990-01-01"
	 */
	@PUT
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, User updatedUser) {
		User existingUser = userDatabase.get(id);
		if (existingUser != null) {
			updatedUser.setId(id);
			userDatabase.put(id, updatedUser);
			return Response.ok("User with ID: " + id + " updated.").build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("User with ID: " + id + " not found.").build();
		}
	}

	// Endpoint: /api/users/{id} -> Xoá 1 user
	// Dùng Postman, phuong thức DELETE, địa chỉ:
	// http://localhost:8080/rest-api/apiUser/users/4
	// Send
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteUser(@PathParam("id") int id) {
		User removedUser = userDatabase.remove(id);
		if (removedUser != null) {
			return Response.ok("User with ID: " + id + " deleted.").build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("User with ID: " + id + " not found.").build();
		}
	}

	// Endpoint: /api/users -> Lấy danh sách người dùng
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getListPerson() {
		return new ArrayList<>(userDatabase.values());
	}
}

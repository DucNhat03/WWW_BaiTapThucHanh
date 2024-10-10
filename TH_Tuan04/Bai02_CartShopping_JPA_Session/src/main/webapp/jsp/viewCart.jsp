<%@ page import="java.util.List, model.CartItem"%>
<link rel="stylesheet" type="text/css" href="asset/style.css" />
<%
List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
%>
<div class="cart-container" >
	<table class="cart-table">
		<tr>
			<th>Product</th>
			<th>Quantity</th>
			<th>Price</th>
			<th></th>
		</tr>
		<%
		if (cart != null && !cart.isEmpty()) {
			for (CartItem item : cart) {
		%>
		<tr>
			<td><%=item.getProduct().getName()%></td>
			<td>
				<form action="updateCart" method="post">
					<input type="number" name="quantity"
						value="<%=item.getQuantity()%>" /> <input type="hidden"
						name="productId" value="<%=item.getProduct().getId()%>" /> <input
						type="submit" value="Update" class="btn-update" />
				</form>
			</td>
			<td>$<%=item.getProduct().getPrice() * item.getQuantity()%></td>
			<td>
				<form action="deleteFromCart" method="post">
					<input type="hidden" name="productId"
						value="<%=item.getProduct().getId()%>" /> <input type="submit"
						value="Delete" class="btn-delete" />
				</form>
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="4">Cart is empty</td>
		</tr>
		<%
		}
		%>
	</table>
</div>

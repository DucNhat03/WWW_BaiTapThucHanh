<%@ page import="java.util.List, model.Product"%>
<link rel="stylesheet" type="text/css" href="asset/style.css" />
<%
List<Product> products = (List<Product>) request.getAttribute("products");
if (products != null) {
%>
<div class="product-container">
	<table class="product-table">
		<tr>
			<th>Name</th>
			<th>Image</th>
			<th>Price</th>
			<th>Quantity</th>
			<th></th>
		</tr>
		<%
		for (Product product : products) {
		%>
		<tr>
			<td><%=product.getName()%></td>
			<td><img src="asset/images/<%=product.getImage()%>"
				alt="<%=product.getName()%>" width="100" height="100" /></td>
			<td><%=product.getQuantity()%></td>
			<td>$<%=product.getPrice()%></td>
			<td>
				<form action="addToCart" method="post">
					<input type="hidden" name="productId" value="<%=product.getId()%>" />
					<input type="submit" value="Add To Cart" class="btn-add-cart" />
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</div>

<%
} else {
%>
<p>No products available</p>
<%
}
%>

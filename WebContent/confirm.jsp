<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order_info</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bg1.css">

    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">



</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


<section id="cart_items">
	<div class="container">
		<div class="shopper-informations">
			<div class="col-sm-3">
				<div class="shopper-info">
					<p>Shopper Information</p>
					<table>
						<tr class="table-active">
							 <td class="table-active">User: </td>
							 <td class="table-active">&nbsp; </td>
							  <td class="table-active"> ${user.userName}</td>
						</tr>
						
						<tr class="table-active">
							 <td class="table-active">Email:</td>
							 <td class="table-active">&nbsp; </td>
							  <td class="table-active"> ${user.email}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	
				<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>

						</tr>
					</thead>
					<tbody>
					<c:forEach items="${order}" var="o" varStatus="varSta">
						<tr>
							<td class="cart_product">
								
							</td>
							<td class="cart_description">
								<p>${o.name }</p>
							</td>
							<td class="cart_price">
								<p>$ ${o.price}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">

									<p>${o.quantity }</p>

								</div>
							</td>

							<td class="cart_delete">
								
							</td>
						</tr>
					</c:forEach>

						<tr>
							<td colspan="2">Total</td>
							<td colspan="2" ><span>$ ${total}</span></td>
						</tr>
					</tbody>
					
					
					
					<tfoot>
					<tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <form action = productSelection.jsp >
	                        <button type="submit" class="btn btn-default">
	                        	
	                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
	                        </button>
                        </form>
                        </td>
					</tr>
					</tfoot>
					
					
				</table>
			</div>
	
</section>





<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
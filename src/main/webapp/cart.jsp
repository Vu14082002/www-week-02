<!DOCTYPE html>
<html lang="en">

<head>
	<jsp:include page="./template/head.jsp"/>
</head>
<body>
<jsp:include page="template/navbar-fix-top.jsp"/>
	<div class="container">
		<jsp:include page="template/navbar-inner.jsp"/>
		<div class="row">
			<div class="span12">
				<ul class="breadcrumb">
					<li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
					<li class="active">Check Out</li>
				</ul>
				<div class="well well-small">
					<h1>Check Out <small class="pull-right"> 2 Items are in the cart </small></h1>
					<hr class="soften" />

					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Product</th>
								<th>Description</th>
								<th> Ref. </th>
								<th>Avail.</th>
								<th>Unit price</th>
								<th>Qty </th>
								<th>Total</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img width="100" src="assets/img/e.jpg" alt=""></td>
								<td>Items name here<br>Carate : 22<br>Model : n/a</td>
								<td> - </td>
								<td><span class="shopBtn"><span class="icon-ok"></span></span> </td>
								<td>$50.00</td>
								<td>
									<input class="span1" style="max-width:34px" placeholder="1" id="appendedInputButtons" size="16"
										type="text" value="2">
									<div class="input-append">
										<button class="btn btn-mini" type="button">-</button><button class="btn btn-mini" type="button"> +
										</button><button class="btn btn-mini btn-danger" type="button"><span
												class="icon-remove"></span></button>
									</div>
								</td>
								<td>$100.00</td>
							</tr>
							<tr>
								<td><img width="100" src="assets/img/f.jpg" alt=""></td>
								<td>Item names and brief details<br>Carate:24 <br>Model:HBK24</td>
								<td> - </td>
								<td><span class="shopBtn"><span class="icon-ok"></span></span> </td>
								<td>$348.42</td>
								<td>
									<input class="span1" style="max-width:34px" placeholder="1" size="16" type="text">
									<div class="input-append">
										<button class="btn btn-mini" type="button">-</button><button class="btn btn-mini"
											type="button">+</button><button class="btn btn-mini btn-danger" type="button"><span
												class="icon-remove"></span></button>
									</div>
								</td>
								<td>$348.42</td>
							</tr>
							<tr>
								<td colspan="6" class="alignR">Total products: </td>
								<td class="label label-primary"> $448.42</td>
							</tr>
						</tbody>
					</table><br />
					<a href="index.jsp" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
					<a href="#" class="shopBtn btn-large pull-right">Next <span class="icon-arrow-right"></span></a>
				</div>
			</div>
		</div>
		<!-- 
Clients 
-->

	</div>
	<!-- /container -->


	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
	<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="assets/js/shop.js"></script>
</body>

</html>
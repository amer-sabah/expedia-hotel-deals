<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

<title>Hotel Deals</title>
</head>
<body>
	<br />
	<div class="container">

		<div class="row">
			<div class="col-md-12"></div>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100" src="https://i.imgur.com/ajO7ZFv.jpg" alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="https://i.imgur.com/oTmbOp5.jpg" alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" src="https://i.imgur.com/IM8aamf.jpg" alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
					</a>
				</div>

			</div>
			<div class="col-md-7">
				<form action="" method="post">

					<div class="form-group">
						<label for="inputAddress">Where do you want to go?</label> <input type="text" class="form-control" id="destinationName" name="destinationName" placeholder="Miami" value="${destinationName}" />
					</div>
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="startDate">Looking from</label> <input type="date" class="form-control" id="startDate" name="startDate" value="${startDate}" />
						</div>
						<div class="form-group col-md-5">
							<label for="endDate">to</label> <input type="date" class="form-control" id="endDate" name="endDate" value="${endDate}" />
						</div>
						<div class="form-group col-md-2">
							<label for="days">Days</label> <input type="number" class="form-control" id="days" name="days" placeholder="3 days" value="${days}" />
						</div>
					</div>

					<div class="form-group">
						<label for="rating">Rating (1 >>>> 5)</label> <input type="range" class="form-control" id="rating" name="rating" min="1" max="5" value="${rating}" />
					</div>

					<div class="form-group text-right">
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</form>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="list-group">

					<c:if test="${empty hotelOffers.size()}">
						<div class="alert alert-warning" role="alert">
							Sorry, we could not found offers based on your filters. <a href="/" class="alert-link">Try again</a>
						</div>
					</c:if>
					<c:forEach var="hotelOffer" items="${hotelOffers}">

						<a href="${hotelOffer.hotelUrls.decodedHotelInfositeUrl }" class="list-group-item list-group-item-action flex-column align-items-start" target="_blank">

							<div class="row">
								<div class="col-md-2">
									<img src="${hotelOffer.hotelInfo.hotelImageUrl }" alt="" border="0" height="100" width="130" style="max-width: 130px;">
								</div>
								<div class="col-md-10">
									<div class="d-flex w-100 justify-content-between">

										<h5 class="mb-1">${hotelOffer.hotelInfo.hotelName }</h5>
										<span"><del>${hotelOffer.hotelPricingInfo.crossOutPriceValue}</del> <b>${hotelOffer.hotelPricingInfo.averagePriceValue } ${hotelOffer.hotelPricingInfo.currency}</b></span>


									</div>
									<div class="d-flex w-100 justify-content-between">
										<span></span> <small>Rating: ${hotelOffer.hotelInfo.hotelStarRating }</small>
									</div>
									<p class="mb-1">${hotelOffer.destination.longName }</p>
									<small>${hotelOffer.offerDateRange.travelStartDate } - ${hotelOffer.offerDateRange.travelEndDate } <b>(${hotelOffer.offerDateRange.lengthOfStay } days)</b></small>
								</div>
							</div>
						</a>

					</c:forEach>


				</div>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

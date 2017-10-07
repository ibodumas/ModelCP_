$(document).ready(function() 
{
	$("#textonImage").attr('href',  window.location.href);
	
	$('#getStockValue').click(function() 
	{
		var symb = $("#symbol").val();
		$.getJSON("http://query.yahooapis.com/v1/public/yql?callback=?", {
					q : "select * from yahoo.finance.quote where symbol='" + symb + "'",
					format : 'json',
					diagnostics : true,
					env : 'store://datatables.org/alltableswithkeys'}).done(function(data) {
					$('#value').text(data.query.results.quote.LastTradePriceOnly);
					
					$('#dayHigh').text(data.query.results.quote.DaysHigh);
					$('#dayLow').text(data.query.results.quote.DaysLow);
					$('#yearHigh').text(data.query.results.quote.YearHigh);
					$('#yearLow').text(data.query.results.quote.YearLow);
					
					}).fail(function(jqXHR, textStatus, errorThrown) {
					alert("error " + textStatus);
					alert("incoming Text " + jqXHR.responseText);
				});
	});
	
	$('#getFxRate').click(function() 
			{
				var frmRate = $("#frmRate").val();
				var toRate = $("#toRate").val();
				
				$.getJSON("http://query.yahooapis.com/v1/public/yql?callback=?", {
							q : "select * from yahoo.finance.xchange where pair='" + frmRate + " " + toRate + "'",
							format : 'json',
							diagnostics : true,
							env : 'store://datatables.org/alltableswithkeys'}).done(function(data) {
							$('#value').text(data.query.results.rate.Rate);
							
							}).fail(function(jqXHR, textStatus, errorThrown) {
							alert("error " + textStatus);
							alert("incoming Text " + jqXHR.responseText);
						});
			});
	
	$('#getStatus').click(function() 
			{
				var airport = $("#airport").val();
				//var data = null;
				//alert(airport);
				//http://services.faa.gov/airport/status/ORD?format=application/json
				$.getJSON("http://services.faa.gov/airport/status/" + airport + "?format=application/json").done(function(data) {
							$('#delay').text(data.delay);
							$('#city').text(data.city);
							$('#state').text(data.state);
							$('#name').text(data.name);
							$('#temp').text(data.weather.temp);
							$('#wind').text(data.weather.wind);
							$('#status').text(data.status.reason);
							$('#time').text(data.weather.meta.updated);
							$('#credit').text(data.weather.meta.credit);
							//alert(JSON.stringify(data));
							//alert(data.delay);
							
							}).fail(function(jqXHR, textStatus, errorThrown) {
							alert("Kindly input a valid US airport code");
							//alert("incoming Text " + jqXHR.responseText);
						});
			});
	
	$('#reset').click(function() 
	{
		$("#airport").val("");
		$('#delay').text("");
		$('#city').text("");
		$('#state').text("");
		$('#name').text("");
		$('#temp').text("");
		$('#wind').text("");
		$('#status').text("");
		$('#time').text("");
		$('#credit').text("");
	});
});


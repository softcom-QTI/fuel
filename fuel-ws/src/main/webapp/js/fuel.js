Fuel = {};

Fuel.init = function() {
	$.getJSON("ws/refill/all", function(data, status, xhr) {
	
		$.each(data, function() {
			jsDate = new Date(this.date);
			html = "<tr>";
			html += "<td>" + this.id + "</td>";
			html += "<td>" + this.tankerId + "</td>";
			html += "<td>" + this.machineId + "</td>";
			html += "<td>" + this.liters + "</td>";
			html += "<td>" + $.format.date(jsDate, "dd.MM.yyyy HH:mm:ss") + "</td>";
			html += "</tr>";
			row = $(html);
			$("#flexme").append(row);
		});
		
		$("#loading-header").hide();
		$("#loading-content").hide();
		
		$("#flexme").flexigrid({
			resizable: false,
			title: 'Données disponibles',
			colModel: [
			    {display: 'ID', name: 'id', width: 85, sortable : false, align: 'left'},
			    {display: 'Camion Citerne', name: 'tankerId', width: 220, sortable : true, align: 'left'},
			    {display: 'Machine cible', name: 'machineId', width: 220, sortable : true, align: 'left'},
			    {display: 'Nb de litres', name: 'liters', width: 120, sortable : true, align: 'right'},
			    {display: 'Date', name: 'date', width: 220, sortable : true, align: 'center'}
			],
			height: 400
		});
		
	});
}
function MostrarFecha() {
	
	var nombres_dias = new Array("Dom", "Lun", "Mar", "Mie",
			"Jue", "Vie", "Sab");
	var nombres_meses = new Array("Ene", "Feb", "Mar", "Abr", "May",
			"Jun", "Jul", "Ago", "Sep", "Oct", "Nov",
			"Dic");

	var fecha_actual = new Date();

	var dia_mes = fecha_actual.getDate();
	var dia_semana = fecha_actual.getDay();
	var mes = fecha_actual.getMonth() + 1;
	var anio = fecha_actual.getFullYear();

	
	document.getElementById("spanfecha").innerHTML=nombres_dias[dia_semana] + ", " + dia_mes + " de "
	+ nombres_meses[mes - 1] + " de " + anio;
}


var RelojID24 = null;
var RelojEjecutandose24 = false;

function DetenerReloj24() {
	if (RelojEjecutandose24)
		;
	clearTimeout(RelojID24);
	RelojEjecutandose24 = false;
}

function MostrarHora24() {
	
	MostrarFecha();
	
	var ahora = new Date();
	var horas = ahora.getHours();
	var minutos = ahora.getMinutes();
	var segundos = ahora.getSeconds();
	var ValorHora;

	if (horas < 10)
		ValorHora = "0" + horas;
	else
		ValorHora = "" + horas;

	if (minutos < 10)
		ValorHora += ":0" + minutos;
	else
		ValorHora += ":" + minutos;

	if (segundos < 10)
		ValorHora += ":0" + segundos;
	else
		ValorHora += ":" + segundos;

	document.getElementById("spanreloj").innerHTML = ValorHora;

	RelojID24 = setTimeout("MostrarHora24()", 1000);
	
	RelojEjecutandose24 = true;
}

function IniciarReloj24() {
	DetenerReloj24();
	MostrarHora24();
}

window.onload = IniciarReloj24;
if (document.captureEvents) {
	document.captureEvents(Event.LOAD);
}

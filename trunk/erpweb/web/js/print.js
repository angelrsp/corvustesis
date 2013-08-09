function printFactura()
{
	var table=document.getElementById('viewTab:form:detail_data');
	var rows =table.getElementsByTagName('tr');
	var cells=rows[0].getElementsByTagName('td');
    alert(cells[0].value);
    alert(cells[1].innerHTML);
    alert(cells[2].innerHTML);
    alert(cells[3].innerHTML);
    alert(cells[4].innerHTML);
    alert(cells[5].innerHTML);
    alert(cells[6].value);
    
    var cells2=rows[1].getElementsByTagName('td');
    alert(cells2[0].value);
    alert(cells2[1].innerHTML);
    alert(cells2[2].innerHTML);
    alert(cells2[3].innerHTML);
    alert(cells2[4].innerHTML);
    alert(cells2[5].innerHTML);
    alert(cells2[6].value);
    
	//window.print();
}
function exportChart() {
    //export image
        
    var print = window.open('', 'Imprimir', 'left=0,top=0,border=0,status=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,resizable=yes');    
    
    $('#contenido\\:outline').empty().append(PF('lineChartSub').exportAsImage());
   
    $('#contenido\\:outsampledush').empty().append(PF('sampleDashSub').exportAsImage());	

    print.window.document.writeln('<div align="center">');
	print.window.document.writeln(document.getElementById("contenido:outline").innerHTML);
	print.window.document.writeln('</div>');

    print.window.document.writeln('<div align="center">');
	print.window.document.writeln(document.getElementById("contenido:outsampledush").innerHTML);
	print.window.document.writeln('</div>');

	print.window.document.writeln('<div align="center">');
	print.window.document.writeln('<table>');
	print.window.document.writeln(document.getElementById("contSub").innerHTML);
	print.window.document.writeln('</table>');
	print.window.document.writeln('</div>');
	
	print.document.close();
	print.print();
	print.close();


    $('#contenido\\:outpie').empty();
    $('#contenido\\:outline').empty();
    $('#contenido\\:outsampledush').empty();	
	
}

function printSuper() {
    //export image
        
    var print = window.open('', 'Imprimir', 'left=0,top=0,border=0,status=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,resizable=yes');    

    $('#contenido\\:outpie').empty().append(PF('pieChart').exportAsImage());
    
    $('#contenido\\:outline').empty().append(PF('lineChart').exportAsImage());
   
    $('#contenido\\:outsampledush').empty().append(PF('sampleDash').exportAsImage());	


    print.window.document.writeln('<div align="center">');
	print.window.document.writeln(document.getElementById("contenido:outpie").innerHTML);
	print.window.document.writeln('</div>');
    

    print.window.document.writeln('<div align="center">');
	print.window.document.writeln(document.getElementById("contenido:outline").innerHTML);
	print.window.document.writeln('</div>');

    print.window.document.writeln('<div align="center">');
	print.window.document.writeln(document.getElementById("contenido:outsampledush").innerHTML);
	print.window.document.writeln('</div>');
	
	print.window.document.writeln('<div align="center">');
	print.window.document.writeln('<table>');
	print.window.document.writeln(document.getElementById("contRep").innerHTML);
	print.window.document.writeln('</table>');
	print.window.document.writeln('</div>');
	
	print.document.close();
	print.print();
	print.close();

    $('#contenido\\:outpie').empty();
    $('#contenido\\:outline').empty();
    $('#contenido\\:outsampledush').empty();	
	
}


function printLogical() {
    //export image
        
    var print = window.open('', 'Imprimir', 'left=0,top=0,border=0,status=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,resizable=yes');    

   
    $('#contenido\\:outsampledush').empty().append(PF('sampleDash2').exportAsImage());	


    print.window.document.writeln('<div align="center">');
	print.window.document.writeln(document.getElementById("contenido:outsampledush").innerHTML);
	print.window.document.writeln('</div>');
	
	print.window.document.writeln('<div align="center">');
	print.window.document.writeln('<table>');
	print.window.document.writeln(document.getElementById("contLogical").innerHTML);
	print.window.document.writeln('</table>');
	print.window.document.writeln('</div>');
	
	print.document.close();
	print.print();
	print.close();

    $('#contenido\\:outpie').empty();
    $('#contenido\\:outline').empty();
    $('#contenido\\:outsampledush').empty();	

}
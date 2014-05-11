function isNumberKey(evt) {
	
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	//37  39
	
	if (charCode > 31 && (charCode < 48 || charCode > 57))
	{
		if(charCode==37||charCode==39)
			return true;
		return false;
	}	
	return true;
}

function isDecimalKey(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    //37  39
    if (charCode > 31 && (charCode < 48 || charCode > 57))
    {
            if(charCode==37||charCode==39||charCode==46||charCode==44)
                    return true;
            return false;
    }
    return true;
}

function isSpace(e)
{
	t=(document.all)?e.keyCode:e.which;
	return (t!=32);	
}

function isCedula(valor) {
	cedula = valor.value;
	array =cedula.split('');
	var num=array.length;
	if(num==10)
	{
		total=0;
		digito=(array[9]*1);
		var i;
		for(i=0;i<(num-1);i++)
		{
			if((i%2)!=0)
			{
				total=total+(array[i]*1);
			}
			else
			{
				mult=array[i]*2;
				if(mult>9)
					total=total+(mult-9);
				else
					total=total+mult;
			}
		}
		decena=total/10;
		decena=Math.floor(decena);
		decena=(decena+1)*10;
		final1=(decena-total);
		if((final1==10 && digito==0)||(final1==digito))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	else
	{
		alert('El número de la cédula debe tener 10 digitos');
		return false;
	}
}


function isLetter(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    
    letras = "�����abcdefghijklmn�opqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false;
    for(var i in especiales){
         if(key == especiales[i]){
             tecla_especial = true;
             break;
         }
     }

     if(letras.indexOf(tecla)==-1 && !tecla_especial){
         return false;
     }
 }


function isAlphaNum(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    
    letras = "�����abcdefghijklmn�opqrstuvwxyz1234567890";
    especiales = "8-37-39-46";

    tecla_especial = false;
    for(var i in especiales){
         if(key == especiales[i]){
             tecla_especial = true;
             break;
         }
     }

     if(letras.indexOf(tecla)==-1 && !tecla_especial){
         return false;
     }
 }

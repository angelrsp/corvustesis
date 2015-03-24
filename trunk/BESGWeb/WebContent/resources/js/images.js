
$(function() {
  var imagenes = ['fondo001.jpg', 'fondo002.jpg', 'fondo003.jpg', 'fondo004.jpg', 'fondo005.jpg', 'fondo006.jpg','fondo007.jpg','fondo008.jpg'];
  $('body').css({'background-image': 'url(/BESGWeb/resources/img/' + imagenes[Math.floor(Math.random() * imagenes.length)] + ')'});

});
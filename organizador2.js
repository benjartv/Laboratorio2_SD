var request = require('request');


tipoOrdenamiento= process.argv[2];
ws = process.argv[3];
var flag = false;
var cantidad;

var fs = require('fs');
var datos;
var string1 = "";
var string2 = "";
var string3 = "";
var string4 = "";
var string5 = "";
fs.readFile('datafile.txt', 'utf8', function(err, data) {
    if( err ){
        console.log(err)
    }
    else{
        datos = data.split("\n");
        cantidad = datos.length / ws;

        if (ws == 1){
          for (var i = 0; i < cantidad; i++) {
            if (i != cantidad-1){
              string1 = string1 + datos[i]+ ';';
            }
            else{
              string1 = string1 + datos[i];
              
            }  
          };
          django(tipoOrdenamiento, string1);
        }

        if (ws == 2){
          for (var i = 0; i < cantidad; i++) {
            if (i != cantidad-1){
              string1 = string1 + datos[i]+ ';';
            }
            else{
              string1 = string1 + datos[i];
              
            }  
          };
          django(tipoOrdenamiento, string1);
          for (var j = cantidad; j < (cantidad*2); j++) {
            if (j != cantidad*2-1){
              string2 = string2 + datos[j]+ ';';
            }
            else{
              string2 = string2 + datos[j];
              
            }  
          };
          rails(tipoOrdenamiento, string2);
        }

        if(ws == 3){
          for (var i = 0; i < cantidad; i++) {
            if (i != cantidad-1){
              string1 = string1 + datos[i]+ ';';
            }
            else{
              string1 = string1 + datos[i];
              
            }  
          };
          django(tipoOrdenamiento, string1);

        for (var j = cantidad; j < (cantidad*2); j++) {
          if (j != cantidad*2-1){
            string2 = string2 + datos[j]+ ';';
          }
          else{
            string2 = string2 + datos[j];
            
          }  
        };
          rails(tipoOrdenamiento, string2);

        for (var x = cantidad*2; x < cantidad*3; x++) {
          if (x != cantidad*3-1){
            string3 = string3 + datos[x]+ ';';
          }
          else{
            string3 = string3 + datos[x];
            }
        };
          java(tipoOrdenamiento, string3)
        }
        if(ws == 4){
          for (var i = 0; i < cantidad; i++) {
          if (i != cantidad-1){
            string1 = string1 + datos[i]+ ';';
          }
          else{
            string1 = string1 + datos[i];
            
          }  
        };
        django(tipoOrdenamiento, string1);

        for (var j = cantidad; j < (cantidad*2); j++) {
          if (j != cantidad*2-1){
            string2 = string2 + datos[j]+ ';';
          }
          else{
            string2 = string2 + datos[j];
            
          }  
        };
        rails(tipoOrdenamiento, string2);

        for (var x = cantidad*2; x < cantidad*3; x++) {
          if (x != cantidad*3-1){
            string3 = string3 + datos[x]+ ';';
          }
          else{
            string3 = string3 + datos[x];
            }
        };
        java(tipoOrdenamiento, string3);

        for (var z = cantidad*3; z < cantidad*4; z++) {
          if (z != cantidad*4-1){
            string4 = string4 + datos[z]+ ';';
          }
          else{
            string4 = string4 + datos[z];
            
          }  
        };
        php(tipoOrdenamiento, string4);
        }
        if(ws==5){
        for (var i = 0; i < cantidad; i++) {
          if (i != cantidad-1){
            string1 = string1 + datos[i]+ ';';
          }
          else{
            string1 = string1 + datos[i];
            
          }  
        };
        django(tipoOrdenamiento, string1);

        for (var j = cantidad; j < (cantidad*2); j++) {
          if (j != cantidad*2-1){
            string2 = string2 + datos[j]+ ';';
          }
          else{
            string2 = string2 + datos[j];
            
          }  
        };
        rails(tipoOrdenamiento, string2);

        for (var x = cantidad*2; x < cantidad*3; x++) {
          if (x != cantidad*3-1){
            string3 = string3 + datos[x]+ ';';
          }
          else{
            string3 = string3 + datos[x];
            }
        };
        java(tipoOrdenamiento, string3);

        for (var z = cantidad*3; z < cantidad*4; z++) {
          if (z != cantidad*4-1){
            string4 = string4 + datos[z]+ ';';
          }
          else{
            string4 = string4 + datos[z];
            
          }  
        };
        php(tipoOrdenamiento, string4);

        for (var q = cantidad*4; q < datos.length; q++) {
          if (q != datos.length-1){
            string5 = string5 + datos[q]+ ';';
          }
          else{
            string5 = string5 + datos[q];
          }  
        };
        puntoNet(tipoOrdenamiento, string5);
      }
        //console.log(string1);
    }
    //console.log(datos);
});



function rails(metodo, entrada){
  //Colocar la URL correspondiente al Web Service de Ruby on Rails
  request.post('http://localhost:3000/'+metodo,{form:{str:entrada}},function(err,httpResponse,body){
    console.log("RAILS ")
    resp = body.substr(1,body.length-2).split(",");
    for(var i = 0 ;i < resp.length; i++){
       resp[i] = parseFloat(resp[i]);
    }
    console.log(resp);
  })
}

function puntoNet(metodo, entrada){
  //Colocar la URL correspondiente al Web Service .NET
  request.post('http://localhost:7000/OrdenarC.asmx/'+metodo,{form:{numeros:entrada, opcion:1}},function(err,httpResponse,body){
    resp = body.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<string xmlns=\"http://tempuri.org/\">","").replace(";</string>","")
    resp = resp.split(";");
    for(var i = 0 ;i < resp.length; i++)
    {
       resp[i] = parseFloat(resp[i]);
    }
    console.log(".NET ");
    console.log(resp)
  })
}


function php(metodo,entrada){
  //Colocar la URL correspondiente a los metodos de PHP
  request.post('http://localhost/~MacBookPro/Laboratorio2_SD/PHP/'+metodo+'.php',{form:{numeros:entrada}},function(err,httpResponse,body){
    console.log("PHP ");
    resp = body.substr(1,body.length-2).split(",");
    for(var i = 0 ;i < resp.length; i++){
       resp[i] = parseFloat(resp[i].substr(1,resp[i].length-2));
    }
    console.log(resp);
  })
}

function java(metodo, entrada){
  //Colocar la URL correspondiente al la Aplicación Web de JAVA
  request.post('http://localhost:8080/ServidorJavaWeb/'+metodo,{form:{entrada:entrada}},function(err,httpResponse,body){
    console.log("JAVA ");
    resp = body.substr(0,body.length-1).split(";");
    for(var i = 0 ;i < resp.length; i++){
       resp[i] = parseFloat(resp[i]);
    }
    console.log(resp);
  })
}

function django(metodo, entrada){
  //Colocar la URL correspondiente al Web Service de Python Django
  request.post('http://localhost:8000/'+metodo,{form:{str:entrada}},function(err,httpResponse,body){
    console.log("Django ");
    resp = body.substr(1,body.length-2).split(",");
    for(var i = 0 ;i < resp.length; i++){
       resp[i] = parseFloat(resp[i]);
    }
    console.log(resp);
  })
}

//console.log(string1);
//rails(tipoOrdenamiento, string1);

// php(tipoOrdenamiento, "11.2;21.3;6.3;1.6");
// puntoNet(tipoOrdenamiento,"11.2;21.3;6.3;1.6");
// rails(tipoOrdenamiento, "11.2;21.3;6.3;1.6");
// django(tipoOrdenamiento, "11.2;21.3;6.3;1.6");
// java(tipoOrdenamiento, "11.2;21.3;6.3;1.6");









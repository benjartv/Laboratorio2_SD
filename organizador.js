var request = require('request');


tipoOrdenamiento= process.argv[2];

var fs = require('fs');
var datos;
fs.readFile('datafile.txt', 'utf8', function(err, data) {
    if( err ){
        console.log(err)
    }
    else{
        datos = data.split("\n");
    }
    console.log(datos);
});



function rails(metodo, entrada){
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
  request.post('http://localhost/~MacBookPro/api-php/'+metodo+'.php',{form:{numeros:entrada}},function(err,httpResponse,body){
    console.log("PHP ");
    resp = body.substr(1,body.length-2).split(",");
    for(var i = 0 ;i < resp.length; i++){
       resp[i] = parseFloat(resp[i].substr(1,resp[i].length-2));
    }
    console.log(resp);
  })
}

function java(metodo, entrada){
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
  request.post('http://localhost:8000/'+metodo,{form:{str:entrada}},function(err,httpResponse,body){
    console.log("Djanguito ");
    resp = body.substr(1,body.length-2).split(",");
    for(var i = 0 ;i < resp.length; i++){
       resp[i] = parseFloat(resp[i]);
    }
    console.log(resp);
  })
}


php(tipoOrdenamiento, "11.2;21.3;6.3;1.6");
puntoNet(tipoOrdenamiento,"11.2;21.3;6.3;1.6");
rails(tipoOrdenamiento, "11.2;21.3;6.3;1.6");
django(tipoOrdenamiento, "11.2;21.3;6.3;1.6");
java(tipoOrdenamiento, "11.2;21.3;6.3;1.6");







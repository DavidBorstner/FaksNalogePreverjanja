var objekti = [];

function zac() {
  for(var i = 0; i<10;i++){
    var iks = Math.floor(Math.random() * 970 +15);
    var ips = Math.floor(Math.random() * 620 + 15);
    var v = Math.floor(Math.random() * 5 +5);
    objekti.push({x: iks, y: ips, r:15, vx: v, vy: v});
  }
}
window.onload = zac;

function preberi(){
  var stevila = document.getElementById("stevilo").value;
  
  if(objekti.length < stevila){
    for(var i = objekti.length; i<stevila;i++){
      var iks = Math.floor(Math.random() * 970 +15);
      var ips = Math.floor(Math.random() * 620 + 15);
      var v = Math.floor(Math.random() * 5 +5);
      objekti.push({x: iks, y: ips, r:15, vx: v, vy: v});
    }
  }
  if(objekti.length > stevila){
    for(var i = objekti.length; i > stevila;i--){
      objekti.pop();
    }
  }
  console.log(objekti.length);
}

function desetzog(){
  if(objekti.length < 10){
    for(var i = objekti.length; i<10;i++){
      var iks = Math.floor(Math.random() * 970 +15);
      var ips = Math.floor(Math.random() * 620 + 15);
      var v = Math.floor(Math.random() * 5 +5);
      objekti.push({x: iks, y: ips, r:15, vx: v, vy: v});
    }
  }
  if(objekti.length > 10){
    for(var i = objekti.length; i > 10;i--){
      objekti.pop();
    }
  }
  console.log(objekti.length);
}

function dvazog(){
  if(objekti.length < 25){
    for(var i = objekti.length; i<25;i++){
      var iks = Math.floor(Math.random() * 970 +15);
      var ips = Math.floor(Math.random() * 620 + 15);
      var v = Math.floor(Math.random() * 5 +5);
      objekti.push({x: iks, y: ips, r:15, vx: v, vy: v});
    }
  }
  if(objekti.length > 25){
    for(var i = objekti.length; i > 25;i--){
      objekti.pop();
    }
  }
  console.log(objekti.length);
}

function petzog(){
  if(objekti.length < 50){
    for(var i = objekti.length; i<50;i++){
      var iks = Math.floor(Math.random() * 970 +15);
      var ips = Math.floor(Math.random() * 620 + 15);
      var v = Math.floor(Math.random() * 5 +5);
      objekti.push({x: iks, y: ips, r:15, vx: v, vy: v});
    }
  }
  if(objekti.length > 50){
    for(var i = objekti.length; i > 50;i--){
      objekti.pop();
    }
  }
  console.log(objekti.length);
}

function stozog(){
  if(objekti.length < 100){
    for(var i = objekti.length; i<100;i++){
      var iks = Math.floor(Math.random() * 970 +15);
      var ips = Math.floor(Math.random() * 620 + 15);
      var v = Math.floor(Math.random() * 5 +5);
      objekti.push({x: iks, y: ips, r:15, vx: v, vy: v});
    }
  }
  if(objekti.length > 100){
    for(var i = objekti.length; i > 100;i--){
      objekti.pop();
    }
  }
  console.log(objekti.length);
}

function resetiraj(){
  var canvas = document.getElementById("myCanvas");
  var c = canvas.getContext("2d");

  c.fillStyle = "#FFFFFF";
  c.fillRect(0, 0, 1000, 650);
}

function risiKroge(xI,yI){
    var canvas = document.getElementById("myCanvas");
    var c = canvas.getContext("2d");

    c.fillStyle = "#000000";
    c.beginPath();
    c.arc(xI, yI, 15, 0, Math.PI * 2, true);
    c.fill();
}

function risi() {
  resetiraj();

  for (var i = 0; i < objekti.length; i++) {    
    var xI = objekti[i].x;
    var yI = objekti[i].y;

    var vyI = objekti[i].vy;
    var vxI = objekti[i].vx;

    if (yI + 15 + vyI > 650 || yI - 15 + vyI < 0) {
      objekti[i].vy = -vyI;
    }

    if (xI - 15 + vxI < 0 || xI + 15 + vxI > 1000) {
      objekti[i].vx = -vxI;
    }
    risiKroge(xI, yI);
    objekti[i].x = objekti[i].x + vxI;
    objekti[i].y = objekti[i].y + vyI;
  }
  requestAnimationFrame(risi);
}
requestAnimationFrame(risi);
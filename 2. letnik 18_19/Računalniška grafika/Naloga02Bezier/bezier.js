var kliki = 0;
var zadnji = [0, 0, 0, 0, 0, 0, 0, 0];
var stevec = 0;
var barva = "black";
var prejsna = [];

var stevecK = 1;
var dolzinaK = 1;
var krivulja = [];
var zlepljenke = [];
var krivulje = [];
var vozlisca = [];
var aproksimirana = [];
var pogoj = true;
var pogPremik = false;
var pogBrisi =false;

document.getElementById('canvas').addEventListener('click', sledi);

function brisi(){
    if(pogoj == true){
        document.getElementById("canvas").removeEventListener('click', sledi,false);
        pogoj = false;
        document.getElementById("ris").style.background='red';
    }
    if(pogPremik == true){
        pogPremik = false;
        document.getElementById('canvas').removeEventListener('mousemove', premik);
        document.getElementById("prem").style.background='red';
    }
    if(pogBrisi == false){
        pogBrisi = true;
        document.getElementById('canvas').addEventListener('click', brisanje);
        document.getElementById("bris").style.background='green';
    }
    kliki = 0;
    zadnji = [0, 0, 0, 0, 0, 0, 0, 0];
    stevec = 0;
    zlepljenke.push(krivulja);
    console.log(zlepljenke[0][0]);
    stevecK++;
    krivulja = [];
    dolzinaK = 1;
    prejsna = [];
}

function koordinate(e) {
    var x;
    var y;

    if (e.pageX != undefined && e.pageY != undefined) {
        x = e.pageX;
        y = e.pageY;
    } else {
        x = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
        y = e.clientY + document.body.scrollTop + document.documentElement.scrollTop;
    }
    
    return [x, y];
}

function onemogoci(){
    if(pogoj == true){
        document.getElementById("canvas").removeEventListener('click', sledi,false);
        document.getElementById('canvas').removeEventListener('click', brisanje);
        pogoj = false;
        console.log("onemogoceno");
        document.getElementById('canvas').addEventListener('mousemove', premik);
        document.getElementById("prem").style.background='green';
        document.getElementById("ris").style.background='red';
        document.getElementById("bris").style.background='red';
        pogBrisi = false;
        pogPremik = true;

    }else{
        if(pogBrisi == true){
            pogBrisi = false;
            document.getElementById('canvas').removeEventListener('click', brisanje);
            document.getElementById('canvas').addEventListener('mousemove', premik);
            document.getElementById("prem").style.background='green';
            document.getElementById("ris").style.background='red';
            document.getElementById("bris").style.background='red';
        }
    }
    
}

function omogoci(){
    if(pogoj == false){
        document.getElementById('canvas').addEventListener('click', sledi);
        document.getElementById('canvas').removeEventListener('click', brisanje);
        pogoj = true;
        console.log("omogoceno test");
        document.getElementById('canvas').removeEventListener('mousemove', premik);
        pogBrisi = false;
        pogPremik = false;
        document.getElementById("prem").style.background='red';
        document.getElementById("ris").style.background='green';
        document.getElementById("bris").style.background='red';
    }else{
        console.log("je že omogoceno");
        document.getElementById('canvas').removeEventListener('click', brisanje);
    }
}

function sledi(e) {
    context = this.getContext('2d');

    x = koordinate(e)[0] - this.offsetLeft;
    y = koordinate(e)[1] - this.offsetTop;

    // risi krogce in kvadrate
    if(kliki == 0 || kliki == 3){
        context.strokeStyle = "black";
        context.fillRect(x-4,y-4,8,8);
        var rec = [x,y];
        vozlisca.push(rec);
        context.stroke();
        context.strokeStyle = barva;
    }else{
        context.strokeStyle = "black";
        context.beginPath();
        var krog = [x,y];
        aproksimirana.push(krog);
        context.arc(x,y,2,0,2*Math.PI);
        console.log(aproksimirana);
        context.fillStyle = "black";
        context.fill();
        context.stroke();
        context.strokeStyle = barva;
    }
    
    if (stevec == 6) {
        zadnji[stevec] = x;
        stevec ++;
        zadnji[stevec] = y;
        stevec ++;

        if(!krivulja.length){
            krivulja[0] = stevecK + ".krivulja";
            krivulja[1] = zadnji[0];
            krivulja[2] = zadnji[1];
            krivulja[3] = dolzinaK;
        }else{
            krivulja[3]++;
        }

        if(prejsna == [zadnji[0],zadnji[1]]){
            var rec = [x,y];
            vozlisca.push(rec);
        }

        // preda koordinate v bezierja za izris
        risiBezier(zadnji[0],zadnji[1],zadnji[2],zadnji[3],zadnji[4],zadnji[5],zadnji[6],zadnji[7]);

        var koo = [zadnji[0],zadnji[1],zadnji[2],zadnji[3],zadnji[4],zadnji[5],zadnji[6],zadnji[7]];
        krivulje.push(koo);

        kliki = 0;
        stevec = 2;
        prejsna = [zadnji[0],zadnji[1]];

        //krivulje = krivulje.concat(zadnji);
        zadnji = [zadnji[6],zadnji[7],0,0,0,0,0,0];
    } else {
        zadnji[stevec] = x;
        stevec ++;
        zadnji[stevec] = y;
        stevec ++;
    }
    
    kliki++;
    
};

function novaKrivulja(){
    kliki = 0;
    zadnji = [0, 0, 0, 0, 0, 0, 0, 0];
    stevec = 0;
    zlepljenke.push(krivulja);
    console.log(zlepljenke[0][0]);
    stevecK++;
    krivulja = [];
    dolzinaK = 1;
    prejsna = [];

    document.getElementById("prem").style.background='red';
    document.getElementById("ris").style.background='green';
    document.getElementById("bris").style.background='red';

    if(pogoj == false){
        document.getElementById('canvas').addEventListener('click', sledi);
        pogoj = true;
        console.log("omogoceno");
        document.getElementById('canvas').removeEventListener('mousemove', premik);

    }else{
        console.log("je že omogoceno");
    }
}


function SpremeniBarvo(){
    context = document.getElementById('canvas').getContext('2d');
    var e = document.getElementById("barve");
    barva = e.options[e.selectedIndex].text;
    context.strokeStyle = barva;
    context.clearRect(0, 0, canvas.width, canvas.height);

    for(var i = 0; i< krivulje.length;i++){
        risiBezier(krivulje[i][0],krivulje[i][1],krivulje[i][2],krivulje[i][3],krivulje[i][4],krivulje[i][5],krivulje[i][6],krivulje[i][7]);
    }


    for(var i = 0; i< aproksimirana.length;i++){
        context.strokeStyle = "black";
        context.beginPath();
        context.arc(aproksimirana[i][0],aproksimirana[i][1],2,0,2*Math.PI);
        context.fillStyle = "black";
        context.fill();
        context.stroke();
        context.strokeStyle = barva;
        
    }

    
    for(var i = 0; i< vozlisca.length;i++){
        context.strokeStyle = "black";
        context.fillRect(vozlisca[i][0]-4,vozlisca[i][1]-4,8,8);
        context.stroke();
        context.strokeStyle = barva;
    }
}


function bezier(t, p0, p1, p2, p3){
    var cX = 3 * (p1.x - p0.x),
        bX = 3 * (p2.x - p1.x) - cX,
        aX = p3.x - p0.x - cX - bX;
          
    var cY = 3 * (p1.y - p0.y),
        bY = 3 * (p2.y - p1.y) - cY,
        aY = p3.y - p0.y - cY - bY;
          
    var x = (aX * Math.pow(t, 3)) + (bX * Math.pow(t, 2)) + (cX * t) + p0.x;
    var y = (aY * Math.pow(t, 3)) + (bY * Math.pow(t, 2)) + (cY * t) + p0.y;
          
    return {x: x, y: y};
}



function risiBezier( x1,y1, x2,y2, x3,y3, x4,y4){
    context = document.getElementById('canvas').getContext('2d');
    var p0 = {x: x1, y: y1}
    var p1 = {x: x2, y: y2}
    var p2 = {x: x3, y: y3}
    var p3 = {x: x4, y: y4}
    document.body.appendChild(context.canvas);
    context.beginPath();
    context.moveTo(p0.x, p0.y);
    for (var i=0; i<1; i+=0.01){
       var p = bezier(i, p0, p1, p2, p3);
       context.lineTo(p.x, p.y);
    }
    context.lineTo(x4,y4);
    context.stroke();
}


function premik(e){
    var x = koordinate(e)[0] - this.offsetLeft;
    var y = koordinate(e)[1] - this.offsetTop;
    for(var i = 0; i<vozlisca.length;i++){
        var xV = vozlisca[i][0];
        var yV = vozlisca[i][1];
        var xa = x - xV;
        var ya = y - yV;
        if(xa < 0){
            xa = xa * -1;
        }
        if(ya < 0){
            ya = ya * -1;
        }

        if(xa <= 25  && ya <= 25){
            if (e.which == 1) {
                    x = koordinate(e)[0] - this.offsetLeft;
                    y = koordinate(e)[1] - this.offsetTop;
                    context = document.getElementById('canvas').getContext('2d');
                    context.clearRect(0, 0, canvas.width, canvas.height);



                    for(var j = 0;j< krivulje.length;j++){
                        if(krivulje[j][0] == vozlisca[i][0] &&  krivulje[j][1] == vozlisca[i][1]){
                            krivulje[j][0] = x;
                            krivulje[j][1] = y;
                        }
                        if(krivulje[j][6] == vozlisca[i][0] &&  krivulje[j][7] == vozlisca[i][1]){
                            krivulje[j][6] = x;
                            krivulje[j][7] = y;
                        }
                        risiBezier(krivulje[j][0],krivulje[j][1],krivulje[j][2],krivulje[j][3],krivulje[j][4],krivulje[j][5],krivulje[j][6],krivulje[j][7]);
                    }
                
                
                    for(var j = 0;j< aproksimirana.length;j++){
                        context.strokeStyle = "black";
                        context.beginPath();
                        context.arc(aproksimirana[j][0]-4,aproksimirana[j][1]-4,2,0,2*Math.PI);
                        context.fillStyle = "black";
                        context.fill();
                        context.stroke();
                        context.strokeStyle = barva;                      
                    }
                
                    vozlisca[i][0] = x;
                    vozlisca[i][1] = y;

                    for(var j = 0; j< vozlisca.length;j++){
                        context.strokeStyle = "black";
                        context.fillRect(vozlisca[j][0],vozlisca[j][1],8,8);
                        context.stroke();
                        context.strokeStyle = barva;
                    }
            }
        }

    }
}

function brisanje(e){
        var x = koordinate(e)[0] - this.offsetLeft;
        var y = koordinate(e)[1] - this.offsetTop;
        console.log(x+ " " + y);
        for(var i = 0; i<vozlisca.length;i++){
        var xV = vozlisca[i][0];
        var yV = vozlisca[i][1];
        var xa = x - xV;
        var ya = y - yV;
        if(xa < 0){
            xa = xa * -1;
        }
        if(ya < 0){
            ya = ya * -1;
        }
        if(xa <= 25  && ya <= 25){
                var k = [yV,xV];
                vozlisca.splice(i,1);
                for(var h = 0; h<krivulje.length;h++){
                    if(krivulje[h][0] == xV && krivulje[h][1] == yV){
                        var prva = krivulje[h][6];
                        var druga = krivulje[h][7];
                        krivulje.splice(h,1);
                        for(var d = 0; d < vozlisca.length;d++){
                            if(prva == vozlisca[d][0] && druga == vozlisca[d][1]){
                                vozlisca.splice(d,1);
                            }
                        }
                    }else{
                        if(krivulje[h][6] == xV && krivulje[h][7] == yV){
                            var prva = krivulje[h][0];
                            var druga = krivulje[h][1];
                            krivulje.splice(h,1);
                            for(var d = 0; d < vozlisca.length;d++){
                                if(prva == vozlisca[d][0] && druga == vozlisca[d][1]){
                                    vozlisca.splice(d,1);
                                    d = vozlisca.length;
                                }
                            }
                        }
                    }
                }

                context = document.getElementById('canvas').getContext('2d');
                context.clearRect(0, 0, canvas.width, canvas.height);
                
                for(var i = 0; i< krivulje.length;i++){
                    risiBezier(krivulje[i][0],krivulje[i][1],krivulje[i][2],krivulje[i][3],krivulje[i][4],krivulje[i][5],krivulje[i][6],krivulje[i][7]);
                }
            
            
                for(var i = 0; i< aproksimirana.length;i++){
                    context.strokeStyle = "black";
                    context.beginPath();
                    context.arc(aproksimirana[i][0],aproksimirana[i][1],2,0,2*Math.PI);
                    context.fillStyle = "black";
                    context.fill();
                    context.stroke();
                    context.strokeStyle = barva;
                    
                }
            
                
                for(var i = 0; i< vozlisca.length;i++){
                    context.strokeStyle = "black";
                    context.fillRect(vozlisca[i][0]-4,vozlisca[i][1]-4,8,8);
                    context.stroke();
                    context.strokeStyle = barva;
                }
        }
    }
}
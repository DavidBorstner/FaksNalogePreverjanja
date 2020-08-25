class Vector4f {
    constructor(x,y,z){
            this.x = x;
            this.y = y;
            this.z = z;
            this.h = 0;       
    }


    static negate(vector){
        var ena = vector.x * -1;
        var dve = vector.y * -1;
        var tri = vector.z * -1;
        let vrni = new Vector4f(ena,dve,tri);
        return vrni;
    }

    static add(vector1, vector2){
        var x = vector1.x + vector2.x;
        var y = vector1.y + vector2.y;
        var z = vector1.z + vector2.z;

        let vrni = new Vector4f(x,y,z);
        return vrni;
    }

    static scalarProduct(vhod,vector){
        var x = vector.x * vhod;
        var y = vector.y * vhod;
        var z = vector.z * vhod;

        let vrni = new Vector4f(x,y,z);
        return vrni;
    }

    static dotProduct(vector1,vector2){
        var prvi = vector1.x * vector2.x;
        var drugi = vector1.y * vector2.y;
        var tretji = vector1.z * vector2.z;

        return (prvi+drugi+tretji);
    }

    static crossProduct(vector1,vector2){
        var prvi = (vector1.y * vector2.z) - (vector1.z * vector2.y);
        var drugi = (vector1.z * vector2.x) - (vector1.x * vector2.z);
        var tretji = (vector1.x * vector2.y) - (vector1.y * vector2.x);

        let vrni = new Vector4f(prvi,drugi,tretji);
        return vrni
    }

    static length(vector){
        var dolzina = Math.sqrt(Math.pow(vector.x,2) + Math.pow(vector.y,2) + Math.pow(vector.z,2));
        return dolzina
    }

    static normalize(vector){
        var dolzina = this.length(vector);
        var x = vector.x/dolzina;
        var y = vector.y/dolzina;
        var z = vector.z/dolzina;

        let vrni = new Vector4f(x,y,z);
        return vrni;
    }

    static project(vector1,vector2){
        var v1Dolzina = Vector4f.length(vector1);
        var v2Dolzina = Vector4f.length(vector2);
        var v1Norm = Vector4f.normalize(vector1);
        var v2Norm = Vector4f.normalize(vector2);
        var kos = Vector4f.cosPhi(vector1,vector2);

        var vrn = v1Dolzina * this.dotProduct(v1Norm,v2Norm);
        let vrni = new Vector4f(v2Norm.x*vrn,v2Norm.y*vrn,v2Norm.z*vrn);
        
        return vrni;
    }

    static cosPhi(vector1,vector2){
        var vrednost = this.dotProduct(vector1,vector2);
        var dolzina1 = this.length(vector1);
        var dolzina2 = this.length(vector2);
        var vrni = vrednost /(dolzina1 * dolzina2);
        return vrni;
    }

}

class VectorMatrix{
    constructor(a,b,c,d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    static negiraj(vector){
        var a = vector.a * -1;
        var b = vector.b * -1;
        var c = vector.c * -1;
        var d = vector.d * -1;
        
        let vrni = new VectorMatrix(a,b,c,d);
        return vrni;
    }

    static add(vector1, vector2){
        var a = vector1.a + vector2.a;
        var b = vector1.b + vector2.b;
        var c = vector1.c + vector2.c;
        var d = vector1.d + vector2.d;

        let vrni = new VectorMatrix(a,b,c,d);
        return vrni;
    }

    static scalarMatrix(vhod, vector){
        var a = vector.a * vhod;
        var b = vector.b * vhod;
        var c = vector.c * vhod;
        var d = vector.d * vhod;

        let vrni = new VectorMatrix(a,b,c,d);
        return vrni;
    }
}

class Matrix4f{

    constructor(v11,v12,v13,v14,v21,v22,v23,v24,v31,v32,v33,v34,v41,v42,v43,v44){
        this.v1 = new VectorMatrix(v11,v12,v13,v14);
        this.v2 = new VectorMatrix(v21,v22,v23,v24);
        this.v3 = new VectorMatrix(v31,v32,v33,v34);
        this.v4 = new VectorMatrix(v41,v42,v43,v44);
    }

    static negate(matrika){
        let prva = VectorMatrix.negiraj(matrika.v1);    
        let druga = VectorMatrix.negiraj(matrika.v2);
        let tretja = VectorMatrix.negiraj(matrika.v3);
        let cetrta = VectorMatrix.negiraj(matrika.v4);
        let vrni = new Matrix4f(prva,druga,tretja,cetrta);
        return vrni.v1;
    }

    static add(matrika1, matrika2){
        let prva = VectorMatrix.add(matrika1.v1,matrika2.v1);
        let druga = VectorMatrix.add(matrika1.v2,matrika2.v2);
        let tretja = VectorMatrix.add(matrika1.v3,matrika2.v3);
        let cetrta = VectorMatrix.add(matrika1.v4,matrika2.v4);
        
        let vrni = new Matrix4f(prva, druga, tretja, cetrta);
        return vrni.v1;

    }

    static transponse(matrika){
        let prva = new VectorMatrix(matrika.v1.a,matrika.v2.a,matrika.v3.a,matrika.v4.a);
        let druga = new VectorMatrix(matrika.v1.b,matrika.v2.b,matrika.v3.b,matrika.v4.b);
        let tretja = new VectorMatrix(matrika.v1.c,matrika.v2.c,matrika.v3.c,matrika.v4.c);
        let cetrta = new VectorMatrix(matrika.v1.d,matrika.v2.d,matrika.v3.d,matrika.v4.d);

        let vrni = new Matrix4f(prva, druga, tretja, cetrta);
        return vrni.v1;
    }

    static multiplyScalar(veckratnik, matrika){
        let prva = VectorMatrix.scalarMatrix(veckratnik,matrika.v1);
        let druga = VectorMatrix.scalarMatrix(veckratnik,matrika.v2);
        let tretja = VectorMatrix.scalarMatrix(veckratnik,matrika.v3);
        let cetrta = VectorMatrix.scalarMatrix(veckratnik,matrika.v4);
        
        let vrni = new Matrix4f(prva, druga, tretja, cetrta);
        return vrni.v1;
    }

    static multiply(matrika1, matrika2){
        var vektor11 = (matrika1.v1.a * matrika2.v1.a)+(matrika1.v1.b*matrika2.v2.a)+(matrika1.v1.c * matrika2.v3.a)+(matrika1.v1.d * matrika2.v4.a);
        var vektor12 = (matrika1.v1.a * matrika2.v1.b)+(matrika1.v1.b*matrika2.v2.b)+(matrika1.v1.c * matrika2.v3.b)+(matrika1.v1.d * matrika2.v4.b);
        var vektor13 = (matrika1.v1.a * matrika2.v1.c)+(matrika1.v1.b*matrika2.v2.c)+(matrika1.v1.c * matrika2.v3.c)+(matrika1.v1.d * matrika2.v4.c);
        var vektor14 = (matrika1.v1.a * matrika2.v1.d)+(matrika1.v1.b*matrika2.v2.d)+(matrika1.v1.c * matrika2.v3.d)+(matrika1.v1.d * matrika2.v4.d);

        let vektor1 = new VectorMatrix(vektor11,vektor12,vektor13,vektor14);
        
        var vektor21 = (matrika1.v2.a * matrika2.v1.a)+(matrika1.v2.b*matrika2.v2.a)+(matrika1.v2.c * matrika2.v3.a)+(matrika1.v2.d * matrika2.v4.a);
        var vektor22 = (matrika1.v2.a * matrika2.v1.b)+(matrika1.v2.b*matrika2.v2.b)+(matrika1.v2.c * matrika2.v3.b)+(matrika1.v2.d * matrika2.v4.b);
        var vektor23 = (matrika1.v2.a * matrika2.v1.c)+(matrika1.v2.b*matrika2.v2.c)+(matrika1.v2.c * matrika2.v3.c)+(matrika1.v2.d * matrika2.v4.c);
        var vektor24 = (matrika1.v2.a * matrika2.v1.d)+(matrika1.v2.b*matrika2.v2.d)+(matrika1.v2.c * matrika2.v3.d)+(matrika1.v2.d * matrika2.v4.d);

        let vektor2 = new VectorMatrix(vektor21,vektor22,vektor23,vektor24);

        var vektor31 = (matrika1.v3.a * matrika2.v1.a)+(matrika1.v3.b*matrika2.v2.a)+(matrika1.v3.c * matrika2.v3.a)+(matrika1.v3.d * matrika2.v4.a);
        var vektor32 = (matrika1.v3.a * matrika2.v1.b)+(matrika1.v3.b*matrika2.v2.b)+(matrika1.v3.c * matrika2.v3.b)+(matrika1.v3.d * matrika2.v4.b);
        var vektor33 = (matrika1.v3.a * matrika2.v1.c)+(matrika1.v3.b*matrika2.v2.c)+(matrika1.v3.c * matrika2.v3.c)+(matrika1.v3.d * matrika2.v4.c);
        var vektor34 = (matrika1.v3.a * matrika2.v1.d)+(matrika1.v3.b*matrika2.v2.d)+(matrika1.v3.c * matrika2.v3.d)+(matrika1.v3.d * matrika2.v4.d);

        let vektor3 = new VectorMatrix(vektor31,vektor32,vektor33,vektor34);

        var vektor41 = (matrika1.v4.a * matrika2.v1.a)+(matrika1.v4.b*matrika2.v2.a)+(matrika1.v4.c * matrika2.v3.a)+(matrika1.v4.d * matrika2.v4.a);
        var vektor42 = (matrika1.v4.a * matrika2.v1.b)+(matrika1.v4.b*matrika2.v2.b)+(matrika1.v4.c * matrika2.v3.b)+(matrika1.v4.d * matrika2.v4.b);
        var vektor43 = (matrika1.v4.a * matrika2.v1.c)+(matrika1.v4.b*matrika2.v2.c)+(matrika1.v4.c * matrika2.v3.c)+(matrika1.v4.d * matrika2.v4.c);
        var vektor44 = (matrika1.v4.a * matrika2.v1.d)+(matrika1.v4.b*matrika2.v2.d)+(matrika1.v4.c * matrika2.v3.d)+(matrika1.v4.d * matrika2.v4.d);

        let vektor4 = new VectorMatrix(vektor41,vektor42,vektor43,vektor44);

        let vrni = new Matrix4f(vektor1,vektor2,vektor3,vektor4);

        return vrni.v1;
        
    }
    
}

class PointManager{
    
    constructor(){
        this.seznamVector = [];
    }
    
    dodaj(vekt){
        this.seznamVector.push(vekt);
        return this.seznamVector;
    }

    izpis(){
        for(var i = 0; i< this.seznamVector.length; i++){
            document.getElementById("textAreaIzpis").value += "v " + this.seznamVector[i].x + " " + this.seznamVector[i].y + " " + this.seznamVector[i].z + "\n";
        }
    }
}

let PM = new PointManager();

function pritisk(){   
    let vek = new Vector4f(document.getElementById("v11").value,document.getElementById("v12").value,document.getElementById("v13").value);
    document.getElementById("v11").value = 0;
    document.getElementById("v12").value = 0;
    document.getElementById("v13").value = 0;
    PM.dodaj(vek);
}

function izhod(){
    PM.izpis();
}

function dodajPM(){
    var beri = document.getElementById("textAreaVpis").value;
    var deli = beri.split("\n");
    for(var i = 0; i<deli.length;i++){
        var notranji = deli[i].split(" ");
        if(notranji[0] != "v"){
            document.getElementById("textAreaVpis").value = "";
            alert("Nepravilen vnos, sledi: v x1 y1 z1");
            continue;
        }else{
            if(!isNaN(parseInt(notranji[1], 10)) && !isNaN(parseInt(notranji[2], 10)) && !isNaN(parseInt(notranji[3], 10))){
                if(notranji[1] == null && notranji[2] == null && notranji[3] == null){
                    alert("Premalo vnešenih točk");
                }
                let vek = new Vector4f(notranji[1],notranji[2],notranji[3]);
                document.getElementById("textAreaVpis").value = "";
                PM.dodaj(vek);
            }else{
                document.getElementById("textAreaVpis").value = "";
                alert("Nepravilen vnos števil");
            }
        }
    }
}


class Transformation{
    constructor(mati){
        this.notri = new Matrix4f(mati.v1.a,mati.v1.b,mati.v1.c,mati.v1.d,mati.v2.a,mati.v2.b,mati.v2.c,mati.v2.d,mati.v3.a,mati.v3.b,mati.v3.c,mati.v3.d,mati.v4.a,mati.v4.b,mati.v4.c,mati.v4.d);
    }
    translate(vektor){
        let prva = new Matrix4f(1,0,0,vektor.x,0,1,0,vektor.y,0,0,1,vektor.z,0,0,0,1);
        let NovaMat = Matrix4f.multiply(prva,this.notri);
        return NovaMat;
    }
    scale(vektor){
        let prva = new Matrix4f(vektor.x,0,0,0,0,vektor.y,0,0,0,0,vektor.z,0,0,0,0,1);
        let NovaMat = Matrix4f.multiply(prva,this.notri);
        return NovaMat;
    }

    rotateX(vhod){
        let prva = new Matrix4f(1,0,0,0,Math.cos(vhod),-Math.sin(vhod),0,0,Math.sin(vhod),Math.cos(vhod),1,0,0,0,0,1);
        let mnozenje = Matrix4f.multiply(prva,this.notri);
        return mnozenje;
    }

    rotateY(vhod){
        let prva = new Matrix4f(Math.cos(vhod),0,Math.sin(vhod),0,0,1,0,0,-Math.sin(vhod),0,Math.cos(vhod),0,0,0,0,1);
        let NovaMat = Matrix4f.multiply(prva,this.notri);
        return NovaMat;
    }

    rotateZ(vhod){
        let prva = new Matrix4f(Math.cos(vhod),-Math.sin(vhod),0,0,Math.sin(vhod),Math.cos(vhod),0,0,0,0,1,0,0,0,0,1);
        let NovaMat = Matrix4f.multiply(prva,this.notri);
        return NovaMat;
    }

    transformPoint(vektor){
        var prva = (this.notri.v1.a * vektor.x) + (this.notri.v1.b * vektor.y) + (this.notri.v1.c * vektor.z) + this.notri.v1.d;
        var druga = (this.notri.v2.a * vektor.x) + (this.notri.v2.a * vektor.y) + (this.notri.v2.a * vektor.z) + this.notri.v1.d;
        var tretja = (this.notri.v3.a * vektor.x) + (this.notri.v3.a * vektor.y) + (this.notri.v3.a * vektor.z) + this.notri.v1.d;
        let vrni = new Vector4f(prva,druga,tretja);
        return vrni;
    }
}


class TransformPoints{
    constructor(){
        this.TP = new Matrix4f(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        this.vrni = new Transformation(this.TP);

    }

    TPtranslacija(vektor){
        
        return this.vrni.translate(vektor);
    }

    TProtacijaX(vhod){
         var spremeni = this.vrni.rotateX(vhod);
         var rotirano = new Matrix4f(zaokrozi(spremeni.a.a),zaokrozi(spremeni.a.b),zaokrozi(spremeni.a.c),zaokrozi(spremeni.a.d),zaokrozi(spremeni.b.a),zaokrozi(spremeni.b.b),zaokrozi(spremeni.b.c),zaokrozi(spremeni.b.d),zaokrozi(spremeni.c.a),zaokrozi(spremeni.c.b),zaokrozi(spremeni.c.c),zaokrozi(spremeni.c.d),zaokrozi(spremeni.d.a),zaokrozi(spremeni.d.b),zaokrozi(spremeni.d.c),zaokrozi(spremeni.d.d));
         console.log(rotirano);
         return rotirano;
    }

    TProtacijaY(vhod){
        var spremeni = this.vrni.rotateY(vhod);
        var rotirano = new Matrix4f(zaokrozi(spremeni.a.a),zaokrozi(spremeni.a.b),zaokrozi(spremeni.a.c),zaokrozi(spremeni.a.d),zaokrozi(spremeni.b.a),zaokrozi(spremeni.b.b),zaokrozi(spremeni.b.c),zaokrozi(spremeni.b.d),zaokrozi(spremeni.c.a),zaokrozi(spremeni.c.b),zaokrozi(spremeni.c.c),zaokrozi(spremeni.c.d),zaokrozi(spremeni.d.a),zaokrozi(spremeni.d.b),zaokrozi(spremeni.d.c),zaokrozi(spremeni.d.d));
        console.log(rotirano);
        return rotirano;
   }

   TProtacijaZ(vhod){
    var spremeni = this.vrni.rotateZ(vhod);
    var rotirano = new Matrix4f(zaokrozi(spremeni.a.a),zaokrozi(spremeni.a.b),zaokrozi(spremeni.a.c),zaokrozi(spremeni.a.d),zaokrozi(spremeni.b.a),zaokrozi(spremeni.b.b),zaokrozi(spremeni.b.c),zaokrozi(spremeni.b.d),zaokrozi(spremeni.c.a),zaokrozi(spremeni.c.b),zaokrozi(spremeni.c.c),zaokrozi(spremeni.c.d),zaokrozi(spremeni.d.a),zaokrozi(spremeni.d.b),zaokrozi(spremeni.d.c),zaokrozi(spremeni.d.d));
    console.log(rotirano);
    return rotirano;
    }
    
    TPskalacija(vektor){
        
        return this.vrni.translate(vektor);
    }
}

let TraPo = new TransformPoints();

function Demo(){
    var beri = document.getElementById("demonstracija").value;
    var deli = beri.split(" ");
    if(deli[0].toUpperCase() == "TRANSLACIJA" || deli[0].toUpperCase() == "TRANSLATION"){
        if(deli[1] == "x" || deli[1] == "X"){
            let DemoVektor = new Vector4f(deli[2],1,1,1);
            let DemoMatrika = TraPo.TPtranslacija(DemoVektor);
            document.getElementById("demoIzpis").value = DemoMatrika.a.a + " " + DemoMatrika.a.b + " " + DemoMatrika.a.c + " " + DemoMatrika.a.d + "\n";
            document.getElementById("demoIzpis").value += DemoMatrika.b.a + " " + DemoMatrika.b.b + " " + DemoMatrika.b.c + " " + DemoMatrika.b.d + "\n";
            document.getElementById("demoIzpis").value += DemoMatrika.c.a + " " + DemoMatrika.c.b + " " + DemoMatrika.c.c + " " + DemoMatrika.c.d + "\n";
            document.getElementById("demoIzpis").value += DemoMatrika.d.a + " " + DemoMatrika.d.b + " " + DemoMatrika.d.c + " " + DemoMatrika.d.d;
        }else{
            if(deli[1] == "y" || deli[1] == "Y"){
                let DemoVektor = new Vector4f(1,deli[2],1,1);
                let DemoMatrika = TraPo.TPtranslacija(DemoVektor);
                document.getElementById("demoIzpis").value = DemoMatrika.a.a + " " + DemoMatrika.a.b + " " + DemoMatrika.a.c + " " + DemoMatrika.a.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.b.a + " " + DemoMatrika.b.b + " " + DemoMatrika.b.c + " " + DemoMatrika.b.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.c.a + " " + DemoMatrika.c.b + " " + DemoMatrika.c.c + " " + DemoMatrika.c.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.d.a + " " + DemoMatrika.d.b + " " + DemoMatrika.d.c + " " + DemoMatrika.d.d;
                
            }else{
                if(deli[1] == "z" || deli[1] == "Z"){
                    let DemoVektor = new Vector4f(1,1,deli[2],1);
                    let DemoMatrika = TraPo.TPtranslacija(DemoVektor);
                    document.getElementById("demoIzpis").value = DemoMatrika.a.a + " " + DemoMatrika.a.b + " " + DemoMatrika.a.c + " " + DemoMatrika.a.d + "\n";
                    document.getElementById("demoIzpis").value += DemoMatrika.b.a + " " + DemoMatrika.b.b + " " + DemoMatrika.b.c + " " + DemoMatrika.b.d + "\n";
                    document.getElementById("demoIzpis").value += DemoMatrika.c.a + " " + DemoMatrika.c.b + " " + DemoMatrika.c.c + " " + DemoMatrika.c.d + "\n";
                    document.getElementById("demoIzpis").value += DemoMatrika.d.a + " " + DemoMatrika.d.b + " " + DemoMatrika.d.c + " " + DemoMatrika.d.d;
                }else{
                    alert("Napaka pri vnosu");
                }
            }
        }
    }else{
        if(deli[0].toUpperCase() == "ROTACIJA" || deli[0].toUpperCase() == "ROTATION"){
            if(deli[1] == "x" || deli[1] == "X"){
            let DemoMatrika = TraPo.TProtacijaX(deli[2]);
            document.getElementById("demoIzpis").value = DemoMatrika.v1.a + " " + DemoMatrika.v1.b + " " + DemoMatrika.v1.c + " " + DemoMatrika.v1.d + "\n";
            document.getElementById("demoIzpis").value += DemoMatrika.v2.a + " " + DemoMatrika.v2.b + " " + DemoMatrika.v2.c + " " + DemoMatrika.v2.d + "\n";
            document.getElementById("demoIzpis").value += DemoMatrika.v3.a + " " + DemoMatrika.v3.b + " " + DemoMatrika.v3.c + " " + DemoMatrika.v3.d + "\n";
            document.getElementById("demoIzpis").value += DemoMatrika.v4.a + " " + DemoMatrika.v4.b + " " + DemoMatrika.v4.c + " " + DemoMatrika.v4.d;
            
        }else{
            if(deli[1] == "y" || deli[1] == "Y"){
                let DemoMatrika = TraPo.TProtacijaY(deli[2]);
                document.getElementById("demoIzpis").value = DemoMatrika.v1.a + " " + DemoMatrika.v1.b + " " + DemoMatrika.v1.c + " " + DemoMatrika.v1.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.v2.a + " " + DemoMatrika.v2.b + " " + DemoMatrika.v2.c + " " + DemoMatrika.v2.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.v3.a + " " + DemoMatrika.v3.b + " " + DemoMatrika.v3.c + " " + DemoMatrika.v3.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.v4.a + " " + DemoMatrika.v4.b + " " + DemoMatrika.v4.c + " " + DemoMatrika.v4.d;
                
            }else{
                if(deli[1] == "z" || deli[1] == "Z"){
                    let DemoMatrika = TraPo.TProtacijaZ(deli[2]);
                    document.getElementById("demoIzpis").value = DemoMatrika.v1.a + " " + DemoMatrika.v1.b + " " + DemoMatrika.v1.c + " " + DemoMatrika.v1.d + "\n";
                    document.getElementById("demoIzpis").value += DemoMatrika.v2.a + " " + DemoMatrika.v2.b + " " + DemoMatrika.v2.c + " " + DemoMatrika.v2.d + "\n";
                    document.getElementById("demoIzpis").value += DemoMatrika.v3.a + " " + DemoMatrika.v3.b + " " + DemoMatrika.v3.c + " " + DemoMatrika.v3.d + "\n";
                    document.getElementById("demoIzpis").value += DemoMatrika.v4.a + " " + DemoMatrika.v4.b + " " + DemoMatrika.v4.c + " " + DemoMatrika.v4.d;
                }else{
                    alert("Napaka pri vnosu");
                }
            }
        }
        }else{
            if(deli[0].toUpperCase() == "SKALACIJA" || deli[0].toUpperCase() == "SCALING"){
                let DemoVektor = new Vector4f(1,1,deli[2],1);
                let DemoMatrika = TraPo.TPskalacija(DemoVektor);
                document.getElementById("demoIzpis").value = DemoMatrika.a.a + " " + DemoMatrika.a.b + " " + DemoMatrika.a.c + " " + DemoMatrika.a.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.b.a + " " + DemoMatrika.b.b + " " + DemoMatrika.b.c + " " + DemoMatrika.b.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.c.a + " " + DemoMatrika.c.b + " " + DemoMatrika.c.c + " " + DemoMatrika.c.d + "\n";
                document.getElementById("demoIzpis").value += DemoMatrika.d.a + " " + DemoMatrika.d.b + " " + DemoMatrika.d.c + " " + DemoMatrika.d.d;         
            }
        }
    }

    
}

function ponastavi(){
    document.getElementById("demoIzpis").value = "";
}

function zaokrozi(num) {    
    return +(Math.round(num + "e+2")  + "e-2");
}

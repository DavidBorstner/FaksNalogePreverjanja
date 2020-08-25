$('button.encode, button.decode').click(function (event) {
  event.preventDefault();
});

function previewDecodeImage() {
  var file = document.querySelector('input[name=decodeFile]').files[0];
  
  previewImage(file, $(".testZakodirano"), function () {
    $(".testZakodirano").fadeIn();
  });

}



var pogoj = false;

function preview() {

  $(".vnosTest").fadeIn();

  if (pogoj == false) {
    var file = document.querySelector("input[name=vnosSlike]").files[0];

    $(".images .nulled").hide();
    $(".images .message").hide();

    var zac = document.getElementById("testOriginal");
    previewImage(file, zac, function () {
    });

  } else {
    var file = document.querySelector("input[name=vnosSlike]").files[0];

    var zac = document.getElementById("testZakodirano");

    var prvi = document.getElementById("testOriginal");

    previewImage(file,prvi, function(){
    });

    previewImage(file, zac, function () {
      decodeMessage();
    });

  }
}

function onKeyDown() {
  var key = window.event.keyCode;

  var zac = document.getElementById("vnos");
  if (key == 13) {
     zac.text="test";
  }
}

var vn = document.getElementById("vnos");
vn.addEventListener("keyup", function(event) {
  console.log("besedilo");
  if (event.keyCode === 13) {
    event.preventDefault();
    document.getElementById("gumbIzvedi").click();
  }
});


var defImg = new Image();
defImg.src = "http://cdn.onlinewebfonts.com/svg/img_148071.png";
function dodajSliko() {
    var prvi = document.getElementById("testOriginal");
    var drugi = document.getElementById("testZakodirano");
    canvas.width = defImg.width;
    canvas.height = defImg.height;
    prvi.drawImage(defImg,0,0);
    drugi.drawImage(defImg,0,0);
    prvi.style("color: black");
    var ctx = canvas.getContext('2d');
    ctx.fillStyle = 'black';
    ctx.fillRect(0, 0, width, height);
}

dodajSliko();

$('#gumbSmer').click(function(){
  $(this).find('i').toggleClass('glyphicon-arrow-right').toggleClass('glyphicon-arrow-left');
  console.log("ja tle smo");
});

function smer(){
  if(pogoj == false){

    $(".gumbSmer span").removeClass('glyphicon glyphicon-arrow-right');
    $(".gumbSmer span").addClass('glyphicon glyphicon-arrow-left');
    $(".gumbSmer span").text("novo");
  
    pogoj = true;
    document.getElementById("vnos").readOnly = true;
    document.getElementById("vnos").value = "";

    var c = document.getElementById("testOriginal");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, c.width, c.height);
    ctx.beginPath();

    var c = document.getElementById("testZakodirano");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, c.width, c.height);
    ctx.beginPath();

    document.getElementById("uploadSlika").value = "";

  }else{
    document.getElementById("uploadSlika").value = "";
    $(".gumbSmer").find('span').removeClass('glyphicon glyphicon-arrow-left');
    $(".gumbSmer").find('span').addClass('glyphicon glyphicon-arrow-right');
    pogoj = false;
    document.getElementById("vnos").readOnly = false;
    document.getElementById("vnos").value = "";

    var c = document.getElementById("testOriginal");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, c.width, c.height);
    ctx.beginPath();

    var c = document.getElementById("testZakodirano");
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, c.width, c.height);
    ctx.beginPath();


    console.log(pogoj);
  }
}

function previewEncodeImage() {
  var file = document.querySelector("input[name=baseFile]").files[0];

  $(".images .nulled").hide();
  $(".images .message").hide();

  previewImage(file, ".original canvas", function () {
    $(".images .original").fadeIn();
    $(".images").fadeIn();
  });
}

function previewImage(file, canvasSelector, callback) {
  var reader = new FileReader();
  var image = new Image();
  var $canvas = $(canvasSelector);
  var context = $canvas[0].getContext('2d');
  var visina = 0;
  var sirina = 0;

  if (file) {
    reader.readAsDataURL(file);
  }

  reader.onloadend = function () {
    image.src = URL.createObjectURL(file);
    image.onload = function () {
      $canvas.prop({
        'width': image.width,
        'height': image.height
      });
      context.drawImage(image, 0, 0);
      visina = image.height;
      sirina = image.width;
      var velikost = visina * sirina * 3;
      var podatkiOSliki = "Višina: " + visina + "\nŠirina: " + sirina + "\nProstor za shranjevanje v bitih: " + velikost;
      $('.slikaPod textarea').text(podatkiOSliki);
      $(".slikaPod").fadeIn();
      callback();
    }
  }


}

function izvedi(){
  if(pogoj == false){
    encodeMessage();
    document.getElementById("vnos").value = "";
    
  }else{
    decodeMessage();
  }
}

function encodeMessage() {
  $(".error").hide();
  $(".binary").hide();

  var text = $(".vnosTest textarea").val();
 
  var zac = document.getElementById("testOriginal");

  var $originalCanvas = $('.original canvas');
  var $nulledCanvas = $('.nulled canvas');

  var $messageCanvas = $('.message canvas');

  var originalContext = $originalCanvas[0].getContext("2d");
  var nulledContext = $nulledCanvas[0].getContext("2d");
  var messageContext = $messageCanvas[0].getContext("2d");

  var width = $originalCanvas[0].width;
  var height = $originalCanvas[0].height;


  if (width == 300 && height == 150) {
    alert("Prosim vnesite neko sliko!");
    return;
  }

  if (text == "") {
    alert("Prosim vnesite neko besedilo!");

    return;
  }

  // Check if the image is big enough to hide the message
  if ((text.length * 8) > (width * height * 3)) {
    alert("Tekst, ki ste ga vnesli je predolg za izbrano sliko!");
    return;
  }

  $nulledCanvas.prop({
    'width': width,
    'height': height
  });

  $messageCanvas.prop({
    'width': width,
    'height': height
  });

  // Normalize the original image and draw it
  var original = originalContext.getImageData(0, 0, width, height);
  var pixel = original.data;
  for (var i = 0, n = pixel.length; i < n; i += 4) {
    for (var offset = 0; offset < 3; offset++) {
      if (pixel[i + offset] % 2 != 0) {
        pixel[i + offset]--;
      }
    }
  }
  nulledContext.putImageData(original, 0, 0);

  // Convert the message to a binary string
  var binaryMessage = "";
  for (i = 0; i < text.length; i++) {
    var binaryChar = text[i].charCodeAt(0).toString(2);

    // Pad with 0 until the binaryChar has a lenght of 8 (1 Byte)
    while (binaryChar.length < 8) {
      binaryChar = "0" + binaryChar;
    }

    binaryMessage += binaryChar;
  }
  $('.binary textarea').text(binaryMessage);

  // Apply the binary string to the image and draw it
  var message = nulledContext.getImageData(0, 0, width, height);
  pixel = message.data;
  counter = 0;
  for (var i = 0, n = pixel.length; i < n; i += 4) {
    for (var offset = 0; offset < 3; offset++) {
      if (counter < binaryMessage.length) {
        pixel[i + offset] += parseInt(binaryMessage[counter]);
        counter++;
      }
      else {
        break;
      }
    }
  }
  messageContext.putImageData(message, 0, 0);
};

function decodeMessage() {
  console.log("dekodiraj");

  var $originalCanvas = $('.message canvas');
  var originalContext = $originalCanvas[0].getContext("2d");

  var $messageCanvas = $('.original canvas');
  var nulledContext = $messageCanvas[0].getContext("2d");


  var width = $originalCanvas[0].width;
  var height = $originalCanvas[0].height;

  var original = originalContext.getImageData(0, 0, width, height);
  var binaryMessage = "";
  var pixel = original.data;
  for (var i = 0, n = pixel.length; i < n; i += 4) {
    for (var offset = 0; offset < 3; offset++) {
      var value = 0;
      if (pixel[i + offset] % 2 != 0) {
        value = 1;
      }

      binaryMessage += value;
    }
  }


  var output = "";
  for (var i = 0; i < binaryMessage.length; i += 8) {
    var c = 0;
    for (var j = 0; j < 8; j++) {
      c <<= 1;
      c |= parseInt(binaryMessage[i + j]);
    }
    if (c != "") {
      output += String.fromCharCode(c);
    }
  }
  console.log(output);

  $(".vnosTest textarea").val(output);
};

function uploadFile(file) {
  var url = 'YOUR URL HERE'
  var xhr = new XMLHttpRequest()
  var formData = new FormData()
  xhr.open('POST', url, true)

  xhr.addEventListener('readystatechange', function (e) {
    if (xhr.readyState == 4 && xhr.status == 200) {
      // Done. Inform the user
    }
    else if (xhr.readyState == 4 && xhr.status != 200) {
      // Error. Inform the user
    }
  })

  formData.append('file', file)
  xhr.send(formData)
}
var originalState = $(".fileDodaj").clone();

function resetirajvse() {
  $('.binary-decode textarea').text("");
  $('.binary-decode').hide();
  $(".binary").hide();
  $(".images .message").hide();
  $('.slikaPod textarea').text("");
  $(".slikaPod").hide();
  $(".images .nulled").hide();
  $(".images .message").hide();
  $(".images").hide();
  $(".decode").hide();
  document.getElementById('vnos').value = "";

  $(".fileDodaj").replaceWith(originalState);
}


function download_image() {
  var canvas = document.getElementById("testZakodirano");
  image = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream");
  var link = document.createElement('a');
  link.download = "my-image.png";
  link.href = image;
  link.click();
}


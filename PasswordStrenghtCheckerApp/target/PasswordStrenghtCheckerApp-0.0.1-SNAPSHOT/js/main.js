function validatePassword(password) {
     
	if (typeof password !== 'string' 
		|| password.includes(' ')){
		PasswordStrengthInfo(`Please input a string without spaces in between and the preferred special characters are ${specialVars}`,  ".err-msg");
	}   

	checkStrenght(password);
}

function checkStrenght(password){
	var rootURL = "http://localhost:8080/PasswordStrenghtCheckerApp/passwordstrenghtcheckerapp/passwordchecker/password/";
	
	console.log('findById: ' + password);
	$.ajax({
		type: 'GET',
		url: rootURL + password,
		dataType: "json",
		success: function(data){
			console.log('findById success: ' + data.passwordStrength);
			console.log('findById success: ' + data.password);
			togglePasswordStrength(data.passwordStrength);
		}
	});
}

//Abstracting document.querySelector into a function for reuse.
function getEl(name){
  return document.querySelector(name);
}

//Checks the various classes and unhides the ncesessary one where possible.
function togglePasswordStrength(passwordStrength) {

    if (passwordStrength === 25){      
      if(getEl(".red").classList.contains('hide')){
        getEl(".red").classList.remove('hide');
      }
      if(!getEl(".orange").classList.contains('hide')){
        getEl(".orange").classList.add('hide');
      }
      if(!getEl(".blue").classList.contains('hide')){
        getEl(".blue").classList.add('hide');
      }
      if(!getEl(".green").classList.contains('hide')){
        getEl(".green").classList.add('hide');
      }
      PasswordStrengthInfo("25%");
    }
   else if (passwordStrength === 50){      
      if(getEl(".orange").classList.contains('hide')){
        getEl(".orange").classList.remove('hide');
      }
      if(!getEl(".red").classList.contains('hide')){
        getEl(".red").classList.add('hide');
      }
      if(!getEl(".blue").classList.contains('hide')){
        getEl(".blue").classList.add('hide');
      }
      if(!getEl(".green").classList.contains('hide')){
        getEl(".green").classList.add('hide');
      }
      PasswordStrengthInfo("50%");
    }
     else if (passwordStrength === 75){      
      if(getEl(".blue").classList.contains('hide')){
        getEl(".blue").classList.remove('hide');
      }
      if(!getEl(".red").classList.contains('hide')){
        getEl(".red").classList.add('hide');
      }
      if(!getEl(".orange").classList.contains('hide')){
        getEl(".orange").classList.add('hide');
      }
      if(!getEl(".green").classList.contains('hide')){
        getEl(".green").classList.add('hide');
      }
      PasswordStrengthInfo("75%");
    }
    
    else if (passwordStrength === 100){      
      if(getEl(".green").classList.contains('hide')){
        getEl(".green").classList.remove('hide');
      }
      if(!getEl(".red").classList.contains('hide')){
        getEl(".red").classList.add('hide');
      }
      if(!getEl(".orange").classList.contains('hide')){
        getEl(".orange").classList.add('hide');
      }
      if(!getEl(".blue").classList.contains('hide')){
        getEl(".blue").classList.add('hide');
      }
      PasswordStrengthInfo("100%");
      
    }
    else {
      if(!getEl(".green").classList.contains('hide')){
        getEl(".green").classList.add('hide');
      }
      if(!getEl(".red").classList.contains('hide')){
        getEl(".red").classList.add('hide');
      }
      if(!getEl(".orange").classList.contains('hide')){
        getEl(".orange").classList.add('hide');
      }
      if(!getEl(".blue").classList.contains('hide')){
        getEl(".blue").classList.add('hide');
      }
      PasswordStrengthInfo("0%");
    }
}

//Prints to the screen 0% or corresponding password strength and info depending on user input.
function PasswordStrengthInfo(msg, ele=null){
  if(ele)
    document.querySelector(ele).innerHTML = msg;
  else
    document.querySelector(".perc").innerHTML = msg;
}

//Grabbing the input value and triggering the function with the event listener.
document.getElementById("input-val")
.addEventListener("keyup", (e) => {
  validatePassword(e.target.value);
})




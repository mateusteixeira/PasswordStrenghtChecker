function validatePassword(password) {
     
	if (typeof password !== 'string' 
		|| password.includes(' ')){
		PasswordStrengthInfo(`Please input a string without spaces in between and the preferred special characters are ${specialVars}`,  ".err-msg");
	}   

	checkStrenght(password);
}

function checkStrenght(password){
	var rootURL = "http://localhost:8080/PasswordStrenghtCheckerApp/passwordstrenghtcheckerapp/passwordchecker/"+password;
	
	
	$.ajax({
		type: 'GET',
		url: rootURL + password,
		dataType: "json",
		success: function(data){
			togglePasswordStrength(data.passwordStrength);
			PasswordStrengthInfo(data.passwordStrength+"%");
		}
	});
}

function getEl(name){
  return document.querySelector(name);
}

function togglePasswordStrength(passwordStrength) {

	var passwordStrenghtAux = passwordStrength;
	
    if (passwordStrength <= 20){      
	      if(getEl(".red").classList.contains('hide')){
	    	  getEl(".red").classList.remove('hide');
	      }
    
	      if(!getEl(".orange").classList.contains('hide')){
	    	  getEl(".orange").classList.add('hide');
	      }
	      
	      if(!getEl(".yellow").classList.contains('hide')){
	    	  getEl(".yellow").classList.add('hide');
	      }
	      
	      if(!getEl(".blue").classList.contains('hide')){
	    	  getEl(".blue").classList.add('hide');
	      }
	      
	      if(!getEl(".green").classList.contains('hide')){
	    	  getEl(".green").classList.add('hide');
	      }
      
    } else if ((passwordStrength >= 21) && (passwordStrenghtAux <= 40)){      
    	
    	if(!getEl(".red").classList.contains('hide')){
    		getEl(".red").classList.add('hide');
    	}

    	if(getEl(".orange").classList.contains('hide')){
    		getEl(".orange").classList.remove('hide');
    	}
    	
    	if(!getEl(".yellow").classList.contains('hide')){
    		getEl(".yellow").classList.add('hide');
        }
    	
    	if(!getEl(".blue").classList.contains('hide')){
    		getEl(".blue").classList.add('hide');
    	}
    	
    	if(!getEl(".green").classList.contains('hide')){
    		getEl(".green").classList.add('hide');
    	}
      
    } else if ((passwordStrength >= 41) && (passwordStrenghtAux < 60)){ 
    	
    	if(!getEl(".red").classList.contains('hide')){
    		getEl(".red").classList.add('hide');
    	}

    	if(!getEl(".orange").classList.contains('hide')){
    		getEl(".orange").classList.add('hide');
    	}

    	if(getEl(".yellow").classList.contains('hide')){
    		getEl(".yellow").classList.remove('hide');
        }
    	
    	if(!getEl(".blue").classList.contains('hide')){
    		getEl(".blue").classList.add('hide');
    	}

    	if(!getEl(".green").classList.contains('hide')){
    		getEl(".green").classList.add('hide');
    	}
      
    }else if ((passwordStrength >= 61) && (passwordStrenghtAux < 80)){ 
    	if(!getEl(".red").classList.contains('hide')){
    		getEl(".red").classList.add('hide');
    	}

    	if(!getEl(".orange").classList.contains('hide')){
    		getEl(".orange").classList.add('hide');
    	}
    	
   	 	if(!getEl(".yellow").classList.contains('hide')){
   	 		getEl(".yellow").classList.add('hide');
   	 	}
   	 	
   	 	if(getEl(".blue").classList.contains('hide')){
   	 		getEl(".blue").classList.remove('hide');
   	 	}
   	 	
   	 	if(!getEl(".green").classList.contains('hide')){
   	 		getEl(".green").classList.add('hide');
   	 	}
   	 	
    } else if (passwordStrength >= 81){      
    	if(!getEl(".red").classList.contains('hide')){
    		getEl(".red").classList.add('hide');
    	}

    	if(!getEl(".orange").classList.contains('hide')){
    		getEl(".orange").classList.add('hide');
    	}
    	
    	if(!getEl(".yellow").classList.contains('hide')){
    		getEl(".yellow").classList.add('hide');
    	}
    	
    	if(!getEl(".blue").classList.contains('hide')){
    		getEl(".blue").classList.add('hide');
    	}
    	
    	if(getEl(".green").classList.contains('hide')){
    		getEl(".green").classList.remove('hide');
    	}
      
    }
    
}

function PasswordStrengthInfo(msg, ele=null){
  if(ele)
    document.querySelector(ele).innerHTML = msg;
  else
    document.querySelector(".perc").innerHTML = msg;
}

document.getElementById("input-val")
.addEventListener("keyup", (e) => {
  validatePassword(e.target.value);
})




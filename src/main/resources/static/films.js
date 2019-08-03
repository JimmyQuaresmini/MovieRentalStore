//for the radiobuttons in rentFilm.html
function disableViaRadio() {
    var isIdRadioChecked = document.getElementById("idRadio").checked;
    if (isIdRadioChecked === true) {
        document.getElementById("searchTitle").disabled = true;
        document.getElementById("btnTitle").disabled = true;
        document.getElementById("searchId").disabled = false;
        document.getElementById("btnId").disabled = false;
    }
    else {
        document.getElementById("searchTitle").disabled = false;
        document.getElementById("btnTitle").disabled = false;
        document.getElementById("searchId").disabled = true;
        document.getElementById("btnId").disabled = true;
    }
}

//for the button in add-film.html
function checkAndFill() {
    var trailers = document.getElementById("checkboxSpecialFeatures");
    var commentaries = document.getElementById("checkboxSFCommentaries");
    var deletedScenes = document.getElementById("checkboxSFDeletedScenes");
    var behindTheScenes = document.getElementById("checkboxSFBehindTheScenes");
    
    var checkedSFs = [trailers.checked, commentaries.checked, deletedScenes.checked, 
        behindTheScenes.checked];
    var txt = "";
    
    checkedSFs.forEach(checkSF);
    
    function checkSF(value, index, array) {
        if (value === true) {
            if (index === 0) {
                txt = txt + trailers.value + ", ";
            }
            else if (index === 1) {
                txt = txt + commentaries.value + ", ";
            }
            else if (index === 2) {
                txt = txt + deletedScenes.value + ", ";
            }
            else if (index === 3) {
                txt = txt + behindTheScenes.value + ", ";
            }
        }            
    }
    
    if (txt !== "") {
        txt = txt.substr(0, txt.length - 2);
    }
    
    document.getElementById("special_features").setAttribute("value", txt);
}

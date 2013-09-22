/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

       var date = document.getElementById("date");
 
        date.addEventListener("input", function() {
            var value = new Date(arrivalDate.value);
            if (date < 0) {
                arrivalDate.setCustomValidity("Arrival date must be after now!");
            } else {
                arrivalDate.setCustomValidity("");
            }
 
        });
 
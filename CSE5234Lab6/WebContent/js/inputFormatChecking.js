/**
 * Do input format checking for the tables
 */
var errorSet = new Set();

function quantityFormatChecking(count) {
	var result = true;
	var quantity = document.getElementById("quantity" + count);
	if (isNaN(quantity.value)) {
		result = false;
		errorSet.add(count);
		alert("The quantity of item " + count + " is not a number!");
	} else if (!isNaN(quantity.value) && parseInt(quantity.value) < 0) {
		result = false;
		errorSet.add(count);
		alert("The quantity of item " + count + " cannot be less than 0!");
	} else {
		errorSet.delete(count);
	}
	return result;
}

function onSubmitChecking() {
	return errorSet.size == 0;
}
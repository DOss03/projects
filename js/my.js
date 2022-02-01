$(document).ready(function () {
    // Hier kommt der jQuery Code

	$("body").css("padding-left", "20px");
	$("#mainheader").css("padding", "20px");
	$("p.maintext").css("color", "#0769AA");
	$("#footer p").css("font-weight", "bold");
	$("body").css("padding-left", "20px");

	// Lösung Aufgabe 3
	$("#mainheader").click(function () {
		$(this).css("border", "5px solid #0769AA");
		$("p.maintext").css("font-size", "2em");
		$("#footer > p").text("Doppelklick verkleinert wieder �");
	});

	// Lösung Aufgabe 4
	$("#mainheader").dblclick(function () {
		$(this).css("border", "5px solid transparent");
		$("p.maintext").css("font-size", "1em");
		$("#footer > p").text("Klick auf das Logo �");
	});
})
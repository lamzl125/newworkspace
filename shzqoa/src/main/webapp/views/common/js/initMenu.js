function initMemu(firstindex,secondindex){
	var fistele = $("#sidebar").children("ul").children("li[class='submenu']").eq(firstindex);
	fistele.addClass("active  open");
	var secondele = fistele.children("ul").children("li").eq(secondindex);
	secondele.addClass("active");
}
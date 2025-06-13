/*Vérifier que notre JavaScript marche 
alert("Hello TOTO");
*/

/*Barre de Navigation*/
window.onscroll = function () {

	if(document.documentElement.scrollTop > 80) {
		document.getElementById("navbar").style.background = "black";
		document.getElementById("navbar").style.padding = "30px 10px";
		document.getElementById("logo").style.color = "white";
		document.getElementById("navbar-right").style.color = "white";

	}else{
		document.getElementById("navbar").style.background = "black";
		document.getElementById("navbar").style.padding = "70px 10px";
		document.getElementById("logo").style.color = "withe";
		document.getElementById("navbar-right").style.color = "withe";
	}
}


/*Bouton retour vers haut*/
const scrollUp = document.querySelector('.scrollUp');

scrollUp.addEventListener('click', () => {
	window.scrollTo({
		top: 0,
		left: 0,
		behavior: "smooth"
	})
})


/*Menu Burger*/
const toggleButton = document.getElementById('bouton');
const sideBar = document.getElementById('barre');

toggleButton.addEventListener('click', show);

function show(){
  sideBar.classList.toggle('active');
}

// REMOVE SIDEBAR IF CLICK ON THE MAIN CONTENT
const content = document.querySelector('.content');

content.addEventListener('click', () => {
  sideBar.classList.remove('active');
});
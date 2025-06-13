// Affichage progressif
// Fonction pour vérifier si un élément est visible dans la fenêtre de visualisation
function isElementInViewport(el) {
    const rect = el.getBoundingClientRect();
    return (
        rect.top >= 0 && rect.left >= 0 && 
        rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && 
        rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
}

// -----------------------------------------
// Récupère le bouton
const scrollToTopBtn = document.getElementById("scrollToTopBtn");

// Lorsque l'utilisateur fait défiler la page, affiche ou masque le bouton
window.onscroll = function () {
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
        scrollToTopBtn.style.display = "block";  // Affiche le bouton si l'utilisateur a fait défiler plus de 200px
    } else {
        scrollToTopBtn.style.display = "none";  // Masque le bouton lorsqu'on est en haut de la page
    }
};

// Lorsque l'utilisateur clique sur le bouton, fait défiler la page vers le haut
scrollToTopBtn.addEventListener("click", function () {
    window.scrollTo({
        top: 0,
        behavior: "smooth"  // Défilement fluide
    });
});

// -----------------------------------------
(() => {
  const canvas = document.getElementById('holoCanvas');
  const ctx = canvas.getContext('2d');

  let width, height, dpr;

  function resize() {
    dpr = window.devicePixelRatio || 1;
    width = window.innerWidth;
    height = window.innerHeight;

    // Fixe la taille réelle du canvas en pixels physiques
    canvas.width = width * dpr;
    canvas.height = height * dpr;
    canvas.style.width = width + 'px';
    canvas.style.height = height + 'px';
    ctx.setTransform(1, 0, 0, 1, 0, 0); // reset transform
    ctx.scale(dpr, dpr); // adapter au pixel ratio
  }

  resize();
  window.addEventListener('resize', resize);
  window.addEventListener('orientationchange', resize);

  class Point {
    constructor() {
      this.reset();
    }
    reset() {
      this.x = Math.random() * width;
      this.y = Math.random() * height;
      this.vx = (Math.random() - 0.5) * 2;
      this.vy = (Math.random() - 0.5) * 2;
      this.radius = Math.random() * 0.8 + 0.2;
    }
    update() {
      this.x += this.vx;
      this.y += this.vy;

      // Réapparition plus rapide (plus proche des bords)
      if (
        this.x < -10 || this.x > width + 10 ||
        this.y < -10 || this.y > height + 10
      ) {
        this.x = Math.random() * width;
        this.y = Math.random() * height;
      }
    }
    draw() {
      const gradient = ctx.createRadialGradient(this.x, this.y, 0, this.x, this.y, this.radius * 4);
      gradient.addColorStop(0, 'rgba(0, 255, 255, 0.6)');
      gradient.addColorStop(1, 'rgba(0, 255, 255, 0)');

      ctx.fillStyle = gradient;
      ctx.beginPath();
      ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2);
      ctx.fill();
    }
  }

  const pointCount = 300; // ou même 250
  const points = Array.from({ length: pointCount }, () => new Point());

  function animate() {
    ctx.clearRect(0, 0, width, height);
    points.forEach(p => {
      p.update();
      p.draw();
    });
    requestAnimationFrame(animate);
  }

  animate();
})();

document.querySelectorAll('.faq-question').forEach(question => {
    question.addEventListener('click', () => {
        question.classList.toggle('active');
        const answer = question.nextElementSibling;
        answer.classList.toggle('active');
    });
});

particlesJS("particles-js", {
  particles: {
    number: {
      value: 120,
      density: {
        enable: true,
        value_area: 1000
      }
    },
    color: {
      value: "#00ffff" // Particules cyan
    },
    shape: {
      type: "circle"
    },
    opacity: {
      value: 0.5
    },
    size: {
      value: 2.8,
      random: true
    },
    line_linked: {
      enable: true,
      distance: 140,
      color: "#00ffff", // TRAITS JAUNES
      opacity: 0.2,
      width: 1.2
    },
    move: {
      enable: true,
      speed: 2.8,
      direction: "none",
      random: false,
      straight: false,
      out_mode: "bounce",
      bounce: true
    }
  },
  interactivity: {
    detect_on: "canvas",
    events: {
      onhover: {
        enable: true,
        mode: "grab" // ou "repulse"
      },
      onclick: {
        enable: true,
        mode: "push"
      }
    },
    modes: {
      grab: {
        distance: 180,
        line_linked: {
          opacity: 0.8
        }
      },
      push: {
        particles_nb: 4
      }
    }
  },
  retina_detect: true
});

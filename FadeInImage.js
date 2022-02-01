const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            document.querySelectorAll(".column")[0].classList.add("fadeInLeft");
            document.querySelectorAll(".column")[1].classList.add("fadeInTop");
            document.querySelectorAll(".column")[2].classList.add("fadeInTop");
            document.querySelectorAll(".column")[3].classList.add("fadeInTop");
            document.querySelectorAll(".column")[4].classList.add("fadeInRight");
        }
    })
})

observer.observe(document.querySelector(".row"));
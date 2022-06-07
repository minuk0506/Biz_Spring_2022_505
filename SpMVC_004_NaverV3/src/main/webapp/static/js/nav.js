document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav");

  if (nav) {
    nav.addEventListener("click", (e) => {
      e.preventDefault();
      const target = e.target;
      const navText = target.innerText;

      let url = `${rootPath}`;

      if (navText === "도서정보") {
        url += "/books/list";
      } else if (navText === "오늘의 뉴스") {
        url += "/news/list";
      } else if (navText === "영화정보") {
        url += "/movies/list";
      }
      document.location.href = url;
    });
  }
});

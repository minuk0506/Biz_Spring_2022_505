document.addEventListener("DOMContentLoaded", () => {
  const search = document.querySelectorAll(".book");

  if (search) {
    for (book of search) {
      book.addEventListener("click", (e) => {
        console.log(e.currentTarget.dataset.title);
      });
    }
  }
});

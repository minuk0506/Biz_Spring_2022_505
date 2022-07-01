document.addEventListener("DOMContentLoaded", () => {
  const file = document.getElementById("input-file");
  file?.addEventListener("change", (e) => {
    const files = e.target.files;
    document.getElementsByClassName("upload-name")[0].innerText = files[0].name;
  });
});

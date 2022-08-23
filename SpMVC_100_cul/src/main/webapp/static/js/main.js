document.addEventListener("DOMContentLoaded", () => {
  const navs = document.querySelectorAll("nav li.top-menu");
  const hambtn = document.querySelector("nav li span.material-icons");
  const slidemenu = document.querySelector("div.slide-menu");

  hambtn.addEventListener("click", () => {
    console.log("menu clicked");
    if (slidemenu.classList.contains("clicked")) {
      slidemenu.classList.remove("clicked");
    } else {
      slidemenu.classList.add("clicked");
    }
  });

  const navs_click = (e) => {
    const nav = e.target;
    let url = `${rootPath}/`;
    if (nav.innerText === "광주 여행") {
      url += "travel/tour";
    } else if (nav.innerText === "광주의 즐길거리") {
      url += "active/event";
    } else if (nav.innerText === "다양한 시설") {
      url += "travel/facility";
    }

    document.location.href = url;
  }; // end navs_click

  // querySelectAll 을 통해서 배열로 가져온 li tag 들에
  // 공통 event 설정하기
  for (const nav of navs) {
    nav.addEventListener("click", navs_click);
  }
});

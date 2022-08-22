document.addEventListener("DOMContentLoaded", () => {
  const navs = document.querySelectorAll("nav li");
  const navs_click = (e) => {
    const nav = e.target;
    let url = `${rootPath}/`;
    if (nav.innerText === "광주 여행") {
      url += "travel/tour";
    } else if (nav.innerText === "광주의 축제") {
      url += "active/event";
    }

    document.location.href = url;
  }; // end navs_click

  // querySelectAll 을 통해서 배열로 가져온 li tag 들에
  // 공통 event 설정하기
  for (const nav of navs) {
    nav.addEventListener("click", navs_click);
  }
});

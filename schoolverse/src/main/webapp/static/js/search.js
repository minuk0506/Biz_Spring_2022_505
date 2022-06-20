const map_button = document.querySelectorAll(".map-btn"); // map버튼
const aca_wrapper = document.querySelector(".section"); // info
const put_in_btn = document.querySelector(".put-in-btn");
const aside = document.querySelector(".aside");
const aside_btn = document.querySelector(".aside_btn");
const btnOpen = document.querySelector(".btn_open");
const left_arrow = aside.querySelector(".xi-angle-left.xi-2x");
const right_arrow = aside.querySelector(".xi-angle-right.xi-2x");
const academy = document.querySelector(".academy");

const url = new URL(window.location.href);
const urlParams = url.searchParams;

const addCart = (c_code) => {
  fetch(`/search/basket_add?c_code=${c_code}`)
    .then((res) => res.text())
    .then((result) => {
      console.log(result);
      if (result === "OK") {
        alert("추가되었습니다.");
        location.reload(true);

      } else {
        alert("이미 추가된 수업입니다.");
      }
    });
};

academy?.addEventListener("click", (e) => {
  const target = e.target;

  fetch(`/search/aca_info?aca_code=${target.dataset.aca_code}`)
    .then((res) => res.json())
    .then((json) => {
      const aca_name = document.querySelector(".aca_name");
      const aca_info = document.querySelector(".aca_info");
      const others = document.querySelector(".others");
      const teacher = document.querySelector(".teacher-info");
      aca_name.textContent = `${json[0].aca_name}`;
      aca_info.textContent = `${json[0].aca_info}`;
      others.textContent = "";
      teacher.textContent = "";

      const category_class = document.createElement("h2");
      category_class.textContent = "수업";
      others.appendChild(category_class);

      json[1].map((item) => {
        others.innerHTML += `
        <div class="about_class">
        <div>
        <h3>${item.class_name}</h3>
        <hr/>
        <h3>수강료 : ${item.class_fee
            .toString()
            .replace(/\B(?=(\d{3})+(?!\d))/g, ",")}원/월</h3>
        </div>
        </div>
        <i class="xi-plus xi-3x add_basket" id="add_btn" data-c_code="${item.class_code
          }" onclick="addCart('${item.class_code}')" />
        `;
      });

      json[2].map((item) => {
        teacher.innerHTML += `
        <div>
        <img src="static/img/teacher2.png" />
        <div>
          <h3>${item.teacher_name}</h3>
          <p>${item.teacher_info}</p>
        </div>
        <div>
        `;
      });
    });
  if (aca_wrapper.className == "section click") {
    return false;
  } else {
    aca_wrapper.classList.add("click");
  }
  aside.classList.remove("click");

  if (aca_wrapper.className === "section") {
    basket_button.style.left = null;
    basket_button.style.right = "5rem";
  } else {
    basket_button.style.left = "6rem";
    basket_button.style.right = null;
  }
});

for (let btn of map_button) {
  btn.addEventListener("click", () => {
    // map누르면 info 나오게

    aca_wrapper.classList.toggle("click");

    if (aca_wrapper.className === "section click") {
      basket_wrapper.classList.remove("click");
      basket_button.style.display = "flex";
      basket_button.style.left = "6rem";
      basket_button.style.right = null;
    } else {
      basket_button.style.left = null;
      basket_button.style.right = "5rem";
    }

    aside.classList.add("click");

    if (aca_wrapper.className === "section") aside.classList.remove("click");
  });
}

put_in_btn.addEventListener("click", () => {
  aca_wrapper.classList.remove("click");
  aside.classList.remove("click");

  if (aca_wrapper.className === "section") {
    basket_button.style.left = null;
    basket_button.style.right = "5rem";
  } else {
    basket_button.style.left = "6rem";
    basket_button.style.right = null;
  }
});

aside_btn.addEventListener("click", () => {
  aside.classList.toggle("click");
  if (aside.className === "aside click") {
    left_arrow.style.display = "none";
    right_arrow.style.display = "inline-block";
  } else {
    left_arrow.style.display = "inline-block";
    right_arrow.style.display = "none";
  }
  if (aca_wrapper.className === "section click")
    aca_wrapper.classList.remove("click");
});

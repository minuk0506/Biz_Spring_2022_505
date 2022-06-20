const basket_button = document.querySelector(".basket-button"); // 장바구니 버튼
const basket_wrapper = document.querySelector(".wrapper"); // 장바구니
const subs = document.querySelectorAll(".sub"); // 빼기 버튼
const count = document.querySelector(".count"); // 장바구니 카운트
const $sum = document.querySelector(".sum");
let classes = document.querySelectorAll(".classes");
const sub_wrapper = document.querySelector(".sub-wrapper");

let sum = 0;



sub_wrapper?.addEventListener("click", (e) => {
  const target = e.target;

  fetch(
    `/search/aca_info?aca_code=${target.closest(".classes").dataset.aca_code}`
  )
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

  // 장바구니 숨기기
  if (e.target.className !== "sub") {
    basket_wrapper.classList.remove("click");
    basket_button.style.display = "flex";

    aca_wrapper.classList.add("click");
  }
});

for (let c of classes) {
  let intPayment = Number.parseInt(c.dataset.expense);
  sum += intPayment;
}
$sum.innerHTML = `총액 : ${sum.toLocaleString("ko-KR")}원/월`;

for (let node of sub_wrapper.childNodes) {
  // 공백 텍스트 없애기
  if (node.element !== "div") {
    sub_wrapper.removeChild(node);
  }
}

if (sub_wrapper.hasChildNodes()) {
  // 장바구니 카운트 하기
  count.style.display = "inline-block";
  count.textContent = sub_wrapper.childNodes.length;
}

basket_button.addEventListener("click", () => {
  // 버튼 누르면 장바구니 display=none으로
  basket_wrapper.classList.add("click");
  basket_button.style.display = "none";
  aca_wrapper.classList.remove("click");
});

basket_wrapper.childNodes[1].addEventListener("click", () => {
  // 장바구니 숨기기
  basket_wrapper.classList.remove("click");
  basket_button.style.display = "flex";

  if (aca_wrapper.className === "section") {
    basket_button.style.left = null;
    basket_button.style.right = "5rem";
  } else {
    basket_button.style.left = "6rem";
    basket_button.style.right = null;
  }
});

for (let sub of subs) {
  sub.addEventListener("click", (e) => {
    fetch(
      `/search/basket_delete?class_code=${e.target.parentNode.dataset.class_code}`
    );

    sub_wrapper.removeChild(e.target.parentNode); // 장바구니 빼기

    classes = document.querySelectorAll(".classes");
    sum = 0;

    for (let c of classes) {
      let intPayment = Number.parseInt(c.dataset.expense);
      sum += intPayment;
    }
    $sum.innerHTML = `총액 : ${sum.toLocaleString("ko-KR")}원/월`;
    if (!sub_wrapper.hasChildNodes()) {
      // 장바구니 내용이 없으면 비었다고 표시
      const h1 = document.createElement("h1");
      sub_wrapper.appendChild(h1);
      h1.innerHTML = `장바구니가 비었습니다 <i class="xi-emoticon-sad xi-2x"></i>`;
      count.style.display = "none";
    } else if (sub_wrapper.hasChildNodes()) {
      count.style.display = "inline-block";
      count.textContent = sub_wrapper.childNodes.length;
    }
  });
}

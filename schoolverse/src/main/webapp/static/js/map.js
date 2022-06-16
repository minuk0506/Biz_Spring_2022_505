fetch(
  `/aca_map_search?aca_region=${urlParams.get(
    "aca_region"
  )}&aca_subject=${urlParams.get("aca_subject")}&aca_age=${urlParams.get(
    "aca_age"
  )}`
)
  .then((res) => res.json())
  .then((json) => {
    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
      mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3, // 지도의 확대 레벨
      };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    // 주소로 좌표를 검색합니다
    const results = [];
    let results_index = 0;

    for (let aca of json) {
      geocoder.addressSearch(aca.aca_addr, function (result, status) {
        results[results_index] = result;
        results_index++;
        // 정상적으로 검색이 완료됐으면
        if (status === kakao.maps.services.Status.OK) {
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

          // 결과값으로 받은 위치를 마커로 표시합니다
          var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            clickable: true,
          });

          // 인포윈도우로 장소에 대한 설명을 표시합니다
          var infowindow = new kakao.maps.InfoWindow({
            content: `<div class="marker" onclick="show_academy(this)" data-aca_code="${aca.aca_code}" style="width:150px;text-align:center;padding:6px 0;">${aca.aca_name}</div>`,
          });
          infowindow.open(map, marker);

          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
          //      map.setCenter(coords);
        }

        if (
          results_index === json.length &&
          "OK" === kakao.maps.services.Status.OK
        ) {
          // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
          // LatLngBounds 객체에 좌표를 추가합니다
          var bounds = new kakao.maps.LatLngBounds();

          for (var i = 0; i < results.length; i++) {
            bounds.extend(
              new kakao.maps.LatLng(results[i][0].y, results[i][0].x)
            );
          }

          // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
          map.setBounds(bounds);
        }
      });
    }
  });

const show_academy = (e) => {
  const target = e;

  fetch(`/search/aca_info?aca_code=${target.dataset.aca_code}`)
    .then((res) => res.json())
    .then((json) => {
      const aca_name = document.querySelector(".aca_name");
      const aca_info = document.querySelector(".aca_info");
      const others = document.querySelector(".others");
      aca_name.textContent = `${json[0].aca_name}`;
      aca_info.textContent = `${json[0].aca_info}`;
      others.textContent = "";
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
          <i class="xi-plus xi-3x add_basket" id="add_btn" data-c_code="${
            item.class_code
          }" onclick="location.href='/search/basket_add?c_code=${
          item.class_code
        }'" />
          `;
      });
    });
  if (aca_wrapper.className == "section click") {
    return false;
  } else {
    aca_wrapper.classList.add("click");
  }

  if (aca_wrapper.className === "section") {
    basket_button.style.left = null;
    basket_button.style.right = "5rem";
  } else {
    basket_button.style.left = "6rem";
    basket_button.style.right = null;
  }
};

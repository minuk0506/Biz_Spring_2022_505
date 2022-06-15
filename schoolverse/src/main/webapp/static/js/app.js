var mapContainer = document.getElementById("map"), // 지도를 표시할 div
  mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3, // 지도의 확대 레벨
  };

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

const addrs = [
  "상무공원로 94",
  "치평로 72",
  "광주광역시 서구 상무중앙로72번길 8",
  "광주광역시 서구 치평동 1252-3",
  "광주광역시 서구 화개중앙로87번길 16-1",
];

// 주소로 좌표를 검색합니다
const results = [];
let results_index = 0;

for (let addr of addrs) {
  geocoder.addressSearch(addr, function (result, status) {
    results[results_index] = result;
    results_index++;
    // 정상적으로 검색이 완료됐으면
    if (status === kakao.maps.services.Status.OK) {
      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

      // 결과값으로 받은 위치를 마커로 표시합니다
      var marker = new kakao.maps.Marker({
        map: map,
        position: coords,
      });

      // 인포윈도우로 장소에 대한 설명을 표시합니다
      var infowindow = new kakao.maps.InfoWindow({
        content: `<div style="width:150px;text-align:center;padding:6px 0;">${addr}</div>`,
      });
      infowindow.open(map, marker);

      // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
      //      map.setCenter(coords);
    }

    if (
      results_index === addrs.length &&
      "OK" === kakao.maps.services.Status.OK
    ) {
      console.log(results[0]);
      // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
      // LatLngBounds 객체에 좌표를 추가합니다
      var bounds = new kakao.maps.LatLngBounds();

      for (var i = 0; i < results.length; i++) {
        bounds.extend(new kakao.maps.LatLng(results[i][0].y, results[i][0].x));
      }

      // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
      map.setBounds(bounds);
    }
  });
}

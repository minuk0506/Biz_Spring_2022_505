const teacher_add = document.querySelector(".teacher_add");
const class_add = document.querySelector(".class_add");
const class_block = document.querySelector(".class_block");
const form = document.querySelector("form");
const _class = [];
let _class_counter = 0;
let _sche_counter = 0;
form.addEventListener("submit", () => {
  const obj = {
    aca: {
      aca_name: "",
      aca_subject: "",
      aca_addr: "",
      aca_info: "",
      aca_img: "",
    },
    teacher: {
      teacher_name: [],
      teacher_info: [],
    },
    class: {
      class_name: [],
      class_subject: [],
      class_fee: [],
      class_sche: [
        {
          sche_day: [],
          sche_period: [],
        },
      ],
    },
  };
  const aca_name = document.querySelector("#aca_name");
  obj.aca.aca_name = aca_name.value;
  const aca_subject = document.querySelector("#aca_subject");
  obj.aca.aca_subject = aca_subject.value;
  const aca_info = document.querySelector("#aca_info");
  obj.aca.aca_info = aca_info.value;
  const aca_img = document.querySelector("#aca_img");
  obj.aca.aca_img = aca_img.value;
  const teacher_name = document.querySelector("#teacher_name");
  obj.teacher.teacher_name = teacher_name.value;
  const teacher_info = document.querySelector("#teacher_info");
  obj.teacher.teacher_info = teacher_info.value;
  const class_name = document.querySelector("#class_name");
  obj.class.class_name = class_name.value;
  const class_subject = document.querySelector("#class_subject");
  obj.class.class_subject = class_subject.value;
  const class_fee = document.querySelector("#class_fee");
  obj.class.class_fee = class_fee.value;
  const sche_day = document.querySelector("#sche_day");
  obj.class.class_sche.sche_day = sche_day.value;
  const sche_period = document.querySelector("#sche_period");
  obj.class.class_sche.sche_period = sche_period.value;

  //    fetch(`/user/register`);
});

teacher_add?.addEventListener("click", (e) => {
  const teacher_block = document.querySelector(".teacher_block");
  teacher_block.innerHTML += `
<div>
    <div class="block">
        <label class="w3-text-blue">선생님 이름</label>
        <input name="teacher_name" id="teacher_name" placeholder="teacher_name">
    </div>
    <div class="block">
        <label class="w3-text-blue">선생님 소개</label>
        <input name="teacher_info" id="teacher_info" placeholder="teacher_info">
    </div>
</div>
<hr/>
    `;
});

class_add?.addEventListener("click", (e) => {
  e.preventDefault();

  _class.push(document.createElement("div"));
  class_block.appendChild(_class[_class_counter]);
  _class[_class_counter].innerHTML += `
<div>
    <div>
        <label class="w3-text-blue">수업이름</label>
        <input name="class_name" id="class_name" placeholder="class_name">
    </div>
    <div>
        <label class="w3-text-blue">수업과목</label>
        <input name="class_subject" id="class_subject" placeholder="class_subject">
    </div>
    <div>
        <label class="w3-text-blue">수업료</label>
        <input name="class_fee" id="class_fee" placeholder="class_fee">
    </div>
    <button type="button" class="schedule_add" onclick="add_period(${_class_counter})">수업시간 추가</button>
    <div class="schedule_block">
    </div>
</div>
<hr/>
    `;
  _class_counter++;
});

const add_period = (c) => {
  _class[c].innerHTML += `
    <div>
    <select name="sche_day">
        <option id="sche_day" value="mon">월</option>
        <option id="sche_day" value="tue">화</option>
        <option id="sche_day" value="wed">수</option>
        <option id="sche_day" value="thu">목</option>
        <option id="sche_day" value="fri">금</option>
        <option id="sche_day" value="sat">토</option>
        <option id="sche_day" value="sun">일</option>
    </select>
    <div class="schedule-period">
        <div>
            <label>09:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};09:00">
        </div>
        <div>
            <label>10:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};10:00">
        </div>
        <div>
            <label>11:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};11:00">
        </div>
        <div>
            <label>12:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};12:00">
        </div>
        <div>
            <label>13:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};13:00">
        </div>
        <div>
            <label>14:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};14:00">
        </div>
        <div>
            <label>15:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};15:00">
        </div>
        <div>
            <label>16:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};16:00">
        </div>
        <div>
            <label>17:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};17:00">
        </div>
        <div>
            <label>18:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${c};${_sche_counter};18:00">
        </div>
    </div>
</div>
<hr/>
    `;
  _sche_counter++;
};

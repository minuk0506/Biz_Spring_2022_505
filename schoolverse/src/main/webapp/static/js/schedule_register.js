const schedule_block = document.querySelector(".schedule_block");
const schedule_add = document.querySelector(".schedule_add");
let counter = 0;

schedule_add.addEventListener("click", () => {
    schedule_block.innerHTML += `
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
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};09:00">
        </div>
        <div>
            <label>10:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};10:00">
        </div>
        <div>
            <label>11:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};11:00">
        </div>
        <div>
            <label>12:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};12:00">
        </div>
        <div>
            <label>13:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};13:00">
        </div>
        <div>
            <label>14:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};14:00">
        </div>
        <div>
            <label>15:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};15:00">
        </div>
        <div>
            <label>16:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};16:00">
        </div>
        <div>
            <label>17:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};17:00">
        </div>
        <div>
            <label>18:00</label>
            <input type="checkbox" name="sche_period" id="sche_period" value="${counter};18:00">
        </div>
    </div>
    <button type="button" onclick="delete_period(this)">삭제</button>
    <hr/>
</div>
    `;
    counter++;
});

const delete_period = (e) => {
    const target = e.parentNode;
    target.parentNode.removeChild(target);
}
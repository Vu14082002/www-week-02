let priveEl = document.querySelector(".price");
const btnMinusArr = document.querySelectorAll(".btn-minus");
const btnAddArr = document.querySelectorAll(".btn-add");
const totalItemsEl = document.querySelector(".totalItems");

// set Total for all iteams
const setAllTotalItems = function () {
    const totaItemlEl = document.querySelectorAll(".totalItem");
    let totaItems = 0.0;
    totaItemlEl.forEach((element) => {
        totaItems += parseFloat(element.textContent.split("$")[1]);
    });
    totalItemsEl.innerHTML = "$" + totaItems.toFixed(2);
};
// set Total for one iteam
const setTotal = function (parentEl, quantity) {
    console.log(quantity);
    const price = parentEl.querySelector(".price").textContent.split("$")[1];
    const totalEl = parentEl.querySelector(".totalItem");
    let totaIteml = 0.0;
    if (Number(quantity) > -1) {
        totaIteml = parseFloat(price) * Number(quantity);
    }
    totalEl.textContent = "$" + totaIteml.toFixed(2);
    setAllTotalItems();
};

const handlerMinus = function (parentEl) {
    const inputEl = parentEl.querySelector("input");
    inputEl.value--;
    return inputEl.value;
};
const handlerAdd = function (parentEl) {
    const inputEl = parentEl.querySelector("input");
    inputEl.value++;
    return inputEl.value;
};

btnMinusArr.forEach((e) => {
    e.addEventListener("click", function () {
        let trEl = e.closest("tr");
        const quantity = handlerMinus(trEl);
        setTotal(trEl, quantity);
    });
});
btnAddArr.forEach((e) => {
    e.addEventListener("click", function () {
        let trEl = e.closest("tr");
        const quantity = handlerAdd(trEl);
        setTotal(trEl, quantity);
    });
});
/// handler Event

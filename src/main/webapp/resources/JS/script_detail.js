const imgs = document.querySelectorAll('.img-select a');
const imgBtns = [...imgs];
let imgId = 1;

imgBtns.forEach((imgItem) => {
    imgItem.addEventListener('click', (event) => {
        event.preventDefault();
        imgId = imgItem.dataset.id;
        slideImage();
    });
});

function slideImage(){
    const displayWidth = document.querySelector('.img-showcase img:first-child').clientWidth;

    document.querySelector('.img-showcase').style.transform = `translateX(${- (imgId - 1) * displayWidth}px)`;
}

window.addEventListener('resize', slideImage);

let currentIndex = 0;
    const products = document.querySelectorAll('.product-details');

    function showProduct(index) {
        products.forEach((product, i) => {
            product.style.display = i === index ? 'block' : 'none';
        });
    }

    function prevProduct() {
        currentIndex = (currentIndex === 0) ? products.length - 1 : currentIndex - 1;
        showProduct(currentIndex);
    }

    function nextProduct() {
        currentIndex = (currentIndex === products.length - 1) ? 0 : currentIndex + 1;
        showProduct(currentIndex);
    }
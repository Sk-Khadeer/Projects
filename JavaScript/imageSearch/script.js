let accessKey = "UuFdvTcuM_pjDW24OyWHXKpAcwBB2j72QXfiq6XKyAo";
const searchForm = document.getElementById("search-form");
const searchBox = document.getElementById("search-box");
const searchResult = document.getElementById("search-result");
const showMoreBtn = document.getElementById("show-more-btn");

// SECRET KEY ::  JBYlaBIjf7L37Q6HlzwmTSoRY3kAHUZ7O5jW9A91rE4
// ACCESS KEY  :: UuFdvTcuM_pjDW24OyWHXKpAcwBB2j72QXfiq6XKyAo

let keyword = "";
let page = 1;

async function searchImages() {
  keyword = searchBox.value;
  const url = `https://api.unsplash.com/search/photos?page=${page}&query=${keyword}&client_id=${accessKey}&per_page=12`;
  const response = await fetch(url);
  const data = await response.json();
  console.log(data);
  const results = data.results;
  if (page === 1) {
    searchResult.innerHTML = "";
  }
  results.map((abc) => {
    const image = document.createElement("img");
    image.src = abc.urls.small;
    const imageLink = document.createElement("a");
    imageLink.href = abc.links.html;
    imageLink.target = "_blank";

    imageLink.appendChild(image);
    searchResult.appendChild(imageLink);
  });
  showMoreBtn.style.display = "block";
}
searchForm.addEventListener("submit", (e) => {
  e.preventDefault();
  page = 1;
  searchImages();
});
showMoreBtn.addEventListener("click", () => {
  page++;
  searchImages();
});

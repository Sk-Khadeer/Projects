const qrText = document.getElementById('qr-text');
const sizes = document.getElementById('sizes');
const generateBtn = document.getElementById('generateBtn');
const downloadBtn = document.getElementById('downloadBtn');
const qrContainer = document.querySelector('.qr-body');

let size = sizes.value;

// Update button status based on input value
qrText.addEventListener('input', () => {
    if (qrText.value.length > 1) {
        generateBtn.removeAttribute('disabled');
    } else {
        generateBtn.setAttribute('disabled', true);
    }
});

generateBtn.addEventListener('click', (e) => {
    e.preventDefault();
    isEmptyInput();
});

sizes.addEventListener('change', (e) => {
    size = e.target.value;
    // If input is empty, revert the size change and show alert.
    if (!isEmptyInput()) {
        sizes.value = size;
    }
});

downloadBtn.addEventListener('click', () => {
    let img = document.querySelector('.qr-body img');

    if (img !== null) {
        let imgAtrr = img.getAttribute('src');
        downloadBtn.setAttribute("href", imgAtrr);
    }
    else {
        downloadBtn.setAttribute("href", `${document.querySelector('canvas').toDataURL()}`);
    }
});

function isEmptyInput() {
    if (qrText.value.length > 1) {
        generateQRCode();
               return true;  // Return true if the input is NOT empty.
    } else {
        alert("Enter the text or URL to generate your QR code");
        return false;  // Return false if the input is empty.
    }
}

function generateQRCode() {
    qrContainer.innerHTML = "";
    new QRCode(qrContainer, {
        text: qrText.value,
        height: size,
        width: size,
        colorLight: "#fff",
        colorDark: "#000",
    });
    // Enable the download button once the QR code is generated
    downloadBtn.removeAttribute('disabled');
}

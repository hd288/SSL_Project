import CryptoJS from "crypto-js";


export const encodeValue = (value) => {
  return CryptoJS.AES.encrypt(
    JSON.stringify(value),
    import.meta.env.VITE_SECRET_KEY
  ).toString();
};

export const decodeValue = (value) => {
  const bytes = CryptoJS.AES.decrypt(value, import.meta.env.VITE_SECRET_KEY);
  return JSON.parse(bytes.toString(CryptoJS.enc.Utf8));
};

// set cookie
export function setCookie(cookieName, cookieValue, expireDays) {
  // date.setTime(expireDays.getTime());
  
  let expires = "expires=" + expireDays;
  document.cookie = cookieName + "=" + cookieValue + ";" + expires + "; path=/";
}

// Get cookie
export function getCookie(cookieName) {
  let name = cookieName + "=";
  let cookies = document.cookie.split(";");

  for (let i = 0; i < cookies.length; i++) {
    let cookie = cookies[i];
    while (cookie.charAt(0) == " ") {
      cookie = cookie.substring(1);
    }

    if (cookie.indexOf(name) == 0) {
      return cookie.substring(name.length, cookie.length);
    }
  }

  return "";
}

// Check cookie
export function checkCookie() {
  let user = getCookie("u");
  if (user != "") {
    alert("Welcome again " + user);
  } else {
    user = prompt("Please enter your name:", "");
    if (user != "" && user != null) {
      setCookie("username", user, 365);
    }
  }
}

export function deleteCookie(cookieName) {
    document.cookie = cookieName + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}

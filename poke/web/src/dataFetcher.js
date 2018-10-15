// brought from https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch

export const postData = (url = ``, data = {}) => {
  // Default options are marked with *
  return fetch(url, {
    method: "POST", // *GET, POST, PUT, DELETE, etc.
    mode: "cors", // no-cors, cors, *same-origin
    cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
    credentials: "same-origin", // include, same-origin, *omit
    headers: {
      'Accept': 'application/json',
      "Content-Type": "application/json; charset=utf-8",
    },
    redirect: "follow", // manual, *follow, error
    referrer: "no-referrer", // no-referrer, *client
    body: JSON.stringify(data), // body data type must match "Content-Type" header
  })
    .then(response => response.json()) // parses response to JSON
    .catch(error => console.error(`Fetch Error =\n`, error));
};

export const pokemonsWithHeight = (height = 7.3) => {
  return postData("http://spluxx.com/api/graphql", {
    query: `
      {
        pokemonsWithHeight(height: ${height}) {
          name
          height
          weight
          description 
          img_url
          cry_url
        }
      }
    `
  })
};

export const pokemonsWithWeight = (weight = 500) => {
  return postData("http://spluxx.com/api/graphql", {
    query: `
      {
        pokemonsWithWeight(weight: ${weight}) {
          name
          height
          weight
          description 
          img_url
          cry_url
        }
      }
    `
  })
};

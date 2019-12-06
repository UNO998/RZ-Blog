import axios from 'axios'

export const loginRequest = (url, {payload}) => {
  return axios({
    method: 'post',
    url: url,
    data: "password=12334&username=djfkrkr",
  });
}
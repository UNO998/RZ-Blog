import axios from 'axios'

export const loginRequest = (url, params) => {
  return axios({
    method: 'post',
    url: url,
    data: params,
  });
}
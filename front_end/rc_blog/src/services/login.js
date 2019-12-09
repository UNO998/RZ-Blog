import axios from 'axios'

var config = {
  headers: {
      'Content-Type': 'text/plain'
  },
 responseType: 'text'
};

export const loginRequest = (url, {payload}) => axios.post(url, payload, config)
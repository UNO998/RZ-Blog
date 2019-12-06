import {userLogin} from '../../utils/api'
import {loginRequest} from '../../services/login'

export function* loginAction(payload) {
  console.log(payload)
  const data = yield loginRequest(userLogin, payload)
  console.log(data)
}